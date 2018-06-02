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

import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectBytePredicate;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableByteCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectByteMap<K> extends ObjectByteMap<K>
{
    @Override
    ImmutableObjectByteMap<K> select(ObjectBytePredicate<? super K> predicate);

    @Override
    ImmutableObjectByteMap<K> reject(ObjectBytePredicate<? super K> predicate);

    @Override
    ImmutableByteCollection select(BytePredicate predicate);

    @Override
    ImmutableByteCollection reject(BytePredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectByteMap<K> tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(ByteToObjectFunction<? extends V> function);

    ImmutableObjectByteMap<K> newWithKeyValue(K key, byte value);

    ImmutableObjectByteMap<K> newWithoutKey(K key);

    ImmutableObjectByteMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableByteObjectMap<K> flipUniqueValues();
}
