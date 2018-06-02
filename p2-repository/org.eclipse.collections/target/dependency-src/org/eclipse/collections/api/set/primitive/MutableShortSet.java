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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.set.MutableSet;

/**
 * This file was automatically generated from template file mutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface MutableShortSet extends MutableShortCollection, ShortSet
{
    @Override
    MutableShortSet select(ShortPredicate predicate);

    @Override
    MutableShortSet reject(ShortPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default MutableShortSet tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableSet<V> collect(ShortToObjectFunction<? extends V> function);

    @Override
    MutableShortSet with(short element);

    @Override
    MutableShortSet without(short element);

    @Override
    MutableShortSet withAll(ShortIterable elements);

    @Override
    MutableShortSet withoutAll(ShortIterable elements);

    @Override
    MutableShortSet asUnmodifiable();

    @Override
    MutableShortSet asSynchronized();

    /**
     * Returns a frozen copy of this set. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    @Override
    ShortSet freeze();

    /**
     * Returns an immutable copy of this set.
     */
    @Override
    ImmutableShortSet toImmutable();

    /**
     * Creates a new empty mutable version of the same Set type.
     *
     * @since 9.2.
     */
    default MutableShortSet newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
