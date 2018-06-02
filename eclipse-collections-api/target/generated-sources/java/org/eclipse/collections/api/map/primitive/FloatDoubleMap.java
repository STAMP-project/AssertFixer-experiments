/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import java.util.Map;

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.FloatDoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatDoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface FloatDoubleMap extends DoubleValuesMap
{
    double get(float key);

    double getIfAbsent(float key, double ifAbsent);

    double getOrThrow(float key);

    boolean containsKey(float key);

    void forEachKey(FloatProcedure procedure);

    void forEachKeyValue(FloatDoubleProcedure procedure);

    LazyFloatIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<FloatDoublePair> keyValuesView();
    /**
     * Return the DoubleFloatMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the DoubleFloatMap contains duplicate values.
     * @since 9.0
     */
    DoubleFloatMap flipUniqueValues();

    FloatDoubleMap select(FloatDoublePredicate predicate);

    FloatDoubleMap reject(FloatDoublePredicate predicate);

    /**
     * Follows the same general contract as {@link Map#equals(Object)}.
     */
    @Override
    boolean equals(Object o);

    /**
     * Follows the same general contract as {@link Map#hashCode()}.
     */
    @Override
    int hashCode();

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this FloatDoubleMap
     */
    @Override
    String toString();

    ImmutableFloatDoubleMap toImmutable();

    MutableFloatSet keySet();
}
