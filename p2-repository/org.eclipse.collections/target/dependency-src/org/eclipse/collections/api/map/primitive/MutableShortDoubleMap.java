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
import org.eclipse.collections.api.block.function.primitive.ShortToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.ShortDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortDoubleMap extends ShortDoubleMap, MutableDoubleValuesMap
{
    void put(short key, double value);

   /**
     * This method allows MutableShortDoubleMap the ability to add an element in the form of ShortDoublePair.
     *
     * @see #put(short, double)
     * @since 9.1.0
     */
    default void putPair(ShortDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortDoubleMap map);

    void removeKey(short key);

    void remove(short key);

    double removeKeyIfAbsent(short key, double value);

    double getIfAbsentPut(short key, double value);

    double getIfAbsentPut(short key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(short key, ShortToDoubleFunction function);

    <P> double getIfAbsentPutWith(short key, DoubleFunction<? super P> function, P parameter);

    double updateValue(short key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleShortMap flipUniqueValues();

    @Override
    MutableShortDoubleMap select(ShortDoublePredicate predicate);

    @Override
    MutableShortDoubleMap reject(ShortDoublePredicate predicate);

    MutableShortDoubleMap withKeyValue(short key, double value);

    MutableShortDoubleMap withoutKey(short key);

    MutableShortDoubleMap withoutAllKeys(ShortIterable keys);

    MutableShortDoubleMap asUnmodifiable();

    MutableShortDoubleMap asSynchronized();

    double addToValue(short key, double toBeAdded);
}
