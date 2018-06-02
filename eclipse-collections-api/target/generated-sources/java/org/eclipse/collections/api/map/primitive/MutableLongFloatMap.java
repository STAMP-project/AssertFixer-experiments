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
import org.eclipse.collections.api.block.function.primitive.LongToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.LongFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongFloatMap extends LongFloatMap, MutableFloatValuesMap
{
    void put(long key, float value);

   /**
     * This method allows MutableLongFloatMap the ability to add an element in the form of LongFloatPair.
     *
     * @see #put(long, float)
     * @since 9.1.0
     */
    default void putPair(LongFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongFloatMap map);

    void removeKey(long key);

    void remove(long key);

    float removeKeyIfAbsent(long key, float value);

    float getIfAbsentPut(long key, float value);

    float getIfAbsentPut(long key, FloatFunction0 function);

    float getIfAbsentPutWithKey(long key, LongToFloatFunction function);

    <P> float getIfAbsentPutWith(long key, FloatFunction<? super P> function, P parameter);

    float updateValue(long key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatLongMap flipUniqueValues();

    @Override
    MutableLongFloatMap select(LongFloatPredicate predicate);

    @Override
    MutableLongFloatMap reject(LongFloatPredicate predicate);

    MutableLongFloatMap withKeyValue(long key, float value);

    MutableLongFloatMap withoutKey(long key);

    MutableLongFloatMap withoutAllKeys(LongIterable keys);

    MutableLongFloatMap asUnmodifiable();

    MutableLongFloatMap asSynchronized();

    float addToValue(long key, float toBeAdded);
}
