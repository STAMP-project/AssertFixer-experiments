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
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.predicate.primitive.IntCharPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableIntCharMap extends IntCharMap
{
    @Override
    ImmutableIntCharMap select(IntCharPredicate predicate);

    @Override
    ImmutableIntCharMap reject(IntCharPredicate predicate);

    @Override
    ImmutableCharBag select(CharPredicate predicate);

    @Override
    ImmutableCharBag reject(CharPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(CharToObjectFunction<? extends V> function);

    ImmutableIntCharMap newWithKeyValue(int key, char value);

    ImmutableIntCharMap newWithoutKey(int key);

    ImmutableIntCharMap newWithoutAllKeys(IntIterable keys);

    @Override
    ImmutableCharIntMap flipUniqueValues();
}
