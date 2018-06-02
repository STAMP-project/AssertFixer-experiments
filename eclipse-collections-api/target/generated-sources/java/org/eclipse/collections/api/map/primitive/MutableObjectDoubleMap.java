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

import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.block.predicate.primitive.ObjectDoublePredicate;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.tuple.primitive.ObjectDoublePair;

/**
 * This file was automatically generated from template file mutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableObjectDoubleMap<K> extends ObjectDoubleMap<K>
{
    @Override
    MutableDoubleIterator doubleIterator();

    void clear();

    void put(K key, double value);

    /**
     * This method allows MutableObjectDoubleMap the ability to add an element in the form of ObjectDoublePair<K>.
     *
     * @see #put(Object, double)
     * @since 9.1.0
     */
    default void putPair(ObjectDoublePair<K> keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ObjectDoubleMap<? extends K> map);

    void removeKey(K key);

    void remove(Object key);

    double removeKeyIfAbsent(K key, double value);

    double getIfAbsentPut(K key, double value);

    double getIfAbsentPut(K key, DoubleFunction0 function);

    double getIfAbsentPutWithKey(K key, DoubleFunction<? super K> function);

    <P> double getIfAbsentPutWith(K key, DoubleFunction<? super P> function, P parameter);

    double updateValue(K key, double initialValueIfAbsent, DoubleToDoubleFunction function);

    @Override
    MutableDoubleObjectMap<K> flipUniqueValues();

    @Override
    MutableObjectDoubleMap<K> select(ObjectDoublePredicate<? super K> predicate);

    @Override
    MutableObjectDoubleMap<K> reject(ObjectDoublePredicate<? super K> predicate);

    @Override
    MutableDoubleCollection select(DoublePredicate predicate);

    @Override
    MutableDoubleCollection reject(DoublePredicate predicate);

    /**
     * @since 9.0.
     */
    default MutableObjectDoubleMap<K> tap(DoubleProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableCollection<V> collect(DoubleToObjectFunction<? extends V> function);

    MutableObjectDoubleMap<K> withKeyValue(K key, double value);

    MutableObjectDoubleMap<K> withoutKey(K key);

    MutableObjectDoubleMap<K> withoutAllKeys(Iterable<? extends K> keys);

    MutableObjectDoubleMap<K> asUnmodifiable();

    MutableObjectDoubleMap<K> asSynchronized();

    double addToValue(K key, double toBeAdded);
}
