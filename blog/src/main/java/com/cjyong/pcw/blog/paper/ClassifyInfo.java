package com.cjyong.pcw.blog.paper;

import com.cjyong.pcw.blog.data.BaseData;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/18
 * Time: 14:36
 * Description:
 */
@Data
public class ClassifyInfo {
    private String firstFoler;
    private String secondFoler;
    private String fileName;
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime updateTime;

    public ClassifyInfo(String firstFoler, String secondFoler, String fileName, int id, LocalDateTime startTime, LocalDateTime updateTime) {
        this.firstFoler = firstFoler.toLowerCase();
        this.secondFoler = secondFoler.toLowerCase();
        this.fileName = fileName;
        this.id = id;
        this.startTime = startTime;
        this.updateTime = updateTime;
    }

    public String getReadPath() {
        return String.format(BaseData.BASERPATH, firstFoler, secondFoler, fileName);
    }

    public String getWritePath() {
        return String.format(BaseData.BASEWPATH, firstFoler, secondFoler, fileName.toLowerCase());
    }

    public String getClassify() {
        return String.format(BaseData.BASECLASSIFY, firstFoler.toUpperCase(), secondFoler.toUpperCase(), fileName);
    }

    public String getTitle() {
        return String.format(BaseData.BASETITLE, secondFoler.toUpperCase());
    }

    public String getStartTime() {
        return startTime.getYear() + "." +
                (startTime.getMonth().getValue() < 10 ? "0"  : "") + startTime.getMonth().getValue() + "." +
                (startTime.getDayOfMonth() < 10 ? "0"  : "") + startTime.getDayOfMonth();
    }

    public String getUpdateTime() {
        return updateTime.getYear() + "." +
                (updateTime.getMonth().getValue() < 10 ? "0"  : "") + updateTime.getMonth().getValue() + "." +
                (updateTime.getDayOfMonth() < 10 ? "0"  : "") + updateTime.getDayOfMonth();
    }
}