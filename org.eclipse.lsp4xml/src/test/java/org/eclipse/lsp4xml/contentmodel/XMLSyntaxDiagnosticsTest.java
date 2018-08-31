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
package org.eclipse.lsp4xml.contentmodel;

import static org.eclipse.lsp4xml.XMLAssert.d;
import static org.eclipse.lsp4xml.XMLAssert.testDiagnosticsFor;

import org.eclipse.lsp4xml.contentmodel.participants.XMLSyntaxErrorCode;
import org.eclipse.lsp4xml.services.XMLLanguageService;
import org.junit.Ignore;
import org.junit.Test;

/**
 * XML diagnostics services tests
 *
 */
public class XMLSyntaxDiagnosticsTest {

	/**
	 * AttributeNotUnique tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/AttributeNotUnique
	 * @throws Exception
	 */
	@Test
	public void testAttributeNotUnique() throws Exception {
		String xml = "<InstdAmt Ccy=\"JPY\" Ccy=\"JPY\" >10000000</InstdAmt>";
		testDiagnosticsFor(xml, d(0, 20, 0, 23, XMLSyntaxErrorCode.AttributeNotUnique));
	}

	/**
	 * AttributeNSNotUnique tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/AttributeNSNotUnique
	 * @throws Exception
	 */
	@Test
	public void testAttributeNSNotUnique() throws Exception {
		String xml = "<Document xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\"\r\n"
				+ "\r\n" + //
				"xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\"> ";
		testDiagnosticsFor(xml, d(2, 0, 2, 5, XMLSyntaxErrorCode.AttributeNSNotUnique));
	}

	/**
	 * ContentIllegalInProlog tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/ContentIllegalInProlog
	 * @throws Exception
	 */
	@Test
	public void testContentIllegalInProlog() throws Exception {
		String xml = " ab?<xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>";
		testDiagnosticsFor(xml, d(0, 1, 0, 4, XMLSyntaxErrorCode.ContentIllegalInProlog));
	}

	/**
	 * DashDashInComment tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/DashDashInComment
	 * @throws Exception
	 */
	@Test
	public void testDashDashInComment() throws Exception {
		String xml = "<Id>\r\n" + //
				"					<!-- comment -- text -->\r\n" + //
				"        </Id>";
		testDiagnosticsFor(xml, d(1, 18, 1, 20, XMLSyntaxErrorCode.DashDashInComment));
	}

	/**
	 * ElementUnterminated tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/ElementUnterminated
	 * @throws Exception
	 */
	@Test
	public void testElementUnterminated() throws Exception {
		String xml = "<Id>\r\n" + //
				"          <OrgId\r\n" + //
				"            <Othr>\r\n" + //
				"              <Id> 222010012</Id>\r\n" + //
				"            </Othr>\r\n" + //
				"          </OrgId>\r\n" + //
				"        </Id>";
		testDiagnosticsFor(xml, d(1, 11, 1, 16, XMLSyntaxErrorCode.ElementUnterminated));
	}

	/**
	 * EmptyPrefixedAttName tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/EmptyPrefixedAttName
	 * @throws Exception
	 */
	@Test
	public void testEmptyPrefixedAttName() throws Exception {
		// FIXME: adjust it!
		String xml = "<Document xmlns:xsi=\"\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">";
		testDiagnosticsFor(xml, d(0, 20, 0, 22, XMLSyntaxErrorCode.EmptyPrefixedAttName));
	}

