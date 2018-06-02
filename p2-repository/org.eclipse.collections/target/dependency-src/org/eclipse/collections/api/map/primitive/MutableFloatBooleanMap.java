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
import org.eclipse.collections.api.block.function.primitive.FloatToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.FloatBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatBooleanMap extends FloatBooleanMap, MutableBooleanValuesMap
{
    void put(float key, boolean value);

   /**
     * This method allows MutableFloatBooleanMap the ability to add an element in the form of FloatBooleanPair.
     *
     * @see #put(float, boolean)
     * @since 9.1.0
     */
    default void putPair(FloatBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(FloatBooleanMap map);

    void removeKey(float key);

    void remove(float key);

    boolean removeKeyIfAbsent(float key, boolean value);

    boolean getIfAbsentPut(float key, boolean value);

    boolean getIfAbsentPut(float key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(float key, FloatToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(float key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(float key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableFloatBooleanMap select(FloatBooleanPredicate predicate);

    @Override
    MutableFloatBooleanMap reject(FloatBooleanPredicate predicate);

    MutableFloatBooleanMap withKeyValue(float key, boolean value);

    MutableFloatBooleanMap withoutKey(float key);

    MutableFloatBooleanMap withoutAllKeys(FloatIterable keys);

    MutableFloatBooleanMap asUnmodifiable();

    MutableFloatBooleanMap asSynchronized();
}
