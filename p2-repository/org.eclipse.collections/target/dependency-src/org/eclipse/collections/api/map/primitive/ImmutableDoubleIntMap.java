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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.predicate.primitive.DoubleIntPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableDoubleIntMap extends DoubleIntMap
{
    @Override
    ImmutableDoubleIntMap select(DoubleIntPredicate predicate);

    @Override
    ImmutableDoubleIntMap reject(DoubleIntPredicate predicate);

    @Override
    ImmutableIntBag select(IntPredicate predicate);

    @Override
    ImmutableIntBag reject(IntPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(IntToObjectFunction<? extends V> function);

    ImmutableDoubleIntMap newWithKeyValue(double key, int value);

    ImmutableDoubleIntMap newWithoutKey(double key);

    ImmutableDoubleIntMap newWithoutAllKeys(DoubleIterable keys);

    @Override
    ImmutableIntDoubleMap flipUniqueValues();
}
