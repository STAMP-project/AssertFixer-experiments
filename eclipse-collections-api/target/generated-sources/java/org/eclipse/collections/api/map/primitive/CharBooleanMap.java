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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.predicate.primitive.CharBooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharBooleanProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.CharBooleanPair;

/**
 * This file was automatically generated from template file primitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface CharBooleanMap extends BooleanValuesMap
{
    boolean get(char key);

    boolean getIfAbsent(char key, boolean ifAbsent);

    boolean getOrThrow(char key);

    boolean containsKey(char key);

    void forEachKey(CharProcedure procedure);

    void forEachKeyValue(CharBooleanProcedure procedure);

    LazyCharIterable keysView();

    /**
     * @since 5.0
     */
    RichIterable<CharBooleanPair> keyValuesView();

    CharBooleanMap select(CharBooleanPredicate predicate);

    CharBooleanMap reject(CharBooleanPredicate predicate);

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
     * @return a string representation of this CharBooleanMap
     */
    @Override
    String toString();

    ImmutableCharBooleanMap toImmutable();

    MutableCharSet keySet();
}
