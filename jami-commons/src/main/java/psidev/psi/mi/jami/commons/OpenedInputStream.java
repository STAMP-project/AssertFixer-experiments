package psidev.psi.mi.jami.commons;

import java.io.*;

/**
 * The openedInputStream contains a PushbackReader reader that can read the opened input stream
 * and the type of dataSourceFile it represents.
 *
 * It needs to be closed after being used.
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>01/03/13</pre>
 */
public class OpenedInputStream {

    private PushbackReader reader;
    private MIFileType source;

    /**
     * <p>Constructor for OpenedInputStream.</p>
     *
     * @param reader a {@link java.io.PushbackReader} object.
     * @param source a {@link psidev.psi.mi.jami.commons.MIFileType} object.
     * @throws java.io.FileNotFoundException if any.
     */
    public OpenedInputStream(PushbackReader reader, MIFileType source) throws FileNotFoundException {
        this.reader = reader;
        this.source = source;
    }

    /**
     * <p>Getter for the field <code>reader</code>.</p>
     *
     * @return a {@link java.io.PushbackReader} object.
     */
    public PushbackReader getReader() {
        return reader;
    }

    /**
     * <p>Getter for the field <code>source</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.commons.MIFileType} object.
     */
    public MIFileType getSource() {
        return source;
    }

    /**
     * <p>close.</p>
     *
     * @throws java.io.IOException if any.
     */
    public void close() throws IOException {
        if (this.reader != null){
            reader.close();
        }
    }
}
