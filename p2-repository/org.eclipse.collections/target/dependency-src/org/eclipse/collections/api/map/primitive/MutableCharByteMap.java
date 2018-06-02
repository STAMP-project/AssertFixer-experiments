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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharBytePredicate;
import org.eclipse.collections.api.tuple.primitive.CharBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharByteMap extends CharByteMap, MutableByteValuesMap
{
    void put(char key, byte value);

   /**
     * This method allows MutableCharByteMap the ability to add an element in the form of CharBytePair.
     *
     * @see #put(char, byte)
     * @since 9.1.0
     */
    default void putPair(CharBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharByteMap map);

    void removeKey(char key);

    void remove(char key);

    byte removeKeyIfAbsent(char key, byte value);

    byte getIfAbsentPut(char key, byte value);

    byte getIfAbsentPut(char key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(char key, CharToByteFunction function);

    <P> byte getIfAbsentPutWith(char key, ByteFunction<? super P> function, P parameter);

    byte updateValue(char key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteCharMap flipUniqueValues();

    @Override
    MutableCharByteMap select(CharBytePredicate predicate);

    @Override
    MutableCharByteMap reject(CharBytePredicate predicate);

    MutableCharByteMap withKeyValue(char key, byte value);

    MutableCharByteMap withoutKey(char key);

    MutableCharByteMap withoutAllKeys(CharIterable keys);

    MutableCharByteMap asUnmodifiable();

    MutableCharByteMap asSynchronized();

    byte addToValue(char key, byte toBeAdded);
}
