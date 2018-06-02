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
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ByteObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableByteObjectMap<V> extends ByteObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(byte key, V value);

    /**
     * This method allows MutableByteObjectMap the ability to add an element in the form of ByteObjectPair<V>.
     *
     * @see #put(byte, Object)
     * @since 9.1.0
     */
    default V putPair(ByteObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(ByteObjectMap<? extends V> map);

    V removeKey(byte key);

    V remove(byte key);

    V getIfAbsentPut(byte key, V value);

    V getIfAbsentPut(byte key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(byte key, ByteToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(byte key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(byte key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(byte, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(byte key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectByteMap<V> flipUniqueValues();

    @Override
    MutableByteObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableByteObjectMap<V> select(ByteObjectPredicate<? super V> predicate);

    @Override
    MutableByteObjectMap<V> reject(ByteObjectPredicate<? super V> predicate);

    MutableByteObjectMap<V> withKeyValue(byte key, V value);

    MutableByteObjectMap<V> withoutKey(byte key);

    MutableByteObjectMap<V> withoutAllKeys(ByteIterable keys);

    MutableByteObjectMap<V> asUnmodifiable();

    MutableByteObjectMap<V> asSynchronized();
}
