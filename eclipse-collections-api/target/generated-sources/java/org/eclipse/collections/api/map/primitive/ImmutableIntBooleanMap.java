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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.predicate.primitive.IntBooleanPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableIntBooleanMap extends IntBooleanMap
{
    @Override
    ImmutableIntBooleanMap select(IntBooleanPredicate predicate);

    @Override
    ImmutableIntBooleanMap reject(IntBooleanPredicate predicate);

    @Override
    ImmutableBooleanBag select(BooleanPredicate predicate);

    @Override
    ImmutableBooleanBag reject(BooleanPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(BooleanToObjectFunction<? extends V> function);

    ImmutableIntBooleanMap newWithKeyValue(int key, boolean value);

    ImmutableIntBooleanMap newWithoutKey(int key);

    ImmutableIntBooleanMap newWithoutAllKeys(IntIterable keys);
}
