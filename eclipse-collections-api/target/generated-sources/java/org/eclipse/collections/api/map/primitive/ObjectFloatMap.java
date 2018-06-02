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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectFloatPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectFloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectFloatPair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectFloatMap<K> extends FloatIterable
{
    float get(Object key);

    float getOrThrow(Object key);

    float getIfAbsent(Object key, float ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(float value);

    void forEachValue(FloatProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectFloatProcedure<? super K> procedure);
    /**
     * Return the FloatObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the FloatObjectMap contains duplicate values.
     * @since 9.0
     */
    FloatObjectMap<K> flipUniqueValues();

    ObjectFloatMap<K> select(ObjectFloatPredicate<? super K> predicate);

    ObjectFloatMap<K> reject(ObjectFloatPredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectFloatMap<K> tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectFloatMap
     */
    String toString();

    ImmutableObjectFloatMap<K> toImmutable();

    Set<K> keySet();

    MutableFloatCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectFloatPair<K>> keyValuesView();
}
