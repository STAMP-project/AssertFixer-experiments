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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.set.MutableSet;

/**
 * This file was automatically generated from template file mutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface MutableByteSet extends MutableByteCollection, ByteSet
{
    @Override
    MutableByteSet select(BytePredicate predicate);

    @Override
    MutableByteSet reject(BytePredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default MutableByteSet tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> MutableSet<V> collect(ByteToObjectFunction<? extends V> function);

    @Override
    MutableByteSet with(byte element);

    @Override
    MutableByteSet without(byte element);

    @Override
    MutableByteSet withAll(ByteIterable elements);

    @Override
    MutableByteSet withoutAll(ByteIterable elements);

    @Override
    MutableByteSet asUnmodifiable();

    @Override
    MutableByteSet asSynchronized();

    /**
     * Returns a frozen copy of this set. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    @Override
    ByteSet freeze();

    /**
     * Returns an immutable copy of this set.
     */
    @Override
    ImmutableByteSet toImmutable();

    /**
     * Creates a new empty mutable version of the same Set type.
     *
     * @since 9.2.
     */
    default MutableByteSet newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
