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
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.DoubleObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableDoubleObjectMap<V> extends DoubleObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableDoubleObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableDoubleObjectMap<V> select(DoubleObjectPredicate<? super V> predicate);

    @Override
    ImmutableDoubleObjectMap<V> reject(DoubleObjectPredicate<? super V> predicate);

    ImmutableDoubleObjectMap<V> newWithKeyValue(double key, V value);

    ImmutableDoubleObjectMap<V> newWithoutKey(double key);

    ImmutableDoubleObjectMap<V> newWithoutAllKeys(DoubleIterable keys);

    @Override
    ImmutableObjectDoubleMap<V> flipUniqueValues();
}
