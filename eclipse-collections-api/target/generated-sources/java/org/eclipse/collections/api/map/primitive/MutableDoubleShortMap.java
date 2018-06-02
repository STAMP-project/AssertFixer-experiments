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
import org.eclipse.collections.api.block.function.primitive.DoubleToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleShortPredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleShortMap extends DoubleShortMap, MutableShortValuesMap
{
    void put(double key, short value);

   /**
     * This method allows MutableDoubleShortMap the ability to add an element in the form of DoubleShortPair.
     *
     * @see #put(double, short)
     * @since 9.1.0
     */
    default void putPair(DoubleShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleShortMap map);

    void removeKey(double key);

    void remove(double key);

    short removeKeyIfAbsent(double key, short value);

    short getIfAbsentPut(double key, short value);

    short getIfAbsentPut(double key, ShortFunction0 function);

    short getIfAbsentPutWithKey(double key, DoubleToShortFunction function);

    <P> short getIfAbsentPutWith(double key, ShortFunction<? super P> function, P parameter);

    short updateValue(double key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortDoubleMap flipUniqueValues();

    @Override
    MutableDoubleShortMap select(DoubleShortPredicate predicate);

    @Override
    MutableDoubleShortMap reject(DoubleShortPredicate predicate);

    MutableDoubleShortMap withKeyValue(double key, short value);

    MutableDoubleShortMap withoutKey(double key);

    MutableDoubleShortMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleShortMap asUnmodifiable();

    MutableDoubleShortMap asSynchronized();

    short addToValue(double key, short toBeAdded);
}
