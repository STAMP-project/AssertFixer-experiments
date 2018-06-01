package io.github.caiwan.spreadsheet.style;

import lombok.Data;

@Data
public class CellStyle {
    private int rowSpan;
    private int colSpan;

    private org.apache.poi.ss.usermodel.CellStyle cellStyle;
}
