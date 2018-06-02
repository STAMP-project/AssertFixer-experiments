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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.IntObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.IntObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.IntObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface IntObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(int key);

    V getIfAbsent(int key, Function0<? extends V> ifAbsent);

    boolean containsKey(int key);

    @Override
    IntObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(IntProcedure procedure);

    void forEachKeyValue(IntObjectProcedure<? super V> procedure);

    IntObjectMap<V> select(IntObjectPredicate<? super V> predicate);

    IntObjectMap<V> reject(IntObjectPredicate<? super V> predicate);

    ImmutableIntObjectMap<V> toImmutable();

    MutableIntSet keySet();

    /**
     * @since 5.0
     */
    LazyIntIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<IntObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectIntMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectIntMap contains duplicate values.
     * @since 9.0
     */
     ObjectIntMap<V> flipUniqueValues();
}
