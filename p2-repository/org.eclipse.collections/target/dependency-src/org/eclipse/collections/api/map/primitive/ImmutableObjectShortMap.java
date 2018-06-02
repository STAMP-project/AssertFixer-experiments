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

import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectShortPredicate;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableShortCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectShortMap<K> extends ObjectShortMap<K>
{
    @Override
    ImmutableObjectShortMap<K> select(ObjectShortPredicate<? super K> predicate);

    @Override
    ImmutableObjectShortMap<K> reject(ObjectShortPredicate<? super K> predicate);

    @Override
    ImmutableShortCollection select(ShortPredicate predicate);

    @Override
    ImmutableShortCollection reject(ShortPredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectShortMap<K> tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(ShortToObjectFunction<? extends V> function);

    ImmutableObjectShortMap<K> newWithKeyValue(K key, short value);

    ImmutableObjectShortMap<K> newWithoutKey(K key);

    ImmutableObjectShortMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableShortObjectMap<K> flipUniqueValues();
}
