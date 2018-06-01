package io.github.caiwan.spreadsheet.parser;

import io.github.caiwan.spreadsheet.style.CellStyle;
import io.github.caiwan.spreadsheet.utils.CellAddress;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public class StyleFromHSSF extends StyleBuilder {

    @SneakyThrows
    @Override
    protected Workbook openWorkbook(@NonNull InputStream in) {
        return new HSSFWorkbook(in);
    }

    @Override
    protected List<CellRangeAddress> getMergedRegions(@NonNull Workbook workbook, int sheetIndex) {
        HSSFSheet sheet = ((HSSFWorkbook) workbook).getSheetAt(sheetIndex);
        List<CellRangeAddress> regions = new LinkedList<>();
        for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
            regions.add(sheet.getMergedRegion(i));
        }
        return regions;
    }

    @Override
    protected void buildCellStyle(@NonNull Workbook workbook, int sheetIndex, @NonNull CellAddress cellAddress, @NonNull CellStyle cellStyle) {
        HSSFSheet sheet = (HSSFSheet) workbook.getSheetAt(sheetIndex);
        HSSFRow row = sheet.getRow(cellAddress.getRowId());
        HSSFCell cell = row.getCell(cellAddress.getColId());
        if (cell == null)
            throw new RuntimeException("No valid cell found at " + cellAddress.toString());
        HSSFCellStyle style = cell.getCellStyle();
        cellStyle.setCellStyle(style);
    }
}
