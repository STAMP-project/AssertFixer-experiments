package io.github.caiwan.spreadsheet;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;

import lombok.Getter;
import lombok.Setter;

public class Sheet {

    @Getter
    @Setter
    private String name;

    @Setter
    @Getter
    private String title;

    @Getter
    @Setter
    private List<Block> blocks = new ArrayList<>();

    public Sheet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Sheet(String name) {
        super();
        this.name = name;
    }

    public void addBlock(Block block) {
        blocks.add(block);
    }

    public void removeBlock(Block block) {
        blocks.remove(block);
    }
}
