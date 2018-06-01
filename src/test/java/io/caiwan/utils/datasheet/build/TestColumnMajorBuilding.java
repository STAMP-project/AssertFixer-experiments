package io.caiwan.utils.datasheet.build;

import io.caiwan.utils.test.DummyCellBuilder;
import io.github.caiwan.datasheet.CellBuilder;
import io.github.caiwan.datasheet.SheetBlockBuilder;
import io.github.caiwan.datasheet.builder.ColumnMajorSheetBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

public class TestColumnMajorBuilding {

    private BlockModel blockModel;
    private SheetBlockBuilder blockBuilder;
    private CellBuilder cellBuilder;
    private List data;

    @Before
    public void setUp() {
        blockBuilder = new ColumnMajorSheetBuilder();
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

        Assert.assertEquals("Col count mismatch", SheetBuilderData.HEADER.length, blockBuilder.getRowCount());
        Assert.assertEquals("Row count mismatch", data.size() + 1, blockBuilder.getColCount());
    }

    // TODO TBD
    @Ignore
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
    public void TestBody() {
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
        Assert.assertEquals(SheetBuilderData.HEADER.length, block.getRows().size());

        for (int j = 0; j< SheetBuilderData.HEADER.length; j++){
            Row row = block.getRows().get(j);
            Assert.assertNotNull(row);

            Cell cell = row.getCells().get(0);
            Assert.assertNotNull(cell);
            Assert.assertNotNull(cell.getValue());
            Assert.assertEquals(SheetBuilderData.HEADER[j], cell.getValue());
        }

        for (int i = 0; i < data.size(); i++) {
            List datarow = (List) data.get(i);
            for (int j = 0; j < datarow.size(); j++) {
                Row row = block.getRows().get(j);
                Assert.assertNotNull("Row is null at" + i, row);

                Cell cell = row.getCells().get(i + 1);
                Assert.assertNotNull("Cell is null at row " + i + " col " + j, cell);
                Assert.assertEquals("Cell is mismatch at row " + i + " col " + j, datarow.get(j), cell.getValue());
            }
        }

    }

}
