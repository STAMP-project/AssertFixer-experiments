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

package ee.openeid.validation.service.ddoc;

import ee.openeid.siva.validation.exception.MalformedDocumentException;
import ee.openeid.validation.service.ddoc.security.SecureSAXParsers;
import ee.sk.digidoc.factory.SignatureInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@ConfigurationProperties(prefix = "siva.ddoc.xmlEntityAttack")
public class XMLEntityAttackValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(XMLEntityAttackValidator.class);

    protected void validateAgainstXMLEntityAttacks(byte[] xmlContent) {
        try {
            SAXParser saxParser = SecureSAXParsers.createParser();
            InputStream inputStream = new SignatureInputStream(new ByteArrayInputStream(xmlContent));

            saxParser.getXMLReader().parse(new InputSource(inputStream));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error("Exception when validation document against XML entity attacks: " + e.getMessage(), e);
            throw new MalformedDocumentException(e);
        }
    }

}
