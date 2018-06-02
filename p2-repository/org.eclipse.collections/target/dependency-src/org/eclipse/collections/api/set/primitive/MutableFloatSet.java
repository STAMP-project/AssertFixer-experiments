/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.set.primitive;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.set.MutableSet;

/**
 * This file was automatically generated from template file mutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface MutableFloatSet extends MutableFloatCollection, FloatSet
{
    @Override
    MutableFloatSet select(FloatPredicate predicate);

    @Override
    MutableFloatSet reject(FloatPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default MutableFloatSet tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableSet<V> collect(FloatToObjectFunction<? extends V> function);

    @Override
    MutableFloatSet with(float element);

    @Override
    MutableFloatSet without(float element);

    @Override
    MutableFloatSet withAll(FloatIterable elements);

    @Override
    MutableFloatSet withoutAll(FloatIterable elements);

    @Override
    MutableFloatSet asUnmodifiable();

    @Override
    MutableFloatSet asSynchronized();

    /**
     * Returns a frozen copy of this set. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    @Override
    FloatSet freeze();

    /**
     * Returns an immutable copy of this set.
     */
    @Override
    ImmutableFloatSet toImmutable();

    /**
     * Creates a new empty mutable version of the same Set type.
     *
     * @since 9.2.
     */
    default MutableFloatSet newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
