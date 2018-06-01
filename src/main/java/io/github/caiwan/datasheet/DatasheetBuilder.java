package io.github.caiwan.datasheet;

import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class DatasheetBuilder {

    @Setter
    @Getter
    private BlockModelBuilder blockModelBuilder;

    @Setter
    @Getter
    private SheetBlockBuilder sheetBuilder;

    @Setter
    @Getter
    private SheetBlockDecorator blockDecorator;

    @Getter
    private Block sheetBlock;

    @Getter
    private BlockModel blockModel;

    public void buildModel() {
        blockModel = new BlockModel();
        blockModelBuilder.buildModel(blockModel);
    }

    @SuppressWarnings("unchecked")
    public void buildSheet(List data) {
        sheetBlock = new Block();
        sheetBuilder.build(blockModelBuilder, blockModel, data);

        sheetBuilder.buildBlock(sheetBlock);

        Row header = new Row();
        sheetBuilder.buildBlockHeader(header);

        sheetBlock.setHeader(header);

        if (blockDecorator != null) {
            sheetBlock.setTitle(blockDecorator.blockTitle(sheetBlock.getTitle()));
            for (Cell headerCell : header.getCells()) {
                headerCell.setValue(blockDecorator.propertyHeader(headerCell.stringValue()));
            }
        }

        int rowNum = sheetBuilder.getRowCount();
        int colNum = sheetBuilder.getColCount();

        for (int rowid = 0; rowid < rowNum; ++rowid) {
            Row row = new Row();
            sheetBlock.addRow(row);
            for (int colid = 0; colid < colNum; ++colid) {
                Cell cell = new Cell();
                row.addColumn(cell);

                sheetBuilder.BuildCell(rowid, colid, cell);

                if (blockDecorator != null) {
// ... TODO
                }

            }
        }
    }

}
