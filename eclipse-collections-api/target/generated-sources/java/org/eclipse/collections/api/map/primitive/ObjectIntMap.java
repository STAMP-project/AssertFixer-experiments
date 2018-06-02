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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectIntPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectIntMap<K> extends IntIterable
{
    int get(Object key);

    int getOrThrow(Object key);

    int getIfAbsent(Object key, int ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(int value);

    void forEachValue(IntProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectIntProcedure<? super K> procedure);
    /**
     * Return the IntObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the IntObjectMap contains duplicate values.
     * @since 9.0
     */
    IntObjectMap<K> flipUniqueValues();

    ObjectIntMap<K> select(ObjectIntPredicate<? super K> predicate);

    ObjectIntMap<K> reject(ObjectIntPredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectIntMap<K> tap(IntProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectIntMap
     */
    String toString();

    ImmutableObjectIntMap<K> toImmutable();

    Set<K> keySet();

    MutableIntCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectIntPair<K>> keyValuesView();
}
