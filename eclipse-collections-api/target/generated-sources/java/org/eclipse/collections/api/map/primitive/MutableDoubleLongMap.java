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
import org.eclipse.collections.api.block.function.primitive.DoubleToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleLongPredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleLongMap extends DoubleLongMap, MutableLongValuesMap
{
    void put(double key, long value);

   /**
     * This method allows MutableDoubleLongMap the ability to add an element in the form of DoubleLongPair.
     *
     * @see #put(double, long)
     * @since 9.1.0
     */
    default void putPair(DoubleLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleLongMap map);

    void removeKey(double key);

    void remove(double key);

    long removeKeyIfAbsent(double key, long value);

    long getIfAbsentPut(double key, long value);

    long getIfAbsentPut(double key, LongFunction0 function);

    long getIfAbsentPutWithKey(double key, DoubleToLongFunction function);

    <P> long getIfAbsentPutWith(double key, LongFunction<? super P> function, P parameter);

    long updateValue(double key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongDoubleMap flipUniqueValues();

    @Override
    MutableDoubleLongMap select(DoubleLongPredicate predicate);

    @Override
    MutableDoubleLongMap reject(DoubleLongPredicate predicate);

    MutableDoubleLongMap withKeyValue(double key, long value);

    MutableDoubleLongMap withoutKey(double key);

    MutableDoubleLongMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleLongMap asUnmodifiable();

    MutableDoubleLongMap asSynchronized();

    long addToValue(double key, long toBeAdded);
}
