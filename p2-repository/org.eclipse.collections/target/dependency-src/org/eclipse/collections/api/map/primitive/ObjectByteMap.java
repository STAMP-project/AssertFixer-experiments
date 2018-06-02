/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import java.util.Set;

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectBytePredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectByteProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectBytePair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectByteMap<K> extends ByteIterable
{
    byte get(Object key);

    byte getOrThrow(Object key);

    byte getIfAbsent(Object key, byte ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(byte value);

    void forEachValue(ByteProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectByteProcedure<? super K> procedure);
    /**
     * Return the ByteObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ByteObjectMap contains duplicate values.
     * @since 9.0
     */
    ByteObjectMap<K> flipUniqueValues();

    ObjectByteMap<K> select(ObjectBytePredicate<? super K> predicate);

    ObjectByteMap<K> reject(ObjectBytePredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectByteMap<K> tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectByteMap
     */
    String toString();

    ImmutableObjectByteMap<K> toImmutable();

    Set<K> keySet();

    MutableByteCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectBytePair<K>> keyValuesView();
}
