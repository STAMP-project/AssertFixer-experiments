package io.github.caiwan.datasheet;

import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Cell;
import lombok.NonNull;

public interface BlockModelBuilder extends CellBuilder {
    void buildModel(@NonNull final BlockModel target);
    void addPropertyOrder(int col, String name);
}
