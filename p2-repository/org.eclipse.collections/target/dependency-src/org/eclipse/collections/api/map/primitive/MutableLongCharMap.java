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
import org.eclipse.collections.api.block.function.primitive.LongToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongCharPredicate;
import org.eclipse.collections.api.tuple.primitive.LongCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongCharMap extends LongCharMap, MutableCharValuesMap
{
    void put(long key, char value);

   /**
     * This method allows MutableLongCharMap the ability to add an element in the form of LongCharPair.
     *
     * @see #put(long, char)
     * @since 9.1.0
     */
    default void putPair(LongCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongCharMap map);

    void removeKey(long key);

    void remove(long key);

    char removeKeyIfAbsent(long key, char value);

    char getIfAbsentPut(long key, char value);

    char getIfAbsentPut(long key, CharFunction0 function);

    char getIfAbsentPutWithKey(long key, LongToCharFunction function);

    <P> char getIfAbsentPutWith(long key, CharFunction<? super P> function, P parameter);

    char updateValue(long key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharLongMap flipUniqueValues();

    @Override
    MutableLongCharMap select(LongCharPredicate predicate);

    @Override
    MutableLongCharMap reject(LongCharPredicate predicate);

    MutableLongCharMap withKeyValue(long key, char value);

    MutableLongCharMap withoutKey(long key);

    MutableLongCharMap withoutAllKeys(LongIterable keys);

    MutableLongCharMap asUnmodifiable();

    MutableLongCharMap asSynchronized();

    char addToValue(long key, char toBeAdded);
}
