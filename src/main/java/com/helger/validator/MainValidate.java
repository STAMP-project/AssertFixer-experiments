/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.validator;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;

import com.helger.bdve.artefact.IValidationArtefact;
import com.helger.bdve.executorset.IValidationExecutorSet;
import com.helger.bdve.executorset.VESID;
import com.helger.bdve.result.ValidationResult;
import com.helger.bdve.result.ValidationResultList;
import com.helger.bdve.source.ValidationSource;
import com.helger.cli.CmdLineParser;
import com.helger.cli.HelpFormatter;
import com.helger.cli.Option;
import com.helger.cli.Options;
import com.helger.cli.ParsedCmdLine;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.error.IError;
import com.helger.commons.error.level.EErrorLevel;
import com.helger.commons.error.level.IErrorLevel;
import com.helger.commons.id.IHasID;
import com.helger.commons.io.file.FileHelper;
import com.helger.commons.io.file.SimpleFileIO;
import com.helger.commons.lang.ClassLoaderHelper;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.locale.LocaleCache;
import com.helger.commons.string.StringHelper;
import com.helger.commons.system.ENewLineMode;
import com.helger.commons.url.URLHelper;
import com.helger.jaxb.GenericJAXBMarshaller;
import com.helger.schematron.svrl.SVRLResourceError;
import com.helger.validator.app.CPVApp;
import com.helger.validator.app.validation.ExtValidationKeyRegistry;
import com.helger.validator.wsclient.ErrorLevelType;
import com.helger.validator.wsclient.ItemType;
import com.helger.validator.wsclient.ObjectFactory;
import com.helger.validator.wsclient.RequestType;
import com.helger.validator.wsclient.ResponseType;
import com.helger.validator.wsclient.ValidationResultType;
import com.helger.validator.wsclient.WSDVSPort;
import com.helger.validator.wsclient.WSDVSService;
import com.helger.wsclient.WSClientConfig;
import com.helger.xml.sax.LoggingSAXErrorHandler;
import com.helger.xml.serialize.read.DOMReader;
import com.helger.xml.serialize.read.DOMReaderSettings;
import com.helger.xml.serialize.write.XMLWriter;

/**
 * Main class to validate a file on disc.
 *
 * @author Philip Helger
 */
public final class MainValidate extends AbstractMain
{
  private static final boolean USE_WS = true;
  private static final Logger LOGGER = LoggerFactory.getLogger (MainValidate.class);

  private static enum EOutputType implements IHasID <String>
  {
    TEXT ("text"),
    XML ("xml");

    public static final EOutputType DEFAULT = TEXT;

    private final String m_sID;

    private EOutputType (@Nonnull @Nonempty final String sID)
    {
      m_sID = sID;
    }

    @Nonnull
    @Nonempty
    public String getID ()
    {
      return m_sID;
    }

    @Nullable
    public static EOutputType getFromIDOrNull (@Nullable final String sID)
    {
      return EnumHelper.getFromIDOrNull (EOutputType.class, sID);
    }
  }

