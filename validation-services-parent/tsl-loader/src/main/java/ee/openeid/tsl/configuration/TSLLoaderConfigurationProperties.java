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

package ee.openeid.tsl.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

@Data
@ConfigurationProperties(prefix = "siva.tsl.loader")
public class TSLLoaderConfigurationProperties {
    private boolean loadFromCache = false;
    private String url = "https://ec.europa.eu/information_society/policy/esignature/trusted-list/tl-mp.xml";
    private String ojUrl = "http://eur-lex.europa.eu/legal-content/EN/TXT/?uri=uriserv:OJ.C_.2016.233.01.0001.01.ENG";
    private String lotlRootSchemeInfoUri = "https://ec.europa.eu/information_society/policy/esignature/trusted-list/tl.html";
    private String code = "EU";
    private String schedulerCron = "0 0 3 * * ?";
    private List<String> trustedTerritories =   Arrays.asList("AT", "BE", "BG", "CY", "CZ", "DE", "DK", "EE", "ES", "FI", "FR", "GR", "HU", "HR", "IE", "IS", "IT", "LT", "LU", "LV", "LI", "MT", "NO", "NL", "PL", "PT", "RO", "SE", "SI", "SK", "UK");
}
