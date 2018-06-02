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
import org.eclipse.collections.api.block.predicate.primitive.ByteDoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteDoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteDoublePair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ByteDoubleMap extends DoubleValuesMap
{
    double get(byte key);

    double getIfAbsent(byte key, double ifAbsent);

    double getOrThrow(byte key);

    boolean containsKey(byte key);

    void forEachKey(ByteProcedure procedure);

    void forEachKeyValue(ByteDoubleProcedure procedure);

    LazyByteIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ByteDoublePair> keyValuesView();
    /**
     * Return the DoubleByteMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the DoubleByteMap contains duplicate values.
     * @since 9.0
     */
    DoubleByteMap flipUniqueValues();

    ByteDoubleMap select(ByteDoublePredicate predicate);

    ByteDoubleMap reject(ByteDoublePredicate predicate);

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
     * @return a string representation of this ByteDoubleMap
     */
    @Override
    String toString();

    ImmutableByteDoubleMap toImmutable();

    MutableByteSet keySet();
}
