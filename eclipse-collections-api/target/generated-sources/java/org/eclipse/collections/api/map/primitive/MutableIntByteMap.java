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
import org.eclipse.collections.api.block.function.primitive.IntToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntBytePredicate;
import org.eclipse.collections.api.tuple.primitive.IntBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntByteMap extends IntByteMap, MutableByteValuesMap
{
    void put(int key, byte value);

   /**
     * This method allows MutableIntByteMap the ability to add an element in the form of IntBytePair.
     *
     * @see #put(int, byte)
     * @since 9.1.0
     */
    default void putPair(IntBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntByteMap map);

    void removeKey(int key);

    void remove(int key);

    byte removeKeyIfAbsent(int key, byte value);

    byte getIfAbsentPut(int key, byte value);

    byte getIfAbsentPut(int key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(int key, IntToByteFunction function);

    <P> byte getIfAbsentPutWith(int key, ByteFunction<? super P> function, P parameter);

    byte updateValue(int key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteIntMap flipUniqueValues();

    @Override
    MutableIntByteMap select(IntBytePredicate predicate);

    @Override
    MutableIntByteMap reject(IntBytePredicate predicate);

    MutableIntByteMap withKeyValue(int key, byte value);

    MutableIntByteMap withoutKey(int key);

    MutableIntByteMap withoutAllKeys(IntIterable keys);

    MutableIntByteMap asUnmodifiable();

    MutableIntByteMap asSynchronized();

    byte addToValue(int key, byte toBeAdded);
}
