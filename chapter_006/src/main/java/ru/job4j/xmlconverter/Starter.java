package ru.job4j.xmlconverter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * /*Main class
 * <p>
 * All the actions with files and DB duplicate to console.
 *
 * @n - main parameter. Amount of iterations.
 * App puts nums to DB from 0 to n
 * If there's on such DB it will be created according to property file
 * After nums have been inserted app get all the data and put it to XML file
 * As XML file has been created app automatically convert it to another XMl file
 * an then parse it using SAX libraries. The sum of all fields of DB writes to console.
 */

public class Starter {
    File scheme = new File("chapter_006/src/main/resources/scheme.xslt");
    File xmlVersionOne = new File("chapter_006/target/xmlVersionOne.xml");
    File xmlVersionTwo = new File("chapter_006/target/xmlVersionTwo.xml");
    StoreSQL store;
    StoreXML storeXML = null;
    List<Integer> dbResult = new ArrayList<>();
    ConvertXSQT converter = new ConvertXSQT();
    SaxConverter saxConverter;
    int n = 100;

    public void startConverter() {
        store = new StoreSQL(new Config(new String("chapter_006/src/main/resources/sqlLiteXmlConfig.properties")));
        try {
            store.setUp();
        } catch (Exception e) {
            System.out.println("Unable to load store SQL...");
            e.printStackTrace();
        }
        store.generate(n);
        dbResult = store.get();
        storeXML = new StoreXML(dbResult);
        storeXML.getXMLStorage();
        storeXML.saveXml(xmlVersionOne.getPath());
        converter.convert(xmlVersionOne, xmlVersionTwo, scheme);
        saxConverter = new SaxConverter(xmlVersionTwo);
        saxConverter.convert();
        System.out.println(saxConverter.getSum());
    }

    public static void main(String[] args) {
        new Starter().startConverter();
    }
}
