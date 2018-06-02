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
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.predicate.primitive.CharBytePredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableCharByteMap extends CharByteMap
{
    @Override
    ImmutableCharByteMap select(CharBytePredicate predicate);

    @Override
    ImmutableCharByteMap reject(CharBytePredicate predicate);

    @Override
    ImmutableByteBag select(BytePredicate predicate);

    @Override
    ImmutableByteBag reject(BytePredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(ByteToObjectFunction<? extends V> function);

    ImmutableCharByteMap newWithKeyValue(char key, byte value);

    ImmutableCharByteMap newWithoutKey(char key);

    ImmutableCharByteMap newWithoutAllKeys(CharIterable keys);

    @Override
    ImmutableByteCharMap flipUniqueValues();
}
