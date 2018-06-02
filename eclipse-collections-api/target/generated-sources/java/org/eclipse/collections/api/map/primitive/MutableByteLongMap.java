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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.function.primitive.ByteToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteLongPredicate;
import org.eclipse.collections.api.tuple.primitive.ByteLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteLongMap extends ByteLongMap, MutableLongValuesMap
{
    void put(byte key, long value);

   /**
     * This method allows MutableByteLongMap the ability to add an element in the form of ByteLongPair.
     *
     * @see #put(byte, long)
     * @since 9.1.0
     */
    default void putPair(ByteLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteLongMap map);

    void removeKey(byte key);

    void remove(byte key);

    long removeKeyIfAbsent(byte key, long value);

    long getIfAbsentPut(byte key, long value);

    long getIfAbsentPut(byte key, LongFunction0 function);

    long getIfAbsentPutWithKey(byte key, ByteToLongFunction function);

    <P> long getIfAbsentPutWith(byte key, LongFunction<? super P> function, P parameter);

    long updateValue(byte key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongByteMap flipUniqueValues();

    @Override
    MutableByteLongMap select(ByteLongPredicate predicate);

    @Override
    MutableByteLongMap reject(ByteLongPredicate predicate);

    MutableByteLongMap withKeyValue(byte key, long value);

    MutableByteLongMap withoutKey(byte key);

    MutableByteLongMap withoutAllKeys(ByteIterable keys);

    MutableByteLongMap asUnmodifiable();

    MutableByteLongMap asSynchronized();

    long addToValue(byte key, long toBeAdded);
}
