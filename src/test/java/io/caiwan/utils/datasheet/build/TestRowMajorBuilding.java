package io.caiwan.utils.datasheet.build;

import io.caiwan.utils.test.DummyCellBuilder;
import io.github.caiwan.datasheet.CellBuilder;
import io.github.caiwan.datasheet.SheetBlockBuilder;
import io.github.caiwan.datasheet.builder.RowMajorSheetBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestRowMajorBuilding {

    private BlockModel blockModel;
    private SheetBlockBuilder blockBuilder;
    private CellBuilder cellBuilder;
    private List data;

    @Before
    public void setUp() {
        blockBuilder = new RowMajorSheetBuilder();
        cellBuilder = new DummyCellBuilder();

        SheetBuilderData dataBuilder = new SheetBuilderData();
        blockModel = dataBuilder.buildModel();
        data = dataBuilder.buildData();
    }


    @Test
    public void TestBlock() {
        // given
        blockBuilder.build(cellBuilder, blockModel, data);

        // when
        Block block = new Block();
        blockBuilder.buildBlock(block);

        // then
        Assert.assertEquals("Block title mismatch", SheetBuilderData.MODEL_NAME, block.getTitle());

        Assert.assertEquals("Col count mismatch", SheetBuilderData.HEADER.length, blockBuilder.getColCount());
        Assert.assertEquals("Row count mismatch", data.size(), blockBuilder.getRowCount());
    }

    @Test
    public void TestHeader() {
        // given
        blockBuilder.build(cellBuilder, blockModel, data);

        // when
        Row header = new Row();
        blockBuilder.buildBlockHeader(header);

        // then
        Assert.assertNotNull("Cells are null", header.getCells());
        Assert.assertEquals("Size mismatch", SheetBuilderData.HEADER.length, header.getCells().size());

        for (int i = 0; i < SheetBuilderData.HEADER.length; i++) {
            Assert.assertNotNull("Cell is null at" + i, header.getCells().get(i));
            Assert.assertEquals("Cell mismatch at " + i, SheetBuilderData.HEADER[i], header.getCells().get(i).stringValue());
        }
    }

    @Test
    public void TestBdoy() {
        // given
        blockBuilder.build(cellBuilder, blockModel, data);

        // when
        Block block = new Block();

        int colCount = blockBuilder.getColCount();
        int rowCount = blockBuilder.getRowCount();

        for (int rowId = 0; rowId < rowCount; rowId++) {
            Row row = new Row();
            for (int colId = 0; colId < colCount; colId++) {
                Cell<String> cell = new Cell();
                blockBuilder.BuildCell(rowId, colId, cell);
                row.addColumn(cell);
            }
            block.addRow(row);
        }

        // then
        Assert.assertEquals(data.size(), block.getRows().size());
        for (int i = 0; i < data.size(); i++) {
            Row row = block.getRows().get(i);
            List datarow = (List) data.get(i);
            Assert.assertNotNull("Row is null at" + i, row);
            for (int j = 0; j < datarow.size(); j++) {
                Cell cell = row.getCells().get(j);
                Assert.assertNotNull("Cell is null at row " + i + " col " + j, cell);
                Assert.assertEquals("Cell is mismatch at row " + i + " col " + j, datarow.get(j), cell.getValue());
            }
        }
    }

}
