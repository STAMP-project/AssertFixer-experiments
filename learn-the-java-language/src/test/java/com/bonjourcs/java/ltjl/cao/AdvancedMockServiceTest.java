package com.bonjourcs.java.ltjl.cao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liang Chenghao
 * Description:
 * Date: 2018/3/30
 */
public class AdvancedMockServiceTest {

    @Test
    public void testPrintMockObject() {

        List<MockObject> mockObjects
                = new ArrayList<>(3);
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 10));
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 5));
        mockObjects.add(new MockObject(MockObject.Color.YELLOW, 10, 10));

        // specify search criteria
        AdvancedMockService advancedMockService = new AdvancedMockService();
        advancedMockService.printMockObject(mockObjects, mockObject ->
                mockObject.getLength() > 5
                        && mockObject.getWeight() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN
        );

    }

    @Test
    public void testPrintMockObject1() {

        List<MockObject> mockObjects
                = new ArrayList<>(3);
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 10));
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 5));
        mockObjects.add(new MockObject(MockObject.Color.YELLOW, 10, 10));

        AdvancedMockService advancedMockService = new AdvancedMockService();
        advancedMockService.printMockObject(mockObjects,
                mockObject -> mockObject.getLength() > 5
                        && mockObject.getWeight() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN,
                System.out::println);
    }

    @Test
    public void testPrintGender() {

        List<MockObject> mockObjects
                = new ArrayList<>(3);
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 10));
        mockObjects.add(new MockObject(MockObject.Color.GREEN, 10, 5));
        mockObjects.add(new MockObject(MockObject.Color.YELLOW, 10, 10));

        AdvancedMockService advancedMockService = new AdvancedMockService();

        advancedMockService.printGender(mockObjects,
                mockObject -> mockObject.getWeight() > 5
                        && mockObject.getLength() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN,
                mockObject -> mockObject.getColor().toString(),
                System.out::println);

        // another form
        mockObjects.stream()
                .filter(mockObject -> mockObject.getLength() > 5
                        && mockObject.getWeight() > 5
                        && mockObject.getColor() == MockObject.Color.GREEN)
                .map(MockObject::getColor)
                .forEach(System.out::println);
    }

    @Test
    public void testCompareByName() {

        MockObject[] mockObjects = new MockObject[3];
        mockObjects[0]
                = new MockObject(MockObject.Color.GREEN, "hat", 1, 1);
        mockObjects[1]
                = new MockObject(MockObject.Color.GREEN, "cup", 1, 1);
        mockObjects[2]
                = new MockObject(MockObject.Color.GREEN, "mouse", 1, 1);

        // instance method reference
        Arrays.sort(mockObjects, new AdvancedMockService()::compareByName);
        for (MockObject mockObject :
                mockObjects) {
            System.out.println(mockObject);
        }

    }
}