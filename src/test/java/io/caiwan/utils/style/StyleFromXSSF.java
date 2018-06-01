package io.caiwan.utils.style;

import io.github.caiwan.spreadsheet.parser.StyleBuilder;
import io.github.caiwan.spreadsheet.style.CellStyle;
import io.github.caiwan.spreadsheet.utils.CellAddress;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.InputStream;
import java.util.List;

public class StyleFromXSSF extends StyleBuilder {

    @Override
    protected Workbook openWorkbook(InputStream in) {
        return null;
    }

    @Override
    protected List<CellRangeAddress> getMergedRegions(Workbook workbook, int sheetIndex) {
        return null;
    }

    @Override
    protected void buildCellStyle(Workbook workbook, int sheetIndex, CellAddress cellAddress, CellStyle cellStyle) {

    }
}
