package com.cjyong.pcw.cp.main.exception;

/**
 * Created with IntelliJ IDEA By
 * User: cjyong
 * Date: 2017/11/29
 * Time: 19:37
 * Description: an exception class which will be throw when parameter is invalid.
 */
public class ParameterInValidException extends Exception {

    private static final long serialVersionUID = 3166281647200096783L;
    private static final String description = "Parameter Invalid";
    public ParameterInValidException(String msg) {
        super(description + " : " + msg);
    }
}
