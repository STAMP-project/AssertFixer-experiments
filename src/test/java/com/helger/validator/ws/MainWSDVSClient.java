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
package com.helger.validator.ws;

import java.nio.charset.StandardCharsets;

import javax.xml.ws.BindingProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.bdve.peppol.PeppolValidation360;
import com.helger.commons.io.resource.ClassPathResource;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.io.stream.StreamHelper;
import com.helger.commons.url.URLHelper;
import com.helger.validator.wsclient.ItemType;
import com.helger.validator.wsclient.RequestType;
import com.helger.validator.wsclient.ResponseType;
import com.helger.validator.wsclient.ValidateFaultError;
import com.helger.validator.wsclient.ValidationResultType;
import com.helger.validator.wsclient.WSDVSPort;
import com.helger.validator.wsclient.WSDVSService;
import com.helger.wsclient.WSClientConfig;
import com.helger.wsclient.WSHelper;

public final class MainWSDVSClient
{
  private static final Logger LOGGER = LoggerFactory.getLogger (MainWSDVSClient.class);

  public static void main (final String [] args) throws ValidateFaultError
  {
    WSHelper.enableSoapLogging (true);

    LOGGER.info ("Starting the engines");
    final String sXML = StreamHelper.getAllBytesAsString (new ClassPathResource ("ws/invoice1.xml"),
                                                          StandardCharsets.UTF_8);

    final WSDVSService aService = new WSDVSService (new FileSystemResource ("src/main/webapp/WEB-INF/wsdl/pp-dvs.wsdl").getAsURL ());
    final WSDVSPort aPort = aService.getWSDVSPort ();

    final WSClientConfig aWsClientConfig = new WSClientConfig (URLHelper.getAsURL ("http://localhost:8080/wsdvs"));
    aWsClientConfig.setRequestTimeoutMS (10_000);
    aWsClientConfig.applyWSSettingsToBindingProvider ((BindingProvider) aPort);

    LOGGER.info ("Starting validation process");
    final RequestType aRequest = new RequestType ();
    aRequest.setVESID (PeppolValidation360.VID_OPENPEPPOL_T10_V2.getAsSingleID ());
    aRequest.setXML (sXML);
    aRequest.setDisplayLocale ("en");
    final ResponseType aResponse = aPort.validate (aRequest);
    LOGGER.info ("Success: " + aResponse.isSuccess ());
    LOGGER.info ("Interrupted: " + aResponse.isInterrupted ());
    LOGGER.info ("Most severe error level: " + aResponse.getMostSevereErrorLevel ());
    int nPos = 1;
    final int nMaxPos = aResponse.getResultCount ();
    for (final ValidationResultType aResult : aResponse.getResult ())
    {
      LOGGER.info ("  [" +
                      nPos +
                      "/" +
                      nMaxPos +
                      "] " +
                      aResult.getArtifactType () +
                      " - " +
                      aResult.getArtifactPath ());
      ++nPos;

      LOGGER.info ("  Success: " + aResult.getSuccess ());
      for (final ItemType aItem : aResult.getItem ())
      {
        LOGGER.info ("    Error Level: " + aItem.getErrorLevel ());
        if (aItem.getErrorID () != null)
          LOGGER.info ("    Error ID: " + aItem.getErrorID ());
        if (aItem.getErrorFieldName () != null)
          LOGGER.info ("    Error Field: " + aItem.getErrorFieldName ());
        LOGGER.info ("    Error Text: " + aItem.getErrorText ());
        if (aItem.getErrorLocation () != null)
          LOGGER.info ("    Location: " + aItem.getErrorLocation ());
        if (aItem.getTest () != null)
          LOGGER.info ("    Test: " + aItem.getTest ());
        LOGGER.info ("--");
      }
    }
    LOGGER.info ("Done");
  }
}
