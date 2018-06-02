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
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntShortPredicate;
import org.eclipse.collections.api.tuple.primitive.IntShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntShortMap extends IntShortMap, MutableShortValuesMap
{
    void put(int key, short value);

   /**
     * This method allows MutableIntShortMap the ability to add an element in the form of IntShortPair.
     *
     * @see #put(int, short)
     * @since 9.1.0
     */
    default void putPair(IntShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntShortMap map);

    void removeKey(int key);

    void remove(int key);

    short removeKeyIfAbsent(int key, short value);

    short getIfAbsentPut(int key, short value);

    short getIfAbsentPut(int key, ShortFunction0 function);

    short getIfAbsentPutWithKey(int key, IntToShortFunction function);

    <P> short getIfAbsentPutWith(int key, ShortFunction<? super P> function, P parameter);

    short updateValue(int key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortIntMap flipUniqueValues();

    @Override
    MutableIntShortMap select(IntShortPredicate predicate);

    @Override
    MutableIntShortMap reject(IntShortPredicate predicate);

    MutableIntShortMap withKeyValue(int key, short value);

    MutableIntShortMap withoutKey(int key);

    MutableIntShortMap withoutAllKeys(IntIterable keys);

    MutableIntShortMap asUnmodifiable();

    MutableIntShortMap asSynchronized();

    short addToValue(int key, short toBeAdded);
}
