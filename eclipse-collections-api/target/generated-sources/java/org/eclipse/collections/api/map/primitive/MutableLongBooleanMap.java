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
import org.eclipse.collections.api.block.function.primitive.LongToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.LongBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongBooleanMap extends LongBooleanMap, MutableBooleanValuesMap
{
    void put(long key, boolean value);

   /**
     * This method allows MutableLongBooleanMap the ability to add an element in the form of LongBooleanPair.
     *
     * @see #put(long, boolean)
     * @since 9.1.0
     */
    default void putPair(LongBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(LongBooleanMap map);

    void removeKey(long key);

    void remove(long key);

    boolean removeKeyIfAbsent(long key, boolean value);

    boolean getIfAbsentPut(long key, boolean value);

    boolean getIfAbsentPut(long key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(long key, LongToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(long key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(long key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableLongBooleanMap select(LongBooleanPredicate predicate);

    @Override
    MutableLongBooleanMap reject(LongBooleanPredicate predicate);

    MutableLongBooleanMap withKeyValue(long key, boolean value);

    MutableLongBooleanMap withoutKey(long key);

    MutableLongBooleanMap withoutAllKeys(LongIterable keys);

    MutableLongBooleanMap asUnmodifiable();

    MutableLongBooleanMap asSynchronized();
}
