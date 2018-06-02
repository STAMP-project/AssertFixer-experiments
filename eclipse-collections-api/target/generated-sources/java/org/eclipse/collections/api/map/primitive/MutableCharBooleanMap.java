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
import org.eclipse.collections.api.block.function.primitive.CharToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.CharBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharBooleanMap extends CharBooleanMap, MutableBooleanValuesMap
{
    void put(char key, boolean value);

   /**
     * This method allows MutableCharBooleanMap the ability to add an element in the form of CharBooleanPair.
     *
     * @see #put(char, boolean)
     * @since 9.1.0
     */
    default void putPair(CharBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(CharBooleanMap map);

    void removeKey(char key);

    void remove(char key);

    boolean removeKeyIfAbsent(char key, boolean value);

    boolean getIfAbsentPut(char key, boolean value);

    boolean getIfAbsentPut(char key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(char key, CharToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(char key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(char key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableCharBooleanMap select(CharBooleanPredicate predicate);

    @Override
    MutableCharBooleanMap reject(CharBooleanPredicate predicate);

    MutableCharBooleanMap withKeyValue(char key, boolean value);

    MutableCharBooleanMap withoutKey(char key);

    MutableCharBooleanMap withoutAllKeys(CharIterable keys);

    MutableCharBooleanMap asUnmodifiable();

    MutableCharBooleanMap asSynchronized();
}
