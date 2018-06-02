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
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteBytePredicate;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteByteMap extends ByteByteMap, MutableByteValuesMap
{
    void put(byte key, byte value);

   /**
     * This method allows MutableByteByteMap the ability to add an element in the form of ByteBytePair.
     *
     * @see #put(byte, byte)
     * @since 9.1.0
     */
    default void putPair(ByteBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteByteMap map);

    void removeKey(byte key);

    void remove(byte key);

    byte removeKeyIfAbsent(byte key, byte value);

    byte getIfAbsentPut(byte key, byte value);

    byte getIfAbsentPut(byte key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(byte key, ByteToByteFunction function);

    <P> byte getIfAbsentPutWith(byte key, ByteFunction<? super P> function, P parameter);

    byte updateValue(byte key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteByteMap flipUniqueValues();

    @Override
    MutableByteByteMap select(ByteBytePredicate predicate);

    @Override
    MutableByteByteMap reject(ByteBytePredicate predicate);

    MutableByteByteMap withKeyValue(byte key, byte value);

    MutableByteByteMap withoutKey(byte key);

    MutableByteByteMap withoutAllKeys(ByteIterable keys);

    MutableByteByteMap asUnmodifiable();

    MutableByteByteMap asSynchronized();

    byte addToValue(byte key, byte toBeAdded);
}
