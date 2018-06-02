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
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableLongObjectMap<V> extends LongObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(long key, V value);

    /**
     * This method allows MutableLongObjectMap the ability to add an element in the form of LongObjectPair<V>.
     *
     * @see #put(long, Object)
     * @since 9.1.0
     */
    default V putPair(LongObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(LongObjectMap<? extends V> map);

    V removeKey(long key);

    V remove(long key);

    V getIfAbsentPut(long key, V value);

    V getIfAbsentPut(long key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(long key, LongToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(long key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(long key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(long, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(long key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectLongMap<V> flipUniqueValues();

    @Override
    MutableLongObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableLongObjectMap<V> select(LongObjectPredicate<? super V> predicate);

    @Override
    MutableLongObjectMap<V> reject(LongObjectPredicate<? super V> predicate);

    MutableLongObjectMap<V> withKeyValue(long key, V value);

    MutableLongObjectMap<V> withoutKey(long key);

    MutableLongObjectMap<V> withoutAllKeys(LongIterable keys);

    MutableLongObjectMap<V> asUnmodifiable();

    MutableLongObjectMap<V> asSynchronized();
}
