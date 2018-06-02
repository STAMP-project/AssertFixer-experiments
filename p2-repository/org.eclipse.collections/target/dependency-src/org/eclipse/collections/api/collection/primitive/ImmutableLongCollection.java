/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.collection.primitive;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.collection.ImmutableCollection;

/**
 * This file was automatically generated from template file immutablePrimitiveCollection.stg.
 *
 * @since 3.0.
 */
public interface ImmutableLongCollection extends LongIterable
{
    @Override
    <V> ImmutableCollection<V> collect(LongToObjectFunction<? extends V> function);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableLongCollection tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    ImmutableLongCollection select(LongPredicate predicate);

    @Override
    ImmutableLongCollection reject(LongPredicate predicate);

    ImmutableLongCollection newWith(long element);

    ImmutableLongCollection newWithout(long element);

    ImmutableLongCollection newWithAll(LongIterable elements);

    ImmutableLongCollection newWithoutAll(LongIterable elements);
}
