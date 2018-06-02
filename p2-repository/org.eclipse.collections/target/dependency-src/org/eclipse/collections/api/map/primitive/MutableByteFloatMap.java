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
import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.ByteFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteFloatMap extends ByteFloatMap, MutableFloatValuesMap
{
    void put(byte key, float value);

   /**
     * This method allows MutableByteFloatMap the ability to add an element in the form of ByteFloatPair.
     *
     * @see #put(byte, float)
     * @since 9.1.0
     */
    default void putPair(ByteFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteFloatMap map);

    void removeKey(byte key);

    void remove(byte key);

    float removeKeyIfAbsent(byte key, float value);

    float getIfAbsentPut(byte key, float value);

    float getIfAbsentPut(byte key, FloatFunction0 function);

    float getIfAbsentPutWithKey(byte key, ByteToFloatFunction function);

    <P> float getIfAbsentPutWith(byte key, FloatFunction<? super P> function, P parameter);

    float updateValue(byte key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatByteMap flipUniqueValues();

    @Override
    MutableByteFloatMap select(ByteFloatPredicate predicate);

    @Override
    MutableByteFloatMap reject(ByteFloatPredicate predicate);

    MutableByteFloatMap withKeyValue(byte key, float value);

    MutableByteFloatMap withoutKey(byte key);

    MutableByteFloatMap withoutAllKeys(ByteIterable keys);

    MutableByteFloatMap asUnmodifiable();

    MutableByteFloatMap asSynchronized();

    float addToValue(byte key, float toBeAdded);
}
