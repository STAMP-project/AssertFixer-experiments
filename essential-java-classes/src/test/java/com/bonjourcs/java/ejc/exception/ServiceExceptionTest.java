package com.bonjourcs.java.ejc.exception;

import org.junit.Test;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/4/27
 */
public class ServiceExceptionTest {

    @Test
    public void testChainedException() {
        try {
            causeException();
        } catch (ServiceException e) {
            System.out.println("An exception occurs and cause is :" + e.getCause().toString());
        }
    }

    private void causeException() throws ServiceException {

        try {
            // an exception occurs here
            System.out.println(1 / 0);
        } catch (Exception e) {
            // wrap to service exception an throw it
            throw new ServiceException(e);
        }

    }
}