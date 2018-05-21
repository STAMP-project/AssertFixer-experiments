package com.bonjourcs.java.ltjl.cao;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Liang Chenghao
 * Description: advanced mock service
 * Date: 2018/3/30
 */
public class AdvancedMockService {

    /**
     * use Java functional interface
     *
     * @param mockObjects objects to be filtered
     * @param predicate   object filter
     */
    public void printMockObject(List<MockObject> mockObjects, Predicate<MockObject> predicate) {
        for (MockObject mockObject :
                mockObjects) {
            if (predicate.test(mockObject)) {
                System.out.println(mockObject);
            }
        }
    }

    /**
     * use more Java functional interface
     *
     * @param mockObjects objects to be filtered
     * @param predicate   object filter
     * @param consumer    object consumer
     */
    public void printMockObject(List<MockObject> mockObjects,
                                Predicate<MockObject> predicate,
                                Consumer<MockObject> consumer) {
        for (MockObject mockObject :
                mockObjects) {
            if (predicate.test(mockObject)) {
                consumer.accept(mockObject);
            }
        }
    }

    /**
     * print gender of filtered object
     *
     * @param mockObjects objects to be filtered
     * @param predicate   object filter
     * @param function    function to get gender
     * @param gender      gender to print
     */
    public void printGender(List<MockObject> mockObjects,
                            Predicate<MockObject> predicate,
                            Function<MockObject, String> function,
                            Consumer<String> gender) {

        for (MockObject mo : mockObjects) {
            if (predicate.test(mo)) {
                String g = function.apply(mo);
                gender.accept(g);
            }
        }

    }

    /**
     * compare object by name
     *
     * @param object1 object 1
     * @param object2 object 2
     * @return differences between two objects
     */
    public int compareByName(MockObject object1, MockObject object2) {
        return object1.getName().compareTo(object2.getName());
    }

}
