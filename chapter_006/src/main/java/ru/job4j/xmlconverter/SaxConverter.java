package ru.job4j.xmlconverter;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SaxConverter {
    private List<String> fields = new ArrayList<>();
    private File path;
    private int sum = 0;


    public SaxConverter(File path) {
        this.path = path;
    }

    private void add() {
        for (String field : fields) {
            sum += Integer.valueOf(field);
        }
    }

    public int getSum() {

        return sum;
    }

    public void convert() {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setValidating(true);
        factory.setNamespaceAware(false);
        SAXParser parser;
        ParserConfigurator parserHandler = new ParserConfigurator();

        try (InputStream xmlData = new FileInputStream(
                this.path)) {

            parser = factory.newSAXParser();
            parser.parse(xmlData, parserHandler);
        } catch (Exception e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
        fields.addAll(parserHandler.getFields());
        this.add();
    }
}
