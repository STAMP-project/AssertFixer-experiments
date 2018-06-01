package io.github.caiwan.spreadsheet;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Row {
    @Getter
    @Setter
    private List<Cell> cells = new ArrayList<>();

    public Row(String... strings) {
        super();
        addColumns(strings);
    }

    public Row(List<String> strings) {
        super();
        addColumns(strings);
    }

    public Row() {
        super();
    }

    public void addColumns(List<String> strings) {
        for (String string : strings) {
            addColumn(new Cell(string));
        }
    }

    public void addColumns(String... strings) {
        for (String string : strings) {
            addColumn(new Cell(string));
        }
    }

    public void addColumn(Cell cell) {
        cells.add(cell);
    }

    public void removeColumn(Cell cell) {
        cells.remove(cell);
    }


}
