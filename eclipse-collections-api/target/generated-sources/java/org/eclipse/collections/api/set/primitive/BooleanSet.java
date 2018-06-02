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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.set.SetIterable;

/**
 * This file was automatically generated from template file primitiveSet.stg.
 *
 * @since 3.0.
 */
public interface BooleanSet extends BooleanIterable
{
    /**
     * @since 9.0.
     */
    @Override
    default BooleanSet tap(BooleanProcedure procedure)
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
    BooleanSet select(BooleanPredicate predicate);

    @Override
    BooleanSet reject(BooleanPredicate predicate);

    @Override
    <V> SetIterable<V> collect(BooleanToObjectFunction<? extends V> function);

    /**
     * Returns a frozen copy of this set. If the set is frozen, it returns itself. A frozen copy is the same thing as an immutable copy without safe-publish guarantees.
     */
    BooleanSet freeze();

    /**
     * Returns an immutable copy of this set. If the set is immutable, it returns itself.
     */
    ImmutableBooleanSet toImmutable();
}
