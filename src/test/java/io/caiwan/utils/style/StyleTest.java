package io.caiwan.utils.style;

import io.github.caiwan.spreadsheet.parser.StyleBuilder;
import io.github.caiwan.spreadsheet.parser.StyleFromHSSF;
import io.github.caiwan.spreadsheet.style.DocumentStyle;
import io.github.caiwan.spreadsheet.utils.CellAddress;
import io.github.caiwan.spreadsheet.utils.CellSquence;
import lombok.SneakyThrows;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

@RunWith(Parameterized.class)
public class StyleTest {

    private final Class clazz;
    private final String className;
    private final String filename;
    private StyleBuilder builder;
    private InputStream inputStream;

    public StyleTest(String className, Class clazz, String filename) {
        this.className = className;
        this.filename = filename;
        this.clazz = clazz;
    }

    @Parameterized.Parameters(name = "{index}: Test style with {0} {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {StyleFromHSSF.class.getName(), StyleFromHSSF.class, "/style/style.testdata.xls"},
                {StyleFromHSSF.class.getName(), StyleFromXSSF.class, "./style/style.testdata.xlsx"}, // ...
        });
    }


    @SneakyThrows
    @Before
    public void SetUpClass() {
        this.builder = (StyleBuilder) this.clazz.newInstance();
        this.builder.setTitleCellAddress(new CellAddress("B1"));
        this.builder.setBlockTitleSequence(new CellSquence("B2", "C2", "G2"));

    }

    @SneakyThrows
    @Before
    public void SetUpInput() {
        URL url = this.getClass().getResource(filename);
        inputStream = url.openStream();
    }

    @SneakyThrows
    @After
    public void TearDownInput() {
        if (inputStream != null)
            inputStream.close();
    }

    @SneakyThrows
    @Test
    public void TestStyle() {
        // given
        builder.parseStyle(inputStream);

        // when
        DocumentStyle styleSheet = builder.getDocumentStyle();

        // then
        Assert.assertNotNull(styleSheet);
    }

    @SneakyThrows
    @Test
    public void TestTitleStle() {
        // given
        builder.parseStyle(inputStream);

        // when
        DocumentStyle styleSheet = builder.getDocumentStyle();

        // then
        Assert.assertNotNull(styleSheet);
        Assert.assertNotNull(styleSheet.getTitleStyle());
        Assert.assertNotNull(styleSheet.getTitleStyle().getCellStyle());

        Assert.assertEquals(0, styleSheet.getTitleStyle().getRowSpan());
        Assert.assertEquals(5, styleSheet.getTitleStyle().getColSpan());
    }

    @SneakyThrows
    @Test
    @Ignore
    public void TestBlockStle() {
        // given
        builder.parseStyle(inputStream);

        // when
        DocumentStyle styleSheet = builder.getDocumentStyle();

        // then
        Assert.assertNotNull(styleSheet);
        Assert.assertNotNull(styleSheet.getTitleStyle());
        Assert.assertNotNull(styleSheet.getTitleStyle().getCellStyle());

        Assert.assertEquals(0, styleSheet.getTitleStyle().getRowSpan());
        Assert.assertEquals(5, styleSheet.getTitleStyle().getColSpan());

        // TODO: fix it
    }

}
