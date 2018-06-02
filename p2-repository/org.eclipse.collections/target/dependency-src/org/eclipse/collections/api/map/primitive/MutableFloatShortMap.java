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
import org.eclipse.collections.api.block.function.primitive.FloatToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatShortPredicate;
import org.eclipse.collections.api.tuple.primitive.FloatShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatShortMap extends FloatShortMap, MutableShortValuesMap
{
    void put(float key, short value);

   /**
     * This method allows MutableFloatShortMap the ability to add an element in the form of FloatShortPair.
     *
     * @see #put(float, short)
     * @since 9.1.0
     */
    default void putPair(FloatShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatShortMap map);

    void removeKey(float key);

    void remove(float key);

    short removeKeyIfAbsent(float key, short value);

    short getIfAbsentPut(float key, short value);

    short getIfAbsentPut(float key, ShortFunction0 function);

    short getIfAbsentPutWithKey(float key, FloatToShortFunction function);

    <P> short getIfAbsentPutWith(float key, ShortFunction<? super P> function, P parameter);

    short updateValue(float key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortFloatMap flipUniqueValues();

    @Override
    MutableFloatShortMap select(FloatShortPredicate predicate);

    @Override
    MutableFloatShortMap reject(FloatShortPredicate predicate);

    MutableFloatShortMap withKeyValue(float key, short value);

    MutableFloatShortMap withoutKey(float key);

    MutableFloatShortMap withoutAllKeys(FloatIterable keys);

    MutableFloatShortMap asUnmodifiable();

    MutableFloatShortMap asSynchronized();

    short addToValue(float key, short toBeAdded);
}
