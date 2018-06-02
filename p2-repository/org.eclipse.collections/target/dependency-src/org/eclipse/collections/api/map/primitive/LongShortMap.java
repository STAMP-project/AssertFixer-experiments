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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.LongShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongShortProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.LongShortPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface LongShortMap extends ShortValuesMap
{
    short get(long key);

    short getIfAbsent(long key, short ifAbsent);

    short getOrThrow(long key);

    boolean containsKey(long key);

    void forEachKey(LongProcedure procedure);

    void forEachKeyValue(LongShortProcedure procedure);

    LazyLongIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<LongShortPair> keyValuesView();
    /**
     * Return the ShortLongMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ShortLongMap contains duplicate values.
     * @since 9.0
     */
    ShortLongMap flipUniqueValues();

    LongShortMap select(LongShortPredicate predicate);

    LongShortMap reject(LongShortPredicate predicate);

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
     * @return a string representation of this LongShortMap
     */
    @Override
    String toString();

    ImmutableLongShortMap toImmutable();

    MutableLongSet keySet();
}
