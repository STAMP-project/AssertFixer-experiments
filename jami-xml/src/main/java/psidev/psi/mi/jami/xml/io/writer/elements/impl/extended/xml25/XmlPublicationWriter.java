package psidev.psi.mi.jami.xml.io.writer.elements.impl.extended.xml25;

import psidev.psi.mi.jami.xml.io.writer.elements.impl.extended.XmlDbXrefWriter;

import javax.xml.stream.XMLStreamWriter;

/**
 * Xml25 writer for publications (bibref objects)
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>11/11/13</pre>
 */
public class XmlPublicationWriter extends psidev.psi.mi.jami.xml.io.writer.elements.impl.xml25.XmlPublicationWriter {

    /**
     * <p>Constructor for XmlPublicationWriter.</p>
     *
     * @param writer a {@link javax.xml.stream.XMLStreamWriter} object.
     */
    public XmlPublicationWriter(XMLStreamWriter writer){
        super(writer);
    }

    /**
     * <p>initialiseXrefWriter.</p>
     */
    protected void initialiseXrefWriter() {
        super.setXrefWriter(new XmlDbXrefWriter(getStreamWriter()));
    }
}