  public static void main (final String [] args) throws Exception
  {
    final Options aOptions = new Options ().addOption (Option.builder ("ves")
                                                             .desc ("Validation Execution Set to use. See http://localhost:" +
                                                                    DEFAULT_PORT +
                                                                    " for details.")
                                                             .args (1)
                                                             .argName ("VESID")
                                                             .required (true))
                                           .addOption (Option.builder ("i")
                                                             .longOpt ("input")
                                                             .desc ("The file to be validated. Must be relative to the current directory or absolute.")
                                                             .args (1)
                                                             .argName ("filename")
                                                             .required (true))
                                           .addOption (Option.builder ("l")
                                                             .longOpt ("language")
                                                             .desc ("Language to use (for error messages). Currently only 'en' is supported.")
                                                             .args (1)
                                                             .argName ("language"))
                                           .addOption (Option.builder ("o")
                                                             .longOpt ("output")
                                                             .desc ("The file to which the vaidation result should be written. If not specified, the default is the current console.")
                                                             .args (1)
                                                             .argName ("filename"))
                                           .addOption (Option.builder ("overwrite")
                                                             .desc ("If this option is present, the output file is overwritten without notice if it already exists."))
                                           .addOption (Option.builder ("ot")
                                                             .longOpt ("output-type")
                                                             .desc ("The output type. Must be one of: " +
                                                                    StringHelper.getImplodedMapped (", ",
                                                                                                    EOutputType.values (),
                                                                                                    EOutputType::getID) +
                                                                    ". Default is " +
                                                                    EOutputType.DEFAULT.getID ())
                                                             .args (1)
                                                             .argName ("type"))
                                           .addOption (Option.builder ("keepwarn")
                                                             .desc ("If present warnings are also emitted."))
                                           .addOption (Option.builder ("?").longOpt ("help").desc ("Show this help"));

    if (USE_WS)
      aOptions.addOption (Option.builder ("p")
                                .longOpt ("port")
                                .desc ("Local port for connection. Default is " + DEFAULT_PORT + ".")
                                .args (1));
    final ParsedCmdLine aCL = new CmdLineParser (aOptions).parseOrNull (args);

    boolean bCanStart = aCL != null && !aCL.hasOption ("?");

    int nPort = 0;
    VESID aVESID = null;
    IValidationExecutorSet aVES = null;
    Locale aDisplayLocale = null;
    String sXMLSystemID = null;
    Node aXML = null;
    File aOutputFile = null;
    EOutputType eOutputType = EOutputType.DEFAULT;
    boolean bKeepWarnings = false;
    if (bCanStart)
    {
      nPort = aCL.getAsInt ("p", DEFAULT_PORT);

      final String sVESID = aCL.getAsString ("ves");
      aVESID = VESID.parseIDOrNull (sVESID);
      aVES = ExtValidationKeyRegistry.getFromIDOrNull (aVESID);
      if (aVES == null)
      {
        LOGGER.error ("Invalid VESID '" + sVESID + "' specified!");
        bCanStart = false;
      }

      final String sDisplayLocale = aCL.getAsString ("l", DEFAULT_LANGUAGE);
      aDisplayLocale = StringHelper.hasText (sDisplayLocale) ? LocaleCache.getInstance ().getLocale (sDisplayLocale)
                                                             : CPVApp.DEFAULT_LOCALE;

      final String sInputFilename = aCL.getAsString ("i");
      if (sInputFilename == null)
      {
        LOGGER.error ("No XML file to be validated was provided");
        bCanStart = false;
      }
      else
      {
        final File aFile = new File (sInputFilename).getCanonicalFile ();
        if (!aFile.exists ())
        {
          LOGGER.error ("Non existing filename '" + sInputFilename + "' specified!");
          bCanStart = false;
        }
        else
        {
          sXMLSystemID = FileHelper.getAsURLString (aFile);
          // Read as XML
          aXML = DOMReader.readXMLDOM (aFile, new DOMReaderSettings ().setErrorHandler (new LoggingSAXErrorHandler ()));
          if (aXML == null)
          {
            LOGGER.error ("Failed to parse " + aFile.getAbsolutePath () + " as XML!");
            bCanStart = false;
          }
        }
      }

      final String sOutputFilename = aCL.getAsString ("o");
      if (sOutputFilename != null)
      {
        final File aFile = new File (sOutputFilename).getCanonicalFile ();
        if (aFile.exists ())
        {
          if (!aCL.hasOption ("overwrite"))
          {
            LOGGER.error ("The output file " +
                             aFile.getAbsolutePath () +
                             " already exists! Specify -overwrite to silently overwrite it.");
            bCanStart = false;
          }
        }

        if (bCanStart)
          aOutputFile = aFile;
      }

      final String sOutputType = aCL.getAsString ("ot");
      if (sOutputType != null)
      {
        final EOutputType eOT = EOutputType.getFromIDOrNull (sOutputType);
        if (eOT == null)
        {
          LOGGER.error ("The output type '" +
                           sOutputType +
                           "' is invalid. Valid values are: " +
                           StringHelper.getImplodedMapped (", ", EOutputType.values (), EOutputType::getID));
          bCanStart = false;
        }
        else
          eOutputType = eOT;
      }

      if (aCL.hasOption ("keepwarn"))
        bKeepWarnings = true;
    }

    if (bCanStart)
    {
      LOGGER.info ("Starting validation process");

      if (USE_WS)
      {
        final WSDVSService aService = new WSDVSService (ClassLoaderHelper.getResource (MainValidate.class.getClassLoader (),
                                                                                       "WEB-INF/wsdl/pp-dvs.wsdl"));
        final WSDVSPort aPort = aService.getWSDVSPort ();

        // WSClient
        final WSClientConfig aWsClientConfig = new WSClientConfig (URLHelper.getAsURL ("http://localhost:" +
                                                                                       nPort +
                                                                                       "/wsdvs"));
        aWsClientConfig.setConnectionTimeoutMS (2_000);
        aWsClientConfig.setRequestTimeoutMS (10_000);
        aWsClientConfig.applyWSSettingsToBindingProvider ((BindingProvider) aPort);

        final RequestType aRequest = new RequestType ();
        aRequest.setVESID (aVESID.getAsSingleID ());
        aRequest.setXML (XMLWriter.getNodeAsString (aXML));
        aRequest.setDisplayLocale (aDisplayLocale.toString ());
        final ResponseType aResponse = aPort.validate (aRequest);

        // Remove all success and warninmg items
        final boolean bFinalDropWarnings = !bKeepWarnings;
        for (final ValidationResultType aResult : aResponse.getResult ())
          aResult.getItem ().removeIf (x -> x.getErrorLevel () == ErrorLevelType.SUCCESS ||
                                            (bFinalDropWarnings && x.getErrorLevel () == ErrorLevelType.WARN));

        String sOutput;
        switch (eOutputType)
        {
          case TEXT:
            final StringBuilder aSB = new StringBuilder ();
            _createTextResult (aResponse, aSB);
            sOutput = aSB.toString ();
            break;
          case XML:
            final GenericJAXBMarshaller <ResponseType> aMarshaller = new GenericJAXBMarshaller <> (ResponseType.class,
                                                                                                   x -> new ObjectFactory ().createValidateResponseOutput (x));
            aMarshaller.setFormattedOutput (true);

            sOutput = aMarshaller.getAsString (aResponse);
            break;
          default:
            throw new IllegalStateException ("Unsupported output type: " + eOutputType);
        }

        if (aOutputFile != null)
        {
          if (SimpleFileIO.writeFile (aOutputFile, sOutput, StandardCharsets.UTF_8).isSuccess ())
            LOGGER.info ("Result was successfully written to " + aOutputFile.getAbsolutePath ());
          else
            LOGGER.error ("Error writing result to " + aOutputFile.getAbsolutePath ());
        }
        else
        {
          // Log output
          LOGGER.info (sOutput);
        }
      }
      else
      {
        // NAtive validation without a WS
        final ValidationResultList aVRL = aVES.createExecutionManager ()
                                              .executeValidation (ValidationSource.create (sXMLSystemID, aXML),
                                                                  aDisplayLocale);

        {
          boolean bValidationInterrupted = false;
          IErrorLevel aMostSevere = EErrorLevel.LOWEST;
          for (final ValidationResult aVR : aVRL)
          {
            if (aVR.isIgnored ())
              bValidationInterrupted = true;

            for (final IError aError : aVR.getErrorList ())
              if (aError.getErrorLevel ().isGE (aMostSevere))
                aMostSevere = aError.getErrorLevel ();
          }
          LOGGER.info ("Success: " + aMostSevere.isSuccess ());
          LOGGER.info ("Interrupted: " + bValidationInterrupted);
          LOGGER.info ("Most severe error level: " + aMostSevere);
        }

        int nPos = 1;
        final int nMaxPos = aVRL.size ();
        for (final ValidationResult aVR : aVRL)
        {
          final IValidationArtefact aVA = aVR.getValidationArtefact ();
          LOGGER.info ("  [" +
                          nPos +
                          "/" +
                          nMaxPos +
                          "] " +
                          aVA.getValidationArtefactType ().getID () +
                          " - " +
                          aVA.getRuleResource ().getPath ());

          if (aVR.isIgnored ())
            LOGGER.info ("    ignored");
          else
          {
            LOGGER.info ("  Success: " + aVR.isSuccess ());
            for (final IError aItem : aVR.getErrorList ())
            {
              LOGGER.info ("    Error Level: " + aItem.getErrorLevel ());
              if (aItem.getErrorID () != null)
                LOGGER.info ("    Error ID: " + aItem.getErrorID ());
              if (aItem.getErrorFieldName () != null)
                LOGGER.info ("    Error Field: " + aItem.getErrorFieldName ());
              LOGGER.info ("    Error Text: " + aItem.getErrorText (aDisplayLocale));
              if (aItem.getErrorLocation () != null)
                LOGGER.info ("    Location: " + aItem.getErrorLocation ());
              if (aItem instanceof SVRLResourceError)
              {
                final String sTest = ((SVRLResourceError) aItem).getTest ();
                LOGGER.info ("    Test: " + sTest);
              }
              LOGGER.info ("--");
            }
          }
          ++nPos;
        }
      }
      LOGGER.info ("Done");
    }
    else
    {
      new HelpFormatter ().printHelp ("phoss-validator validate", aOptions, true);
      System.out.println ("Press Enter to end the application...");
      System.in.read ();
    }
  }

