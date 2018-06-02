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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.primitive.ImmutableDoubleCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableDoubleSet extends ImmutableDoubleCollection, DoubleSet
{
    @Override
    ImmutableDoubleSet select(DoublePredicate predicate);

    @Override
    ImmutableDoubleSet reject(DoublePredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableDoubleSet tap(DoubleProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(DoubleToObjectFunction<? extends V> function);

    @Override
    ImmutableDoubleSet newWith(double element);

    @Override
    ImmutableDoubleSet newWithout(double element);

    @Override
    ImmutableDoubleSet newWithAll(DoubleIterable elements);

    @Override
    ImmutableDoubleSet newWithoutAll(DoubleIterable elements);
}
