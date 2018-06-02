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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.function.primitive.LongToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongIntPredicate;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongIntMap extends LongIntMap, MutableIntValuesMap
{
    void put(long key, int value);

   /**
     * This method allows MutableLongIntMap the ability to add an element in the form of LongIntPair.
     *
     * @see #put(long, int)
     * @since 9.1.0
     */
    default void putPair(LongIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongIntMap map);

    void removeKey(long key);

    void remove(long key);

    int removeKeyIfAbsent(long key, int value);

    int getIfAbsentPut(long key, int value);

    int getIfAbsentPut(long key, IntFunction0 function);

    int getIfAbsentPutWithKey(long key, LongToIntFunction function);

    <P> int getIfAbsentPutWith(long key, IntFunction<? super P> function, P parameter);

    int updateValue(long key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntLongMap flipUniqueValues();

    @Override
    MutableLongIntMap select(LongIntPredicate predicate);

    @Override
    MutableLongIntMap reject(LongIntPredicate predicate);

    MutableLongIntMap withKeyValue(long key, int value);

    MutableLongIntMap withoutKey(long key);

    MutableLongIntMap withoutAllKeys(LongIterable keys);

    MutableLongIntMap asUnmodifiable();

    MutableLongIntMap asSynchronized();

    int addToValue(long key, int toBeAdded);
}
