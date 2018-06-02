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
import org.eclipse.collections.api.collection.primitive.ImmutableLongCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableLongSet extends ImmutableLongCollection, LongSet
{
    @Override
    ImmutableLongSet select(LongPredicate predicate);

    @Override
    ImmutableLongSet reject(LongPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableLongSet tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(LongToObjectFunction<? extends V> function);

    @Override
    ImmutableLongSet newWith(long element);

    @Override
    ImmutableLongSet newWithout(long element);

    @Override
    ImmutableLongSet newWithAll(LongIterable elements);

    @Override
    ImmutableLongSet newWithoutAll(LongIterable elements);
}
