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
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.IntObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableIntObjectMap<V> extends IntObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableIntObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableIntObjectMap<V> select(IntObjectPredicate<? super V> predicate);

    @Override
    ImmutableIntObjectMap<V> reject(IntObjectPredicate<? super V> predicate);

    ImmutableIntObjectMap<V> newWithKeyValue(int key, V value);

    ImmutableIntObjectMap<V> newWithoutKey(int key);

    ImmutableIntObjectMap<V> newWithoutAllKeys(IntIterable keys);

    @Override
    ImmutableObjectIntMap<V> flipUniqueValues();
}
