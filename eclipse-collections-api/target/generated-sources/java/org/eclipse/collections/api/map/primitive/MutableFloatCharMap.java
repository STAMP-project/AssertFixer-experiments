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
import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatCharPredicate;
import org.eclipse.collections.api.tuple.primitive.FloatCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatCharMap extends FloatCharMap, MutableCharValuesMap
{
    void put(float key, char value);

   /**
     * This method allows MutableFloatCharMap the ability to add an element in the form of FloatCharPair.
     *
     * @see #put(float, char)
     * @since 9.1.0
     */
    default void putPair(FloatCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatCharMap map);

    void removeKey(float key);

    void remove(float key);

    char removeKeyIfAbsent(float key, char value);

    char getIfAbsentPut(float key, char value);

    char getIfAbsentPut(float key, CharFunction0 function);

    char getIfAbsentPutWithKey(float key, FloatToCharFunction function);

    <P> char getIfAbsentPutWith(float key, CharFunction<? super P> function, P parameter);

    char updateValue(float key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharFloatMap flipUniqueValues();

    @Override
    MutableFloatCharMap select(FloatCharPredicate predicate);

    @Override
    MutableFloatCharMap reject(FloatCharPredicate predicate);

    MutableFloatCharMap withKeyValue(float key, char value);

    MutableFloatCharMap withoutKey(float key);

    MutableFloatCharMap withoutAllKeys(FloatIterable keys);

    MutableFloatCharMap asUnmodifiable();

    MutableFloatCharMap asSynchronized();

    char addToValue(float key, char toBeAdded);
}
