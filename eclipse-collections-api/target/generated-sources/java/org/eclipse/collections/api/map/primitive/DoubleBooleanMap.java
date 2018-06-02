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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.DoubleBooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleBooleanProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleBooleanPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface DoubleBooleanMap extends BooleanValuesMap
{
    boolean get(double key);

    boolean getIfAbsent(double key, boolean ifAbsent);

    boolean getOrThrow(double key);

    boolean containsKey(double key);

    void forEachKey(DoubleProcedure procedure);

    void forEachKeyValue(DoubleBooleanProcedure procedure);

    LazyDoubleIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<DoubleBooleanPair> keyValuesView();

    DoubleBooleanMap select(DoubleBooleanPredicate predicate);

    DoubleBooleanMap reject(DoubleBooleanPredicate predicate);

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
     * @return a string representation of this DoubleBooleanMap
     */
    @Override
    String toString();

    ImmutableDoubleBooleanMap toImmutable();

    MutableDoubleSet keySet();
}
