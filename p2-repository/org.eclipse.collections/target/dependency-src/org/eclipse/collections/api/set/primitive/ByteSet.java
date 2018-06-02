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

import java.util.Set;

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.set.SetIterable;

/**
 * This file was automatically generated from template file primitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ByteSet extends ByteIterable
{
    /**
     * @since 9.0.
     */
    @Override
    default ByteSet tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Follows the same general contract as {@link Set#equals(Object)}.
     */
    @Override
    boolean equals(Object o);

    /**
     * Follows the same general contract as {@link Set#hashCode()}.
     */
    @Override
    int hashCode();

    @Override
    ByteSet select(BytePredicate predicate);

    @Override
    ByteSet reject(BytePredicate predicate);

    @Override
    <V> SetIterable<V> collect(ByteToObjectFunction<? extends V> function);

    /**
     * Returns a frozen copy of this set. If the set is frozen, it returns itself. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    ByteSet freeze();

    /**
     * Returns an immutable copy of this set. If the set is immutable, it returns itself.
     */
    ImmutableByteSet toImmutable();
}
