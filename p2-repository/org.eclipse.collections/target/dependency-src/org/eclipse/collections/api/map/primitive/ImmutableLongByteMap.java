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
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.predicate.primitive.LongBytePredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableLongByteMap extends LongByteMap
{
    @Override
    ImmutableLongByteMap select(LongBytePredicate predicate);

    @Override
    ImmutableLongByteMap reject(LongBytePredicate predicate);

    @Override
    ImmutableByteBag select(BytePredicate predicate);

    @Override
    ImmutableByteBag reject(BytePredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(ByteToObjectFunction<? extends V> function);

    ImmutableLongByteMap newWithKeyValue(long key, byte value);

    ImmutableLongByteMap newWithoutKey(long key);

    ImmutableLongByteMap newWithoutAllKeys(LongIterable keys);

    @Override
    ImmutableByteLongMap flipUniqueValues();
}
