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

import java.util.Map;

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ByteBooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteBooleanProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.tuple.primitive.ByteBooleanPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ByteBooleanMap extends BooleanValuesMap
{
    boolean get(byte key);

    boolean getIfAbsent(byte key, boolean ifAbsent);

    boolean getOrThrow(byte key);

    boolean containsKey(byte key);

    void forEachKey(ByteProcedure procedure);

    void forEachKeyValue(ByteBooleanProcedure procedure);

    LazyByteIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ByteBooleanPair> keyValuesView();

    ByteBooleanMap select(ByteBooleanPredicate predicate);

    ByteBooleanMap reject(ByteBooleanPredicate predicate);

    /**
     * Follows the same general contract as {@link Map#equals(Object)}.
     */
    @Override
    boolean equals(Object o);

    /**
     * Follows the same general contract as {@link Map#hashCode()}.
     */
    @Override
    int hashCode();

    /**
     * Follows the same general contract as {@link java.util.AbstractMap#toString()}
     *
     * @return a string representation of this ByteBooleanMap
     */
    @Override
    String toString();

    ImmutableByteBooleanMap toImmutable();

    MutableByteSet keySet();
}
