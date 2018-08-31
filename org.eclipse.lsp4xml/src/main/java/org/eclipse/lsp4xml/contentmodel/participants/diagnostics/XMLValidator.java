/**
 *  Copyright (c) 2018 Angelo ZERR
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *  Angelo Zerr <angelo.zerr@gmail.com> - initial API and implementation
 */
package org.eclipse.lsp4xml.contentmodel.participants.diagnostics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;

import org.apache.xml.resolver.tools.CatalogResolver;
import org.eclipse.lsp4j.Diagnostic;
import org.eclipse.lsp4j.jsonrpc.CancelChecker;
import org.eclipse.lsp4xml.commons.TextDocument;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * XML validator utilities class.
 *
 */
public class XMLValidator {

	private static final Logger LOGGER = Logger.getLogger(XMLValidator.class.getName());

	public static void doDiagnostics(TextDocument document, Schema schema, CatalogResolver catalogResolver,
			List<Diagnostic> diagnostics, CancelChecker monitor) {

		// System.setProperty("org.apache.xerces.xni.parser.XMLParserConfiguration",
		// "org.apache.xerces.parsers.XMLGrammarCachingConfiguration");
		String xmlContent = document.getText();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);

		if (schema != null) {
			factory.setSchema(schema);
		} else {
			factory.setValidating(
					xmlContent.contains("schemaLocation") || xmlContent.contains("noNamespaceSchemaLocation"));
		}

		try {
			SAXParser parser = factory.newSAXParser();
			if (schema == null) {
				parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
						"http://www.w3.org/2001/XMLSchema");
			}

			// Add LSP error reporter to fill LSP diagnostics from Xerces errors
			parser.setProperty("http://apache.org/xml/properties/internal/error-reporter",
					new LSPErrorReporter(document, diagnostics));

			XMLReader reader = parser.getXMLReader();
			reader.setFeature("http://apache.org/xml/features/continue-after-fatal-error", false); //$NON-NLS-1$

			// XML catalog
			if (catalogResolver != null) {
				reader.setEntityResolver(catalogResolver);
			}

			// Add LSP content handler to stop XML parsing if monitor is canceled.
			reader.setContentHandler(new LSPContentHandler(monitor));

			// Parse XML
			String content = document.getText();
			String uri = document.getUri();
			InputSource inputSource = new InputSource();
			inputSource.setByteStream(new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8.name())));
			inputSource.setSystemId(uri);
			reader.parse(inputSource);

		} catch (IOException | ParserConfigurationException | SAXException | CancellationException exception) {
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Unexpected XMLValidator error", e);
		}
	}

}
