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
import org.eclipse.collections.api.block.predicate.primitive.CharIntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharIntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface CharIntMap extends IntValuesMap
{
    int get(char key);

    int getIfAbsent(char key, int ifAbsent);

    int getOrThrow(char key);

    boolean containsKey(char key);

    void forEachKey(CharProcedure procedure);

    void forEachKeyValue(CharIntProcedure procedure);

    LazyCharIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<CharIntPair> keyValuesView();
    /**
     * Return the IntCharMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the IntCharMap contains duplicate values.
     * @since 9.0
     */
    IntCharMap flipUniqueValues();

    CharIntMap select(CharIntPredicate predicate);

    CharIntMap reject(CharIntPredicate predicate);

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
     * @return a string representation of this CharIntMap
     */
    @Override
    String toString();

    ImmutableCharIntMap toImmutable();

    MutableCharSet keySet();
}
