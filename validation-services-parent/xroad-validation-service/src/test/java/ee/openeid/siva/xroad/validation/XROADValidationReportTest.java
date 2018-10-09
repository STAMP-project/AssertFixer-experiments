/*
 * Copyright 2017 Riigi Infosüsteemide Amet
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence");
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://joinup.ec.europa.eu/software/page/eupl5
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the Licence is
 * distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and limitations under the Licence.
 */

package ee.openeid.siva.xroad.validation;

import ee.openeid.siva.validation.document.ValidationDocument;
import ee.openeid.siva.validation.document.report.Policy;
import ee.openeid.siva.validation.document.report.SimpleReport;
import ee.openeid.siva.validation.service.signature.policy.InvalidPolicyException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static ee.openeid.siva.validation.service.signature.policy.PredefinedValidationPolicySource.ADES_POLICY;
import static ee.openeid.siva.xroad.validation.XROADTestUtils.*;
import static org.junit.Assert.assertEquals;


public class XROADValidationReportTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private XROADValidationService validationService;

    @Before
    public void setUp() {
        validationService = initializeXROADValidationService();
    }

    @Test
    public void ValidatingXRoadSimpleContainerShouldHaveOnlyTheCNFieldOfTheSingersCerificateAsSignedByFieldInValidationReport() throws Exception {
        ValidationDocument validationDocument = buildValidationDocument(XROAD_SIMPLE);
        SimpleReport report = validationService.validateDocument(validationDocument).getSimpleReport();
        assertEquals("Riigi Infosüsteemi Amet", report.getValidationConclusion().getSignatures().get(0).getSignedBy());
    }

    @Test
    public void validationReportForXroadBatchSignatureShouldHaveCorrectSignatureForm() throws Exception {
        ValidationDocument validationDocument = buildValidationDocument(XROAD_BATCHSIGNATURE);
        SimpleReport report = validationService.validateDocument(validationDocument).getSimpleReport();
        assertEquals("ASiC-E_batchsignature", report.getValidationConclusion().getSignatureForm());
    }

    @Test
    public void validationReportForXROADSimpleAndPatchSignatureShouldHaveEmptySignatureLevel() throws Exception {
        SimpleReport report1 = validationService.validateDocument(buildValidationDocument(XROAD_SIMPLE)).getSimpleReport();
        SimpleReport report2 = validationService.validateDocument(buildValidationDocument(XROAD_BATCHSIGNATURE)).getSimpleReport();
        assertEquals("", report1.getValidationConclusion().getSignatures().get(0).getSignatureLevel());
        assertEquals("", report2.getValidationConclusion().getSignatures().get(0).getSignatureLevel());
    }

    @Test
    public void signatureFormInReportShouldBeAsicEWhenValidatingXROADSimpleContainer() throws Exception {
        SimpleReport report = validationService.validateDocument(buildValidationDocument(XROAD_SIMPLE)).getSimpleReport();
        assertEquals("ASiC-E", report.getValidationConclusion().getSignatureForm());
    }

    @Test
    public void signatureFormatInReportShouldBeXadesBaselineBWhenValidatingXROADBatchSignature() throws Exception {
        SimpleReport report = validationService.validateDocument(buildValidationDocument(XROAD_BATCHSIGNATURE)).getSimpleReport();
        assertEquals("XAdES_BASELINE_B_BES", report.getValidationConclusion().getSignatures().get(0).getSignatureFormat());
    }

    @Test
    public void signatureFormatInReportShouldBeXadesBaselineLTWhenValidatingXROADSimpleContainer() throws Exception {
        SimpleReport report = validationService.validateDocument(buildValidationDocument(XROAD_SIMPLE)).getSimpleReport();
        assertEquals("XAdES_BASELINE_LT", report.getValidationConclusion().getSignatures().get(0).getSignatureFormat());
    }

    @Test
    public void validationReportShouldContainDefaultPolicyWhenPolicyIsNotExplicitlyGiven() throws Exception {
        Policy policy = validateWithPolicy("").getValidationConclusion().getPolicy();
        assertEquals(ADES_POLICY.getName(), policy.getPolicyName());
        assertEquals(ADES_POLICY.getDescription(), policy.getPolicyDescription());
        assertEquals(ADES_POLICY.getUrl(), policy.getPolicyUrl());
    }

    @Test
    public void validationReportShouldContainNoTypePolicyWhenNoTypePolicyIsGivenToValidator() throws Exception {
        Policy policy = validateWithPolicy("POLv3").getValidationConclusion().getPolicy();
        assertEquals(ADES_POLICY.getName(), policy.getPolicyName());
        assertEquals(ADES_POLICY.getDescription(), policy.getPolicyDescription());
        assertEquals(ADES_POLICY.getUrl(), policy.getPolicyUrl());
    }

    @Test
    public void validatorShouldThrowExceptionWhenGivenQESPolicy() throws Exception {
        expectedException.expect(InvalidPolicyException.class);
        validateWithPolicy("polv4");
    }

    @Test
    public void whenNonExistingPolicyIsGivenThenValidatorShouldThrowException() throws Exception {
        expectedException.expect(InvalidPolicyException.class);
        validateWithPolicy("non-existing-policy");
    }

    private SimpleReport validateWithPolicy(String policyName) throws Exception {
        ValidationDocument validationDocument = buildValidationDocument(XROAD_SIMPLE);
        validationDocument.setSignaturePolicy(policyName);
        return validationService.validateDocument(validationDocument).getSimpleReport();
    }

}
