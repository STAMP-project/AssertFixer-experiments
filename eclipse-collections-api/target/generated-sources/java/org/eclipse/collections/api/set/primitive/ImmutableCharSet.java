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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.collection.primitive.ImmutableCharCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableCharSet extends ImmutableCharCollection, CharSet
{
    @Override
    ImmutableCharSet select(CharPredicate predicate);

    @Override
    ImmutableCharSet reject(CharPredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableCharSet tap(CharProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(CharToObjectFunction<? extends V> function);

    @Override
    ImmutableCharSet newWith(char element);

    @Override
    ImmutableCharSet newWithout(char element);

    @Override
    ImmutableCharSet newWithAll(CharIterable elements);

    @Override
    ImmutableCharSet newWithoutAll(CharIterable elements);
}
