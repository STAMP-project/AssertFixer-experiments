package domonkos.suranyi.me_d;

import java.util.NoSuchElementException;


public enum MidiFormat {
    FORMAT_0,
    FORMAT_1,
    FORMAT_2;

    public static MidiFormat getByValue(final int value) {
        switch (value) {
        case 0:
            return FORMAT_0;
        case 1:
            return FORMAT_1;
        case 2:
            return FORMAT_2;
        default:
            throw new NoSuchElementException("Invalid format value: 0x" + Integer.toHexString(value));
        }
    }
}
