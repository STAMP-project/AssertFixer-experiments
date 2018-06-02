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

import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectIntPredicate;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableIntCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectIntMap<K> extends ObjectIntMap<K>
{
    @Override
    ImmutableObjectIntMap<K> select(ObjectIntPredicate<? super K> predicate);

    @Override
    ImmutableObjectIntMap<K> reject(ObjectIntPredicate<? super K> predicate);

    @Override
    ImmutableIntCollection select(IntPredicate predicate);

    @Override
    ImmutableIntCollection reject(IntPredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectIntMap<K> tap(IntProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(IntToObjectFunction<? extends V> function);

    ImmutableObjectIntMap<K> newWithKeyValue(K key, int value);

    ImmutableObjectIntMap<K> newWithoutKey(K key);

    ImmutableObjectIntMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableIntObjectMap<K> flipUniqueValues();
}
