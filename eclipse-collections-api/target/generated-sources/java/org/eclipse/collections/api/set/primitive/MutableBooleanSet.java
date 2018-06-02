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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.set.MutableSet;

/**
 * This file was automatically generated from template file mutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface MutableBooleanSet extends MutableBooleanCollection, BooleanSet
{
    @Override
    MutableBooleanSet select(BooleanPredicate predicate);

    @Override
    MutableBooleanSet reject(BooleanPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default MutableBooleanSet tap(BooleanProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableSet<V> collect(BooleanToObjectFunction<? extends V> function);

    @Override
    MutableBooleanSet with(boolean element);

    @Override
    MutableBooleanSet without(boolean element);

    @Override
    MutableBooleanSet withAll(BooleanIterable elements);

    @Override
    MutableBooleanSet withoutAll(BooleanIterable elements);

    @Override
    MutableBooleanSet asUnmodifiable();

    @Override
    MutableBooleanSet asSynchronized();

    /**
     * Returns a frozen copy of this set. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    @Override
    BooleanSet freeze();

    /**
     * Returns an immutable copy of this set.
     */
    @Override
    ImmutableBooleanSet toImmutable();

    /**
     * Creates a new empty mutable version of the same Set type.
     *
     * @since 9.2.
     */
    default MutableBooleanSet newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
