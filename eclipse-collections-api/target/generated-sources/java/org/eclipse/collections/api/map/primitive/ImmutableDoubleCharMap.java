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
import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.predicate.primitive.DoubleCharPredicate;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableDoubleCharMap extends DoubleCharMap
{
    @Override
    ImmutableDoubleCharMap select(DoubleCharPredicate predicate);

    @Override
    ImmutableDoubleCharMap reject(DoubleCharPredicate predicate);

    @Override
    ImmutableCharBag select(CharPredicate predicate);

    @Override
    ImmutableCharBag reject(CharPredicate predicate);

    @Override
    <V> ImmutableBag<V> collect(CharToObjectFunction<? extends V> function);

    ImmutableDoubleCharMap newWithKeyValue(double key, char value);

    ImmutableDoubleCharMap newWithoutKey(double key);

    ImmutableDoubleCharMap newWithoutAllKeys(DoubleIterable keys);

    @Override
    ImmutableCharDoubleMap flipUniqueValues();
}
