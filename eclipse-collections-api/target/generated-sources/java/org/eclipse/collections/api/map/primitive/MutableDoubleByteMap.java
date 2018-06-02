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
import org.eclipse.collections.api.block.function.primitive.DoubleToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleBytePredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleBytePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleByteMap extends DoubleByteMap, MutableByteValuesMap
{
    void put(double key, byte value);

   /**
     * This method allows MutableDoubleByteMap the ability to add an element in the form of DoubleBytePair.
     *
     * @see #put(double, byte)
     * @since 9.1.0
     */
    default void putPair(DoubleBytePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleByteMap map);

    void removeKey(double key);

    void remove(double key);

    byte removeKeyIfAbsent(double key, byte value);

    byte getIfAbsentPut(double key, byte value);

    byte getIfAbsentPut(double key, ByteFunction0 function);

    byte getIfAbsentPutWithKey(double key, DoubleToByteFunction function);

    <P> byte getIfAbsentPutWith(double key, ByteFunction<? super P> function, P parameter);

    byte updateValue(double key, byte initialValueIfAbsent, ByteToByteFunction function);

    @Override
    MutableByteDoubleMap flipUniqueValues();

    @Override
    MutableDoubleByteMap select(DoubleBytePredicate predicate);

    @Override
    MutableDoubleByteMap reject(DoubleBytePredicate predicate);

    MutableDoubleByteMap withKeyValue(double key, byte value);

    MutableDoubleByteMap withoutKey(double key);

    MutableDoubleByteMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleByteMap asUnmodifiable();

    MutableDoubleByteMap asSynchronized();

    byte addToValue(double key, byte toBeAdded);
}
