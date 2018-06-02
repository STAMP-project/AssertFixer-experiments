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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.IntDoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntDoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.IntDoublePair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface IntDoubleMap extends DoubleValuesMap
{
    double get(int key);

    double getIfAbsent(int key, double ifAbsent);

    double getOrThrow(int key);

    boolean containsKey(int key);

    void forEachKey(IntProcedure procedure);

    void forEachKeyValue(IntDoubleProcedure procedure);

    LazyIntIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<IntDoublePair> keyValuesView();
    /**
     * Return the DoubleIntMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the DoubleIntMap contains duplicate values.
     * @since 9.0
     */
    DoubleIntMap flipUniqueValues();

    IntDoubleMap select(IntDoublePredicate predicate);

    IntDoubleMap reject(IntDoublePredicate predicate);

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
     * @return a string representation of this IntDoubleMap
     */
    @Override
    String toString();

    ImmutableIntDoubleMap toImmutable();

    MutableIntSet keySet();
}
