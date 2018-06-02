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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.collection.primitive.ImmutableFloatCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableFloatSet extends ImmutableFloatCollection, FloatSet
{
    @Override
    ImmutableFloatSet select(FloatPredicate predicate);

    @Override
    ImmutableFloatSet reject(FloatPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableFloatSet tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(FloatToObjectFunction<? extends V> function);

    @Override
    ImmutableFloatSet newWith(float element);

    @Override
    ImmutableFloatSet newWithout(float element);

    @Override
    ImmutableFloatSet newWithAll(FloatIterable elements);

    @Override
    ImmutableFloatSet newWithoutAll(FloatIterable elements);
}
