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
import org.eclipse.collections.api.block.function.primitive.CharToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharIntPredicate;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharIntMap extends CharIntMap, MutableIntValuesMap
{
    void put(char key, int value);

   /**
     * This method allows MutableCharIntMap the ability to add an element in the form of CharIntPair.
     *
     * @see #put(char, int)
     * @since 9.1.0
     */
    default void putPair(CharIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharIntMap map);

    void removeKey(char key);

    void remove(char key);

    int removeKeyIfAbsent(char key, int value);

    int getIfAbsentPut(char key, int value);

    int getIfAbsentPut(char key, IntFunction0 function);

    int getIfAbsentPutWithKey(char key, CharToIntFunction function);

    <P> int getIfAbsentPutWith(char key, IntFunction<? super P> function, P parameter);

    int updateValue(char key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntCharMap flipUniqueValues();

    @Override
    MutableCharIntMap select(CharIntPredicate predicate);

    @Override
    MutableCharIntMap reject(CharIntPredicate predicate);

    MutableCharIntMap withKeyValue(char key, int value);

    MutableCharIntMap withoutKey(char key);

    MutableCharIntMap withoutAllKeys(CharIterable keys);

    MutableCharIntMap asUnmodifiable();

    MutableCharIntMap asSynchronized();

    int addToValue(char key, int toBeAdded);
}
