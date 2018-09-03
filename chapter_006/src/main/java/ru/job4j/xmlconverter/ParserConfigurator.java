package ru.job4j.xmlconverter;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ParserConfigurator extends DefaultHandler {
    private List<String> fields = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        System.out.println(String.format("Tag %s parsed ", qName));
        if (qName.equals("entry")) {
            System.out.println(String.format("Field %s parsed", attributes.getValue("field")));
            fields.add(attributes.getValue("field"));
        }
        super.startElement(uri, localName, qName, attributes);


    }

    @Override
    public void characters(char[] c, int start, int length)
            throws SAXException {
        super.characters(c, start, length);
        for (int i = start; i < start + length; ++i) {
            System.err.print(c[i]);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        System.out.println(String.format("Tag parsed: ", qName));
        super.endElement(uri, localName, qName);
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Starting parsing the document...");
        super.startDocument();
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("Done.");

    }


    public List<String> getFields() {
        return fields;
    }
}
