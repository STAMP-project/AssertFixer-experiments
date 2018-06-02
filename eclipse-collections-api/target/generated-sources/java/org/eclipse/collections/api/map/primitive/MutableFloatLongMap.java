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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.block.function.primitive.FloatToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatLongPredicate;
import org.eclipse.collections.api.tuple.primitive.FloatLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatLongMap extends FloatLongMap, MutableLongValuesMap
{
    void put(float key, long value);

   /**
     * This method allows MutableFloatLongMap the ability to add an element in the form of FloatLongPair.
     *
     * @see #put(float, long)
     * @since 9.1.0
     */
    default void putPair(FloatLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatLongMap map);

    void removeKey(float key);

    void remove(float key);

    long removeKeyIfAbsent(float key, long value);

    long getIfAbsentPut(float key, long value);

    long getIfAbsentPut(float key, LongFunction0 function);

    long getIfAbsentPutWithKey(float key, FloatToLongFunction function);

    <P> long getIfAbsentPutWith(float key, LongFunction<? super P> function, P parameter);

    long updateValue(float key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongFloatMap flipUniqueValues();

    @Override
    MutableFloatLongMap select(FloatLongPredicate predicate);

    @Override
    MutableFloatLongMap reject(FloatLongPredicate predicate);

    MutableFloatLongMap withKeyValue(float key, long value);

    MutableFloatLongMap withoutKey(float key);

    MutableFloatLongMap withoutAllKeys(FloatIterable keys);

    MutableFloatLongMap asUnmodifiable();

    MutableFloatLongMap asSynchronized();

    long addToValue(float key, long toBeAdded);
}
