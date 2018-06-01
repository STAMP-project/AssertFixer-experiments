package io.github.caiwan.datasheet;

import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.spreadsheet.Row;

import java.util.List;

public interface SheetBlockBuilder {
    void build(CellBuilder builder, BlockModel blockModel, List<Object> data);
    void buildBlock(Block block);
    void buildBlockHeader(Row header);
    int getRowCount();
    int getColCount();
    void BuildCell(int rowid, int colid, Cell cell);
}
