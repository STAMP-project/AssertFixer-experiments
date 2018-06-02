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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortObjectMap<V> extends ShortObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(short key, V value);

    /**
     * This method allows MutableShortObjectMap the ability to add an element in the form of ShortObjectPair<V>.
     *
     * @see #put(short, Object)
     * @since 9.1.0
     */
    default V putPair(ShortObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(ShortObjectMap<? extends V> map);

    V removeKey(short key);

    V remove(short key);

    V getIfAbsentPut(short key, V value);

    V getIfAbsentPut(short key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(short key, ShortToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(short key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(short key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(short, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(short key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectShortMap<V> flipUniqueValues();

    @Override
    MutableShortObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableShortObjectMap<V> select(ShortObjectPredicate<? super V> predicate);

    @Override
    MutableShortObjectMap<V> reject(ShortObjectPredicate<? super V> predicate);

    MutableShortObjectMap<V> withKeyValue(short key, V value);

    MutableShortObjectMap<V> withoutKey(short key);

    MutableShortObjectMap<V> withoutAllKeys(ShortIterable keys);

    MutableShortObjectMap<V> asUnmodifiable();

    MutableShortObjectMap<V> asSynchronized();
}
