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
import org.eclipse.collections.api.collection.primitive.ImmutableIntCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableIntSet extends ImmutableIntCollection, IntSet
{
    @Override
    ImmutableIntSet select(IntPredicate predicate);

    @Override
    ImmutableIntSet reject(IntPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableIntSet tap(IntProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(IntToObjectFunction<? extends V> function);

    @Override
    ImmutableIntSet newWith(int element);

    @Override
    ImmutableIntSet newWithout(int element);

    @Override
    ImmutableIntSet newWithAll(IntIterable elements);

    @Override
    ImmutableIntSet newWithoutAll(IntIterable elements);
}
