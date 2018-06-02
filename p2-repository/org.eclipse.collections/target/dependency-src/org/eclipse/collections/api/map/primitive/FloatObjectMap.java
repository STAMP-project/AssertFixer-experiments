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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.FloatObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface FloatObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(float key);

    V getIfAbsent(float key, Function0<? extends V> ifAbsent);

    boolean containsKey(float key);

    @Override
    FloatObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(FloatProcedure procedure);

    void forEachKeyValue(FloatObjectProcedure<? super V> procedure);

    FloatObjectMap<V> select(FloatObjectPredicate<? super V> predicate);

    FloatObjectMap<V> reject(FloatObjectPredicate<? super V> predicate);

    ImmutableFloatObjectMap<V> toImmutable();

    MutableFloatSet keySet();

    /**
     * @since 5.0
     */
    LazyFloatIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<FloatObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectFloatMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectFloatMap contains duplicate values.
     * @since 9.0
     */
     ObjectFloatMap<V> flipUniqueValues();
}
