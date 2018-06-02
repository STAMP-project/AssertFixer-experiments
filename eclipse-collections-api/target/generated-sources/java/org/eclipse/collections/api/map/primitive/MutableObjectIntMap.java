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

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectIntPredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectIntMap<K> extends ObjectIntMap<K>
{
    @Override
    MutableIntIterator intIterator();

    void clear();

    void put(K key, int value);

    /**
     * This method allows MutableObjectIntMap the ability to add an element in the form of ObjectIntPair<K>.
     *
     * @see #put(Object, int)
     * @since 9.1.0
     */
    default void putPair(ObjectIntPair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectIntMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    int removeKeyIfAbsent(K key, int value);

    int getIfAbsentPut(K key, int value);

    int getIfAbsentPut(K key, IntFunction0 function);

    int getIfAbsentPutWithKey(K key, IntFunction<? super K> function);

    <P> int getIfAbsentPutWith(K key, IntFunction<? super P> function, P parameter);

    int updateValue(K key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectIntMap<K> select(ObjectIntPredicate<? super K> predicate);

    @Override
    MutableObjectIntMap<K> reject(ObjectIntPredicate<? super K> predicate);

    @Override
    MutableIntCollection select(IntPredicate predicate);

    @Override
    MutableIntCollection reject(IntPredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectIntMap<K> tap(IntProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(IntToObjectFunction<? extends V> function);

    MutableObjectIntMap<K> withKeyValue(K key, int value);

    MutableObjectIntMap<K> withoutKey(K key);

    MutableObjectIntMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectIntMap<K> asUnmodifiable();

    MutableObjectIntMap<K> asSynchronized();

    int addToValue(K key, int toBeAdded);
}
