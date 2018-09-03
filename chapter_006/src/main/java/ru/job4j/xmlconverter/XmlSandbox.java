package ru.job4j.xmlconverter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;

public class XmlSandbox {
    public static void main(String[] args) {
        Field f1 = new Field(10);
        Field f2 = new Field(20);
        ArrayList<Field> entry = new ArrayList<Field>();
        entry.add(f1);
        entry.add(f2);
        Entries entries = new Entries(entry);


        try (StringWriter sw = new StringWriter()) {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, sw);
            System.out.println(sw);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
