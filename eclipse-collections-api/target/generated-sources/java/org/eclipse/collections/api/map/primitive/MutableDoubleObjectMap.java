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
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoubleObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleObjectMap<V> extends DoubleObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(double key, V value);

    /**
     * This method allows MutableDoubleObjectMap the ability to add an element in the form of DoubleObjectPair<V>.
     *
     * @see #put(double, Object)
     * @since 9.1.0
     */
    default V putPair(DoubleObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(DoubleObjectMap<? extends V> map);

    V removeKey(double key);

    V remove(double key);

    V getIfAbsentPut(double key, V value);

    V getIfAbsentPut(double key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(double key, DoubleToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(double key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(double key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(double, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(double key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectDoubleMap<V> flipUniqueValues();

    @Override
    MutableDoubleObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableDoubleObjectMap<V> select(DoubleObjectPredicate<? super V> predicate);

    @Override
    MutableDoubleObjectMap<V> reject(DoubleObjectPredicate<? super V> predicate);

    MutableDoubleObjectMap<V> withKeyValue(double key, V value);

    MutableDoubleObjectMap<V> withoutKey(double key);

    MutableDoubleObjectMap<V> withoutAllKeys(DoubleIterable keys);

    MutableDoubleObjectMap<V> asUnmodifiable();

    MutableDoubleObjectMap<V> asSynchronized();
}
