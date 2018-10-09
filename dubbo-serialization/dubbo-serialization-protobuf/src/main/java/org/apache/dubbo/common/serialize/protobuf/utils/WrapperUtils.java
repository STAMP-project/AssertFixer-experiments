package org.apache.dubbo.common.serialize.protobuf.utils;

import org.apache.dubbo.common.serialize.protobuf.Wrapper;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class WrapperUtils {
    private static final Set<Class<?>> WRAPPER_SET = new HashSet<>();

    static {
        WRAPPER_SET.add(Map.class);
        WRAPPER_SET.add(HashMap.class);
        WRAPPER_SET.add(TreeMap.class);
        WRAPPER_SET.add(Hashtable.class);
        WRAPPER_SET.add(SortedMap.class);
        WRAPPER_SET.add(LinkedHashMap.class);
        WRAPPER_SET.add(ConcurrentHashMap.class);

        WRAPPER_SET.add(List.class);
        WRAPPER_SET.add(ArrayList.class);
        WRAPPER_SET.add(LinkedList.class);

        WRAPPER_SET.add(Vector.class);

        WRAPPER_SET.add(Set.class);
        WRAPPER_SET.add(HashSet.class);
        WRAPPER_SET.add(TreeSet.class);
        WRAPPER_SET.add(BitSet.class);

        WRAPPER_SET.add(StringBuffer.class);
        WRAPPER_SET.add(StringBuilder.class);

        WRAPPER_SET.add(BigDecimal.class);
        WRAPPER_SET.add(Date.class);
        WRAPPER_SET.add(Calendar.class);

        WRAPPER_SET.add(Wrapper.class);
    }

    public static boolean needWrapper(Class<?> clazz) {
        return WrapperUtils.WRAPPER_SET.contains(clazz) || clazz.isArray() || clazz.isEnum();
    }

    public static boolean needWrapper(Object obj) {
        return needWrapper(obj.getClass());
    }

}
