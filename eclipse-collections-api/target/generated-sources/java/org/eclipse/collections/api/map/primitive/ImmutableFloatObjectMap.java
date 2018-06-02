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
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.FloatObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableFloatObjectMap<V> extends FloatObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableFloatObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableFloatObjectMap<V> select(FloatObjectPredicate<? super V> predicate);

    @Override
    ImmutableFloatObjectMap<V> reject(FloatObjectPredicate<? super V> predicate);

    ImmutableFloatObjectMap<V> newWithKeyValue(float key, V value);

    ImmutableFloatObjectMap<V> newWithoutKey(float key);

    ImmutableFloatObjectMap<V> newWithoutAllKeys(FloatIterable keys);

    @Override
    ImmutableObjectFloatMap<V> flipUniqueValues();
}
