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

import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectLongPredicate;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableLongCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectLongMap<K> extends ObjectLongMap<K>
{
    @Override
    ImmutableObjectLongMap<K> select(ObjectLongPredicate<? super K> predicate);

    @Override
    ImmutableObjectLongMap<K> reject(ObjectLongPredicate<? super K> predicate);

    @Override
    ImmutableLongCollection select(LongPredicate predicate);

    @Override
    ImmutableLongCollection reject(LongPredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectLongMap<K> tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(LongToObjectFunction<? extends V> function);

    ImmutableObjectLongMap<K> newWithKeyValue(K key, long value);

    ImmutableObjectLongMap<K> newWithoutKey(K key);

    ImmutableObjectLongMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableLongObjectMap<K> flipUniqueValues();
}
