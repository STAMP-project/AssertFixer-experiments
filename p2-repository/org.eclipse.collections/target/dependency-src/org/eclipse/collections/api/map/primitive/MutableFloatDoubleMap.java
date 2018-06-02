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
import org.eclipse.collections.api.block.function.primitive.FloatToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatDoubleMap extends FloatDoubleMap, MutableDoubleValuesMap
{
    void put(float key, double value);

   /**
     * This method allows MutableFloatDoubleMap the ability to add an element in the form of FloatDoublePair.
     *
     * @see #put(float, double)
     * @since 9.1.0
     */
    default void putPair(FloatDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatDoubleMap map);

    void removeKey(float key);

    void remove(float key);

    double removeKeyIfAbsent(float key, double value);

    double getIfAbsentPut(float key, double value);

    double getIfAbsentPut(float key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(float key, FloatToDoubleFunction function);

    <P> double getIfAbsentPutWith(float key, DoubleFunction<? super P> function, P parameter);

    double updateValue(float key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleFloatMap flipUniqueValues();

    @Override
    MutableFloatDoubleMap select(FloatDoublePredicate predicate);

    @Override
    MutableFloatDoubleMap reject(FloatDoublePredicate predicate);

    MutableFloatDoubleMap withKeyValue(float key, double value);

    MutableFloatDoubleMap withoutKey(float key);

    MutableFloatDoubleMap withoutAllKeys(FloatIterable keys);

    MutableFloatDoubleMap asUnmodifiable();

    MutableFloatDoubleMap asSynchronized();

    double addToValue(float key, double toBeAdded);
}
