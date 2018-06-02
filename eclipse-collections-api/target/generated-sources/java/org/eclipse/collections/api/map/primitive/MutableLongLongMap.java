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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongLongPredicate;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongLongMap extends LongLongMap, MutableLongValuesMap
{
    void put(long key, long value);

   /**
     * This method allows MutableLongLongMap the ability to add an element in the form of LongLongPair.
     *
     * @see #put(long, long)
     * @since 9.1.0
     */
    default void putPair(LongLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongLongMap map);

    void removeKey(long key);

    void remove(long key);

    long removeKeyIfAbsent(long key, long value);

    long getIfAbsentPut(long key, long value);

    long getIfAbsentPut(long key, LongFunction0 function);

    long getIfAbsentPutWithKey(long key, LongToLongFunction function);

    <P> long getIfAbsentPutWith(long key, LongFunction<? super P> function, P parameter);

    long updateValue(long key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongLongMap flipUniqueValues();

    @Override
    MutableLongLongMap select(LongLongPredicate predicate);

    @Override
    MutableLongLongMap reject(LongLongPredicate predicate);

    MutableLongLongMap withKeyValue(long key, long value);

    MutableLongLongMap withoutKey(long key);

    MutableLongLongMap withoutAllKeys(LongIterable keys);

    MutableLongLongMap asUnmodifiable();

    MutableLongLongMap asSynchronized();

    long addToValue(long key, long toBeAdded);
}
