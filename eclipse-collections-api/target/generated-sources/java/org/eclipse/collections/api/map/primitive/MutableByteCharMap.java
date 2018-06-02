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
import org.eclipse.collections.api.block.function.primitive.ByteToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteCharPredicate;
import org.eclipse.collections.api.tuple.primitive.ByteCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteCharMap extends ByteCharMap, MutableCharValuesMap
{
    void put(byte key, char value);

   /**
     * This method allows MutableByteCharMap the ability to add an element in the form of ByteCharPair.
     *
     * @see #put(byte, char)
     * @since 9.1.0
     */
    default void putPair(ByteCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteCharMap map);

    void removeKey(byte key);

    void remove(byte key);

    char removeKeyIfAbsent(byte key, char value);

    char getIfAbsentPut(byte key, char value);

    char getIfAbsentPut(byte key, CharFunction0 function);

    char getIfAbsentPutWithKey(byte key, ByteToCharFunction function);

    <P> char getIfAbsentPutWith(byte key, CharFunction<? super P> function, P parameter);

    char updateValue(byte key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharByteMap flipUniqueValues();

    @Override
    MutableByteCharMap select(ByteCharPredicate predicate);

    @Override
    MutableByteCharMap reject(ByteCharPredicate predicate);

    MutableByteCharMap withKeyValue(byte key, char value);

    MutableByteCharMap withoutKey(byte key);

    MutableByteCharMap withoutAllKeys(ByteIterable keys);

    MutableByteCharMap asUnmodifiable();

    MutableByteCharMap asSynchronized();

    char addToValue(byte key, char toBeAdded);
}
