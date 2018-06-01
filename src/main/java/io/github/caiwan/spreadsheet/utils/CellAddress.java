package io.github.caiwan.spreadsheet.utils;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CellAddress implements Comparable<CellAddress> {
    private int colId;
    private int rowId;

    public CellAddress(String address) {
        SetCellId(address);
    }

    public void SetCellId(String excelCellId) {
        int[] pair = ExcelCellIdParser.parseId(excelCellId);
        rowId = pair[1];
        colId = pair[0];
    }

    @Override
    public String toString() {
        return "CellAddress{" +
                "rowId=" + rowId +
                ", colId=" + colId +
                '}';
    }

    private static final int BEFORE = -1;
    private static final int EQUAL = 0;
    private static final int AFTER = 1;

    @Override
    public int compareTo(CellAddress o) {
        if (o.colId > colId) return AFTER;
        if (o.colId < colId) return BEFORE;

        if (o.rowId > rowId) return AFTER;
        if (o.rowId < rowId) return BEFORE;

        return EQUAL;
    }
}
