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
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortShortPredicate;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortShortMap extends ShortShortMap, MutableShortValuesMap
{
    void put(short key, short value);

   /**
     * This method allows MutableShortShortMap the ability to add an element in the form of ShortShortPair.
     *
     * @see #put(short, short)
     * @since 9.1.0
     */
    default void putPair(ShortShortPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortShortMap map);

    void removeKey(short key);

    void remove(short key);

    short removeKeyIfAbsent(short key, short value);

    short getIfAbsentPut(short key, short value);

    short getIfAbsentPut(short key, ShortFunction0 function);

    short getIfAbsentPutWithKey(short key, ShortToShortFunction function);

    <P> short getIfAbsentPutWith(short key, ShortFunction<? super P> function, P parameter);

    short updateValue(short key, short initialValueIfAbsent, ShortToShortFunction function);

    @Override
    MutableShortShortMap flipUniqueValues();

    @Override
    MutableShortShortMap select(ShortShortPredicate predicate);

    @Override
    MutableShortShortMap reject(ShortShortPredicate predicate);

    MutableShortShortMap withKeyValue(short key, short value);

    MutableShortShortMap withoutKey(short key);

    MutableShortShortMap withoutAllKeys(ShortIterable keys);

    MutableShortShortMap asUnmodifiable();

    MutableShortShortMap asSynchronized();

    short addToValue(short key, short toBeAdded);
}
