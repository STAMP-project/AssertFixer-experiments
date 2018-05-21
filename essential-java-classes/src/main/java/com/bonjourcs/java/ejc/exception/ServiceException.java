package com.bonjourcs.java.ejc.exception;

/**
 * @author Liang Chenghao
 * Description: Service Exception
 * Date: 2018/4/27
 */
public class ServiceException extends RuntimeException {

    public ServiceException(Throwable t) {
        super(t);
    }

    public ServiceException(String message) {
        super(message);
    }

}
