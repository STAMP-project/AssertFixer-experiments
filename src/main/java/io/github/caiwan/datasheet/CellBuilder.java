package io.github.caiwan.datasheet;

import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Cell;
import lombok.NonNull;

public interface CellBuilder {
    void buildCell(@NonNull final PropertyModel propertyModel, Object data, Cell target);
}
