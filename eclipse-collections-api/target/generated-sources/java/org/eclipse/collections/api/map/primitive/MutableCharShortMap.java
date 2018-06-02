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
import org.eclipse.collections.api.block.function.primitive.CharToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharShortPredicate;
import org.eclipse.collections.api.tuple.primitive.CharShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharShortMap extends CharShortMap, MutableShortValuesMap
{
    void put(char key, short value);

   /**
     * This method allows MutableCharShortMap the ability to add an element in the form of CharShortPair.
     *
     * @see #put(char, short)
     * @since 9.1.0
     */
    default void putPair(CharShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharShortMap map);

    void removeKey(char key);

    void remove(char key);

    short removeKeyIfAbsent(char key, short value);

    short getIfAbsentPut(char key, short value);

    short getIfAbsentPut(char key, ShortFunction0 function);

    short getIfAbsentPutWithKey(char key, CharToShortFunction function);

    <P> short getIfAbsentPutWith(char key, ShortFunction<? super P> function, P parameter);

    short updateValue(char key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortCharMap flipUniqueValues();

    @Override
    MutableCharShortMap select(CharShortPredicate predicate);

    @Override
    MutableCharShortMap reject(CharShortPredicate predicate);

    MutableCharShortMap withKeyValue(char key, short value);

    MutableCharShortMap withoutKey(char key);

    MutableCharShortMap withoutAllKeys(CharIterable keys);

    MutableCharShortMap asUnmodifiable();

    MutableCharShortMap asSynchronized();

    short addToValue(char key, short toBeAdded);
}
