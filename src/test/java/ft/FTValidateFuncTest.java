package ft;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.UUID;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.helger.commons.base64.Base64;
import com.helger.commons.io.file.SimpleFileIO;
import com.helger.commons.mime.CMimeType;
import com.helger.httpclient.HttpClientFactory;
import com.helger.httpclient.HttpClientManager;
import com.helger.httpclient.HttpDebugger;
import com.helger.httpclient.response.ResponseHandlerMicroDom;
import com.helger.xml.microdom.IMicroDocument;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroDocument;
import com.helger.xml.microdom.serialize.MicroReader;
import com.helger.xml.microdom.serialize.MicroWriter;
import com.helger.xml.namespace.MapBasedNamespaceContext;
import com.helger.xml.serialize.write.XMLWriterSettings;

public class FTValidateFuncTest
{
  private static final MapBasedNamespaceContext NSCTX = new MapBasedNamespaceContext ();

  private static final String NS_DSS2 = "urn:oasis:names:tc:dss:2.0:core:schema";
  private static final String NS_ETSIVAL = "http://uri.etsi.org/119442/v1.1.1#";
  private static final String NS_VR = "urn:oasis:names:tc:dss:1.0:profiles:verificationreport:schema#";
  private static final XMLWriterSettings XWS = new XMLWriterSettings ().setNamespaceContext (NSCTX)
                                                                       .setPutNamespaceContextPrefixesInRoot (true);
  private static final XMLWriterSettings XWS_C14 = XMLWriterSettings.createForCanonicalization ()
                                                                    .setNamespaceContext (NSCTX)
                                                                    .setPutNamespaceContextPrefixesInRoot (true);

  static
  {
    NSCTX.addMapping ("ds", "http://www.w3.org/2000/09/xmldsig#");
    NSCTX.addMapping ("xenc", "http://www.w3.org/2001/04/xmlenc#");

    NSCTX.addMapping ("dss1", "urn:oasis:names:tc:dss:1.0:core:schema");
    NSCTX.addMapping ("ades", "urn:oasis:names:tc:dss:1.0:profiles:AdES:schema#");
    NSCTX.addMapping ("vr", NS_VR);
    NSCTX.addMapping ("async", "urn:oasis:names:tc:dss:1.0:profiles:asynchronousprocessing:1.0");
    NSCTX.addMapping ("timestamping", "urn:oasis:names:tc:dss:1.0:profiles:TimeStamp:schema#");
    NSCTX.addMapping ("dss", NS_DSS2);
    NSCTX.addMapping ("saml1", "urn:oasis:names:tc:SAML:1.0:assertion");
    NSCTX.addMapping ("saml2", "urn:oasis:names:tc:SAML:2.0:assertion");

    NSCTX.addMapping ("xades132", "http://uri.etsi.org/01903/v1.3.2#");
    NSCTX.addMapping ("xades141", "http://uri.etsi.org/01903/v1.4.1#");
    NSCTX.addMapping ("etsival", NS_ETSIVAL);
    NSCTX.addMapping ("ts102231", "http://uri.etsi.org/102231/v2#");
    NSCTX.addMapping ("etsivr", "http://uri.etsi.org/1191022/v1.1.1#");

    NSCTX.addMapping ("policy", "http://www.arhs-group.com/spikeseed");
    NSCTX.addMapping ("vals", "http://futuretrust.eu/vals/v1.0.0#");
  }

  @BeforeClass
  public static void beforeClass ()
  {
    HttpDebugger.setEnabled (false);
  }

