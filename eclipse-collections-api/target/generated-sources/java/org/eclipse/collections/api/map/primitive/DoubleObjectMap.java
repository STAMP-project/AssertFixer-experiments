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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.DoubleObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface DoubleObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(double key);

    V getIfAbsent(double key, Function0<? extends V> ifAbsent);

    boolean containsKey(double key);

    @Override
    DoubleObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(DoubleProcedure procedure);

    void forEachKeyValue(DoubleObjectProcedure<? super V> procedure);

    DoubleObjectMap<V> select(DoubleObjectPredicate<? super V> predicate);

    DoubleObjectMap<V> reject(DoubleObjectPredicate<? super V> predicate);

    ImmutableDoubleObjectMap<V> toImmutable();

    MutableDoubleSet keySet();

    /**
     * @since 5.0
     */
    LazyDoubleIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<DoubleObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectDoubleMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectDoubleMap contains duplicate values.
     * @since 9.0
     */
     ObjectDoubleMap<V> flipUniqueValues();
}
