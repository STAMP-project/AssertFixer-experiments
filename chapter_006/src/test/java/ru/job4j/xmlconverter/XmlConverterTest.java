package ru.job4j.xmlconverter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class XmlConverterTest {
    Connection connection;

    @Before
    public void setUp() {
        String path = new String("src/main/resources/sqlLiteXmlConfig.properties");
        Config config = new Config(path);
        try {
            connection = DriverManager.getConnection(config.getUrl(), config.getUser(),
                    config.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void shutDown() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Config test. Prints config.
     */
    @Test
    public void whenReadPropertiesThenRead() {
        String path = new String(
                "src/main/resources/sqlLiteXmlConfig.properties");
        Config config = new Config(path);
        System.out.println(config.getUrl());
        System.out.println(config.getUser());
        System.out.println(config.getPassword());
        System.out.println(config.getUrlToCreateNewDb());
        System.out.println(config.getdBCreateScript());
        System.out.println(config.getCreateTableScript());
    }

    @Test
    public void whenConvertXMLThenConverted() {
        ConvertXSQT converter = new ConvertXSQT();
        File source = new File(
                "src/test/java/ru/job4j/xmlconverter/outputs/ListToXML.xml");
        File dest = new File(
                "src/test/java/ru/job4j/xmlconverter/outputs/XMLToXML.xml");
        File scheme = new File("src/main/resources/scheme.xslt");
        converter.convert(source, dest, scheme);
    }

    @Test
    public void whenParseXmlThenGetSum() {
        File source = new File("src/test/java/ru/job4j/xmlconverter/outputs/XMLToXML.xml");
        SaxConverter converter = new SaxConverter(source);
        converter.convert();
        System.out.println(converter.getSum());
        assertThat(converter.getSum(), is(6));
    }

    @Test
    public void whenGetSetThenGotIt() {
        String path = "src/main/resources/sqlLiteXmlConfig.properties";
        StoreSQL store = new StoreSQL(new Config(path));
        store.setUp();
        PreparedStatement st = null;
        ResultSet result;
        List<Integer> expected = new ArrayList<>();
        List<Integer> storeResult = new ArrayList<>();
        try {
            st = connection.prepareStatement("SELECT field FROM entry;");
            result = st.executeQuery();
            while (result.next()) {
                expected.add(result.getInt(1));
            }
            storeResult = store.get();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < storeResult.size(); i++) {
            assertTrue(storeResult.get(i) == expected.get(i));
        }
    }

    /**
     * xml test
     */
    @Test
    public void whenPutListThenGetXML() {
        List<Integer> testEntry = new ArrayList<>();
        String path = new String(
                "src/test/java/ru/job4j/xmlconverter/outputs/ListToXML.xml");
        testEntry.add(1);
        testEntry.add(2);
        testEntry.add(3);
        StoreXML store = new StoreXML(testEntry);
        System.out.println(store.getXMLStorage());
        store.saveXml(path);
    }
    /**
     * xml converter test
     */

}
