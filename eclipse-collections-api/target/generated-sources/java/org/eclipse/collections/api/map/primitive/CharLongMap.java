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
import org.eclipse.collections.api.block.predicate.primitive.CharLongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharLongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharLongPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface CharLongMap extends LongValuesMap
{
    long get(char key);

    long getIfAbsent(char key, long ifAbsent);

    long getOrThrow(char key);

    boolean containsKey(char key);

    void forEachKey(CharProcedure procedure);

    void forEachKeyValue(CharLongProcedure procedure);

    LazyCharIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<CharLongPair> keyValuesView();
    /**
     * Return the LongCharMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the LongCharMap contains duplicate values.
     * @since 9.0
     */
    LongCharMap flipUniqueValues();

    CharLongMap select(CharLongPredicate predicate);

    CharLongMap reject(CharLongPredicate predicate);

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
     * @return a string representation of this CharLongMap
     */
    @Override
    String toString();

    ImmutableCharLongMap toImmutable();

    MutableCharSet keySet();
}
