package io.github.caiwan.spreadsheet.builder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface SpreadsheetFactory {
    public Workbook createWorkbook();

    public Sheet createSheet(Workbook workbook, String title);

    public Row createRow(Sheet sheet, int row);

    public Cell createCell(Row row, int col);
}
