package io.github.caiwan.spreadsheet.style;

import lombok.Data;

@Data
public class BlockStyle {

    private RowStyle titleStyle;
    private RowStyle headerStyle;

    private RowStyle firstRowStyle;
    private RowStyle bodyRowStyle;
    private RowStyle lastRowStyle;

    private Padding padding;
}
