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
import org.eclipse.collections.api.block.function.primitive.ByteToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteIntPredicate;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteIntMap extends ByteIntMap, MutableIntValuesMap
{
    void put(byte key, int value);

   /**
     * This method allows MutableByteIntMap the ability to add an element in the form of ByteIntPair.
     *
     * @see #put(byte, int)
     * @since 9.1.0
     */
    default void putPair(ByteIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteIntMap map);

    void removeKey(byte key);

    void remove(byte key);

    int removeKeyIfAbsent(byte key, int value);

    int getIfAbsentPut(byte key, int value);

    int getIfAbsentPut(byte key, IntFunction0 function);

    int getIfAbsentPutWithKey(byte key, ByteToIntFunction function);

    <P> int getIfAbsentPutWith(byte key, IntFunction<? super P> function, P parameter);

    int updateValue(byte key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntByteMap flipUniqueValues();

    @Override
    MutableByteIntMap select(ByteIntPredicate predicate);

    @Override
    MutableByteIntMap reject(ByteIntPredicate predicate);

    MutableByteIntMap withKeyValue(byte key, int value);

    MutableByteIntMap withoutKey(byte key);

    MutableByteIntMap withoutAllKeys(ByteIterable keys);

    MutableByteIntMap asUnmodifiable();

    MutableByteIntMap asSynchronized();

    int addToValue(byte key, int toBeAdded);
}
