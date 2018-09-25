package com.cjyong.pcw.cp.main.exception;

/**
 * Class created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2018/9/17
 * Time: 16:35
 * Description:
 */
public class RuntimeException extends Exception {
    private static final String description = "Runtime error";

    public RuntimeException(String msg) {
        super(description + " : " + msg);
    }
}
