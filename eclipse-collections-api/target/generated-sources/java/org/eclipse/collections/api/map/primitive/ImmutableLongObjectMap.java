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
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.LongObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableLongObjectMap<V> extends LongObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableLongObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableLongObjectMap<V> select(LongObjectPredicate<? super V> predicate);

    @Override
    ImmutableLongObjectMap<V> reject(LongObjectPredicate<? super V> predicate);

    ImmutableLongObjectMap<V> newWithKeyValue(long key, V value);

    ImmutableLongObjectMap<V> newWithoutKey(long key);

    ImmutableLongObjectMap<V> newWithoutAllKeys(LongIterable keys);

    @Override
    ImmutableObjectLongMap<V> flipUniqueValues();
}
