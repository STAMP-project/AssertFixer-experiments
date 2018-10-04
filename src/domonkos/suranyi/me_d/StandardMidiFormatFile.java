package domonkos.suranyi.me_d;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;


public class StandardMidiFormatFile {
    private final Path path;
    private final HeaderChunk header;

    public StandardMidiFormatFile(final String path) throws IOException {
        this.path = Paths.get(path);
        try (InputStream is = Files.newInputStream(this.path);) {
            byte[] headerChunkBytes = new byte[HeaderChunk.CHUNK_FULL_LENGTH];
            if(is.read(headerChunkBytes, 0, HeaderChunk.CHUNK_FULL_LENGTH) != HeaderChunk.CHUNK_FULL_LENGTH)
                throw new IllegalArgumentException("The midi file is corrupted");
            header = new HeaderChunk(Arrays.copyOfRange(headerChunkBytes, 8, HeaderChunk.CHUNK_FULL_LENGTH));
        }
    }
    
    public MidiFormat getFormat() {
        return header.format;
    }
}
