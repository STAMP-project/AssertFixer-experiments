/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.block.function.primitive.IntToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntLongPredicate;
import org.eclipse.collections.api.tuple.primitive.IntLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntLongMap extends IntLongMap, MutableLongValuesMap
{
    void put(int key, long value);

   /**
     * This method allows MutableIntLongMap the ability to add an element in the form of IntLongPair.
     *
     * @see #put(int, long)
     * @since 9.1.0
     */
    default void putPair(IntLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntLongMap map);

    void removeKey(int key);

    void remove(int key);

    long removeKeyIfAbsent(int key, long value);

    long getIfAbsentPut(int key, long value);

    long getIfAbsentPut(int key, LongFunction0 function);

    long getIfAbsentPutWithKey(int key, IntToLongFunction function);

    <P> long getIfAbsentPutWith(int key, LongFunction<? super P> function, P parameter);

    long updateValue(int key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongIntMap flipUniqueValues();

    @Override
    MutableIntLongMap select(IntLongPredicate predicate);

    @Override
    MutableIntLongMap reject(IntLongPredicate predicate);

    MutableIntLongMap withKeyValue(int key, long value);

    MutableIntLongMap withoutKey(int key);

    MutableIntLongMap withoutAllKeys(IntIterable keys);

    MutableIntLongMap asUnmodifiable();

    MutableIntLongMap asSynchronized();

    long addToValue(int key, long toBeAdded);
}
