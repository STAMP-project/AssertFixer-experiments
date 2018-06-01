package io.caiwan.utils.datasheet.build;

import io.github.caiwan.spreadsheet.utils.ExcelCellIdParser;
import io.github.caiwan.utils.Pair;
import org.junit.Assert;
import org.junit.Test;

public class ExcelCellIdParserTest {

    @Test
    public void TestCellId() {
        Assert.assertArrayEquals(new int[]{0, 0}, ExcelCellIdParser.parseId("A1"));
        Assert.assertArrayEquals(new int[]{25, 0}, ExcelCellIdParser.parseId("Z1"));
        Assert.assertArrayEquals(new int[]{26, 0}, ExcelCellIdParser.parseId("aa1"));

        Assert.assertArrayEquals(new int[]{0, 9}, ExcelCellIdParser.parseId("A10"));
        Assert.assertArrayEquals(new int[]{25, 9}, ExcelCellIdParser.parseId("Z10"));
        Assert.assertArrayEquals(new int[]{26, 9}, ExcelCellIdParser.parseId("Aa10"));
    }
}
