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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatObjectMap<V> extends FloatObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(float key, V value);

    /**
     * This method allows MutableFloatObjectMap the ability to add an element in the form of FloatObjectPair<V>.
     *
     * @see #put(float, Object)
     * @since 9.1.0
     */
    default V putPair(FloatObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(FloatObjectMap<? extends V> map);

    V removeKey(float key);

    V remove(float key);

    V getIfAbsentPut(float key, V value);

    V getIfAbsentPut(float key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(float key, FloatToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(float key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(float key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(float, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(float key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectFloatMap<V> flipUniqueValues();

    @Override
    MutableFloatObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableFloatObjectMap<V> select(FloatObjectPredicate<? super V> predicate);

    @Override
    MutableFloatObjectMap<V> reject(FloatObjectPredicate<? super V> predicate);

    MutableFloatObjectMap<V> withKeyValue(float key, V value);

    MutableFloatObjectMap<V> withoutKey(float key);

    MutableFloatObjectMap<V> withoutAllKeys(FloatIterable keys);

    MutableFloatObjectMap<V> asUnmodifiable();

    MutableFloatObjectMap<V> asSynchronized();
}
