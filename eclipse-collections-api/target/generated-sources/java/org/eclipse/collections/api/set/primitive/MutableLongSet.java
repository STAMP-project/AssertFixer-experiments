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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.set.MutableSet;

/**
 * This file was automatically generated from template file mutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface MutableLongSet extends MutableLongCollection, LongSet
{
    @Override
    MutableLongSet select(LongPredicate predicate);

    @Override
    MutableLongSet reject(LongPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default MutableLongSet tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableSet<V> collect(LongToObjectFunction<? extends V> function);

    @Override
    MutableLongSet with(long element);

    @Override
    MutableLongSet without(long element);

    @Override
    MutableLongSet withAll(LongIterable elements);

    @Override
    MutableLongSet withoutAll(LongIterable elements);

    @Override
    MutableLongSet asUnmodifiable();

    @Override
    MutableLongSet asSynchronized();

    /**
     * Returns a frozen copy of this set. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    @Override
    LongSet freeze();

    /**
     * Returns an immutable copy of this set.
     */
    @Override
    ImmutableLongSet toImmutable();

    /**
     * Creates a new empty mutable version of the same Set type.
     *
     * @since 9.2.
     */
    default MutableLongSet newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
