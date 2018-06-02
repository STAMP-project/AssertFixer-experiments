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
import org.eclipse.collections.api.block.function.primitive.ByteToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteShortPredicate;
import org.eclipse.collections.api.tuple.primitive.ByteShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteShortMap extends ByteShortMap, MutableShortValuesMap
{
    void put(byte key, short value);

   /**
     * This method allows MutableByteShortMap the ability to add an element in the form of ByteShortPair.
     *
     * @see #put(byte, short)
     * @since 9.1.0
     */
    default void putPair(ByteShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteShortMap map);

    void removeKey(byte key);

    void remove(byte key);

    short removeKeyIfAbsent(byte key, short value);

    short getIfAbsentPut(byte key, short value);

    short getIfAbsentPut(byte key, ShortFunction0 function);

    short getIfAbsentPutWithKey(byte key, ByteToShortFunction function);

    <P> short getIfAbsentPutWith(byte key, ShortFunction<? super P> function, P parameter);

    short updateValue(byte key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortByteMap flipUniqueValues();

    @Override
    MutableByteShortMap select(ByteShortPredicate predicate);

    @Override
    MutableByteShortMap reject(ByteShortPredicate predicate);

    MutableByteShortMap withKeyValue(byte key, short value);

    MutableByteShortMap withoutKey(byte key);

    MutableByteShortMap withoutAllKeys(ByteIterable keys);

    MutableByteShortMap asUnmodifiable();

    MutableByteShortMap asSynchronized();

    short addToValue(byte key, short toBeAdded);
}
