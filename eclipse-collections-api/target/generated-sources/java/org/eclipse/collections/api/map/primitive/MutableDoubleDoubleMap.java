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
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleDoublePredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleDoubleMap extends DoubleDoubleMap, MutableDoubleValuesMap
{
    void put(double key, double value);

   /**
     * This method allows MutableDoubleDoubleMap the ability to add an element in the form of DoubleDoublePair.
     *
     * @see #put(double, double)
     * @since 9.1.0
     */
    default void putPair(DoubleDoublePair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleDoubleMap map);

    void removeKey(double key);

    void remove(double key);

    double removeKeyIfAbsent(double key, double value);

    double getIfAbsentPut(double key, double value);

    double getIfAbsentPut(double key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(double key, DoubleToDoubleFunction function);

    <P> double getIfAbsentPutWith(double key, DoubleFunction<? super P> function, P parameter);

    double updateValue(double key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleDoubleMap flipUniqueValues();

    @Override
    MutableDoubleDoubleMap select(DoubleDoublePredicate predicate);

    @Override
    MutableDoubleDoubleMap reject(DoubleDoublePredicate predicate);

    MutableDoubleDoubleMap withKeyValue(double key, double value);

    MutableDoubleDoubleMap withoutKey(double key);

    MutableDoubleDoubleMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleDoubleMap asUnmodifiable();

    MutableDoubleDoubleMap asSynchronized();

    double addToValue(double key, double toBeAdded);
}
