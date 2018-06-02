/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import java.util.Set;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectCharPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectCharProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectCharPair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectCharMap<K> extends CharIterable
{
    char get(Object key);

    char getOrThrow(Object key);

    char getIfAbsent(Object key, char ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(char value);

    void forEachValue(CharProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectCharProcedure<? super K> procedure);
    /**
     * Return the CharObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the CharObjectMap contains duplicate values.
     * @since 9.0
     */
    CharObjectMap<K> flipUniqueValues();

    ObjectCharMap<K> select(ObjectCharPredicate<? super K> predicate);

    ObjectCharMap<K> reject(ObjectCharPredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectCharMap<K> tap(CharProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectCharMap
     */
    String toString();

    ImmutableObjectCharMap<K> toImmutable();

    Set<K> keySet();

    MutableCharCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectCharPair<K>> keyValuesView();
}
