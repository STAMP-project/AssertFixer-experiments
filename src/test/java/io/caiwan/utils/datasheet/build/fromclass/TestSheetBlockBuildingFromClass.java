package io.caiwan.utils.datasheet.build.fromclass;

import io.caiwan.utils.test.DummyTestDto;
import io.github.caiwan.datasheet.BlockModelBuilder;
import io.github.caiwan.datasheet.DatasheetBuilder;
import io.github.caiwan.datasheet.builder.ReflectionModelBuilder;
import io.github.caiwan.datasheet.builder.RowMajorSheetBuilder;
import io.github.caiwan.spreadsheet.Block;
import io.github.caiwan.spreadsheet.Row;
import io.github.caiwan.utils.RandomString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class TestSheetBlockBuildingFromClass {

    private static final int DATA_LENGTH = 256;
    private List<DummyTestDto> data = new LinkedList<>();
    private DatasheetBuilder datasheetBuilder;

    @Before
    public void setupData() {
        data.clear();
        RandomString randomString = new RandomString();
        for (int i = 0; i < DATA_LENGTH; i++) {
            data.add(new DummyTestDto((long) i, randomString.nextString(), randomString.nextString(), randomString.nextString()));
        }
    }

    @Before
    public void setupBuilder() {
        datasheetBuilder = new DatasheetBuilder();
        datasheetBuilder.setBlockModelBuilder(new ReflectionModelBuilder(DummyTestDto.class));
        datasheetBuilder.setSheetBuilder(new RowMajorSheetBuilder());

        BlockModelBuilder builder = datasheetBuilder.getBlockModelBuilder();

        builder.addPropertyOrder(0, "id");
        builder.addPropertyOrder(1, "kitten");
        builder.addPropertyOrder(3, "puppy");
        builder.addPropertyOrder(4, "giraffe");

        datasheetBuilder.buildModel();
    }

    @Test
    public void TestSheetBlockFromClass() {
        //given
        datasheetBuilder.buildSheet(data);

        //when
        Block block = datasheetBuilder.getSheetBlock();

        // then
        Assert.assertNotNull(block);
        Assert.assertNotNull(block.getTitle());
        Assert.assertEquals(DummyTestDto.class.getCanonicalName(), block.getTitle());

        Assert.assertNotNull(block.getHeader());
        Assert.assertNotNull(block.getHeader().getCells());
        Assert.assertEquals(4, block.getHeader().getCells().size());

        Assert.assertEquals("id", block.getHeader().getCells().get(0).getValue());
        Assert.assertEquals("kitten", block.getHeader().getCells().get(1).getValue());
        Assert.assertEquals("puppy", block.getHeader().getCells().get(2).getValue());
        Assert.assertEquals("giraffe", block.getHeader().getCells().get(3).getValue());

        Assert.assertNotNull(block.getRows());
        Assert.assertEquals(DATA_LENGTH, block.getRows().size());
        for (int i = 0; i < DATA_LENGTH; i++) {
            Row row = block.getRows().get(i);
            Assert.assertNotNull(row);
            Assert.assertNotNull(row.getCells());
            Assert.assertEquals(4, row.getCells().size());

            DummyTestDto dto = data.get(i);

            Assert.assertEquals(dto.getId(), row.getCells().get(0).longValue());
            Assert.assertEquals(dto.getKitten(), row.getCells().get(1).stringValue());
            Assert.assertEquals(dto.getPuppy(), row.getCells().get(2).stringValue());
            Assert.assertEquals(dto.getGiraffe(), row.getCells().get(3).stringValue());
        }
    }

}
