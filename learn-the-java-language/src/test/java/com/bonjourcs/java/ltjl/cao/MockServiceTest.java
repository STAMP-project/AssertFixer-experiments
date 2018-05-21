package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/29
 */
public class MockServiceTest {

    @Test
    public void testPrintMockObject() {

        List<MockObject> mockObjects
                = new ArrayList<>(3);
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 10));
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 5));
        mockObjects.add(new MockObject(MockObject.Color.YELLOW, 10, 10));

        MockService mockService = new MockService();

        // specify search criteria
        mockService.printMockObject(mockObjects, new MockInterface() {
            @Override
            public boolean filterMockObject(MockObject mockObject) {
                return mockObject.getWeight() > 5
                        && mockObject.getLength() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN;
            }
        });

        // the following code is equivalent to code above
        mockService.printMockObject(mockObjects,
                mockObject ->
                        mockObject.getWeight() > 5
                                && mockObject.getLength() > 5
                                && mockObject.getColor() == MockObject.Color.GREEN);

    }

}