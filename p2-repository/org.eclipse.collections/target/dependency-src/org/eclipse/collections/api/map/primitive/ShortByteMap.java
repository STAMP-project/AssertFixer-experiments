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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ShortBytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortByteProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortBytePair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ShortByteMap extends ByteValuesMap
{
    byte get(short key);

    byte getIfAbsent(short key, byte ifAbsent);

    byte getOrThrow(short key);

    boolean containsKey(short key);

    void forEachKey(ShortProcedure procedure);

    void forEachKeyValue(ShortByteProcedure procedure);

    LazyShortIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ShortBytePair> keyValuesView();
    /**
     * Return the ByteShortMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ByteShortMap contains duplicate values.
     * @since 9.0
     */
    ByteShortMap flipUniqueValues();

    ShortByteMap select(ShortBytePredicate predicate);

    ShortByteMap reject(ShortBytePredicate predicate);

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
     * @return a string representation of this ShortByteMap
     */
    @Override
    String toString();

    ImmutableShortByteMap toImmutable();

    MutableShortSet keySet();
}
