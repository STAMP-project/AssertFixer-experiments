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
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatFloatMap extends FloatFloatMap, MutableFloatValuesMap
{
    void put(float key, float value);

   /**
     * This method allows MutableFloatFloatMap the ability to add an element in the form of FloatFloatPair.
     *
     * @see #put(float, float)
     * @since 9.1.0
     */
    default void putPair(FloatFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatFloatMap map);

    void removeKey(float key);

    void remove(float key);

    float removeKeyIfAbsent(float key, float value);

    float getIfAbsentPut(float key, float value);

    float getIfAbsentPut(float key, FloatFunction0 function);

    float getIfAbsentPutWithKey(float key, FloatToFloatFunction function);

    <P> float getIfAbsentPutWith(float key, FloatFunction<? super P> function, P parameter);

    float updateValue(float key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatFloatMap flipUniqueValues();

    @Override
    MutableFloatFloatMap select(FloatFloatPredicate predicate);

    @Override
    MutableFloatFloatMap reject(FloatFloatPredicate predicate);

    MutableFloatFloatMap withKeyValue(float key, float value);

    MutableFloatFloatMap withoutKey(float key);

    MutableFloatFloatMap withoutAllKeys(FloatIterable keys);

    MutableFloatFloatMap asUnmodifiable();

    MutableFloatFloatMap asSynchronized();

    float addToValue(float key, float toBeAdded);
}
