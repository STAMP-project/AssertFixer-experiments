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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.ShortObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ShortObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(short key);

    V getIfAbsent(short key, Function0<? extends V> ifAbsent);

    boolean containsKey(short key);

    @Override
    ShortObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(ShortProcedure procedure);

    void forEachKeyValue(ShortObjectProcedure<? super V> procedure);

    ShortObjectMap<V> select(ShortObjectPredicate<? super V> predicate);

    ShortObjectMap<V> reject(ShortObjectPredicate<? super V> predicate);

    ImmutableShortObjectMap<V> toImmutable();

    MutableShortSet keySet();

    /**
     * @since 5.0
     */
    LazyShortIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ShortObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectShortMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectShortMap contains duplicate values.
     * @since 9.0
     */
     ObjectShortMap<V> flipUniqueValues();
}
