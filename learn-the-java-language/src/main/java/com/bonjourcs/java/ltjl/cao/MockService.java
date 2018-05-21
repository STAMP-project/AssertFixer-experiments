package com.bonjourcs.java.ltjl.cao;

import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/29
 */
public class MockService {

    public void printMockObject(List<MockObject> mockObjectList, MockInterface mockInterface) {
        for (MockObject mockObject : mockObjectList) {
            if (mockInterface.filterMockObject(mockObject)) {
                System.out.println(mockObject);
            }
        }
    }

}
