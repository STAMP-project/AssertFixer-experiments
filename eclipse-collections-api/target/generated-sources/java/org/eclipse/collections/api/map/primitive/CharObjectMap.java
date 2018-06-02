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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.predicate.primitive.CharObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.primitive.CharObjectProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;

/**
 * This file was automatically generated from template file primitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface CharObjectMap<V> extends PrimitiveObjectMap<V>
{
    V get(char key);

    V getIfAbsent(char key, Function0<? extends V> ifAbsent);

    boolean containsKey(char key);

    @Override
    CharObjectMap<V> tap(Procedure<? super V> procedure);

    void forEachKey(CharProcedure procedure);

    void forEachKeyValue(CharObjectProcedure<? super V> procedure);

    CharObjectMap<V> select(CharObjectPredicate<? super V> predicate);

    CharObjectMap<V> reject(CharObjectPredicate<? super V> predicate);

    ImmutableCharObjectMap<V> toImmutable();

    MutableCharSet keySet();

    /**
     * @since 5.0
     */
    LazyCharIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<CharObjectPair<V>> keyValuesView();

    /**
     * Return the ObjectCharMap that is obtained by flipping the direction of this map and making the associations
     * from value to key.
     *
     * @throws IllegalStateException if the ObjectCharMap contains duplicate values.
     * @since 9.0
     */
     ObjectCharMap<V> flipUniqueValues();
}