  @Test
  public void testCreateNewRequest () throws Exception
  {
    final File f = new File ("src/test/resources/ft/ebi43-signed-ft.xml");
    final IMicroDocument aEbiSignedDoc = MicroReader.readMicroXML (f);
    assertNotNull (aEbiSignedDoc);

    final IMicroElement eSignatureElement = aEbiSignedDoc.getDocumentElement ().getFirstChildElement ();
    assertNotNull (eSignatureElement);
    assertEquals ("Signature", eSignatureElement.getLocalName ());

    final IMicroDocument aVerifyReuqestDoc = new MicroDocument ();
    final IMicroElement eRoot = aVerifyReuqestDoc.appendElement (NS_ETSIVAL, "VerifyRequest");
    eRoot.setAttribute ("RequestID", UUID.randomUUID ().toString ());
    eRoot.appendElement (NS_DSS2, "Profile").appendText ("http://uri.etsi.org/19442/v1.1.1/validationprofile#");
    if (false)
    {
      final IMicroElement eInputDocs = eRoot.appendElement (NS_ETSIVAL, "InputDocuments");
      final IMicroElement eDoc = eInputDocs.appendElement (NS_DSS2, "Document");
      eDoc.setAttribute ("ID", "bla");
      eDoc.setAttribute ("RefURI", f.getName ());
      final IMicroElement eBase64 = eDoc.appendElement (NS_DSS2, "Base64Data");
      final IMicroElement eValue = eBase64.appendElement (NS_DSS2, "Value");
      eValue.appendText (Base64.encodeBytes (MicroWriter.getNodeAsBytes (aEbiSignedDoc, XWS_C14),
                                             Base64.DO_BREAK_LINES));
    }
    {
      final IMicroElement eOptionalInputs = eRoot.appendElement (NS_ETSIVAL, "OptionalInputs");
      if (true)
      {
        final IMicroElement eDocWithSig = eOptionalInputs.appendElement (NS_ETSIVAL, "DocumentWithSignature");
        final IMicroElement eDoc = eDocWithSig.appendElement (NS_DSS2, "Document");
        final IMicroElement eBase64 = eDoc.appendElement (NS_DSS2, "Base64Data");
        eBase64.setAttribute ("MimeType", CMimeType.APPLICATION_XML.getAsString ());
        final IMicroElement eValue = eBase64.appendElement (NS_DSS2, "Value");
        eValue.appendText (Base64.encodeBytes (MicroWriter.getNodeAsBytes (aEbiSignedDoc, XWS_C14),
                                               Base64.DO_BREAK_LINES));
      }
      eOptionalInputs.appendElement (NS_ETSIVAL, "ReturnVerificationTimeInfo").appendText ("true");
      final IMicroElement eRVR = eOptionalInputs.appendElement (NS_VR, "ReturnVerificationReport");
      eRVR.appendElement (NS_VR, "IncludeVerifier").appendText ("true");
      eRVR.appendElement (NS_VR, "IncludeCertificateValues").appendText ("false");
      eRVR.appendElement (NS_VR, "IncludeRevocationValues").appendText ("false");
      eRVR.appendElement (NS_VR, "ExpandBinaryValues").appendText ("false");
      String sReportDetailLevel = "urn:oasis:names:tc:dss:1.0:profiles:verificationreport:reportdetail:noDetails";
      if (true)
        sReportDetailLevel = "urn:oasis:names:tc:dss:1.0:profiles:verificationreport:reportdetail:allDetails";
      eRVR.appendElement (NS_VR, "ReportDetailLevel").appendText (sReportDetailLevel);
      if (false)
        eOptionalInputs.appendElement (NS_ETSIVAL, "VerifyManifests").appendText ("true");
      eOptionalInputs.appendElement (NS_ETSIVAL, "SignVerificationReport").appendText ("true");
    }

    if (true)
    {
      final IMicroElement eSignatureObject = eRoot.appendElement (NS_ETSIVAL, "SignatureObject");
      if (false)
      {
        final IMicroElement eBase64Signature = eSignatureObject.appendElement (NS_DSS2, "Base64Signature");
        eBase64Signature.setAttribute ("MimeType", CMimeType.APPLICATION_XML.getAsString ());
        final IMicroElement eValue = eBase64Signature.appendElement (NS_DSS2, "Value");
        eValue.appendText (Base64.encodeBytes (MicroWriter.getNodeAsBytes (aEbiSignedDoc, XWS_C14),
                                               Base64.DO_BREAK_LINES));
      }
      else
      {
        final IMicroElement eSignaturePtr = eSignatureObject.appendElement (NS_DSS2, "SignaturePtr");
        eSignaturePtr.setAttribute ("WhichDocument", "bla");
        eSignaturePtr.setAttribute ("XPath",
                                    "/{http://www.ebinterface.at/schema/4p3/}Invoice/{http://www.w3.org/2000/09/xmldsig#}Signature");
      }
    }

    SimpleFileIO.writeFile (new File ("request.xml"), MicroWriter.getNodeAsBytes (aVerifyReuqestDoc, XWS));
    System.out.println ("Sending:\n" + MicroWriter.getNodeAsString (aVerifyReuqestDoc, XWS));

    final HttpClientFactory aHCFactory = new HttpClientFactory ();
    try (HttpClientManager aMgr = new HttpClientManager (aHCFactory))
    {
      final HttpPost aPost = new HttpPost ("http://localhost:8001/api/validation");
      aPost.setEntity (new ByteArrayEntity (MicroWriter.getNodeAsBytes (aVerifyReuqestDoc),
                                            ContentType.APPLICATION_XML));

      final ResponseHandlerMicroDom aRH = new ResponseHandlerMicroDom (false);
      final IMicroDocument aDoc = aMgr.execute (aPost, aRH);

      System.out.println ("Received:\n" + MicroWriter.getNodeAsString (aDoc, XWS));
      SimpleFileIO.writeFile (new File ("response.xml"), MicroWriter.getNodeAsBytes (aDoc, XWS));
    }
  }

  @Test
  @Ignore
  public void testSendPrebuild () throws Exception
  {
    final File f = new File ("src/test/resources/ft/eRechnung_01_verify-request_working.xml");

    final HttpClientFactory aHCFactory = new HttpClientFactory ();
    try (HttpClientManager aMgr = new HttpClientManager (aHCFactory))
    {
      final HttpPost aPost = new HttpPost ("http://localhost:8001/api/validation");
      aPost.setEntity (new FileEntity (f, ContentType.APPLICATION_XML));

      final ResponseHandlerMicroDom aRH = new ResponseHandlerMicroDom (false);
      final IMicroDocument aDoc = aMgr.execute (aPost, aRH);

      System.out.println ("Received:\n" + MicroWriter.getNodeAsString (aDoc, XWS));
    }
  }
}
