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
import org.eclipse.collections.api.collection.primitive.ImmutableShortCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableShortSet extends ImmutableShortCollection, ShortSet
{
    @Override
    ImmutableShortSet select(ShortPredicate predicate);

    @Override
    ImmutableShortSet reject(ShortPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableShortSet tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(ShortToObjectFunction<? extends V> function);

    @Override
    ImmutableShortSet newWith(short element);

    @Override
    ImmutableShortSet newWithout(short element);

    @Override
    ImmutableShortSet newWithAll(ShortIterable elements);

    @Override
    ImmutableShortSet newWithoutAll(ShortIterable elements);
}
