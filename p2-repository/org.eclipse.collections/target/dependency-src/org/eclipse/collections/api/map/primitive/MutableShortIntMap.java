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
import org.eclipse.collections.api.block.function.primitive.ShortToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortIntPredicate;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortIntMap extends ShortIntMap, MutableIntValuesMap
{
    void put(short key, int value);

   /**
     * This method allows MutableShortIntMap the ability to add an element in the form of ShortIntPair.
     *
     * @see #put(short, int)
     * @since 9.1.0
     */
    default void putPair(ShortIntPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortIntMap map);

    void removeKey(short key);

    void remove(short key);

    int removeKeyIfAbsent(short key, int value);

    int getIfAbsentPut(short key, int value);

    int getIfAbsentPut(short key, IntFunction0 function);

    int getIfAbsentPutWithKey(short key, ShortToIntFunction function);

    <P> int getIfAbsentPutWith(short key, IntFunction<? super P> function, P parameter);

    int updateValue(short key, int initialValueIfAbsent, IntToIntFunction function);

    @Override
    MutableIntShortMap flipUniqueValues();

    @Override
    MutableShortIntMap select(ShortIntPredicate predicate);

    @Override
    MutableShortIntMap reject(ShortIntPredicate predicate);

    MutableShortIntMap withKeyValue(short key, int value);

    MutableShortIntMap withoutKey(short key);

    MutableShortIntMap withoutAllKeys(ShortIterable keys);

    MutableShortIntMap asUnmodifiable();

    MutableShortIntMap asSynchronized();

    int addToValue(short key, int toBeAdded);
}
