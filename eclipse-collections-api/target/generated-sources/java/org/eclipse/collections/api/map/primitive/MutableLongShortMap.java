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
import org.eclipse.collections.api.block.function.primitive.LongToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongShortPredicate;
import org.eclipse.collections.api.tuple.primitive.LongShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongShortMap extends LongShortMap, MutableShortValuesMap
{
    void put(long key, short value);

   /**
     * This method allows MutableLongShortMap the ability to add an element in the form of LongShortPair.
     *
     * @see #put(long, short)
     * @since 9.1.0
     */
    default void putPair(LongShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongShortMap map);

    void removeKey(long key);

    void remove(long key);

    short removeKeyIfAbsent(long key, short value);

    short getIfAbsentPut(long key, short value);

    short getIfAbsentPut(long key, ShortFunction0 function);

    short getIfAbsentPutWithKey(long key, LongToShortFunction function);

    <P> short getIfAbsentPutWith(long key, ShortFunction<? super P> function, P parameter);

    short updateValue(long key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortLongMap flipUniqueValues();

    @Override
    MutableLongShortMap select(LongShortPredicate predicate);

    @Override
    MutableLongShortMap reject(LongShortPredicate predicate);

    MutableLongShortMap withKeyValue(long key, short value);

    MutableLongShortMap withoutKey(long key);

    MutableLongShortMap withoutAllKeys(LongIterable keys);

    MutableLongShortMap asUnmodifiable();

    MutableLongShortMap asSynchronized();

    short addToValue(long key, short toBeAdded);
}
