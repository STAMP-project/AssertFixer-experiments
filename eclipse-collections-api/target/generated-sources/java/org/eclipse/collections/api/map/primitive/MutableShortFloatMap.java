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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortFloatPredicate;
import org.eclipse.collections.api.tuple.primitive.ShortFloatPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortFloatMap extends ShortFloatMap, MutableFloatValuesMap
{
    void put(short key, float value);

   /**
     * This method allows MutableShortFloatMap the ability to add an element in the form of ShortFloatPair.
     *
     * @see #put(short, float)
     * @since 9.1.0
     */
    default void putPair(ShortFloatPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortFloatMap map);

    void removeKey(short key);

    void remove(short key);

    float removeKeyIfAbsent(short key, float value);

    float getIfAbsentPut(short key, float value);

    float getIfAbsentPut(short key, FloatFunction0 function);

    float getIfAbsentPutWithKey(short key, ShortToFloatFunction function);

    <P> float getIfAbsentPutWith(short key, FloatFunction<? super P> function, P parameter);

    float updateValue(short key, float initialValueIfAbsent, FloatToFloatFunction function);

    @Override
    MutableFloatShortMap flipUniqueValues();

    @Override
    MutableShortFloatMap select(ShortFloatPredicate predicate);

    @Override
    MutableShortFloatMap reject(ShortFloatPredicate predicate);

    MutableShortFloatMap withKeyValue(short key, float value);

    MutableShortFloatMap withoutKey(short key);

    MutableShortFloatMap withoutAllKeys(ShortIterable keys);

    MutableShortFloatMap asUnmodifiable();

    MutableShortFloatMap asSynchronized();

    float addToValue(short key, float toBeAdded);
}
