/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.spring.data.gremlin.common;

import static com.microsoft.spring.data.gremlin.common.Constants.GREMLIN_QUERY_BARRIER;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.tinkerpop.shaded.jackson.databind.MapperFeature;
import org.apache.tinkerpop.shaded.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;
import org.springframework.util.ReflectionUtils;

import com.microsoft.spring.data.gremlin.annotation.EdgeSet;
import com.microsoft.spring.data.gremlin.annotation.GeneratedValue;
import com.microsoft.spring.data.gremlin.annotation.VertexSet;
import com.microsoft.spring.data.gremlin.conversion.source.GremlinSource;
import com.microsoft.spring.data.gremlin.exception.GremlinEntityInformationException;
import com.microsoft.spring.data.gremlin.exception.GremlinIllegalConfigurationException;
import com.microsoft.spring.data.gremlin.exception.GremlinInvalidEntityIdFieldException;
import com.microsoft.spring.data.gremlin.repository.support.GremlinEntityInformation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GremlinUtils {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final String GETTER_PREFIX = "get";

    static {
        mapper.configure(MapperFeature.AUTO_DETECT_FIELDS, false);
    }

    public static ObjectMapper getObjectMapper() {
        return mapper;
    }

    public static <T> T createInstance(@NonNull Class<T> type) {
        final T instance;

        try {
            instance = type.newInstance();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("can not access type constructor", e);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("failed to create instance of given type", e);
        }

        return instance;
    }

    public static <T> Field getIdField(@NonNull Class<T> domainClass) {
        final Field idField;
        final List<Field> idFields = FieldUtils.getFieldsListWithAnnotation(domainClass, Id.class);
        final List<Field> generatedValueFields = 
                FieldUtils.getFieldsListWithAnnotation(domainClass, GeneratedValue.class);

        if (generatedValueFields.size() > 1) {
            throw new GremlinIllegalConfigurationException("Only one field, the id field, can have the optional "
                    + "@GeneratedValue annotation!");
        }

        if (idFields.isEmpty()) {
            idField = ReflectionUtils.findField(domainClass, Constants.PROPERTY_ID);
        } else if (idFields.size() == 1) {
            idField = idFields.get(0);
        } else {
            throw new GremlinInvalidEntityIdFieldException("only one @Id field is allowed");
        }

        if (idField == null) {
            throw new GremlinInvalidEntityIdFieldException("no field named id in class");
        } else if (idField.getType() != String.class
                && idField.getType() != Long.class && idField.getType() != Integer.class) {
            throw new GremlinInvalidEntityIdFieldException("the type of @Id/id field should be String/Integer/Long");
        }

        if (!generatedValueFields.isEmpty() && !generatedValueFields.get(0).equals(idField)) {
            throw new GremlinIllegalConfigurationException("Only the id field can have the optional "
                    + "@GeneratedValue annotation!");
        }

        return idField;
    }

    public static <T, U extends Annotation> boolean checkIfFieldBearsAnnotation(@NonNull Class<T> domainClass, 
            @NonNull Class<U> annotationClass, @NonNull String fieldName) {
        final Field namedField = ReflectionUtils.findField(domainClass, fieldName);
        if (namedField == null) {
            return false;
        }
        return namedField.isAnnotationPresent(annotationClass);
    }

    public static long timeToMilliSeconds(@NonNull Object time) {
        if (time instanceof Date) {
            return ((Date) time).getTime();
        } else {
            throw new UnsupportedOperationException("Unsupported time type");
        }
    }

    public static long toPrimitiveLong(@NonNull Object object) {
        if (object instanceof Date) {
            return timeToMilliSeconds(object);
        } else if (object instanceof Integer) {
            return (long) (int) object;
        } else if (object instanceof Long) {
            return (long) object;
        } else {
            throw new UnsupportedOperationException("Unsupported object type to long");
        }
    }

    public static GremlinSource toGremlinSource(@NonNull Class<?> domainClass) {
        return new GremlinEntityInformation<>(domainClass).getGremlinSource();
    }

    public static <T> GremlinSource toGremlinSource(@NonNull T domain) {
        @SuppressWarnings("unchecked") final GremlinEntityInformation information =
                new GremlinEntityInformation(domain.getClass());
        final GremlinSource source = information.getGremlinSource();

        source.setId(information.getId(domain));

        return source;
    }

    public static List<List<String>> toParallelQueryList(@NonNull List<String> queries) {
        final List<List<String>> parallelQueries = new ArrayList<>();
        List<String> parallelQuery = new ArrayList<>();

        for (final String query : queries) {
            if (query.equals(GREMLIN_QUERY_BARRIER)) {
                parallelQueries.add(parallelQuery);
                parallelQuery = new ArrayList<>();
            } else {
                parallelQuery.add(query);
            }
        }

        parallelQueries.add(parallelQuery);

        return parallelQueries;
    }
    
    public static Class<?> determineGraphVertexType(@NonNull Class<?> graphType) {
        for (final Field field : FieldUtils.getAllFields(graphType)) {
            if (field.isAnnotationPresent(VertexSet.class)) {
                return extractGenericTypeFromCollection(field, graphType);
            }
        }
        return null;
    }

    public static Class<?> determineGraphEdgeType(@NonNull Class<?> graphType) {
        for (final Field field : FieldUtils.getAllFields(graphType)) {
            if (field.isAnnotationPresent(EdgeSet.class)) {
                return extractGenericTypeFromCollection(field, graphType);
            }
        }
        return null;
    }

    private static Class<?> extractGenericTypeFromCollection(Field field, Class<?> clazz) {
        final String getterName = GETTER_PREFIX + capitalizeFirstLetter(field.getName());
        final Method getterMethod = ReflectionUtils.findMethod(clazz, getterName);
        if (getterMethod == null) {
            throw new GremlinEntityInformationException("No getter method found for field " + field.getName());
        }
        if (!(Collection.class.isAssignableFrom(getterMethod.getReturnType()))) {
            throw new GremlinEntityInformationException("The current implementation only supports collections "
                    + "of vertices in Graph objects");
        }
        final ParameterizedType returnType = (ParameterizedType) getterMethod.getGenericReturnType();
        final Type genericType = returnType.getActualTypeArguments()[0];
        return (Class<?>) genericType;
    }

    private static String capitalizeFirstLetter(String str) {
        final StringBuilder capitalizedString = new StringBuilder();
        capitalizedString.append(str.substring(0, 1).toUpperCase(Locale.ROOT)).append(str.substring(1));
        return capitalizedString.toString();
    }
}
