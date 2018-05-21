package com.bonjourcs.java.ltjl.cao;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/29
 */
public interface MockInterface {

    /**
     * filter the specified mock object
     *
     * @param mockObject mock object to be filtered
     * @return whether the mock object meets specified standard
     */
    boolean filterMockObject(MockObject mockObject);
}
