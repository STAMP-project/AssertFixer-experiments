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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectLongPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectLongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectLongPair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectLongMap<K> extends LongIterable
{
    long get(Object key);

    long getOrThrow(Object key);

    long getIfAbsent(Object key, long ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(long value);

    void forEachValue(LongProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectLongProcedure<? super K> procedure);
    /**
     * Return the LongObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the LongObjectMap contains duplicate values.
     * @since 9.0
     */
    LongObjectMap<K> flipUniqueValues();

    ObjectLongMap<K> select(ObjectLongPredicate<? super K> predicate);

    ObjectLongMap<K> reject(ObjectLongPredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectLongMap<K> tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectLongMap
     */
    String toString();

    ImmutableObjectLongMap<K> toImmutable();

    Set<K> keySet();

    MutableLongCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectLongPair<K>> keyValuesView();
}
