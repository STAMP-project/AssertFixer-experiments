package ru.job4j.xmlconverter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Entries {

    ArrayList<Field> entry = new ArrayList<Field>();

    public Entries(ArrayList<Field> entry) {
        this.entry = entry;
    }

    public Entries() {
    }

    @XmlElement
    public ArrayList<Field> getEntry() {
        return entry;
    }

    public void setEntry(ArrayList<Field> entry) {
        this.entry = entry;
    }
}
