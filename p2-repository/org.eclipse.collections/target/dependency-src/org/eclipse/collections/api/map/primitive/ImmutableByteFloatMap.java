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
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.predicate.primitive.ByteFloatPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableByteFloatMap extends ByteFloatMap
{
    @Override
    ImmutableByteFloatMap select(ByteFloatPredicate predicate);

    @Override
    ImmutableByteFloatMap reject(ByteFloatPredicate predicate);

    @Override
    ImmutableFloatBag select(FloatPredicate predicate);

    @Override
    ImmutableFloatBag reject(FloatPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(FloatToObjectFunction<? extends V> function);

    ImmutableByteFloatMap newWithKeyValue(byte key, float value);

    ImmutableByteFloatMap newWithoutKey(byte key);

    ImmutableByteFloatMap newWithoutAllKeys(ByteIterable keys);

    @Override
    ImmutableFloatByteMap flipUniqueValues();
}
