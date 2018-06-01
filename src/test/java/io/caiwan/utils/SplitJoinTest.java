package io.caiwan.utils;

import io.github.caiwan.spreadsheet.builder.hssf.HSSFBuilder;
import io.github.caiwan.spreadsheet.builder.xssf.XSSFBuilder;
import io.github.caiwan.utils.SplitJoin;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@Deprecated
@RunWith(Parameterized.class)
public class SplitJoinTest {


    private String expect;
    private String input;

    public SplitJoinTest(String expect, String input) {
        this.expect = expect;
        this.input = input;
    }

    @Parameterized.Parameters(name = "{index}: Test splitjoin with {0}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"kutya, cica, roka, farkas", "\'kutya\', \'cica\', \'roka\', \'farkas\'"},
                {"kutya,   cica, roka,    zsiraf      ", "\'kutya\', \'cica\', \'roka\', \'zsiraf\'"},
                {"kutya,, cica, roka,,, macska ", "\'kutya\', \'cica\', \'roka\', \'macska\'"}
        });
    }

    @Test
    @Ignore
    public void TestSplitJoin() {
        // given
        // ..

        // when
        SplitJoin splitJoin = new SplitJoin(",", ", ", "\'", true);

        // then
        Assert.assertEquals(expect, splitJoin.doFormat(input));

    }

}
