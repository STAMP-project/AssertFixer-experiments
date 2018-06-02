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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.FloatBooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatBooleanProcedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatBooleanPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface FloatBooleanMap extends BooleanValuesMap
{
    boolean get(float key);

    boolean getIfAbsent(float key, boolean ifAbsent);

    boolean getOrThrow(float key);

    boolean containsKey(float key);

    void forEachKey(FloatProcedure procedure);

    void forEachKeyValue(FloatBooleanProcedure procedure);

    LazyFloatIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<FloatBooleanPair> keyValuesView();

    FloatBooleanMap select(FloatBooleanPredicate predicate);

    FloatBooleanMap reject(FloatBooleanPredicate predicate);

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
     * @return a string representation of this FloatBooleanMap
     */
    @Override
    String toString();

    ImmutableFloatBooleanMap toImmutable();

    MutableFloatSet keySet();
}
