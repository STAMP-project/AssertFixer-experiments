package io.github.caiwan.spreadsheet.parser;

import io.github.caiwan.spreadsheet.style.BlockStyle;
import io.github.caiwan.spreadsheet.style.CellStyle;
import io.github.caiwan.spreadsheet.style.DocumentStyle;
import io.github.caiwan.spreadsheet.style.RowStyle;
import io.github.caiwan.spreadsheet.utils.CellAddress;
import io.github.caiwan.spreadsheet.utils.CellSquence;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.InputStream;
import java.util.List;

public abstract class StyleBuilder {
    @Getter
    private DocumentStyle documentStyle = new DocumentStyle();

    @Setter
    @Getter
    protected int sheetIndex = 0;

    @Setter
    @Getter
    @NonNull
    protected CellAddress titleCellAddress = new CellAddress();

    @Setter
    @Getter
    @NonNull
    protected CellSquence blockTitleSequence;

    @Setter
    @Getter
    @NonNull
    protected CellSquence blockHeaderSequece;


    public StyleBuilder() {
        blockTitleSequence = new CellSquence(new CellAddress(0,1));
        blockHeaderSequece = new CellSquence(new CellAddress(0,2));
    }

    public void parseStyle(InputStream in) {
        Workbook workbook = openWorkbook(in);

        // get merged regions
        List<CellRangeAddress> mergedRegions = getMergedRegions(workbook, sheetIndex);

        // get title style
        documentStyle.setTitleStyle(new CellStyle());
        buildCellStyle(workbook, sheetIndex, titleCellAddress, documentStyle.getTitleStyle());

        // -- set merged region of title
        CellRangeAddress titleRegion = findMergedRegion(titleCellAddress, mergedRegions);
        if (titleRegion != null) {
            setSpanBox(titleRegion, documentStyle.getTitleStyle());
        }

        // block style
        BlockStyle blockStyle = new BlockStyle();
        documentStyle.setBlockStyle(blockStyle);

        // get block title style
        blockStyle.setHeaderStyle(new RowStyle());

        // -- set merged region of block title
        buildRowstyle(workbook, sheetIndex, blockTitleSequence, blockStyle.getHeaderStyle());
        if (blockTitleSequence.getLeftCellAddress() == null || blockTitleSequence.getRightCellAddress() == null) {
            CellRangeAddress blockTitleRegion = findMergedRegion(blockTitleSequence.getBodyCellAddress(), mergedRegions);
            if (blockTitleRegion != null){
                setSpanBox(titleRegion, blockStyle.getHeaderStyle().getBody());
            }
        }

        // get block header style
        // -- set merged region of block header

        // get body style

    }

    private void buildRowstyle(Workbook workbook, int sheetIndex, CellSquence cellSquence, RowStyle blockStyle) {
        blockStyle.setBody(new CellStyle());
        buildCellStyle(workbook, sheetIndex, cellSquence.getBodyCellAddress(), blockStyle.getBody());

        if (cellSquence.getLeftCellAddress() != null && cellSquence.getRightCellAddress() != null) {
            blockStyle.setLeft(new CellStyle());
            buildCellStyle(workbook, sheetIndex, cellSquence.getLeftCellAddress(), blockStyle.getLeft());

            blockStyle.setRight(new CellStyle());
            buildCellStyle(workbook, sheetIndex, cellSquence.getRightCellAddress(), blockStyle.getRight());
        }
    }

    private void setSpanBox(@NonNull CellRangeAddress region, @NonNull CellStyle cellStyle) {
        cellStyle.setColSpan(region.getLastColumn() - region.getFirstColumn());
        cellStyle.setRowSpan(region.getLastRow() - region.getFirstRow());
    }

    protected CellRangeAddress findMergedRegion(CellAddress titleCellAddress, List<CellRangeAddress> mergedRegions) {
        for (CellRangeAddress region : mergedRegions) {
            CellAddress topLeft = new CellAddress(region.getFirstColumn(), region.getFirstRow());
            CellAddress bottomRight = new CellAddress(region.getLastColumn(), region.getLastRow());

            int a = topLeft.compareTo(this.titleCellAddress);
            int b = bottomRight.compareTo(this.titleCellAddress);

            if (a >= 0 && b <= 0)
                return region;
        }
        return null;
    }

    protected abstract List<CellRangeAddress> getMergedRegions(Workbook workbook, int sheetIndex);

    protected abstract Workbook openWorkbook(InputStream in);

    protected abstract void buildCellStyle(Workbook workbook, int sheetIndex, CellAddress cellAddress, CellStyle cellStyle);

}
