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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.DoubleBytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleByteProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleBytePair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface DoubleByteMap extends ByteValuesMap
{
    byte get(double key);

    byte getIfAbsent(double key, byte ifAbsent);

    byte getOrThrow(double key);

    boolean containsKey(double key);

    void forEachKey(DoubleProcedure procedure);

    void forEachKeyValue(DoubleByteProcedure procedure);

    LazyDoubleIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<DoubleBytePair> keyValuesView();
    /**
     * Return the ByteDoubleMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ByteDoubleMap contains duplicate values.
     * @since 9.0
     */
    ByteDoubleMap flipUniqueValues();

    DoubleByteMap select(DoubleBytePredicate predicate);

    DoubleByteMap reject(DoubleBytePredicate predicate);

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
     * @return a string representation of this DoubleByteMap
     */
    @Override
    String toString();

    ImmutableDoubleByteMap toImmutable();

    MutableDoubleSet keySet();
}
