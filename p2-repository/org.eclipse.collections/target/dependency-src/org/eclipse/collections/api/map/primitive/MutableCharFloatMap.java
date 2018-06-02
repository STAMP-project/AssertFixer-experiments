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
import org.eclipse.collections.api.block.function.primitive.CharToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.CharFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharFloatMap extends CharFloatMap, MutableFloatValuesMap
{
    void put(char key, float value);

   /**
     * This method allows MutableCharFloatMap the ability to add an element in the form of CharFloatPair.
     *
     * @see #put(char, float)
     * @since 9.1.0
     */
    default void putPair(CharFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharFloatMap map);

    void removeKey(char key);

    void remove(char key);

    float removeKeyIfAbsent(char key, float value);

    float getIfAbsentPut(char key, float value);

    float getIfAbsentPut(char key, FloatFunction0 function);

    float getIfAbsentPutWithKey(char key, CharToFloatFunction function);

    <P> float getIfAbsentPutWith(char key, FloatFunction<? super P> function, P parameter);

    float updateValue(char key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatCharMap flipUniqueValues();

    @Override
    MutableCharFloatMap select(CharFloatPredicate predicate);

    @Override
    MutableCharFloatMap reject(CharFloatPredicate predicate);

    MutableCharFloatMap withKeyValue(char key, float value);

    MutableCharFloatMap withoutKey(char key);

    MutableCharFloatMap withoutAllKeys(CharIterable keys);

    MutableCharFloatMap asUnmodifiable();

    MutableCharFloatMap asSynchronized();

    float addToValue(char key, float toBeAdded);
}
