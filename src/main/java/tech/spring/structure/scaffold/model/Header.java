package tech.spring.structure.scaffold.model;

import tech.spring.structure.scaffold.ScaffoldProperty.PropertyHeader;

public class Header {

    private final String text;

    private final boolean italicized;

    public Header(PropertyHeader header) {
        this.text = header.text();
        this.italicized = header.italicized();
    }

    public Header(String text, boolean italicized) {
        this.text = text;
        this.italicized = italicized;
    }

    public String getText() {
        return text;
    }

    public boolean isItalicized() {
        return italicized;
    }

}
