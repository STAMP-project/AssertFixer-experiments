/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectBooleanPredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectBooleanPair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectBooleanMap<K> extends ObjectBooleanMap<K>
{
    @Override
    MutableBooleanIterator booleanIterator();

    void clear();

    void put(K key, boolean value);

    /**
     * This method allows MutableObjectBooleanMap the ability to add an element in the form of ObjectBooleanPair<K>.
     *
     * @see #put(Object, boolean)
     * @since 9.1.0
     */
    default void putPair(ObjectBooleanPair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectBooleanMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    boolean removeKeyIfAbsent(K key, boolean value);

    boolean getIfAbsentPut(K key, boolean value);

    boolean getIfAbsentPut(K key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(K key, BooleanFunction<? super K> function);

    <P> boolean getIfAbsentPutWith(K key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(K key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableObjectBooleanMap<K> select(ObjectBooleanPredicate<? super K> predicate);

    @Override
    MutableObjectBooleanMap<K> reject(ObjectBooleanPredicate<? super K> predicate);

    @Override
    MutableBooleanCollection select(BooleanPredicate predicate);

    @Override
    MutableBooleanCollection reject(BooleanPredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectBooleanMap<K> tap(BooleanProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(BooleanToObjectFunction<? extends V> function);

    MutableObjectBooleanMap<K> withKeyValue(K key, boolean value);

    MutableObjectBooleanMap<K> withoutKey(K key);

    MutableObjectBooleanMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectBooleanMap<K> asUnmodifiable();

    MutableObjectBooleanMap<K> asSynchronized();
}
