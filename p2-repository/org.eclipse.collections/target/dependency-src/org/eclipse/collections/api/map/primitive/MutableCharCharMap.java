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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharCharPredicate;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharCharMap extends CharCharMap, MutableCharValuesMap
{
    void put(char key, char value);

   /**
     * This method allows MutableCharCharMap the ability to add an element in the form of CharCharPair.
     *
     * @see #put(char, char)
     * @since 9.1.0
     */
    default void putPair(CharCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharCharMap map);

    void removeKey(char key);

    void remove(char key);

    char removeKeyIfAbsent(char key, char value);

    char getIfAbsentPut(char key, char value);

    char getIfAbsentPut(char key, CharFunction0 function);

    char getIfAbsentPutWithKey(char key, CharToCharFunction function);

    <P> char getIfAbsentPutWith(char key, CharFunction<? super P> function, P parameter);

    char updateValue(char key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharCharMap flipUniqueValues();

    @Override
    MutableCharCharMap select(CharCharPredicate predicate);

    @Override
    MutableCharCharMap reject(CharCharPredicate predicate);

    MutableCharCharMap withKeyValue(char key, char value);

    MutableCharCharMap withoutKey(char key);

    MutableCharCharMap withoutAllKeys(CharIterable keys);

    MutableCharCharMap asUnmodifiable();

    MutableCharCharMap asSynchronized();

    char addToValue(char key, char toBeAdded);
}
