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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.set.MutableSet;

/**
 * This file was automatically generated from template file mutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface MutableIntSet extends MutableIntCollection, IntSet
{
    @Override
    MutableIntSet select(IntPredicate predicate);

    @Override
    MutableIntSet reject(IntPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default MutableIntSet tap(IntProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableSet<V> collect(IntToObjectFunction<? extends V> function);

    @Override
    MutableIntSet with(int element);

    @Override
    MutableIntSet without(int element);

    @Override
    MutableIntSet withAll(IntIterable elements);

    @Override
    MutableIntSet withoutAll(IntIterable elements);

    @Override
    MutableIntSet asUnmodifiable();

    @Override
    MutableIntSet asSynchronized();

    /**
     * Returns a frozen copy of this set. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    @Override
    IntSet freeze();

    /**
     * Returns an immutable copy of this set.
     */
    @Override
    ImmutableIntSet toImmutable();

    /**
     * Creates a new empty mutable version of the same Set type.
     *
     * @since 9.2.
     */
    default MutableIntSet newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
