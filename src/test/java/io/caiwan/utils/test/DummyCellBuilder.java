package io.caiwan.utils.test;

import io.github.caiwan.datasheet.CellBuilder;
import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Cell;
import lombok.NonNull;

import java.util.List;

public class DummyCellBuilder implements CellBuilder {
    @SuppressWarnings("unchecked")
    @Override
    public void buildCell(@NonNull PropertyModel propertyModel, @NonNull Object data, @NonNull Cell target) {
        List<Integer> inData = (List<Integer>) data;
        target.setValue(inData.get(propertyModel.getId()));
    }
}
