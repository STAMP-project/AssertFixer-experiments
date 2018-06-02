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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortBytePredicate;
import org.eclipse.collections.api.tuple.primitive.ShortBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortByteMap extends ShortByteMap, MutableByteValuesMap
{
    void put(short key, byte value);

   /**
     * This method allows MutableShortByteMap the ability to add an element in the form of ShortBytePair.
     *
     * @see #put(short, byte)
     * @since 9.1.0
     */
    default void putPair(ShortBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortByteMap map);

    void removeKey(short key);

    void remove(short key);

    byte removeKeyIfAbsent(short key, byte value);

    byte getIfAbsentPut(short key, byte value);

    byte getIfAbsentPut(short key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(short key, ShortToByteFunction function);

    <P> byte getIfAbsentPutWith(short key, ByteFunction<? super P> function, P parameter);

    byte updateValue(short key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteShortMap flipUniqueValues();

    @Override
    MutableShortByteMap select(ShortBytePredicate predicate);

    @Override
    MutableShortByteMap reject(ShortBytePredicate predicate);

    MutableShortByteMap withKeyValue(short key, byte value);

    MutableShortByteMap withoutKey(short key);

    MutableShortByteMap withoutAllKeys(ShortIterable keys);

    MutableShortByteMap asUnmodifiable();

    MutableShortByteMap asSynchronized();

    byte addToValue(short key, byte toBeAdded);
}
