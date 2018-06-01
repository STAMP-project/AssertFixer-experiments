package io.github.caiwan.datasheet.builder;

import io.github.caiwan.datasheet.BlockModelBuilder;
import io.github.caiwan.datasheet.CellBuilder;
import io.github.caiwan.datasheet.SheetBlockBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public abstract class AbstractSheetBlockBuilder implements SheetBlockBuilder {

    protected CellBuilder builder;
    protected BlockModel blockModel;

    @Getter
    protected int rowCount;
    @Getter
    protected int colCount;

    @Override
    abstract public void build(@NonNull final CellBuilder builder, @NonNull final BlockModel blockModel, @NonNull final List<Object> data);

    @Override
    abstract public void buildBlock(@NonNull final Block block);

    @Override
    abstract public void buildBlockHeader(@NonNull final Row header);

    @Override
    abstract public void BuildCell(int rowid, int colid, @NonNull final Cell cell);
}
