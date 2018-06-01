package io.github.caiwan.utils;

import com.google.common.base.CaseFormat;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassReflector implements Iterable<String>{

    private static final Pattern propertyPattern = Pattern.compile("(get|set)(\\w+)");
//    private static final Pattern baseTypePattern = Pattern.compile("java\\.lang\\.(\\w+)");

    @Getter
    private Class modelClass;

    // Getter -> setter
    private Map<String, Pair<Method, Method>> properties = new HashMap<>();

    public ClassReflector(Class modelClass) {
        this.modelClass = modelClass;
    }

    @SneakyThrows
    public void build() {
        for (Method method : modelClass.getDeclaredMethods()) {
            Matcher propertyMatcher = propertyPattern.matcher(method.getName());

            if (!propertyMatcher.find())
                continue;

            String methodType = propertyMatcher.group(1);
            String propertyName = propertyMatcher.group(2);

            propertyName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, propertyName);

            Pair<Method, Method> methodPair = properties.get(propertyName);
            if (methodPair == null) {
                methodPair = new Pair<>();
            }

            // left = getter
            // right = setter
            if (methodType.equals("get")) {
                methodPair.setLeft(method);

            } else if (methodType.equals("set")) {
                methodPair.setRight(method);
            }

            properties.put(propertyName, methodPair);

        }
    }

    public boolean hasGetter(String name) {
        return properties.containsKey(name) && properties.get(name).getLeft() != null;
    }

    public boolean hasSetter(String name) {
        return properties.containsKey(name) && properties.get(name).getRight() != null;
    }

    @SneakyThrows
    public Object get(String name, Object source) {
        if (!hasGetter(name))
            throw new RuntimeException("Reflector has no getter method: " + name);
        Method getterMethod = properties.get(name).getLeft();
        return getterMethod.invoke(source);
    }

    @SneakyThrows
    public void set(String name, Object value, Object target) {
        if (!hasSetter(name))
            throw new RuntimeException("Reflector has no setter method: " + name);
        Method setterMethod = properties.get(name).getRight();
        setterMethod.invoke(target, value);
    }

    @Override
    public Iterator<String> iterator() {
        return properties.keySet().iterator();
    }
}
