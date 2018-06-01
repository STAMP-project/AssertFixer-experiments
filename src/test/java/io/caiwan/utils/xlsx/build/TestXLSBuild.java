package io.caiwan.utils.xlsx.build;

import io.caiwan.utils.test.utils.TestFileOutputStreamProxy;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Document;
import io.github.caiwan.spreadsheet.Row;
import io.github.caiwan.spreadsheet.Sheet;
import io.github.caiwan.spreadsheet.builder.SpreadsheetBuilder;
import io.github.caiwan.spreadsheet.builder.hssf.HSSFBuilder;
import io.github.caiwan.spreadsheet.builder.xssf.XSSFBuilder;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestXLSBuild {

    @Rule
    public TemporaryFolder temp = new TemporaryFolder();

    @Parameterized.Parameters(name = "{index}: Test building with {0} {1} ext")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {HSSFBuilder.class.getName(), "xls", HSSFBuilder.class, HSSFWorkbook.class},
                {XSSFBuilder.class.getName(), "xlsx", XSSFBuilder.class, XSSFWorkbook.class},
        });
    }

    private String builderClassName;
    private String fileExtension;
    private Class builderClazz;
    private Class loaderClazz;

    public TestXLSBuild(String builderClassName, String fileExtension, Class builderClazz, Class loaderClazz) {
        this.builderClassName = builderClassName;
        this.fileExtension = fileExtension;
        this.builderClazz = builderClazz;
        this.loaderClazz = loaderClazz;
    }

    private static final String EMPTY_OUTFILE = "./empty.";
    private static final String SHEET_OUTFILE = "./sheets.";
    private static final String SINGLEBLOCK_OUTFILE = "./singleblock.";
    private static final String MULTIBLOCK_OUTFILE = "./multiblock.";

    private SpreadsheetBuilder builder;

    @SneakyThrows
    @Before
    public void setUp() {
        this.builder = (SpreadsheetBuilder) this.builderClazz.newInstance();
    }

    @Test
    public void TestEmpty() throws IOException {
        // given
        Document document = new Document();
        document.addSheet(new Sheet("Hello"));

        // when
        TestFileOutputStreamProxy tos = new TestFileOutputStreamProxy(temp.newFile(EMPTY_OUTFILE + fileExtension));
        tos.createStrems();

        builder.build(document, tos);

        tos.close();

        // then
        assertEmptyFile(tos);
        assertXLSOpen(tos);
    }

    @Test
    public void TestSheets() throws IOException {
        // given
        Document document = new Document();
        document.addSheet(new Sheet("Hello"));
        document.addSheet(new Sheet("Hello2"));

        // when
        TestFileOutputStreamProxy tos = new TestFileOutputStreamProxy(temp.newFile(SHEET_OUTFILE + fileExtension));
        tos.createStrems();

        builder.build(document, tos);

        tos.close();

        // then
        assertEmptyFile(tos);
        org.apache.poi.ss.usermodel.Workbook worksheet = assertXLSOpen(tos);
        assertSheet(worksheet, "Hello", 0);
        assertSheet(worksheet, "Hello2", 1);

    }

    @Test
    public void TestSingleBlock() throws IOException {
        // given
        Document document = new Document();
        Sheet sheet = new Sheet();
        document.addSheet(sheet);

        sheet.setName("Sheet");
        sheet.setTitle("Sheet Title");

        Block block = new Block();
        sheet.addBlock(block);

        block.setTitle("Block Title");
        block.addHeaderColumn("Keys");
        block.addHeaderColumn("Values");

        block.addRow(new Row("key1", "value1"));
        block.addRow(new Row("key2", "value2"));

        // when
        TestFileOutputStreamProxy tos = new TestFileOutputStreamProxy(temp.newFile(SINGLEBLOCK_OUTFILE + fileExtension));
        tos.createStrems();

        builder.build(document, tos);

        tos.close();

        // then
        assertEmptyFile(tos);
        org.apache.poi.ss.usermodel.Workbook worksheet = assertXLSOpen(tos);
        org.apache.poi.ss.usermodel.Sheet fSheet = assertSheet(worksheet, sheet.getName(), 0);

        assertCellvalue(fSheet, 0, 0, sheet.getTitle());

        assertCellvalue(fSheet, 1, 0, block.getTitle());

        assertCellvalue(fSheet, 2, 0, block.getHeader().getCells().get(0).stringValue());
        assertCellvalue(fSheet, 2, 1, block.getHeader().getCells().get(1).stringValue());

        assertCellvalue(fSheet, 3, 0, block.getRows().get(0).getCells().get(0).stringValue());
        assertCellvalue(fSheet, 3, 1, block.getRows().get(0).getCells().get(1).stringValue());

        assertCellvalue(fSheet, 4, 0, block.getRows().get(1).getCells().get(0).stringValue());
        assertCellvalue(fSheet, 4, 1, block.getRows().get(1).getCells().get(1).stringValue());
    }

    @Test
    public void TestMultipleBlocks() throws IOException {
        // given
        Document document = new Document();
        Sheet sheet = new Sheet();
        document.addSheet(sheet);

        sheet.setName("Sheet");
        sheet.setTitle("Sheet Title");

        Block block = new Block();
        sheet.addBlock(block);

        block.setTitle("Block Title");
        block.addHeaderColumn("Keys");
        block.addHeaderColumn("Values");

        block.addRow(new Row("key1", "value1"));
        block.addRow(new Row("key2", "value2"));

        Block block2 = new Block();
        sheet.addBlock(block2);

        block2.setTitle("Second Block Title");
        block2.setHeader(block.getHeader());
        block2.setRows(block.getRows());

        // when
        TestFileOutputStreamProxy tos = new TestFileOutputStreamProxy(temp.newFile(MULTIBLOCK_OUTFILE + fileExtension));
        tos.createStrems();

        builder.build(document, tos);

        tos.close();

        // then
        assertEmptyFile(tos);
        org.apache.poi.ss.usermodel.Workbook worksheet = assertXLSOpen(tos);
        org.apache.poi.ss.usermodel.Sheet fSheet = assertSheet(worksheet, sheet.getName(), 0);

        assertCellvalue(fSheet, 0, 0, sheet.getTitle());

        assertCellvalue(fSheet, 1, 0, block.getTitle());

        assertCellvalue(fSheet, 2, 0, block.getHeader().getCells().get(0).stringValue());
        assertCellvalue(fSheet, 2, 1, block.getHeader().getCells().get(1).stringValue());

        assertCellvalue(fSheet, 3, 0, block.getRows().get(0).getCells().get(0).stringValue());
        assertCellvalue(fSheet, 3, 1, block.getRows().get(0).getCells().get(1).stringValue());

        assertCellvalue(fSheet, 4, 0, block.getRows().get(1).getCells().get(0).stringValue());
        assertCellvalue(fSheet, 4, 1, block.getRows().get(1).getCells().get(1).stringValue());

        // 5th row is padded

        assertCellvalue(fSheet, 6, 0, block2.getTitle());

        assertCellvalue(fSheet, 7, 0, block2.getHeader().getCells().get(0).stringValue());
        assertCellvalue(fSheet, 7, 1, block2.getHeader().getCells().get(1).stringValue());

        assertCellvalue(fSheet, 8, 0, block2.getRows().get(0).getCells().get(0).stringValue());
        assertCellvalue(fSheet, 8, 1, block2.getRows().get(0).getCells().get(1).stringValue());

        assertCellvalue(fSheet, 9, 0, block2.getRows().get(1).getCells().get(0).stringValue());
        assertCellvalue(fSheet, 9, 1, block2.getRows().get(1).getCells().get(1).stringValue());
    }

    // ---
    // test utils
    // ----
    private void assertEmptyFile(TestFileOutputStreamProxy tos) {
        byte[] result = tos.getByteStream().toByteArray();
        assertNotNull("File was empty", result);
        assertNotEquals(0, result.length);
    }

    private org.apache.poi.ss.usermodel.Workbook assertXLSOpen(TestFileOutputStreamProxy tos) {
        InputStream in = tos.toInputStream();
        org.apache.poi.ss.usermodel.Workbook myWorkBook;
        try {
            myWorkBook = (Workbook) this.loaderClazz.getConstructor(InputStream.class).newInstance(in);

            assertNotNull("Could not get workbook", myWorkBook);
            return myWorkBook;
        } catch (Exception e) {
            fail("Could not parse xls: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private org.apache.poi.ss.usermodel.Sheet assertSheet(org.apache.poi.ss.usermodel.Workbook workbook, String expectedName, int sheetIndex) {
        org.apache.poi.ss.usermodel.Sheet mySheet = workbook.getSheetAt(sheetIndex);
        assertNotNull("could not get worksheet at index " + sheetIndex, mySheet);
        assertEquals("sheet index dos not match at index " + sheetIndex, expectedName, mySheet.getSheetName());
        return mySheet;
    }

    private void assertCellvalue(org.apache.poi.ss.usermodel.Sheet xssfSheet, int row, int col, String expected) {
        org.apache.poi.ss.usermodel.Row xssRow = xssfSheet.getRow(row);
        assertNotNull("No row at " + row, xssRow);
        org.apache.poi.ss.usermodel.Cell xssfCell = xssRow.getCell(col);
        assertNotNull("No cell at " + row + " " + col, xssfCell);
        String value = xssfCell.getStringCellValue();
        assertEquals("Cell value at row" + row + " col " + col + " rows not match", expected, value);
    }
}
