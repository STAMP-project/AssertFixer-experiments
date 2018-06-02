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
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.IntObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableIntObjectMap<V> extends IntObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(int key, V value);

    /**
     * This method allows MutableIntObjectMap the ability to add an element in the form of IntObjectPair<V>.
     *
     * @see #put(int, Object)
     * @since 9.1.0
     */
    default V putPair(IntObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(IntObjectMap<? extends V> map);

    V removeKey(int key);

    V remove(int key);

    V getIfAbsentPut(int key, V value);

    V getIfAbsentPut(int key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(int key, IntToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(int key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(int key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(int, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(int key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectIntMap<V> flipUniqueValues();

    @Override
    MutableIntObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableIntObjectMap<V> select(IntObjectPredicate<? super V> predicate);

    @Override
    MutableIntObjectMap<V> reject(IntObjectPredicate<? super V> predicate);

    MutableIntObjectMap<V> withKeyValue(int key, V value);

    MutableIntObjectMap<V> withoutKey(int key);

    MutableIntObjectMap<V> withoutAllKeys(IntIterable keys);

    MutableIntObjectMap<V> asUnmodifiable();

    MutableIntObjectMap<V> asSynchronized();
}
