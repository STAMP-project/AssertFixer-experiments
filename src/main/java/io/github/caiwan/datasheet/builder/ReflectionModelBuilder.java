package io.github.caiwan.datasheet.builder;

import io.github.caiwan.datasheet.BlockModelBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Cell;
import io.github.caiwan.utils.ClassReflector;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReflectionModelBuilder implements BlockModelBuilder {

    @Getter
    ClassReflector classReflector;

    Map<String, Integer> order = new HashMap<>();

    public ReflectionModelBuilder(Class clazz) {
        classReflector = new ClassReflector(clazz);
        classReflector.build();
    }

    @Override
    public void addPropertyOrder(int col, String name) {
        order.put(name, col);
    }

    @Override
    public void buildModel(@NonNull final BlockModel target) {
        target.setName(classReflector.getModelClass().getCanonicalName());

        Iterator<String> it = classReflector.iterator();
        int count = 0;
        while (it.hasNext()) {
            String name = it.next();
            PropertyModel propertyModel = new PropertyModel();
            propertyModel.setName(name);
            propertyModel.setId(count++);

            Integer col = order.get(name);
            if (col != null)
                target.addProperty(col.intValue(), propertyModel);
            else
                target.addProperty(propertyModel);
        }
    }

    @Override
    public void buildCell(@NonNull PropertyModel propertyModel, @NonNull Object data, @NonNull Cell target) {
        String name = propertyModel.getName();
        if (!classReflector.hasGetter(name)) {
            target.setValue(propertyModel.getDefaultValue());
            return;
        }

        target.setValue(classReflector.get(name, data));
    }
}
