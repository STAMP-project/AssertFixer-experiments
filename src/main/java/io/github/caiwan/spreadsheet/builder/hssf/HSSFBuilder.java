package io.github.caiwan.spreadsheet.builder.hssf;

import io.github.caiwan.spreadsheet.builder.SpreadsheetBuilder;
import io.github.caiwan.spreadsheet.builder.SpreadsheetFactory;
import io.github.caiwan.spreadsheet.builder.SpreadsheetStyleDecorator;
import lombok.Getter;

final public class HSSFBuilder extends SpreadsheetBuilder {

    @Getter
    private SpreadsheetFactory factory = new HSSFFactory();
    @Getter
    private SpreadsheetStyleDecorator styleDecorator = new HSSFSytleDecorator();

}
