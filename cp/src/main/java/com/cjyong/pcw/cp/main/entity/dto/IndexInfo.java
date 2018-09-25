package com.cjyong.pcw.cp.main.entity.dto;

import com.cjyong.pcw.cp.main.entity.Album;
import com.cjyong.pcw.cp.main.entity.DailyActivity;
import com.cjyong.pcw.cp.main.entity.DailySentence;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/12/10
 * Time: 21:30
 * Description: A class which packet index page info.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class IndexInfo implements Serializable{
    private List<DailySentence> sentences;
    private List<DailyActivity> activities;
    private List<Album> albums;
}
