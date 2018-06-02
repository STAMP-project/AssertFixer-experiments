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

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectBytePredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectBytePair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectByteMap<K> extends ObjectByteMap<K>
{
    @Override
    MutableByteIterator byteIterator();

    void clear();

    void put(K key, byte value);

    /**
     * This method allows MutableObjectByteMap the ability to add an element in the form of ObjectBytePair<K>.
     *
     * @see #put(Object, byte)
     * @since 9.1.0
     */
    default void putPair(ObjectBytePair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectByteMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    byte removeKeyIfAbsent(K key, byte value);

    byte getIfAbsentPut(K key, byte value);

    byte getIfAbsentPut(K key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(K key, ByteFunction<? super K> function);

    <P> byte getIfAbsentPutWith(K key, ByteFunction<? super P> function, P parameter);

    byte updateValue(K key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectByteMap<K> select(ObjectBytePredicate<? super K> predicate);

    @Override
    MutableObjectByteMap<K> reject(ObjectBytePredicate<? super K> predicate);

    @Override
    MutableByteCollection select(BytePredicate predicate);

    @Override
    MutableByteCollection reject(BytePredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectByteMap<K> tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(ByteToObjectFunction<? extends V> function);

    MutableObjectByteMap<K> withKeyValue(K key, byte value);

    MutableObjectByteMap<K> withoutKey(K key);

    MutableObjectByteMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectByteMap<K> asUnmodifiable();

    MutableObjectByteMap<K> asSynchronized();

    byte addToValue(K key, byte toBeAdded);
}
