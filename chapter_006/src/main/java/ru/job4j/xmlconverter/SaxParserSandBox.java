package ru.job4j.xmlconverter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;
import java.io.InputStream;

public class SaxParserSandBox {
    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;
        ParserConfigurator parserHandler = new ParserConfigurator();

        try (InputStream xmlData = new FileInputStream(
                "XMLToXML.xml")) {
            parser = factory.newSAXParser();
            parser.parse(xmlData, parserHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(parserHandler.getFields());
    }
}
