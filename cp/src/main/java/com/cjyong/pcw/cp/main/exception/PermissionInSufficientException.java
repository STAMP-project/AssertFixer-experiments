package com.cjyong.pcw.cp.main.exception;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/29
 * Time: 19:43
 * Description: an exception class which will be throw when permission is denied.
 */
public class PermissionInSufficientException extends Exception{

    private static final String description = "Permission deny";

    public PermissionInSufficientException(String msg) {
        super(description + " : " + msg);
    }
}
