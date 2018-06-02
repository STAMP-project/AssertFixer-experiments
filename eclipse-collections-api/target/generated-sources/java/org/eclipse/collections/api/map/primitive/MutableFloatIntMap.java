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
import org.eclipse.collections.api.block.function.primitive.FloatToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatIntPredicate;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatIntMap extends FloatIntMap, MutableIntValuesMap
{
    void put(float key, int value);

   /**
     * This method allows MutableFloatIntMap the ability to add an element in the form of FloatIntPair.
     *
     * @see #put(float, int)
     * @since 9.1.0
     */
    default void putPair(FloatIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatIntMap map);

    void removeKey(float key);

    void remove(float key);

    int removeKeyIfAbsent(float key, int value);

    int getIfAbsentPut(float key, int value);

    int getIfAbsentPut(float key, IntFunction0 function);

    int getIfAbsentPutWithKey(float key, FloatToIntFunction function);

    <P> int getIfAbsentPutWith(float key, IntFunction<? super P> function, P parameter);

    int updateValue(float key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntFloatMap flipUniqueValues();

    @Override
    MutableFloatIntMap select(FloatIntPredicate predicate);

    @Override
    MutableFloatIntMap reject(FloatIntPredicate predicate);

    MutableFloatIntMap withKeyValue(float key, int value);

    MutableFloatIntMap withoutKey(float key);

    MutableFloatIntMap withoutAllKeys(FloatIterable keys);

    MutableFloatIntMap asUnmodifiable();

    MutableFloatIntMap asSynchronized();

    int addToValue(float key, int toBeAdded);
}
