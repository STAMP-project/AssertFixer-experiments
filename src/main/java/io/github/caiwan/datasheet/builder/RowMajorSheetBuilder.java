package io.github.caiwan.datasheet.builder;


import io.github.caiwan.datasheet.CellBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;
import lombok.NonNull;
import lombok.SneakyThrows;

import java.util.List;

public class RowMajorSheetBuilder extends AbstractSheetBlockBuilder {

    List<Object> data;

    @Override
    public void build(@NonNull final CellBuilder builder, @NonNull final BlockModel blockModel, @NonNull final List<Object> data) {
        this.builder = builder;
        this.blockModel = blockModel;
        this.data = data;

        this.rowCount = this.data.size();
        this.colCount = this.blockModel.getPropertyModels().size();
    }

    @Override
    public void buildBlock(@NonNull final Block block) {
        block.setTitle(blockModel.getName());
    }

    @Override
    public void buildBlockHeader(@NonNull final Row header) {
        header.getCells().clear();
        for (PropertyModel propertyModel : blockModel.getPropertyModels()) {
            Cell cell = new Cell();
            cell.setValue(propertyModel.getName());
            header.addColumn(cell);
        }
    }

    @Override
    @SneakyThrows
    public void BuildCell(int rowid, int colid, @NonNull final Cell cell) {
        Object rowData = data.get(rowid);
        PropertyModel colModel = blockModel.getPropertyModels().get(colid);
        builder.buildCell(colModel, rowData, cell);
    }

}
