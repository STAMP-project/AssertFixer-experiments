package io.github.caiwan.spreadsheet.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExcelCellIdParser {

    private static final Pattern CELLID_REGEX = Pattern.compile("([a-zA-Z]+)([0-9]+)");

    /**
     * @return [1] = col, [2]= row, with zero base
     * Like A1 will return 0, 0, B1 will 1, 0 and so on
     */
    public static int[] parseId(String string) {

        Matcher matcher = CELLID_REGEX.matcher(string);
        if (matcher.find()) {
            String col = matcher.group(1);
            String row = matcher.group(2);

            return new int []{cellToNumber(col), Integer.parseInt(row) - 1};
        }

        return null;

    }

    private static int cellToNumber(String col) {
        int r = 0;
        for (int i = col.length() - 1; i >= 0; i--) {
            int c = Character.toUpperCase(col.charAt(i)) - 65;
            r += 26 * i + c;
        }
        return r;
    }

}
