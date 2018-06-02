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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectShortPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectShortProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectShortPair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectShortMap<K> extends ShortIterable
{
    short get(Object key);

    short getOrThrow(Object key);

    short getIfAbsent(Object key, short ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(short value);

    void forEachValue(ShortProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectShortProcedure<? super K> procedure);
    /**
     * Return the ShortObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ShortObjectMap contains duplicate values.
     * @since 9.0
     */
    ShortObjectMap<K> flipUniqueValues();

    ObjectShortMap<K> select(ObjectShortPredicate<? super K> predicate);

    ObjectShortMap<K> reject(ObjectShortPredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectShortMap<K> tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectShortMap
     */
    String toString();

    ImmutableObjectShortMap<K> toImmutable();

    Set<K> keySet();

    MutableShortCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectShortPair<K>> keyValuesView();
}
