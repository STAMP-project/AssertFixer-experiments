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

package ee.openeid.tsl;

import eu.europa.esig.dss.tsl.ServiceInfo;
import eu.europa.esig.dss.tsl.TrustedListsCertificateSource;
import eu.europa.esig.dss.x509.CertificateToken;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomCertificatesLoaderTest {

    private TrustedListsCertificateSource trustedListSource;

    @Before
    public void setUp() {
        CustomCertificatesLoader customCertificatesLoader = new CustomCertificatesLoader();
        trustedListSource = new TrustedListsCertificateSource();
        customCertificatesLoader.setTrustedListsCertificateSource(trustedListSource);
        customCertificatesLoader.init();
    }

    @Test
    public void allTestCertificatesShouldBeAddedToTSL() {
        List<CertificateToken> certTokens = getCertificateTokens();
        assertEquals(12, certTokens.size());
    }

    @Test
    public void softCertCAShouldNotBeLoadedWithQCServiceInfoQualifiers() {
        getServiceInfoStream()
                .filter(this::isManagementOrNortalServiceInfo)
                .forEach(this::assertNoQualifiers);
    }


    @Test
    public void testSKCAsShouldBeLoadedWithQCServiceInfoQualifiers() {
        getServiceInfoStream()
                .filter(this::isNonManagementCA)
                .forEach(this::assertQcQualifiers);
    }

    private Stream<ServiceInfo> getServiceInfoStream() {
        return getCertificateTokens()
                .stream()
                .map(this::getServiceInfo);
    }

    private boolean isManagementOrNortalServiceInfo(ServiceInfo serviceInfo) {
        return StringUtils.contains(serviceInfo.getServiceName(), "Management") || StringUtils.contains(serviceInfo.getServiceName(), "Nortal");
    }

    private boolean isNonManagementCA(ServiceInfo serviceInfo) {
        return
                StringUtils.equals("http://uri.etsi.org/TrstSvc/Svctype/CA/QC", serviceInfo.getStatus().getLatest().getType()) &&
                !isManagementOrNortalServiceInfo(serviceInfo);
    }

    private List<CertificateToken> getCertificateTokens() {
        return trustedListSource
                .getCertificatePool()
                .getCertificateTokens();
    }

    private void assertNoQualifiers(ServiceInfo serviceInfo) {
        serviceInfo.getStatus().iterator().forEachRemaining(s->s.getQualifiersAndConditions().isEmpty());
        assertTrue(serviceInfo.getStatus().getLatest().getQualifiersAndConditions().keySet().isEmpty());

    }

    private void assertQcQualifiers(ServiceInfo serviceInfo) {
        Set<String> qualifiers = serviceInfo.getStatus().getLatest().getQualifiersAndConditions().keySet();
        assertTrue(qualifiers.contains("http://uri.etsi.org/TrstSvc/TrustedList/SvcInfoExt/QCForESig"));
        assertTrue(qualifiers.contains("http://uri.etsi.org/TrstSvc/TrustedList/SvcInfoExt/QCWithQSCD"));
        assertTrue(qualifiers.contains("http://uri.etsi.org/TrstSvc/TrustedList/SvcInfoExt/QCStatement"));

    }

    private ServiceInfo getServiceInfo(CertificateToken certificateToken) {
        return (ServiceInfo) certificateToken.getAssociatedTSPS().toArray()[0];
    }


}
