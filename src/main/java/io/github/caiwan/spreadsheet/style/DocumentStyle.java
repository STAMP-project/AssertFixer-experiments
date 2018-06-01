package io.github.caiwan.spreadsheet.style;

import lombok.Data;

@Data
public class DocumentStyle {

    private CellStyle titleStyle;
    private BlockStyle blockStyle;
    private Padding documentPadding;

}
