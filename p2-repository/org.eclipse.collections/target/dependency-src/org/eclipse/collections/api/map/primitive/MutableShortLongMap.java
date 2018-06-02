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
import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortLongPredicate;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortLongMap extends ShortLongMap, MutableLongValuesMap
{
    void put(short key, long value);

   /**
     * This method allows MutableShortLongMap the ability to add an element in the form of ShortLongPair.
     *
     * @see #put(short, long)
     * @since 9.1.0
     */
    default void putPair(ShortLongPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortLongMap map);

    void removeKey(short key);

    void remove(short key);

    long removeKeyIfAbsent(short key, long value);

    long getIfAbsentPut(short key, long value);

    long getIfAbsentPut(short key, LongFunction0 function);

    long getIfAbsentPutWithKey(short key, ShortToLongFunction function);

    <P> long getIfAbsentPutWith(short key, LongFunction<? super P> function, P parameter);

    long updateValue(short key, long initialValueIfAbsent, LongToLongFunction function);

    @Override
    MutableLongShortMap flipUniqueValues();

    @Override
    MutableShortLongMap select(ShortLongPredicate predicate);

    @Override
    MutableShortLongMap reject(ShortLongPredicate predicate);

    MutableShortLongMap withKeyValue(short key, long value);

    MutableShortLongMap withoutKey(short key);

    MutableShortLongMap withoutAllKeys(ShortIterable keys);

    MutableShortLongMap asUnmodifiable();

    MutableShortLongMap asSynchronized();

    long addToValue(short key, long toBeAdded);
}
