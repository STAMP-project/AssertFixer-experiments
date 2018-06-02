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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.predicate.primitive.FloatIntPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableFloatIntMap extends FloatIntMap
{
    @Override
    ImmutableFloatIntMap select(FloatIntPredicate predicate);

    @Override
    ImmutableFloatIntMap reject(FloatIntPredicate predicate);

    @Override
    ImmutableIntBag select(IntPredicate predicate);

    @Override
    ImmutableIntBag reject(IntPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(IntToObjectFunction<? extends V> function);

    ImmutableFloatIntMap newWithKeyValue(float key, int value);

    ImmutableFloatIntMap newWithoutKey(float key);

    ImmutableFloatIntMap newWithoutAllKeys(FloatIterable keys);

    @Override
    ImmutableIntFloatMap flipUniqueValues();
}
