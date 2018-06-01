package io.caiwan.utils.datasheet.build.fromclass;

import io.caiwan.utils.test.DummyTestDto;
import io.github.caiwan.datasheet.BlockModelBuilder;
import io.github.caiwan.datasheet.builder.ReflectionModelBuilder;
import io.github.caiwan.datasheet.model.BlockModel;
import io.github.caiwan.datasheet.model.PropertyModel;
import io.github.caiwan.spreadsheet.Cell;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestModelBuildingFromClass {

    @Test
    public void TestModelFromClass() {

        // given
        BlockModelBuilder builder = new ReflectionModelBuilder(DummyTestDto.class);

        BlockModel model = new BlockModel();

        // when
        builder.addPropertyOrder(0, "id");
        builder.addPropertyOrder(1, "kitten");
        builder.addPropertyOrder(3, "puppy");
        builder.addPropertyOrder(4, "giraffe");
        builder.buildModel(model);

        // then
        Assert.assertNotNull(model.getName());
        Assert.assertEquals("Class name does not match", "io.caiwan.utils.test.DummyTestDto", model.getName());

        validateBuilder(model);
    }

    private void validateBuilder(BlockModel model) {
        List<PropertyModel> propertyModels = model.getPropertyModels();

        Assert.assertNotNull("No property models were built", propertyModels);
        Assert.assertEquals(4, propertyModels.size());

        Assert.assertEquals("id", propertyModels.get(0).getName());
        Assert.assertEquals("kitten", propertyModels.get(1).getName());
        Assert.assertEquals("puppy", propertyModels.get(2).getName());
        Assert.assertEquals("giraffe", propertyModels.get(3).getName());
    }


    @Test
    public void TestModelPropertyFromObject() {
        // given
        final BlockModelBuilder builder = new ReflectionModelBuilder(DummyTestDto.class);
        final BlockModel model = new BlockModel();

        builder.addPropertyOrder(0, "id");
        builder.addPropertyOrder(1, "kitten");
        builder.addPropertyOrder(3, "puppy");
        builder.addPropertyOrder(4, "giraffe");
        builder.buildModel(model);

        validateBuilder(model);

        // when

        DummyTestDto dto = new DummyTestDto();
        dto.setId(1L);
        dto.setKitten("Cica");
        dto.setGiraffe("Zsiraf");
        dto.setPuppy("Kutya");

        // then

        int id;
        String cellString;

        validateCell(builder, model, dto, 0, "1");
        validateCell(builder, model, dto, 1, "Cica");
        validateCell(builder, model, dto, 2, "Kutya");
        validateCell(builder, model, dto, 3, "Zsiraf");

    }

    private void validateCell(BlockModelBuilder builder, BlockModel model, Object object, int id, String cellContent) {
        final Cell cell = new Cell();
        builder.buildCell(model.getPropertyModels().get(id), object, cell);

        Assert.assertNotNull("Cell is null" + id, cell.getValue());
        Assert.assertEquals("Cell value mismatch" + id, cellContent, cell.stringValue());
    }

}
