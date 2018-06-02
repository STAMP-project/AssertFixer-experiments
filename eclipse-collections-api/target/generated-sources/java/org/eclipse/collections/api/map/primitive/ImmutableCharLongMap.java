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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.predicate.primitive.CharLongPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableCharLongMap extends CharLongMap
{
    @Override
    ImmutableCharLongMap select(CharLongPredicate predicate);

    @Override
    ImmutableCharLongMap reject(CharLongPredicate predicate);

    @Override
    ImmutableLongBag select(LongPredicate predicate);

    @Override
    ImmutableLongBag reject(LongPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(LongToObjectFunction<? extends V> function);

    ImmutableCharLongMap newWithKeyValue(char key, long value);

    ImmutableCharLongMap newWithoutKey(char key);

    ImmutableCharLongMap newWithoutAllKeys(CharIterable keys);

    @Override
    ImmutableLongCharMap flipUniqueValues();
}
