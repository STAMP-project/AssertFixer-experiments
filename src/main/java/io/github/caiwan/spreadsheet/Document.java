package io.github.caiwan.spreadsheet;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import lombok.Getter;
import lombok.Setter;

public class Document {

    @Getter
    @Setter
    private List<Sheet> sheets = new ArrayList<>();

    public void addSheet(Sheet sheet) {
        sheets.add(sheet);
    }

    public void removeSheet(Sheet sheet) {
        sheets.remove(sheet);
    }

}
