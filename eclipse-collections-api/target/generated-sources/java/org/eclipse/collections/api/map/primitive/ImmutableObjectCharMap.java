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

import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ObjectCharPredicate;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableCharCollection;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableObjectCharMap<K> extends ObjectCharMap<K>
{
    @Override
    ImmutableObjectCharMap<K> select(ObjectCharPredicate<? super K> predicate);

    @Override
    ImmutableObjectCharMap<K> reject(ObjectCharPredicate<? super K> predicate);

    @Override
    ImmutableCharCollection select(CharPredicate predicate);

    @Override
    ImmutableCharCollection reject(CharPredicate predicate);

    /**
     * @since 9.0.
     */
    default ImmutableObjectCharMap<K> tap(CharProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableCollection<V> collect(CharToObjectFunction<? extends V> function);

    ImmutableObjectCharMap<K> newWithKeyValue(K key, char value);

    ImmutableObjectCharMap<K> newWithoutKey(K key);

    ImmutableObjectCharMap<K> newWithoutAllKeys(Iterable<? extends K> keys);

    @Override
    ImmutableCharObjectMap<K> flipUniqueValues();
}
