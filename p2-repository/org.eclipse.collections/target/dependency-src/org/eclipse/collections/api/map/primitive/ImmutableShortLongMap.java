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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.predicate.primitive.ShortLongPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableShortLongMap extends ShortLongMap
{
    @Override
    ImmutableShortLongMap select(ShortLongPredicate predicate);

    @Override
    ImmutableShortLongMap reject(ShortLongPredicate predicate);

    @Override
    ImmutableLongBag select(LongPredicate predicate);

    @Override
    ImmutableLongBag reject(LongPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(LongToObjectFunction<? extends V> function);

    ImmutableShortLongMap newWithKeyValue(short key, long value);

    ImmutableShortLongMap newWithoutKey(short key);

    ImmutableShortLongMap newWithoutAllKeys(ShortIterable keys);

    @Override
    ImmutableLongShortMap flipUniqueValues();
}
