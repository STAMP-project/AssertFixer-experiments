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
import org.eclipse.collections.api.block.predicate.primitive.IntLongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntLongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.IntLongPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface IntLongMap extends LongValuesMap
{
    long get(int key);

    long getIfAbsent(int key, long ifAbsent);

    long getOrThrow(int key);

    boolean containsKey(int key);

    void forEachKey(IntProcedure procedure);

    void forEachKeyValue(IntLongProcedure procedure);

    LazyIntIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<IntLongPair> keyValuesView();
    /**
     * Return the LongIntMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the LongIntMap contains duplicate values.
     * @since 9.0
     */
    LongIntMap flipUniqueValues();

    IntLongMap select(IntLongPredicate predicate);

    IntLongMap reject(IntLongPredicate predicate);

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
     * @return a string representation of this IntLongMap
     */
    @Override
    String toString();

    ImmutableIntLongMap toImmutable();

    MutableIntSet keySet();
}
