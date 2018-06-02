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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.LongObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.LongObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface LongObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(long key);

    V getIfAbsent(long key, Function0<? extends V> ifAbsent);

    boolean containsKey(long key);

    @Override
    LongObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(LongProcedure procedure);

    void forEachKeyValue(LongObjectProcedure<? super V> procedure);

    LongObjectMap<V> select(LongObjectPredicate<? super V> predicate);

    LongObjectMap<V> reject(LongObjectPredicate<? super V> predicate);

    ImmutableLongObjectMap<V> toImmutable();

    MutableLongSet keySet();

    /**
     * @since 5.0
     */
    LazyLongIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<LongObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectLongMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectLongMap contains duplicate values.
     * @since 9.0
     */
     ObjectLongMap<V> flipUniqueValues();
}
