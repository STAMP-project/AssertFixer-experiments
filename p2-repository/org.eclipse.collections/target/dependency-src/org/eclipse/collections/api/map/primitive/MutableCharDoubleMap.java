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
import org.eclipse.collections.api.block.function.primitive.CharToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.CharDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharDoubleMap extends CharDoubleMap, MutableDoubleValuesMap
{
    void put(char key, double value);

   /**
     * This method allows MutableCharDoubleMap the ability to add an element in the form of CharDoublePair.
     *
     * @see #put(char, double)
     * @since 9.1.0
     */
    default void putPair(CharDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharDoubleMap map);

    void removeKey(char key);

    void remove(char key);

    double removeKeyIfAbsent(char key, double value);

    double getIfAbsentPut(char key, double value);

    double getIfAbsentPut(char key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(char key, CharToDoubleFunction function);

    <P> double getIfAbsentPutWith(char key, DoubleFunction<? super P> function, P parameter);

    double updateValue(char key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleCharMap flipUniqueValues();

    @Override
    MutableCharDoubleMap select(CharDoublePredicate predicate);

    @Override
    MutableCharDoubleMap reject(CharDoublePredicate predicate);

    MutableCharDoubleMap withKeyValue(char key, double value);

    MutableCharDoubleMap withoutKey(char key);

    MutableCharDoubleMap withoutAllKeys(CharIterable keys);

    MutableCharDoubleMap asUnmodifiable();

    MutableCharDoubleMap asSynchronized();

    double addToValue(char key, double toBeAdded);
}
