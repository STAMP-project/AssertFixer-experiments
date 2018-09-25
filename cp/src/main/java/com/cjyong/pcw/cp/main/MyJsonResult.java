package com.cjyong.pcw.cp.main;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/29
 * Time: 15:50
 * Description: A class use to package the interactive information between font and end.
 */
@Data
public class MyJsonResult<T> implements Serializable{
    private static final long serialVersionUID = -7048435098709063418L;

    /**
     * The interaction is success ?
     */
    private boolean success;
    /**
     * The tip message.
     */
    private String msg;
    /**
     * The time stamp.
     */
    private long createTime = System.currentTimeMillis();
    /**
     * The result data.
     */
    private T data;


    private static final String OperationSuccess = "操作成功";

    /**
     *  默认构造方法为操作成功无数据返回
     */
    public MyJsonResult() {
        this(true, null, OperationSuccess);
    }

    /**
     * 传递数据, 默认为操作成功方法
     *
     * @param data
     */
    public MyJsonResult(T data) {
        this(true, data, OperationSuccess);
    }

    /**
     * 传递消息, 默认为操作失败,返回错误提示
     *
     * @param msg
     */
    public MyJsonResult(String msg) {
        this(false, null, msg);
    }


    /**
     * 所有构造方法执行的子方法
     *
     * @param success
     * @param data
     * @param msg
     */
    public MyJsonResult(boolean success, T data, String msg) {
        this.success = success;
        this.data = data;
        this.msg = msg;
    }
}
