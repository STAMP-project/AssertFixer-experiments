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
import org.eclipse.collections.api.block.predicate.primitive.IntIntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntIntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface IntIntMap extends IntValuesMap
{
    int get(int key);

    int getIfAbsent(int key, int ifAbsent);

    int getOrThrow(int key);

    boolean containsKey(int key);

    void forEachKey(IntProcedure procedure);

    void forEachKeyValue(IntIntProcedure procedure);

    LazyIntIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<IntIntPair> keyValuesView();
    /**
     * Return the IntIntMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the IntIntMap contains duplicate values.
     * @since 9.0
     */
    IntIntMap flipUniqueValues();

    IntIntMap select(IntIntPredicate predicate);

    IntIntMap reject(IntIntPredicate predicate);

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
     * @return a string representation of this IntIntMap
     */
    @Override
    String toString();

    ImmutableIntIntMap toImmutable();

    MutableIntSet keySet();
}
