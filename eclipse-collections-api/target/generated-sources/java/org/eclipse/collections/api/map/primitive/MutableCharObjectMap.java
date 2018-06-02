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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface MutableCharObjectMap<V> extends CharObjectMap<V>, MutablePrimitiveObjectMap<V>
{
    V put(char key, V value);

    /**
     * This method allows MutableCharObjectMap the ability to add an element in the form of CharObjectPair<V>.
     *
     * @see #put(char, Object)
     * @since 9.1.0
     */
    default V putPair(CharObjectPair<V> keyValuePair)
    {
        return this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    /**
     * @since 5.0.
     */
    void putAll(CharObjectMap<? extends V> map);

    V removeKey(char key);

    V remove(char key);

    V getIfAbsentPut(char key, V value);

    V getIfAbsentPut(char key, Function0<? extends V> function);

    V getIfAbsentPutWithKey(char key, CharToObjectFunction<? extends V> function);

    <P> V getIfAbsentPutWith(char key, Function<? super P, ? extends V> function, P parameter);

    /**
     * Look up the value associated with {@code key}, apply the {@code function} to it, and replace the value. If there
     * is no value associated with {@code key}, start it off with a value supplied by {@code factory}.
     */
    V updateValue(char key, Function0<? extends V> factory, Function<? super V, ? extends V> function);

    /**
     * Same as {@link #updateValue(char, Function0, Function)} with a Function2 and specified parameter which is
     * passed to the function.
     */
    <P> V updateValueWith(char key, Function0<? extends V> factory, Function2<? super V, ? super P, ? extends V> function, P parameter);

    @Override
    MutableObjectCharMap<V> flipUniqueValues();

    @Override
    MutableCharObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    MutableCharObjectMap<V> select(CharObjectPredicate<? super V> predicate);

    @Override
    MutableCharObjectMap<V> reject(CharObjectPredicate<? super V> predicate);

    MutableCharObjectMap<V> withKeyValue(char key, V value);

    MutableCharObjectMap<V> withoutKey(char key);

    MutableCharObjectMap<V> withoutAllKeys(CharIterable keys);

    MutableCharObjectMap<V> asUnmodifiable();

    MutableCharObjectMap<V> asSynchronized();
}
