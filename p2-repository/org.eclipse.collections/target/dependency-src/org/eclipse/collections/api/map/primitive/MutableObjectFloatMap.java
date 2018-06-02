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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectFloatPredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectFloatPair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectFloatMap<K> extends ObjectFloatMap<K>
{
    @Override
    MutableFloatIterator floatIterator();

    void clear();

    void put(K key, float value);

    /**
     * This method allows MutableObjectFloatMap the ability to add an element in the form of ObjectFloatPair<K>.
     *
     * @see #put(Object, float)
     * @since 9.1.0
     */
    default void putPair(ObjectFloatPair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectFloatMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    float removeKeyIfAbsent(K key, float value);

    float getIfAbsentPut(K key, float value);

    float getIfAbsentPut(K key, FloatFunction0 function);

    float getIfAbsentPutWithKey(K key, FloatFunction<? super K> function);

    <P> float getIfAbsentPutWith(K key, FloatFunction<? super P> function, P parameter);

    float updateValue(K key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectFloatMap<K> select(ObjectFloatPredicate<? super K> predicate);

    @Override
    MutableObjectFloatMap<K> reject(ObjectFloatPredicate<? super K> predicate);

    @Override
    MutableFloatCollection select(FloatPredicate predicate);

    @Override
    MutableFloatCollection reject(FloatPredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectFloatMap<K> tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(FloatToObjectFunction<? extends V> function);

    MutableObjectFloatMap<K> withKeyValue(K key, float value);

    MutableObjectFloatMap<K> withoutKey(K key);

    MutableObjectFloatMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectFloatMap<K> asUnmodifiable();

    MutableObjectFloatMap<K> asSynchronized();

    float addToValue(K key, float toBeAdded);
}
