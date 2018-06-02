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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectShortPredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectShortPair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectShortMap<K> extends ObjectShortMap<K>
{
    @Override
    MutableShortIterator shortIterator();

    void clear();

    void put(K key, short value);

    /**
     * This method allows MutableObjectShortMap the ability to add an element in the form of ObjectShortPair<K>.
     *
     * @see #put(Object, short)
     * @since 9.1.0
     */
    default void putPair(ObjectShortPair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectShortMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    short removeKeyIfAbsent(K key, short value);

    short getIfAbsentPut(K key, short value);

    short getIfAbsentPut(K key, ShortFunction0 function);

    short getIfAbsentPutWithKey(K key, ShortFunction<? super K> function);

    <P> short getIfAbsentPutWith(K key, ShortFunction<? super P> function, P parameter);

    short updateValue(K key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectShortMap<K> select(ObjectShortPredicate<? super K> predicate);

    @Override
    MutableObjectShortMap<K> reject(ObjectShortPredicate<? super K> predicate);

    @Override
    MutableShortCollection select(ShortPredicate predicate);

    @Override
    MutableShortCollection reject(ShortPredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectShortMap<K> tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(ShortToObjectFunction<? extends V> function);

    MutableObjectShortMap<K> withKeyValue(K key, short value);

    MutableObjectShortMap<K> withoutKey(K key);

    MutableObjectShortMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectShortMap<K> asUnmodifiable();

    MutableObjectShortMap<K> asSynchronized();

    short addToValue(K key, short toBeAdded);
}
