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
import org.eclipse.collections.api.block.function.primitive.IntToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.IntFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntFloatMap extends IntFloatMap, MutableFloatValuesMap
{
    void put(int key, float value);

   /**
     * This method allows MutableIntFloatMap the ability to add an element in the form of IntFloatPair.
     *
     * @see #put(int, float)
     * @since 9.1.0
     */
    default void putPair(IntFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntFloatMap map);

    void removeKey(int key);

    void remove(int key);

    float removeKeyIfAbsent(int key, float value);

    float getIfAbsentPut(int key, float value);

    float getIfAbsentPut(int key, FloatFunction0 function);

    float getIfAbsentPutWithKey(int key, IntToFloatFunction function);

    <P> float getIfAbsentPutWith(int key, FloatFunction<? super P> function, P parameter);

    float updateValue(int key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatIntMap flipUniqueValues();

    @Override
    MutableIntFloatMap select(IntFloatPredicate predicate);

    @Override
    MutableIntFloatMap reject(IntFloatPredicate predicate);

    MutableIntFloatMap withKeyValue(int key, float value);

    MutableIntFloatMap withoutKey(int key);

    MutableIntFloatMap withoutAllKeys(IntIterable keys);

    MutableIntFloatMap asUnmodifiable();

    MutableIntFloatMap asSynchronized();

    float addToValue(int key, float toBeAdded);
}
