/*
 * Copyright 2017 Riigi Infosüsteemide Amet
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/software/page/eupl
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and limitations under the Licence.
 */

package ee.openeid.siva.integrationtest;

import ee.openeid.siva.integrationtest.configuration.IntegrationTest;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class DdocValidationPassIT extends SiVaRestTests {

    private static final String TEST_FILES_DIRECTORY = "ddoc/live/timemark/";

    /**
     * TestCaseID: Ddoc-ValidationPass-2
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.0 with valid signatures
     *
     * Expected Result: The document should pass the validation
     *
     * File: SK-XML1.0.ddoc
     */
    @Ignore //TODO:  https://github.com/open-eid/SiVa/issues/11
    @Test
    public void ddocValidMultipleSignaturesV1_0() {
        assertAllSignaturesAreValid(postForReport("SK-XML1.0.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-3
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.1 with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: DIGIDOC-XML1.1.ddoc
     */
    @Test
    public void ddocValidSignatureV1_1() {
        assertAllSignaturesAreValid(postForReport("DIGIDOC-XML1.1.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-4
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.2 with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: DIGIDOC-XML1.2.ddoc
     */
    @Test
    public void ddocValidSignatureV1_2() {
        assertAllSignaturesAreValid(postForReport("DIGIDOC-XML1.2.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-5
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.3 with valid signature with ESTEID-SK 2011 certificate chain
     *
     * Expected Result: The document should pass the validation
     *
     * File: DIGIDOC-XML1.3.ddoc
     */
    @Test
    public void ddocValidSignatureV1_3() {
        assertAllSignaturesAreValid(postForReport("DIGIDOC-XML1.3.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-6
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.3 with valid signature, signed data file name has special characters and ESTEID-SK certificate chain
     *
     * Expected Result: The document should pass the validation
     *
     * File: susisevad1_3.ddoc
     */
    @Test
    public void ddocSpecialCharactersInDataFileValidSignature() {
        assertAllSignaturesAreValid(postForReport("susisevad1_3.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-7
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.3 KLASS3-SK certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: KLASS3-SK _ KLASS3-SK OCSP RESPONDER uus.ddoc
     */
    @Test
    public void ddocKlass3SkCertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("KLASS3-SK _ KLASS3-SK OCSP RESPONDER uus.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-8
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.3 KLASS3-SK 2010 certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: KLASS3-SK 2010 _ KLASS3-SK 2010 OCSP RESPONDER.ddoc
     */
    @Test
    public void ddocKlass3Sk2010CertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("KLASS3-SK 2010 _ KLASS3-SK 2010 OCSP RESPONDER.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-9
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.1 ESTEID-SK 2007 certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: vaikesed1.1.ddoc
     */
    @Test
    public void ddocEsteidSk2007CertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("vaikesed1.1.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-10
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.1 ESTEID-SK 2007 certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: IB-4270_ESTEID-SK 2015  SK OCSP RESPONDER 2011.ddoc
     */
    @Test
    public void ddocEsteidSk2015CertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("IB-4270_ESTEID-SK 2015  SK OCSP RESPONDER 2011.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-11
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.1 ESTEID-SK certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: EID-SK _ EID-SK OCSP RESPONDER.ddoc
     */
    @Test
    public void ddocEsteidSkCertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("EID-SK _ EID-SK OCSP RESPONDER.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-12
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.1 ESTEID-SK 2007 and OCSP 2010 certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: EID-SK 2007 _ EID-SK 2007 OCSP RESPONDER 2010.ddoc
     */
    @Test
    public void ddocEsteidSk2007Ocsp2010CertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("EID-SK 2007 _ EID-SK 2007 OCSP RESPONDER 2010.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-13
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.3 ESTEID-SK 2007 and OCSP 2007 certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: EID-SK 2007 _ EID-SK 2007 OCSP RESPONDER.ddoc
     */
    @Test
    public void ddocEsteidSk2007Ocsp2007CertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("EID-SK 2007 _ EID-SK 2007 OCSP RESPONDER.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-14
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#siva-signature-validation-policy-version-2-polv4
     *
     * Title: Ddoc v1.3 ESTEID-SK 2011 and OCSP 2011 certificate chain with valid signature
     *
     * Expected Result: The document should pass the validation
     *
     * File: EID-SK 2011 _ SK OCSP RESPONDER 2011.ddoc
     */
    @Test
    public void ddocEsteidSk2011Ocsp2011CertificateChainValidSignature() {
        assertAllSignaturesAreValid(postForReport("EID-SK 2011 _ SK OCSP RESPONDER 2011.ddoc"));
    }

    /**
     * TestCaseID: Ddoc-ValidationPass-15
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#common-validation-constraints-polv3-polv4
     *
     * Title: Ddoc with warning should pass
     *
     * Expected Result: Document passes the validation
     *
     * File: 18912.ddoc
     */
    @Test
    public void ddocWithWarningShouldPass() {
        post(validationRequestFor("18912.ddoc"))
                .then()
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.3"))
                .body("validationReport.validationConclusion.signatures[0].id", Matchers.is("S0"))
                .body("validationReport.validationConclusion.signatures[0].signatureFormat", Matchers.is("DIGIDOC_XML_1.3"))
                .body("validationReport.validationConclusion.signatures[0].signedBy", Matchers.is("SINIVEE,VEIKO,36706020210"))
                .body("validationReport.validationConclusion.signatures[0].indication", Matchers.is("TOTAL-PASSED"))
                .body("validationReport.validationConclusion.signatures[0].errors", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].name", Matchers.is("readme"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].scope", Matchers.is("FullSignatureScope"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].content", Matchers.is("Full document"))
                .body("validationReport.validationConclusion.signatures[0].claimedSigningTime", Matchers.is("2012-09-21T11:56:53Z"))
                .body("validationReport.validationConclusion.signatures[0].warnings[0].content", Matchers.is("Bad digest for DataFile: D0 alternate digest matches!"))
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.3"))
                .body("validationReport.validationConclusion.validatedDocument.filename", Matchers.is("18912.ddoc"))
                .body("validationReport.validationConclusion.validSignaturesCount", Matchers.is(1))
                .body("validationReport.validationConclusion.signaturesCount", Matchers.is(1));
    }

    /**
     * TestCaseID: DdocHashcode-ValidationPass-1
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#common-validation-constraints-polv3-polv4
     *
     * Title: Validation of DDOC Hashcode v1.0
     *
     * Expected Result: Document passes the validation
     *
     * File: SK-XML1.0_hashcode.ddoc
     */
    @Ignore //TODO: https://github.com/open-eid/SiVa/issues/11
    @Test
    public void ddocV1_0HashcodeShouldPass() {
        post(validationRequestFor("SK-XML1_0_hashcode.ddoc"))
                .then()
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("SK_XML_1.0"))
                .body("validationReport.validationConclusion.signatures[0].id", Matchers.is("S0"))
                .body("validationReport.validationConclusion.signatures[0].signatureFormat", Matchers.is("SK_XML_1.0"))
                .body("validationReport.validationConclusion.signatures[0].signatureLevel", Matchers.is(""))
                .body("validationReport.validationConclusion.signatures[0].signedBy", Matchers.is("ANSIP,ANDRUS,35610012722"))
                .body("validationReport.validationConclusion.signatures[0].indication", Matchers.is("TOTAL-PASSED"))
                .body("validationReport.validationConclusion.signatures[0].subIndication", Matchers.is(""))
                .body("validationReport.validationConclusion.signatures[0].errors", Matchers.hasSize(0))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].name", Matchers.is(""))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].scope", Matchers.is(""))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].content", Matchers.is(""))
                .body("validationReport.validationConclusion.signatures[0].claimedSigningTime", Matchers.is("2002-10-07T12:10:19Z"))
                .body("validationReport.validationConclusion.signatures[0].warnings", Matchers.hasSize(0))
                .body("validationReport.validationConclusion.signatures[0].info.bestSignatureTime", Matchers.is(""))
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.0_hashcode"))
                .body("validationReport.validationConclusion.validatedDocument.filename", Matchers.is("SK-XML1.0_hashcode.ddoc"))
                .body("validationReport.validationConclusion.validSignaturesCount", Matchers.is(2))
                .body("validationReport.validationConclusion.signaturesCount", Matchers.is(2));
    }

    /**
     * TestCaseID: DdocHashcode-ValidationPass-2
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#common-validation-constraints-polv3-polv4
     *
     * Title: Validation of DDOC Hashcode v1.1
     *
     * Expected Result: Document passes the validation
     *
     * File: DIGIDOC-XML1.1_hashcode.ddoc
     */
    @Test
    @Ignore //TODO: This tests fails in Travis. Has been executed locally
    public void ddocV1_1HashcodeShouldPass() {
        post(validationRequestFor("DIGIDOC-XML1.1_hashcode.ddoc"))
                .then()
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.1_hashcode"))
                .body("validationReport.validationConclusion.signatures[0].id", Matchers.is("S0"))
                .body("validationReport.validationConclusion.signatures[0].signatureFormat", Matchers.is("DIGIDOC_XML_1.1"))
                .body("validationReport.validationConclusion.signatures[0].signedBy", Matchers.is("KESKEL,URMO,38002240232"))
                .body("validationReport.validationConclusion.signatures[0].indication", Matchers.is("TOTAL-PASSED"))
                .body("validationReport.validationConclusion.signatures[0].errors", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].name", Matchers.is("puhkus_urmo_062006.doc"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].scope", Matchers.is("FullSignatureScope"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].content", Matchers.is("Full document"))
                .body("validationReport.validationConclusion.signatures[0].claimedSigningTime", Matchers.is("2006-06-26T12:15:40Z"))
                .body("validationReport.validationConclusion.signatures[0].warnings", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.1_hashcode"))
                .body("validationReport.validationConclusion.validatedDocument.filename", Matchers.is("DIGIDOC-XML1.1_hashcode.ddoc"))
                .body("validationReport.validationConclusion.validSignaturesCount", Matchers.is(1))
                .body("validationReport.validationConclusion.signaturesCount", Matchers.is(1));
    }

    /**
     * TestCaseID: DdocHashcode-ValidationPass-3
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#common-validation-constraints-polv3-polv4
     *
     * Title: Validation of DDOC Hashcode v1.2
     *
     * Expected Result: Document passes the validation
     *
     * File: DIGIDOC-XML1.2_hashcode.ddoc
     */

    @Test
    @Ignore //TODO: This tests fails in Travis. Has been executed locally
    public void ddocV1_2HashcodeShouldPass() {
        post(validationRequestFor("DIGIDOC-XML1.2_hashcode.ddoc"))
                .then()
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.2_hashcode"))
                .body("validationReport.validationConclusion.signatures[0].id", Matchers.is("S0"))
                .body("validationReport.validationConclusion.signatures[0].signatureFormat", Matchers.is("DIGIDOC_XML_1.2"))
                .body("validationReport.validationConclusion.signatures[0].signatureLevel", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].signedBy", Matchers.is("Eesti Ühispank: Ülekandejuhise kinnitus"))
                .body("validationReport.validationConclusion.signatures[0].indication", Matchers.is("TOTAL-PASSED"))
                .body("validationReport.validationConclusion.signatures[0].subIndication", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].errors", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].name", Matchers.is("RO219559508.pdf"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].scope", Matchers.is("FullSignatureScope"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].content", Matchers.is("Full document"))
                .body("validationReport.validationConclusion.signatures[0].claimedSigningTime", Matchers.is("2003-10-24T10:57:19Z"))
                .body("validationReport.validationConclusion.signatures[0].warnings", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.2_hashcode"))
                .body("validationReport.validationConclusion.validatedDocument.filename", Matchers.is("DIGIDOC-XML1.2_hashcode.ddoc"))
                .body("validationReport.validationConclusion.validSignaturesCount", Matchers.is(1))
                .body("validationReport.validationConclusion.signaturesCount", Matchers.is(1));
    }

    /**
     * TestCaseID: DdocHashcode-ValidationPass-4
     *
     * TestType: Automated
     *
     * Requirement: http://open-eid.github.io/SiVa/siva2/appendix/validation_policy/#common-validation-constraints-polv3-polv4
     *
     * Title: Validation of DDOC Hashcode v1.3
     *
     * Expected Result: Document passes the validation
     *
     * File: DIGIDOC-XML1.3_hashcode.ddoc
     */
    @Test
    @Ignore //TODO: This tests fails in Travis. Has been executed locally
    public void ddocV1_3HashcodeShouldPass() {
        post(validationRequestFor("DIGIDOC-XML1.3_hashcode.ddoc"))
                .then()
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.3_hashcode"))
                .body("validationReport.validationConclusion.signatures[0].id", Matchers.is("S0"))
                .body("validationReport.validationConclusion.signatures[0].signatureFormat", Matchers.is("DIGIDOC_XML_1.3"))
                .body("validationReport.validationConclusion.signatures[0].signatureLevel", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].signedBy", Matchers.is("LUKIN,LIISA,47710110274"))
                .body("validationReport.validationConclusion.signatures[0].indication", Matchers.is("TOTAL-PASSED"))
                .body("validationReport.validationConclusion.signatures[0].subIndication", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].errors", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].name", Matchers.is("Glitter-rock-4_gallery.jpg"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].scope", Matchers.is("FullSignatureScope"))
                .body("validationReport.validationConclusion.signatures[0].signatureScopes[0].content", Matchers.is("Full document"))
                .body("validationReport.validationConclusion.signatures[0].claimedSigningTime", Matchers.is("2012-10-03T07:46:31Z"))
                .body("validationReport.validationConclusion.signatures[0].warnings", Matchers.isEmptyOrNullString())
                .body("validationReport.validationConclusion.signatureForm", Matchers.is("DIGIDOC_XML_1.3_hashcode"))
                .body("validationReport.validationConclusion.validatedDocument.filename", Matchers.is("DIGIDOC-XML1.3_hashcode.ddoc"))
                .body("validationReport.validationConclusion.validSignaturesCount", Matchers.is(1))
                .body("validationReport.validationConclusion.signaturesCount", Matchers.is(1));
    }

    @Override
    protected String getTestFilesDirectory() {
        return TEST_FILES_DIRECTORY;
    }
}
