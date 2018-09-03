package ru.job4j.xmlconverter;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class ConvertXSQT {
    TransformerFactory factory = TransformerFactory.newInstance();


    public void convert(File source, File dest, File scheme) {
        Source xslt = new StreamSource(new File(scheme.toString()));
        Transformer transformer = null;

        try {
            transformer = factory.newTransformer(xslt);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        Source text = new StreamSource(new File(source.toString()));
        try {
            transformer.transform(text, new StreamResult(new File(dest.toString())));
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}