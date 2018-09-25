package com.cjyong.pcw.cp.main.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import com.cjyong.pcw.blog.data.BaseData;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/11
 * Time: 16:48
 * Description:
 */
@Entity
@Table(name="blog_paper")
@Data
@Accessors(chain = true)
public class Paper implements Serializable, Comparable{
    @Id
    private Integer id;
    private long createTime;
    private long updateTime;
    private String bigType;
    private String mediumType;
    private String smallType;
    private int type;           //二级分类ID，所有的Record共享一个id
    private int typeid;         //拓展Record的二级ID
    private String title;
    private String signature;
    private int viewsCount;

    public Paper(int id, String bigType, String mediumType, String smallType) {
        this.id = id;
        this.createTime = System.currentTimeMillis();
        this.updateTime = System.currentTimeMillis();
        this.bigType = bigType;
        this.mediumType = mediumType;
        this.smallType = smallType;
        this.type = BaseData.getType(mediumType);
        //注意这里存在问题,typeid存在Record的兼容问题
        this.typeid= type == 1 ? 1 : type + 3;
        this.title = smallType;
        this.signature = "";
        this.viewsCount = 1;
    }

    @Override
    public int compareTo(Object o) {
        Paper paper = (Paper) o;
        return createTime > paper.createTime ? -1 : createTime == paper.createTime ? 0 : 1;
    }
}
