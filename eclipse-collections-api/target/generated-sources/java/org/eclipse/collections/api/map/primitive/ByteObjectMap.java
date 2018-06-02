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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.ByteObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ByteObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(byte key);

    V getIfAbsent(byte key, Function0<? extends V> ifAbsent);

    boolean containsKey(byte key);

    @Override
    ByteObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(ByteProcedure procedure);

    void forEachKeyValue(ByteObjectProcedure<? super V> procedure);

    ByteObjectMap<V> select(ByteObjectPredicate<? super V> predicate);

    ByteObjectMap<V> reject(ByteObjectPredicate<? super V> predicate);

    ImmutableByteObjectMap<V> toImmutable();

    MutableByteSet keySet();

    /**
     * @since 5.0
     */
    LazyByteIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ByteObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectByteMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectByteMap contains duplicate values.
     * @since 9.0
     */
     ObjectByteMap<V> flipUniqueValues();
}
