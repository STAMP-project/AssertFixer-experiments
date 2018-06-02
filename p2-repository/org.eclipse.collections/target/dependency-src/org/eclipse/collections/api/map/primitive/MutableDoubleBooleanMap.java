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
import org.eclipse.collections.api.block.function.primitive.DoubleToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.DoubleBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleBooleanMap extends DoubleBooleanMap, MutableBooleanValuesMap
{
    void put(double key, boolean value);

   /**
     * This method allows MutableDoubleBooleanMap the ability to add an element in the form of DoubleBooleanPair.
     *
     * @see #put(double, boolean)
     * @since 9.1.0
     */
    default void putPair(DoubleBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(DoubleBooleanMap map);

    void removeKey(double key);

    void remove(double key);

    boolean removeKeyIfAbsent(double key, boolean value);

    boolean getIfAbsentPut(double key, boolean value);

    boolean getIfAbsentPut(double key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(double key, DoubleToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(double key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(double key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableDoubleBooleanMap select(DoubleBooleanPredicate predicate);

    @Override
    MutableDoubleBooleanMap reject(DoubleBooleanPredicate predicate);

    MutableDoubleBooleanMap withKeyValue(double key, boolean value);

    MutableDoubleBooleanMap withoutKey(double key);

    MutableDoubleBooleanMap withoutAllKeys(DoubleIterable keys);

    MutableDoubleBooleanMap asUnmodifiable();

    MutableDoubleBooleanMap asSynchronized();
}
