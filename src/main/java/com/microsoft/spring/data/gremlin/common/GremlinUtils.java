/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for
 * license information.
 */
package com.microsoft.spring.data.gremlin.common;

import static com.microsoft.spring.data.gremlin.common.Constants.GREMLIN_QUERY_BARRIER;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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

        if (generatedValueFields.size() == 1 && !generatedValueFields.get(0).equals(idField)) {
            throw new GremlinIllegalConfigurationException("Only the id field can have the optional "
                    + "@GeneratedValue annotation!");
        }

        return idField;
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

    public static <T> GremlinSource<T> toGremlinSource(@NonNull Class<T> domainClass) {
        return new GremlinEntityInformation<>(domainClass).createGremlinSource();
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
        final Field vertexSetField =  
                Arrays.stream(FieldUtils.getAllFields(graphType))
                      .filter(f -> f.isAnnotationPresent(VertexSet.class))
                      .findFirst()
                      .orElseThrow(() -> new GremlinEntityInformationException("No VertexSet found in class " 
                              + graphType.getName()));
        return extractGenericTypeFromCollection(vertexSetField, graphType);
    }

    public static Class<?> determineGraphEdgeType(@NonNull Class<?> graphType) {
        final Field edgeSetField =  
                Arrays.stream(FieldUtils.getAllFields(graphType))
                      .filter(f -> f.isAnnotationPresent(EdgeSet.class))
                      .findFirst()
                      .orElseThrow(() -> new GremlinEntityInformationException("No EdgeSet found in class " 
                              + graphType.getName()));
        return extractGenericTypeFromCollection(edgeSetField, graphType);
    }

    private static Class<?> extractGenericTypeFromCollection(Field field, Class<?> clazz) {
        ReflectionUtils.makeAccessible(field);
        if (!(Collection.class.isAssignableFrom(field.getType()))) {
            throw new GremlinEntityInformationException("The current implementation only supports collections "
                    + "of vertices in Graph objects");
        }
        
        final ParameterizedType returnType = (ParameterizedType) field.getGenericType();
        final Type genericType = returnType.getActualTypeArguments()[0];
        return (Class<?>) genericType;
    }
}
