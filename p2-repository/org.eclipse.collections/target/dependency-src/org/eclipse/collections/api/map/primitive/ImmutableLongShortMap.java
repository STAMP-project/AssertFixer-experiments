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
import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.predicate.primitive.LongShortPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableLongShortMap extends LongShortMap
{
    @Override
    ImmutableLongShortMap select(LongShortPredicate predicate);

    @Override
    ImmutableLongShortMap reject(LongShortPredicate predicate);

    @Override
    ImmutableShortBag select(ShortPredicate predicate);

    @Override
    ImmutableShortBag reject(ShortPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(ShortToObjectFunction<? extends V> function);

    ImmutableLongShortMap newWithKeyValue(long key, short value);

    ImmutableLongShortMap newWithoutKey(long key);

    ImmutableLongShortMap newWithoutAllKeys(LongIterable keys);

    @Override
    ImmutableShortLongMap flipUniqueValues();
}
