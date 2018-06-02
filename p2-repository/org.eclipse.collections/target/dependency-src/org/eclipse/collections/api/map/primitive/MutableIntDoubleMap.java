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
import org.eclipse.collections.api.block.function.primitive.IntToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.IntDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntDoubleMap extends IntDoubleMap, MutableDoubleValuesMap
{
    void put(int key, double value);

   /**
     * This method allows MutableIntDoubleMap the ability to add an element in the form of IntDoublePair.
     *
     * @see #put(int, double)
     * @since 9.1.0
     */
    default void putPair(IntDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntDoubleMap map);

    void removeKey(int key);

    void remove(int key);

    double removeKeyIfAbsent(int key, double value);

    double getIfAbsentPut(int key, double value);

    double getIfAbsentPut(int key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(int key, IntToDoubleFunction function);

    <P> double getIfAbsentPutWith(int key, DoubleFunction<? super P> function, P parameter);

    double updateValue(int key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleIntMap flipUniqueValues();

    @Override
    MutableIntDoubleMap select(IntDoublePredicate predicate);

    @Override
    MutableIntDoubleMap reject(IntDoublePredicate predicate);

    MutableIntDoubleMap withKeyValue(int key, double value);

    MutableIntDoubleMap withoutKey(int key);

    MutableIntDoubleMap withoutAllKeys(IntIterable keys);

    MutableIntDoubleMap asUnmodifiable();

    MutableIntDoubleMap asSynchronized();

    double addToValue(int key, double toBeAdded);
}
