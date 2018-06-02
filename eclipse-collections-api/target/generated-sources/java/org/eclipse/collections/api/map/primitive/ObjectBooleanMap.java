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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ObjectBooleanPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectBooleanProcedure;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.tuple.primitive.ObjectBooleanPair;

/**
 * This file was automatically generated from template file objectPrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ObjectBooleanMap<K> extends BooleanIterable
{
    boolean get(Object key);

    boolean getOrThrow(Object key);

    boolean getIfAbsent(Object key, boolean ifAbsent);

    boolean containsKey(Object key);

    boolean containsValue(boolean value);

    void forEachValue(BooleanProcedure procedure);

    void forEachKey(Procedure<? super K> procedure);

    void forEachKeyValue(ObjectBooleanProcedure<? super K> procedure);

    ObjectBooleanMap<K> select(ObjectBooleanPredicate<? super K> predicate);

    ObjectBooleanMap<K> reject(ObjectBooleanPredicate<? super K> predicate);

    /**
     * @since 9.0.
     */
    default ObjectBooleanMap<K> tap(BooleanProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ObjectBooleanMap
     */
    String toString();

    ImmutableObjectBooleanMap<K> toImmutable();

    Set<K> keySet();

    MutableBooleanCollection values();

    /**
     * @since 5.0
     */
    LazyIterable<K> keysView();

    /**
     * @since 5.0
     */
    RichIterable<ObjectBooleanPair<K>> keyValuesView();
}
