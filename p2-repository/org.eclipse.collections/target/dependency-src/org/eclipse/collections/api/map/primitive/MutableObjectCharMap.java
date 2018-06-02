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

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectCharPredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectCharPair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectCharMap<K> extends ObjectCharMap<K>
{
    @Override
    MutableCharIterator charIterator();

    void clear();

    void put(K key, char value);

    /**
     * This method allows MutableObjectCharMap the ability to add an element in the form of ObjectCharPair<K>.
     *
     * @see #put(Object, char)
     * @since 9.1.0
     */
    default void putPair(ObjectCharPair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectCharMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    char removeKeyIfAbsent(K key, char value);

    char getIfAbsentPut(K key, char value);

    char getIfAbsentPut(K key, CharFunction0 function);

    char getIfAbsentPutWithKey(K key, CharFunction<? super K> function);

    <P> char getIfAbsentPutWith(K key, CharFunction<? super P> function, P parameter);

    char updateValue(K key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectCharMap<K> select(ObjectCharPredicate<? super K> predicate);

    @Override
    MutableObjectCharMap<K> reject(ObjectCharPredicate<? super K> predicate);

    @Override
    MutableCharCollection select(CharPredicate predicate);

    @Override
    MutableCharCollection reject(CharPredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectCharMap<K> tap(CharProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(CharToObjectFunction<? extends V> function);

    MutableObjectCharMap<K> withKeyValue(K key, char value);

    MutableObjectCharMap<K> withoutKey(K key);

    MutableObjectCharMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectCharMap<K> asUnmodifiable();

    MutableObjectCharMap<K> asSynchronized();

    char addToValue(K key, char toBeAdded);
}
