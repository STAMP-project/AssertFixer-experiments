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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.block.function.primitive.IntToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.IntBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntBooleanMap extends IntBooleanMap, MutableBooleanValuesMap
{
    void put(int key, boolean value);

   /**
     * This method allows MutableIntBooleanMap the ability to add an element in the form of IntBooleanPair.
     *
     * @see #put(int, boolean)
     * @since 9.1.0
     */
    default void putPair(IntBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(IntBooleanMap map);

    void removeKey(int key);

    void remove(int key);

    boolean removeKeyIfAbsent(int key, boolean value);

    boolean getIfAbsentPut(int key, boolean value);

    boolean getIfAbsentPut(int key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(int key, IntToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(int key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(int key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableIntBooleanMap select(IntBooleanPredicate predicate);

    @Override
    MutableIntBooleanMap reject(IntBooleanPredicate predicate);

    MutableIntBooleanMap withKeyValue(int key, boolean value);

    MutableIntBooleanMap withoutKey(int key);

    MutableIntBooleanMap withoutAllKeys(IntIterable keys);

    MutableIntBooleanMap asUnmodifiable();

    MutableIntBooleanMap asSynchronized();
}
