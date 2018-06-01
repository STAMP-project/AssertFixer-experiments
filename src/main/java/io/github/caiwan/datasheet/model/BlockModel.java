package io.github.caiwan.datasheet.model;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BlockModel {

    @Getter
    @Setter
    private
    List<PropertyModel> propertyModels= new LinkedList<>();

    @Getter
    @Setter
    private String name;

    public void addProperty(@NonNull PropertyModel propertyModel) {
        propertyModels.add(propertyModel);
    }

    public void addProperty(int col, @NonNull PropertyModel propertyModel) {
        if (col >= propertyModels.size()) {
            propertyModels.add(propertyModel);
        } else {
            propertyModels.add(col, propertyModel);
        }
    }

    public void removeProperty(PropertyModel propertyModel) {
        propertyModels.remove(propertyModel);
    }

}
