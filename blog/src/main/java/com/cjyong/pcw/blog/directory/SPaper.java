package com.cjyong.pcw.blog.directory;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/18
 * Time: 17:13
 * Description:
 */
@Data
@AllArgsConstructor
public class SPaper implements Comparable{
    private int id;
    private String bigType;
    private String mediumType;
    private String smallType;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String title;

    public SPaper(int id) {
        this.id = id;
    }

    public SPaper(String id, String bigType, String mediumType, String smallType, String startTime, String updateTime, String title) {
        this.id = Integer.parseInt(id);
        this.bigType = bigType;
        this.mediumType = mediumType;
        this.smallType = smallType;
        String[] nums = startTime.split("\\.");
        this.createTime = LocalDateTime.of(Integer.parseInt(nums[0]),
                Integer.parseInt(nums[1]),
                Integer.parseInt(nums[2]), 1, 1);
        nums = updateTime.split("\\.");
        this.updateTime = LocalDateTime.of(Integer.parseInt(nums[0]),
                Integer.parseInt(nums[1]),
                Integer.parseInt(nums[2]),1 ,1);
        this.title = title;
    }

    public static SPaper getPaper(String total) {
        String[] datas = total.trim().split(" ");
        if (datas.length != 7){
            System.out.println(total + "length: " + datas.length);
            return null;
        }
        return new SPaper(datas[0], datas[1], datas[2], datas[3], datas[4], datas[5], datas[6]);
    }

    public String getStartTime() {
        return createTime.getYear() + "." +
                (createTime.getMonth().getValue() < 10 ? "0"  : "") + createTime.getMonth().getValue() + "." +
                (createTime.getDayOfMonth() < 10 ? "0"  : "") + createTime.getDayOfMonth();
    }

    @Override
    public int compareTo(Object o) {
        SPaper SPaper = (SPaper) o;
        return -createTime.compareTo(SPaper.createTime);
    }
}