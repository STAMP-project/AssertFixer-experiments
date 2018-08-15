package psidev.psi.mi.jami.xml.io.writer.elements.impl.xml30;

import javax.xml.stream.XMLStreamWriter;

/**
 * Writer of a source in a 3.0 entry.
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>11/11/13</pre>
 */
public class XmlSourceWriter extends psidev.psi.mi.jami.xml.io.writer.elements.impl.xml25.XmlSourceWriter {

    /**
     * <p>Constructor for XmlSourceWriter.</p>
     *
     * @param writer a {@link javax.xml.stream.XMLStreamWriter} object.
     */
    public XmlSourceWriter(XMLStreamWriter writer) {
        super(writer);
    }

    /** {@inheritDoc} */
    @Override
    protected void initialisePublicationWriter() {
        super.setPublicationWriter(new XmlPublicationWriter(getStreamWriter()));
    }
}
