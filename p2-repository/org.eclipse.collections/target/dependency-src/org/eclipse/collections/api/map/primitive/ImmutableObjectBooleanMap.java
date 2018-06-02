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

import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectBooleanPredicate;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectBooleanMap<K> extends ObjectBooleanMap<K>
{
    @Override
    ImmutableObjectBooleanMap<K> select(ObjectBooleanPredicate<? super K> predicate);

    @Override
    ImmutableObjectBooleanMap<K> reject(ObjectBooleanPredicate<? super K> predicate);

    @Override
    ImmutableBooleanCollection select(BooleanPredicate predicate);

    @Override
    ImmutableBooleanCollection reject(BooleanPredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectBooleanMap<K> tap(BooleanProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(BooleanToObjectFunction<? extends V> function);

    ImmutableObjectBooleanMap<K> newWithKeyValue(K key, boolean value);

    ImmutableObjectBooleanMap<K> newWithoutKey(K key);

    ImmutableObjectBooleanMap<K> newWithoutAllKeys(Iterable<? extends K> keys);
}
