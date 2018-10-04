package domonkos.suranyi.me_d;

public class HeaderChunk {
    static final int CHUNK_FULL_LENGTH = 14;
    static final String TYPE = "MThd";

    public final MidiFormat format;
    public final int numOfTrackChunks;
    public final int division;

    public HeaderChunk(final byte[] chunkBytes) {
        format = MidiFormat.getByValue(Utility.getInt(chunkBytes, 0, 2));
        numOfTrackChunks = Utility.getInt(chunkBytes, 2, 2);
        division = Utility.getInt(chunkBytes, 4, 2);
    }
}
