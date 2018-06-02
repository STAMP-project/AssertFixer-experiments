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
import org.eclipse.collections.api.block.function.primitive.IntToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntCharPredicate;
import org.eclipse.collections.api.tuple.primitive.IntCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntCharMap extends IntCharMap, MutableCharValuesMap
{
    void put(int key, char value);

   /**
     * This method allows MutableIntCharMap the ability to add an element in the form of IntCharPair.
     *
     * @see #put(int, char)
     * @since 9.1.0
     */
    default void putPair(IntCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntCharMap map);

    void removeKey(int key);

    void remove(int key);

    char removeKeyIfAbsent(int key, char value);

    char getIfAbsentPut(int key, char value);

    char getIfAbsentPut(int key, CharFunction0 function);

    char getIfAbsentPutWithKey(int key, IntToCharFunction function);

    <P> char getIfAbsentPutWith(int key, CharFunction<? super P> function, P parameter);

    char updateValue(int key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharIntMap flipUniqueValues();

    @Override
    MutableIntCharMap select(IntCharPredicate predicate);

    @Override
    MutableIntCharMap reject(IntCharPredicate predicate);

    MutableIntCharMap withKeyValue(int key, char value);

    MutableIntCharMap withoutKey(int key);

    MutableIntCharMap withoutAllKeys(IntIterable keys);

    MutableIntCharMap asUnmodifiable();

    MutableIntCharMap asSynchronized();

    char addToValue(int key, char toBeAdded);
}
