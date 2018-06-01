package io.github.caiwan.spreadsheet.builder.xssf;

import io.github.caiwan.spreadsheet.builder.SpreadsheetBuilder;
import io.github.caiwan.spreadsheet.builder.SpreadsheetFactory;
import io.github.caiwan.spreadsheet.builder.SpreadsheetStyleDecorator;
import lombok.Getter;

public class XSSFBuilder extends SpreadsheetBuilder {

    @Getter
    private SpreadsheetFactory factory = new XSSFFactory();
    @Getter
    private SpreadsheetStyleDecorator styleDecorator = new XSSFStyleDecorator();

}
