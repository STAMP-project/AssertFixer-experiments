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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.block.function.primitive.FloatToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatBytePredicate;
import org.eclipse.collections.api.tuple.primitive.FloatBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatByteMap extends FloatByteMap, MutableByteValuesMap
{
    void put(float key, byte value);

   /**
     * This method allows MutableFloatByteMap the ability to add an element in the form of FloatBytePair.
     *
     * @see #put(float, byte)
     * @since 9.1.0
     */
    default void putPair(FloatBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatByteMap map);

    void removeKey(float key);

    void remove(float key);

    byte removeKeyIfAbsent(float key, byte value);

    byte getIfAbsentPut(float key, byte value);

    byte getIfAbsentPut(float key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(float key, FloatToByteFunction function);

    <P> byte getIfAbsentPutWith(float key, ByteFunction<? super P> function, P parameter);

    byte updateValue(float key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteFloatMap flipUniqueValues();

    @Override
    MutableFloatByteMap select(FloatBytePredicate predicate);

    @Override
    MutableFloatByteMap reject(FloatBytePredicate predicate);

    MutableFloatByteMap withKeyValue(float key, byte value);

    MutableFloatByteMap withoutKey(float key);

    MutableFloatByteMap withoutAllKeys(FloatIterable keys);

    MutableFloatByteMap asUnmodifiable();

    MutableFloatByteMap asSynchronized();

    byte addToValue(float key, byte toBeAdded);
}
