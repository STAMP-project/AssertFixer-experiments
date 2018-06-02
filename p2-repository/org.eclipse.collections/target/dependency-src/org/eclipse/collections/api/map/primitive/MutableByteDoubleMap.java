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
import org.eclipse.collections.api.block.function.primitive.ByteToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.ByteDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteDoubleMap extends ByteDoubleMap, MutableDoubleValuesMap
{
    void put(byte key, double value);

   /**
     * This method allows MutableByteDoubleMap the ability to add an element in the form of ByteDoublePair.
     *
     * @see #put(byte, double)
     * @since 9.1.0
     */
    default void putPair(ByteDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ByteDoubleMap map);

    void removeKey(byte key);

    void remove(byte key);

    double removeKeyIfAbsent(byte key, double value);

    double getIfAbsentPut(byte key, double value);

    double getIfAbsentPut(byte key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(byte key, ByteToDoubleFunction function);

    <P> double getIfAbsentPutWith(byte key, DoubleFunction<? super P> function, P parameter);

    double updateValue(byte key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleByteMap flipUniqueValues();

    @Override
    MutableByteDoubleMap select(ByteDoublePredicate predicate);

    @Override
    MutableByteDoubleMap reject(ByteDoublePredicate predicate);

    MutableByteDoubleMap withKeyValue(byte key, double value);

    MutableByteDoubleMap withoutKey(byte key);

    MutableByteDoubleMap withoutAllKeys(ByteIterable keys);

    MutableByteDoubleMap asUnmodifiable();

    MutableByteDoubleMap asSynchronized();

    double addToValue(byte key, double toBeAdded);
}
