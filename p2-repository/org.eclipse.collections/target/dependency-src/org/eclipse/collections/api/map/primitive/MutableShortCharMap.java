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
import org.eclipse.collections.api.block.function.primitive.ShortToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortCharPredicate;
import org.eclipse.collections.api.tuple.primitive.ShortCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortCharMap extends ShortCharMap, MutableCharValuesMap
{
    void put(short key, char value);

   /**
     * This method allows MutableShortCharMap the ability to add an element in the form of ShortCharPair.
     *
     * @see #put(short, char)
     * @since 9.1.0
     */
    default void putPair(ShortCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortCharMap map);

    void removeKey(short key);

    void remove(short key);

    char removeKeyIfAbsent(short key, char value);

    char getIfAbsentPut(short key, char value);

    char getIfAbsentPut(short key, CharFunction0 function);

    char getIfAbsentPutWithKey(short key, ShortToCharFunction function);

    <P> char getIfAbsentPutWith(short key, CharFunction<? super P> function, P parameter);

    char updateValue(short key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharShortMap flipUniqueValues();

    @Override
    MutableShortCharMap select(ShortCharPredicate predicate);

    @Override
    MutableShortCharMap reject(ShortCharPredicate predicate);

    MutableShortCharMap withKeyValue(short key, char value);

    MutableShortCharMap withoutKey(short key);

    MutableShortCharMap withoutAllKeys(ShortIterable keys);

    MutableShortCharMap asUnmodifiable();

    MutableShortCharMap asSynchronized();

    char addToValue(short key, char toBeAdded);
}
