package ru.job4j.xmlconverter;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class StoreXML {
    List<Integer> values;
    ArrayList<Field> entry = new ArrayList<Field>();
    Entries entries = new Entries(entry);
    StringWriter sw = new StringWriter();

    public StoreXML(List<Integer> values) {
        this.values = values;
    }

    private void convertList() {
        for (Integer value : values) {
            entry.add(new Field(value));
        }
    }


    public List<String> getXMLStorage() {
        this.convertList();
        List<String> result = new ArrayList<>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Entries.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(entries, sw);
            System.out.println(sw);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void saveXml(String path) {
        try (FileWriter fw = new FileWriter(path)) {
            fw.write(sw.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
