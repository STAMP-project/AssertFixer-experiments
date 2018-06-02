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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.block.function.primitive.DoubleToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleFloatMap extends DoubleFloatMap, MutableFloatValuesMap
{
    void put(double key, float value);

   /**
     * This method allows MutableDoubleFloatMap the ability to add an element in the form of DoubleFloatPair.
     *
     * @see #put(double, float)
     * @since 9.1.0
     */
    default void putPair(DoubleFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleFloatMap map);

    void removeKey(double key);

    void remove(double key);

    float removeKeyIfAbsent(double key, float value);

    float getIfAbsentPut(double key, float value);

    float getIfAbsentPut(double key, FloatFunction0 function);

    float getIfAbsentPutWithKey(double key, DoubleToFloatFunction function);

    <P> float getIfAbsentPutWith(double key, FloatFunction<? super P> function, P parameter);

    float updateValue(double key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatDoubleMap flipUniqueValues();

    @Override
    MutableDoubleFloatMap select(DoubleFloatPredicate predicate);

    @Override
    MutableDoubleFloatMap reject(DoubleFloatPredicate predicate);

    MutableDoubleFloatMap withKeyValue(double key, float value);

    MutableDoubleFloatMap withoutKey(double key);

    MutableDoubleFloatMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleFloatMap asUnmodifiable();

    MutableDoubleFloatMap asSynchronized();

    float addToValue(double key, float toBeAdded);
}
