package io.github.caiwan.spreadsheet.builder;

import java.io.IOException;
import java.io.OutputStream;

import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Document;
import io.github.caiwan.spreadsheet.Row;
import io.github.caiwan.spreadsheet.Sheet;

abstract public class SpreadsheetBuilder {
    public SpreadsheetBuilder() {
        super();
    }

    abstract public SpreadsheetFactory getFactory();

    abstract public SpreadsheetStyleDecorator getStyleDecorator();


    public void build(Document document, OutputStream os) throws IOException {
        org.apache.poi.ss.usermodel.Workbook wb = getFactory().createWorkbook();

        for (Sheet sheet : document.getSheets()) {
            buildSheet(sheet, wb);
        }

        wb.write(os);
        os.flush();

    }

    private void buildSheet(Sheet sheet, org.apache.poi.ss.usermodel.Workbook wb) {
        org.apache.poi.ss.usermodel.Sheet fSheet = getFactory().createSheet(wb, sheet.getName());
        int cursor = 0;

        // title
        org.apache.poi.ss.usermodel.Row titleRow = getFactory().createRow(fSheet, cursor++);
        org.apache.poi.ss.usermodel.Cell titleCell = getFactory().createCell(titleRow, 0);
        titleCell.setCellValue(sheet.getTitle());


        for (Block block : sheet.getBlocks()) {
            cursor += buildBlock(block, cursor, fSheet);
            cursor += block.getHorizontalPadding();
        }
    }

    private int buildBlock(Block block, int firstrow, org.apache.poi.ss.usermodel.Sheet fSheet) {

        int cursor = firstrow;
        // title
        org.apache.poi.ss.usermodel.Row titleRow = getFactory().createRow(fSheet, cursor++);
        org.apache.poi.ss.usermodel.Cell titleCell = getFactory().createCell(titleRow, 0);
        titleCell.setCellValue(block.getTitle());

        // header

        buildRow(block.getHeader(), cursor++, fSheet);

        for (Row row : block.getRows()) {
            buildRow(row, cursor++, fSheet);
        }

        return cursor - firstrow;

    }

    private void buildRow(Row row, int cursor, org.apache.poi.ss.usermodel.Sheet xssfSheet) {
        org.apache.poi.ss.usermodel.Row xRow = xssfSheet.createRow(cursor);

        int colIndex = 0;
        for (Cell cell : row.getCells()) {
            org.apache.poi.ss.usermodel.Cell xssCell = getFactory().createCell(xRow, colIndex++);
            xssCell.setCellValue(cell.stringValue());
        }

    }

}
