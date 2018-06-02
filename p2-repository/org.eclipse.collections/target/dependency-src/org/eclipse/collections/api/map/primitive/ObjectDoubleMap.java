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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectDoublePredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectDoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectDoublePair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectDoubleMap<K> extends DoubleIterable
{
    double get(Object key);

    double getOrThrow(Object key);

    double getIfAbsent(Object key, double ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(double value);

    void forEachValue(DoubleProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectDoubleProcedure<? super K> procedure);
    /**
     * Return the DoubleObjectMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the DoubleObjectMap contains duplicate values.
     * @since 9.0
     */
    DoubleObjectMap<K> flipUniqueValues();

    ObjectDoubleMap<K> select(ObjectDoublePredicate<? super K> predicate);

    ObjectDoubleMap<K> reject(ObjectDoublePredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectDoubleMap<K> tap(DoubleProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectDoubleMap
     */
    String toString();

    ImmutableObjectDoubleMap<K> toImmutable();

    Set<K> keySet();

    MutableDoubleCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectDoublePair<K>> keyValuesView();
}
