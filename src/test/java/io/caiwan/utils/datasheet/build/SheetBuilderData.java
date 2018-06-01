package io.caiwan.utils.datasheet.build;

import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.datasheet.model.PropertyModel;

import java.util.LinkedList;
import java.util.List;

class SheetBuilderData {

    static String MODEL_NAME = "Kiscica";
    static String HEADER[] = {"1st", "2nd", "3rd"};

    BlockModel buildModel() {
        BlockModel blockModel = new BlockModel();
        blockModel.setName("Kiscica");
        blockModel.addProperty(new PropertyModel(HEADER[0], 0));
        blockModel.addProperty(new PropertyModel(HEADER[1], 1));
        blockModel.addProperty(new PropertyModel(HEADER[2], 2));
        return blockModel;
    }

    @SuppressWarnings("unchecked")
    List buildData() {
        List data = new LinkedList<LinkedList<Integer>>();

        int count = 0;
        for (int y = 0; y < 256; ++y) {
            LinkedList<Integer> row = new LinkedList<>();
            data.add(row);
            for (int x = 0; x < 3; ++x) {
                row.add(count++);
            }
        }
        return data;
    }
}
