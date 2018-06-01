package io.github.caiwan.datasheet.builder;

import io.github.caiwan.datasheet.CellBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;

import java.util.List;

public class ColumnMajorSheetBuilder extends AbstractSheetBlockBuilder {

    private List<Object> data;

    @Override
    public void build(CellBuilder builder, BlockModel blockModel, List<Object> data) {
        this.blockModel = blockModel;
        this.builder = builder;
        this.data = data;

        this.rowCount = blockModel.getPropertyModels().size();
        this.colCount = data.size() + 1;
    }

    @Override
    public void buildBlock(Block block) {
        block.setTitle(blockModel.getName());
    }

    @Override
    public void buildBlockHeader(Row header) {
        // TODO TBD
    }

    @Override
    public void BuildCell(int rowid, int colid, Cell cell) {
        PropertyModel model = this.blockModel.getPropertyModels().get(rowid);
        // 1st col is the header
        if (colid == 0) {
            String name = model.getName();
            cell.setValue(name);
        } else {
            int id = colid - 1;
            Object colData = this.data.get(id);
            builder.buildCell(model, colData, cell);
        }
    }
}
