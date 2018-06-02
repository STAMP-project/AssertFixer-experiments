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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.CharFloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharFloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharFloatPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface CharFloatMap extends FloatValuesMap
{
    float get(char key);

    float getIfAbsent(char key, float ifAbsent);

    float getOrThrow(char key);

    boolean containsKey(char key);

    void forEachKey(CharProcedure procedure);

    void forEachKeyValue(CharFloatProcedure procedure);

    LazyCharIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<CharFloatPair> keyValuesView();
    /**
     * Return the FloatCharMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the FloatCharMap contains duplicate values.
     * @since 9.0
     */
    FloatCharMap flipUniqueValues();

    CharFloatMap select(CharFloatPredicate predicate);

    CharFloatMap reject(CharFloatPredicate predicate);

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
     * @return a string representation of this CharFloatMap
     */
    @Override
    String toString();

    ImmutableCharFloatMap toImmutable();

    MutableCharSet keySet();
}
