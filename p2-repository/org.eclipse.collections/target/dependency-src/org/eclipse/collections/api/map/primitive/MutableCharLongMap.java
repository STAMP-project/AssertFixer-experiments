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
import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharLongPredicate;
import org.eclipse.collections.api.tuple.primitive.CharLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharLongMap extends CharLongMap, MutableLongValuesMap
{
    void put(char key, long value);

   /**
     * This method allows MutableCharLongMap the ability to add an element in the form of CharLongPair.
     *
     * @see #put(char, long)
     * @since 9.1.0
     */
    default void putPair(CharLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharLongMap map);

    void removeKey(char key);

    void remove(char key);

    long removeKeyIfAbsent(char key, long value);

    long getIfAbsentPut(char key, long value);

    long getIfAbsentPut(char key, LongFunction0 function);

    long getIfAbsentPutWithKey(char key, CharToLongFunction function);

    <P> long getIfAbsentPutWith(char key, LongFunction<? super P> function, P parameter);

    long updateValue(char key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongCharMap flipUniqueValues();

    @Override
    MutableCharLongMap select(CharLongPredicate predicate);

    @Override
    MutableCharLongMap reject(CharLongPredicate predicate);

    MutableCharLongMap withKeyValue(char key, long value);

    MutableCharLongMap withoutKey(char key);

    MutableCharLongMap withoutAllKeys(CharIterable keys);

    MutableCharLongMap asUnmodifiable();

    MutableCharLongMap asSynchronized();

    long addToValue(char key, long toBeAdded);
}
