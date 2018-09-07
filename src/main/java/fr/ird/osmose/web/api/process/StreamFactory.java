package fr.ird.osmose.web.api.process;

import java.io.IOException;
import java.io.OutputStream;

public interface StreamFactory {
    OutputStream outputStreamFor(String name) throws IOException;
}