  private static String yn (final boolean b)
  {
    return b ? "yes" : "no";
  }

  private static void _createTextResult (@Nonnull final ResponseType aResponse, @Nonnull final StringBuilder aSB)
  {
    final String sCRLF = ENewLineMode.DEFAULT.getText ();

    aSB.append ("Success: ").append (yn (aResponse.isSuccess ())).append (sCRLF);
    aSB.append ("Interrupted: ").append (yn (aResponse.isInterrupted ())).append (sCRLF);
    aSB.append ("Most severe error level: ").append (aResponse.getMostSevereErrorLevel ()).append (sCRLF);
    int nPos = 1;

    final int nMaxPos = aResponse.getResultCount ();
    for (final ValidationResultType aResult : aResponse.getResult ())
    {
      aSB.append ("  [")
         .append (nPos)
         .append ("/")
         .append (nMaxPos)
         .append ("] ")
         .append (aResult.getArtifactType ())
         .append (" - ")
         .append (aResult.getArtifactPath ())
         .append (sCRLF);
      ++nPos;

      aSB.append ("  Success: ").append (aResult.getSuccess ()).append (sCRLF);
      boolean bFirst = true;
      for (final ItemType aItem : aResult.getItem ())
      {
        if (bFirst)
          bFirst = false;
        else
          aSB.append ("    --").append (sCRLF);
        aSB.append ("    Error Level: ").append (aItem.getErrorLevel ()).append (sCRLF);
        if (aItem.getErrorID () != null)
          aSB.append ("    Error ID: ").append (aItem.getErrorID ()).append (sCRLF);
        if (aItem.getErrorFieldName () != null)
          aSB.append ("    Error Field: ").append (aItem.getErrorFieldName ()).append (sCRLF);
        aSB.append ("    Error Text: ").append (aItem.getErrorText ()).append (sCRLF);
        if (aItem.getErrorLocation () != null)
          aSB.append ("    Location: ").append (aItem.getErrorLocation ()).append (sCRLF);
        if (aItem.getTest () != null)
          aSB.append ("    Test: ").append (aItem.getTest ()).append (sCRLF);
      }
    }
  }
}
