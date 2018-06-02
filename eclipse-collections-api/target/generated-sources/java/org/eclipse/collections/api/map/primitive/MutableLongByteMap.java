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
import org.eclipse.collections.api.block.function.primitive.LongToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongBytePredicate;
import org.eclipse.collections.api.tuple.primitive.LongBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongByteMap extends LongByteMap, MutableByteValuesMap
{
    void put(long key, byte value);

   /**
     * This method allows MutableLongByteMap the ability to add an element in the form of LongBytePair.
     *
     * @see #put(long, byte)
     * @since 9.1.0
     */
    default void putPair(LongBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongByteMap map);

    void removeKey(long key);

    void remove(long key);

    byte removeKeyIfAbsent(long key, byte value);

    byte getIfAbsentPut(long key, byte value);

    byte getIfAbsentPut(long key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(long key, LongToByteFunction function);

    <P> byte getIfAbsentPutWith(long key, ByteFunction<? super P> function, P parameter);

    byte updateValue(long key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteLongMap flipUniqueValues();

    @Override
    MutableLongByteMap select(LongBytePredicate predicate);

    @Override
    MutableLongByteMap reject(LongBytePredicate predicate);

    MutableLongByteMap withKeyValue(long key, byte value);

    MutableLongByteMap withoutKey(long key);

    MutableLongByteMap withoutAllKeys(LongIterable keys);

    MutableLongByteMap asUnmodifiable();

    MutableLongByteMap asSynchronized();

    byte addToValue(long key, byte toBeAdded);
}
