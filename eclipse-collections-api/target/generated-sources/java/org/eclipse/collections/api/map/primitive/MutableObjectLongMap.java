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

import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectLongPredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectLongPair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectLongMap<K> extends ObjectLongMap<K>
{
    @Override
    MutableLongIterator longIterator();

    void clear();

    void put(K key, long value);

    /**
     * This method allows MutableObjectLongMap the ability to add an element in the form of ObjectLongPair<K>.
     *
     * @see #put(Object, long)
     * @since 9.1.0
     */
    default void putPair(ObjectLongPair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectLongMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    long removeKeyIfAbsent(K key, long value);

    long getIfAbsentPut(K key, long value);

    long getIfAbsentPut(K key, LongFunction0 function);

    long getIfAbsentPutWithKey(K key, LongFunction<? super K> function);

    <P> long getIfAbsentPutWith(K key, LongFunction<? super P> function, P parameter);

    long updateValue(K key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectLongMap<K> select(ObjectLongPredicate<? super K> predicate);

    @Override
    MutableObjectLongMap<K> reject(ObjectLongPredicate<? super K> predicate);

    @Override
    MutableLongCollection select(LongPredicate predicate);

    @Override
    MutableLongCollection reject(LongPredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectLongMap<K> tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(LongToObjectFunction<? extends V> function);

    MutableObjectLongMap<K> withKeyValue(K key, long value);

    MutableObjectLongMap<K> withoutKey(K key);

    MutableObjectLongMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectLongMap<K> asUnmodifiable();

    MutableObjectLongMap<K> asSynchronized();

    long addToValue(K key, long toBeAdded);
}
