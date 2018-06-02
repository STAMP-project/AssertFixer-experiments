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
import org.eclipse.collections.api.block.predicate.primitive.DoubleCharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleCharProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleCharPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface DoubleCharMap extends CharValuesMap
{
    char get(double key);

    char getIfAbsent(double key, char ifAbsent);

    char getOrThrow(double key);

    boolean containsKey(double key);

    void forEachKey(DoubleProcedure procedure);

    void forEachKeyValue(DoubleCharProcedure procedure);

    LazyDoubleIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<DoubleCharPair> keyValuesView();
    /**
     * Return the CharDoubleMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the CharDoubleMap contains duplicate values.
     * @since 9.0
     */
    CharDoubleMap flipUniqueValues();

    DoubleCharMap select(DoubleCharPredicate predicate);

    DoubleCharMap reject(DoubleCharPredicate predicate);

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
     * @return a string representation of this DoubleCharMap
     */
    @Override
    String toString();

    ImmutableDoubleCharMap toImmutable();

    MutableDoubleSet keySet();
}
