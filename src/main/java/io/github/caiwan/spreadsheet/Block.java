package io.github.caiwan.spreadsheet;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Block {

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private List<Row> rows = new ArrayList<>();

    @Getter
    @Setter
    private Row header = new Row();

    @Getter
    @Setter
    int horizontalPadding = 1;

    public void addRow(Row row) {
        rows.add(row);
    }

    public void removeRow(Row row) {
        rows.remove(row);
    }

    public void addHeaderColumn(String value) {
        header.addColumn(new Cell(value));
    }

}
