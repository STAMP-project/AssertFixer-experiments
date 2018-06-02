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
import org.eclipse.collections.api.block.function.primitive.DoubleToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleCharPredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleCharPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleCharMap extends DoubleCharMap, MutableCharValuesMap
{
    void put(double key, char value);

   /**
     * This method allows MutableDoubleCharMap the ability to add an element in the form of DoubleCharPair.
     *
     * @see #put(double, char)
     * @since 9.1.0
     */
    default void putPair(DoubleCharPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleCharMap map);

    void removeKey(double key);

    void remove(double key);

    char removeKeyIfAbsent(double key, char value);

    char getIfAbsentPut(double key, char value);

    char getIfAbsentPut(double key, CharFunction0 function);

    char getIfAbsentPutWithKey(double key, DoubleToCharFunction function);

    <P> char getIfAbsentPutWith(double key, CharFunction<? super P> function, P parameter);

    char updateValue(double key, char initialValueIfAbsent, CharToCharFunction function);

    @Override
    MutableCharDoubleMap flipUniqueValues();

    @Override
    MutableDoubleCharMap select(DoubleCharPredicate predicate);

    @Override
    MutableDoubleCharMap reject(DoubleCharPredicate predicate);

    MutableDoubleCharMap withKeyValue(double key, char value);

    MutableDoubleCharMap withoutKey(double key);

    MutableDoubleCharMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleCharMap asUnmodifiable();

    MutableDoubleCharMap asSynchronized();

    char addToValue(double key, char toBeAdded);
}
