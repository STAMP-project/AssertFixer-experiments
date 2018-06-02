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
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntIntPredicate;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntIntMap extends IntIntMap, MutableIntValuesMap
{
    void put(int key, int value);

   /**
     * This method allows MutableIntIntMap the ability to add an element in the form of IntIntPair.
     *
     * @see #put(int, int)
     * @since 9.1.0
     */
    default void putPair(IntIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntIntMap map);

    void removeKey(int key);

    void remove(int key);

    int removeKeyIfAbsent(int key, int value);

    int getIfAbsentPut(int key, int value);

    int getIfAbsentPut(int key, IntFunction0 function);

    int getIfAbsentPutWithKey(int key, IntToIntFunction function);

    <P> int getIfAbsentPutWith(int key, IntFunction<? super P> function, P parameter);

    int updateValue(int key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntIntMap flipUniqueValues();

    @Override
    MutableIntIntMap select(IntIntPredicate predicate);

    @Override
    MutableIntIntMap reject(IntIntPredicate predicate);

    MutableIntIntMap withKeyValue(int key, int value);

    MutableIntIntMap withoutKey(int key);

    MutableIntIntMap withoutAllKeys(IntIterable keys);

    MutableIntIntMap asUnmodifiable();

    MutableIntIntMap asSynchronized();

    int addToValue(int key, int toBeAdded);
}
