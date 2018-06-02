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

import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectFloatPredicate;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableFloatCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectFloatMap<K> extends ObjectFloatMap<K>
{
    @Override
    ImmutableObjectFloatMap<K> select(ObjectFloatPredicate<? super K> predicate);

    @Override
    ImmutableObjectFloatMap<K> reject(ObjectFloatPredicate<? super K> predicate);

    @Override
    ImmutableFloatCollection select(FloatPredicate predicate);

    @Override
    ImmutableFloatCollection reject(FloatPredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectFloatMap<K> tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(FloatToObjectFunction<? extends V> function);

    ImmutableObjectFloatMap<K> newWithKeyValue(K key, float value);

    ImmutableObjectFloatMap<K> newWithoutKey(K key);

    ImmutableObjectFloatMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableFloatObjectMap<K> flipUniqueValues();
}
