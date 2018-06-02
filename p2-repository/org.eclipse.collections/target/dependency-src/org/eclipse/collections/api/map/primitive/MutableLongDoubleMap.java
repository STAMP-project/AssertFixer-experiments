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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.function.primitive.LongToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.LongDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongDoubleMap extends LongDoubleMap, MutableDoubleValuesMap
{
    void put(long key, double value);

   /**
     * This method allows MutableLongDoubleMap the ability to add an element in the form of LongDoublePair.
     *
     * @see #put(long, double)
     * @since 9.1.0
     */
    default void putPair(LongDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongDoubleMap map);

    void removeKey(long key);

    void remove(long key);

    double removeKeyIfAbsent(long key, double value);

    double getIfAbsentPut(long key, double value);

    double getIfAbsentPut(long key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(long key, LongToDoubleFunction function);

    <P> double getIfAbsentPutWith(long key, DoubleFunction<? super P> function, P parameter);

    double updateValue(long key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleLongMap flipUniqueValues();

    @Override
    MutableLongDoubleMap select(LongDoublePredicate predicate);

    @Override
    MutableLongDoubleMap reject(LongDoublePredicate predicate);

    MutableLongDoubleMap withKeyValue(long key, double value);

    MutableLongDoubleMap withoutKey(long key);

    MutableLongDoubleMap withoutAllKeys(LongIterable keys);

    MutableLongDoubleMap asUnmodifiable();

    MutableLongDoubleMap asSynchronized();

    double addToValue(long key, double toBeAdded);
}
