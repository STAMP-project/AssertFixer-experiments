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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.ShortBooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortBooleanProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.ShortBooleanPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface ShortBooleanMap extends BooleanValuesMap
{
    boolean get(short key);

    boolean getIfAbsent(short key, boolean ifAbsent);

    boolean getOrThrow(short key);

    boolean containsKey(short key);

    void forEachKey(ShortProcedure procedure);

    void forEachKeyValue(ShortBooleanProcedure procedure);

    LazyShortIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<ShortBooleanPair> keyValuesView();

    ShortBooleanMap select(ShortBooleanPredicate predicate);

    ShortBooleanMap reject(ShortBooleanPredicate predicate);

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
     * @return a string representation of this ShortBooleanMap
     */
    @Override
    String toString();

    ImmutableShortBooleanMap toImmutable();

    MutableShortSet keySet();
}
