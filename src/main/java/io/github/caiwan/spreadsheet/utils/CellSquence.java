package io.github.caiwan.spreadsheet.utils;

import io.github.caiwan.spreadsheet.style.RowStyle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.poi.ss.usermodel.Workbook;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CellSquence {
    private CellAddress leftCellAddress;
    private CellAddress bodyCellAddress = new CellAddress();
    private CellAddress rightCellAddress;

    public CellSquence(String bodyAddress) {
        bodyCellAddress = new CellAddress(bodyAddress);
    }

    public CellSquence(String leftAddress, String bodyAddress, String rightAddress) {
        leftCellAddress = new CellAddress(leftAddress);
        bodyCellAddress = new CellAddress(bodyAddress);
        rightCellAddress = new CellAddress(rightAddress);
    }

    public CellSquence(CellAddress cellAddress) {
        bodyCellAddress = cellAddress;
    }
}
