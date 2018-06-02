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

import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectDoublePredicate;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableDoubleCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectDoubleMap<K> extends ObjectDoubleMap<K>
{
    @Override
    ImmutableObjectDoubleMap<K> select(ObjectDoublePredicate<? super K> predicate);

    @Override
    ImmutableObjectDoubleMap<K> reject(ObjectDoublePredicate<? super K> predicate);

    @Override
    ImmutableDoubleCollection select(DoublePredicate predicate);

    @Override
    ImmutableDoubleCollection reject(DoublePredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectDoubleMap<K> tap(DoubleProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(DoubleToObjectFunction<? extends V> function);

    ImmutableObjectDoubleMap<K> newWithKeyValue(K key, double value);

    ImmutableObjectDoubleMap<K> newWithoutKey(K key);

    ImmutableObjectDoubleMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableDoubleObjectMap<K> flipUniqueValues();
}
