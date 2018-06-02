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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.function.primitive.ByteToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.ByteBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteBooleanMap extends ByteBooleanMap, MutableBooleanValuesMap
{
    void put(byte key, boolean value);

   /**
     * This method allows MutableByteBooleanMap the ability to add an element in the form of ByteBooleanPair.
     *
     * @see #put(byte, boolean)
     * @since 9.1.0
     */
    default void putPair(ByteBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteBooleanMap map);

    void removeKey(byte key);

    void remove(byte key);

    boolean removeKeyIfAbsent(byte key, boolean value);

    boolean getIfAbsentPut(byte key, boolean value);

    boolean getIfAbsentPut(byte key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(byte key, ByteToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(byte key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(byte key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableByteBooleanMap select(ByteBooleanPredicate predicate);

    @Override
    MutableByteBooleanMap reject(ByteBooleanPredicate predicate);

    MutableByteBooleanMap withKeyValue(byte key, boolean value);

    MutableByteBooleanMap withoutKey(byte key);

    MutableByteBooleanMap withoutAllKeys(ByteIterable keys);

    MutableByteBooleanMap asUnmodifiable();

    MutableByteBooleanMap asSynchronized();
}
