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
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.ShortObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableShortObjectMap<V> extends ShortObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableShortObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableShortObjectMap<V> select(ShortObjectPredicate<? super V> predicate);

    @Override
    ImmutableShortObjectMap<V> reject(ShortObjectPredicate<? super V> predicate);

    ImmutableShortObjectMap<V> newWithKeyValue(short key, V value);

    ImmutableShortObjectMap<V> newWithoutKey(short key);

    ImmutableShortObjectMap<V> newWithoutAllKeys(ShortIterable keys);

    @Override
    ImmutableObjectShortMap<V> flipUniqueValues();
}
