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
import org.eclipse.collections.api.collection.primitive.ImmutableBooleanCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableBooleanSet extends ImmutableBooleanCollection, BooleanSet
{
    @Override
    ImmutableBooleanSet select(BooleanPredicate predicate);

    @Override
    ImmutableBooleanSet reject(BooleanPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableBooleanSet tap(BooleanProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(BooleanToObjectFunction<? extends V> function);

    @Override
    ImmutableBooleanSet newWith(boolean element);

    @Override
    ImmutableBooleanSet newWithout(boolean element);

    @Override
    ImmutableBooleanSet newWithAll(BooleanIterable elements);

    @Override
    ImmutableBooleanSet newWithoutAll(BooleanIterable elements);
}
