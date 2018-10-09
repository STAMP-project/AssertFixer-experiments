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

package ee.openeid.siva.statistics.googleanalytics;

import ee.openeid.siva.statistics.googleanalytics.configuration.properties.GoogleAnalyticsMeasurementProtocolProperties;
import ee.openeid.siva.statistics.model.SimpleSignatureReport;
import ee.openeid.siva.statistics.model.SimpleValidationReport;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @see <a href="https://developers.google.com/analytics/devguides/collection/protocol/v1/">Google Analytics Measurement Protocol</a>
 */
@Component
public class GoogleAnalyticsMeasurementProtocolClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoogleAnalyticsMeasurementProtocolClient.class);

    private RestTemplate restTemplate = new RestTemplateBuilder().build();

    private GoogleAnalyticsMeasurementProtocolProperties properties;

    public void sendStatisticalData(SimpleValidationReport simpleValidationReport) {
        if (!properties.isEnabled()) {
            return;
        }
        try {
            HttpEntity<String> entity = new HttpEntity<>(composeBatchRequestBody(simpleValidationReport));
            restTemplate.postForObject(properties.getUrl(), entity, byte[].class);
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("Error on URI-encoding request body: {}", e.getMessage(), e);
        } catch (HttpStatusCodeException e) {
            LOGGER.error("Batch request failed with status code: {}", e.getStatusCode(), e);
        }
    }

    private String composeBatchRequestBody(SimpleValidationReport report) throws UnsupportedEncodingException {
        List<String> events = new ArrayList<>();
        events.addAll(getContainerEvents(report));
        report.getSimpleSignatureReports().forEach(sigReport -> events.add(createSignatureEvent(sigReport, report.getContainerType(), report.getUserIdentifier())));
        StringBuilder requestBodyBuilder = new StringBuilder();
        for (String event : events) {
            String encodedEvent = UriUtils.encodeFragment(event, "UTF-8");
            requestBodyBuilder.append(encodedEvent + "\n");
        }

        return requestBodyBuilder.toString();
    }

    private List<String> getContainerEvents(SimpleValidationReport report) {
        List<String> containerEvents = new ArrayList<>();
        containerEvents.add(createContainerEvent("duration", Long.toString(report.getDuration()), report.getContainerType(), report.getUserIdentifier()));
        containerEvents.add(createContainerEvent("signaturesCount", report.getSignatureCount().toString(), report.getContainerType(), report.getUserIdentifier()));
        containerEvents.add(createContainerEvent("validSignaturesCount", report.getValidSignatureCount().toString(), report.getContainerType(), report.getUserIdentifier()));
        return containerEvents;
    }

    private String createContainerEvent(String elementLabel, String elementValue, String eventCategory, String userIdentifier) {
        String clientId = UUID.randomUUID().toString();
        String eventAction  = "Container validation";
        return "v=1&t=event&ds=" + properties.getDataSourceName() +
                "&tid=" + properties.getTrackingId() +
                "&cid=" + clientId +
                "&cd1=" + userIdentifier +
                "&ec=" + eventCategory +
                "&ea=" + eventAction +
                "&el=" + elementLabel +
                "&ev=" + elementValue;
    }

    private String createSignatureEvent(SimpleSignatureReport report, String containerType, String userIdentifier) {
        String elementLabel = report.getIndication() + (StringUtils.isEmpty(report.getSubIndication()) ? "" : "/" + report.getSubIndication());
        String eventCategory = containerType + "/" + report.getSignatureFormat();
        String clientId = UUID.randomUUID().toString();
        String eventAction  = "Signature validation";
        return "v=1&t=event&ds=" + properties.getDataSourceName() +
                "&tid=" + properties.getTrackingId() +
                "&cid=" + clientId +
                "&cd1=" + userIdentifier +
                "&ec=" + eventCategory +
                "&ea=" + eventAction +
                "&el=" + elementLabel +
                "&geoid=" + report.getCountryCode();
    }

    @Autowired
    public void setProperties(GoogleAnalyticsMeasurementProtocolProperties properties) {
        this.properties = properties;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
