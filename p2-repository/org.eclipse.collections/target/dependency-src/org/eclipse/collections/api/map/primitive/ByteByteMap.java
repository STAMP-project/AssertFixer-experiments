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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ByteBytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteByteProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ByteByteMap extends ByteValuesMap
{
    byte get(byte key);

    byte getIfAbsent(byte key, byte ifAbsent);

    byte getOrThrow(byte key);

    boolean containsKey(byte key);

    void forEachKey(ByteProcedure procedure);

    void forEachKeyValue(ByteByteProcedure procedure);

    LazyByteIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ByteBytePair> keyValuesView();
    /**
     * Return the ByteByteMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ByteByteMap contains duplicate values.
     * @since 9.0
     */
    ByteByteMap flipUniqueValues();

    ByteByteMap select(ByteBytePredicate predicate);

    ByteByteMap reject(ByteBytePredicate predicate);

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
     * @return a string representation of this ByteByteMap
     */
    @Override
    String toString();

    ImmutableByteByteMap toImmutable();

    MutableByteSet keySet();
}
