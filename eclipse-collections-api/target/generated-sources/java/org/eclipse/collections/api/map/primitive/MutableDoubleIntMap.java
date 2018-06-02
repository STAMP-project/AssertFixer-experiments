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
import org.eclipse.collections.api.block.function.primitive.DoubleToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleIntPredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleIntMap extends DoubleIntMap, MutableIntValuesMap
{
    void put(double key, int value);

   /**
     * This method allows MutableDoubleIntMap the ability to add an element in the form of DoubleIntPair.
     *
     * @see #put(double, int)
     * @since 9.1.0
     */
    default void putPair(DoubleIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleIntMap map);

    void removeKey(double key);

    void remove(double key);

    int removeKeyIfAbsent(double key, int value);

    int getIfAbsentPut(double key, int value);

    int getIfAbsentPut(double key, IntFunction0 function);

    int getIfAbsentPutWithKey(double key, DoubleToIntFunction function);

    <P> int getIfAbsentPutWith(double key, IntFunction<? super P> function, P parameter);

    int updateValue(double key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntDoubleMap flipUniqueValues();

    @Override
    MutableDoubleIntMap select(DoubleIntPredicate predicate);

    @Override
    MutableDoubleIntMap reject(DoubleIntPredicate predicate);

    MutableDoubleIntMap withKeyValue(double key, int value);

    MutableDoubleIntMap withoutKey(double key);

    MutableDoubleIntMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleIntMap asUnmodifiable();

    MutableDoubleIntMap asSynchronized();

    int addToValue(double key, int toBeAdded);
}
