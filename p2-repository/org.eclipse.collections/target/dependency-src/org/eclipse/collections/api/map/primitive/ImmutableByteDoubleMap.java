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
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.predicate.primitive.ByteDoublePredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableByteDoubleMap extends ByteDoubleMap
{
    @Override
    ImmutableByteDoubleMap select(ByteDoublePredicate predicate);

    @Override
    ImmutableByteDoubleMap reject(ByteDoublePredicate predicate);

    @Override
    ImmutableDoubleBag select(DoublePredicate predicate);

    @Override
    ImmutableDoubleBag reject(DoublePredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(DoubleToObjectFunction<? extends V> function);

    ImmutableByteDoubleMap newWithKeyValue(byte key, double value);

    ImmutableByteDoubleMap newWithoutKey(byte key);

    ImmutableByteDoubleMap newWithoutAllKeys(ByteIterable keys);

    @Override
    ImmutableDoubleByteMap flipUniqueValues();
}