	@Ignore
	@Test
	public void testEncodingDeclRequired() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" lang=\"en\" ?><a></a>";
		testDiagnosticsFor(xml, d(0, 20, 0, 22, XMLSyntaxErrorCode.EncodingDeclRequired));
	}

	@Test
	public void testEqRequiredInAttribute() throws Exception {
		// FIXME: adjust it!
		String xml = "<a Ccy>123.456</a>";
		testDiagnosticsFor(xml, d(0, 6, 0, 6, XMLSyntaxErrorCode.EqRequiredInAttribute));
	}

	@Ignore("This test works on OS Windows but fails in travis, why? ")
	@Test
	public void testEqRequiredInXMLDecl() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version:\"1.0\" encoding=\"UTF-8\"?><a></a>";
		testDiagnosticsFor(xml, d(0, 14, 0, 14, XMLSyntaxErrorCode.EqRequiredInXMLDecl));
	}

	/**
	 * ETagRequired tests
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/ETagRequired * @throws
	 *      Exception
	 */
	@Test
	public void testETagRequired() throws Exception {
		String xml = "<UltmtDbtr>\r\n" + //
				"  		<Nm>Name\r\n" + //
				"		</UltmtDbtr> \r\n" + //
				"			</Nm>  ";
		testDiagnosticsFor(xml, d(2, 4, 2, 13, XMLSyntaxErrorCode.ETagRequired));
	}

	@Test
	public void testETagRequired2() throws Exception {
		// FIXME: adjust it!
		String xml = "<UltmtDbtr>\r\n" + //
				"  		Nm>Name</Nm>\r\n" + //
				"		</UltmtDbtr>";
		testDiagnosticsFor(xml, d(1, 13, 1, 13, XMLSyntaxErrorCode.ETagRequired));
	}

	/**
	 * Test ETagUnterminated
	 * 
	 * @see https://wiki.xmldation.com/Support/Validator/ETagUnterminated
	 * @throws Exception
	 */
	@Test
	public void testETagUnterminated() throws Exception {
		String xml = "<MsgId>ABC/090928/CCT001</MsgId\r\n" + //
				"  <CreDtTm>2009-09-28T14:07:00</CreDtTm>";
		testDiagnosticsFor(xml, d(0, 26, 0, 31, XMLSyntaxErrorCode.ETagUnterminated));
	}

	@Test
	public void testIllegalQName() throws Exception {
		// FIXME: adjust it!
		String xml = "<a Ccy:\"JPY\">100</a>";
		testDiagnosticsFor(xml, d(0, 7, 0, 7, XMLSyntaxErrorCode.IllegalQName));
	}

	@Test
	public void testInvalidCommentStart() throws Exception {
		// FIXME: adjust it!
		String xml = "<!- gdfgdfg -- starts here -->";
		testDiagnosticsFor(xml, d(0, 3, 0, 3, XMLSyntaxErrorCode.InvalidCommentStart));
	}

	@Test
	public void testLessThanAttValue() throws Exception {
		// FIXME: adjust it!
		String xml = "<InstdAmt Ccy=\"<EUR\">123.45</InstdAmt> ";
		testDiagnosticsFor(xml, d(0, 15, 0, 15, XMLSyntaxErrorCode.LessthanInAttValue));
	}

	@Test
	public void testMarkupEntityMismatch() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" //
				+ "<Document xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns=\"urn:iso:std:iso:20022:tech:xsd:pain.001.001.03\">\r\n" //
				+ "<CstmrCdtTrfInitn>\r\n" + //
				"</CstmrCdtTrfInitn>";
		testDiagnosticsFor(xml, d(3, 19, 3, 19, XMLSyntaxErrorCode.MarkupEntityMismatch));
	}

	@Test
	public void testMarkupNotRecognizedInContent() throws Exception {
		// FIXME: adjust it!
		String xml = "<GrpHdr>\r\n" + //
				"<- almost a comment-->\r\n" + //
				"<MsgId>2.012.001</MsgId>";
		testDiagnosticsFor(xml, d(1, 1, 1, 1, XMLSyntaxErrorCode.MarkupNotRecognizedInContent));
	}

	@Test
	public void testNameRequiredInReference() throws Exception {
		// FIXME: adjust it!
		String xml = "<Nm>Virgay & Co</Nm>";
		testDiagnosticsFor(xml, d(0, 12, 0, 12, XMLSyntaxErrorCode.NameRequiredInReference));
	}

	@Test
	public void testOpenQuoteExpected() throws Exception {
		// FIXME: adjust it!
		String xml = " <InstdAmt Ccy==\"JPY\">10000000</InstdAmt>";
		testDiagnosticsFor(xml, d(0, 15, 0, 15, XMLSyntaxErrorCode.OpenQuoteExpected));
	}

	@Test
	public void testPITargetRequired() throws Exception {
		// FIXME: adjust it!
		String xml = "<? encoding=\"UTF-8\"?>";
		testDiagnosticsFor(xml, d(0, 2, 0, 2, XMLSyntaxErrorCode.PITargetRequired));
	}

	@Test
	public void testPseudoAttrNameExpected() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"><a></a>";
		testDiagnosticsFor(xml, d(0, 36, 0, 36, XMLSyntaxErrorCode.PseudoAttrNameExpected));
	}

	@Test
	public void testQuoteRequiredInXMLDecl() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version= encoding=\"UTF-8\"?>";
		testDiagnosticsFor(xml, d(0, 14, 0, 14, XMLSyntaxErrorCode.QuoteRequiredInXMLDecl));
	}

	@Test
	public void testSDDeclInvalid() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"en\"?>";
		testDiagnosticsFor(xml, d(0, 52, 0, 52, XMLSyntaxErrorCode.SDDeclInvalid));
	}

	@Test
	public void testSpaceRequiredBeforeEncodingInXMLDecl() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\"encoding=\"UTF-8\"?>";
		testDiagnosticsFor(xml, d(0, 35, 0, 35, XMLSyntaxErrorCode.SpaceRequiredBeforeEncodingInXMLDecl));
	}

	@Test
	public void testSpaceRequiredBeforeStandalone() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"standalone=\"no\"?>";
		testDiagnosticsFor(xml, d(0, 51, 0, 51, XMLSyntaxErrorCode.SpaceRequiredBeforeStandalone));
	}

	@Test
	public void testSpaceRequiredInPI() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xmlversion=\"1.0\" encoding=\"UTF-8\"?>";
		testDiagnosticsFor(xml, d(0, 12, 0, 12, XMLSyntaxErrorCode.SpaceRequiredInPI));
	}

	/**
	 * @see https://wiki.xmldation.com/Support/Validator/the-element-type-lmsg
	 * @throws Exception
	 */
	@Ignore
	@Test
	public void testTheElementTypeLmsg() throws Exception {
		// FIXME: adjust it!
		String xml = "<Issr>ADE</Lssr>";
		testDiagnosticsFor(xml, d(0, 20, 0, 22, XMLSyntaxErrorCode.the_element_type_lmsg));
	}

	@Test
	public void testVersionInfoRequired() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml encoding=\"UTF-8\"?>";
		testDiagnosticsFor(xml, d(0, 22, 0, 22, XMLSyntaxErrorCode.VersionInfoRequired));
	}

	@Test
	public void testVersionNotSupported() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"5000.0\"encoding=\"UTF-8\"?>";
		testDiagnosticsFor(xml, d(0, 22, 0, 22, XMLSyntaxErrorCode.VersionNotSupported));
	}

	@Ignore
	@Test
	public void testXMLDeclUnterminated() throws Exception {
		// FIXME: adjust it!
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?";
		testDiagnosticsFor(xml, d(0, 37, 0, 37, XMLSyntaxErrorCode.XMLDeclUnterminated));
	}
}
