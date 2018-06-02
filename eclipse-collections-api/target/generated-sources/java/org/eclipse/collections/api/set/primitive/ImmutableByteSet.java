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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.primitive.ImmutableByteCollection;
import org.eclipse.collections.api.set.ImmutableSet;

/**
 * This file was automatically generated from template file immutablePrimitiveSet.stg.
 *
 * @since 3.0.
 */
public interface ImmutableByteSet extends ImmutableByteCollection, ByteSet
{
    @Override
    ImmutableByteSet select(BytePredicate predicate);

    @Override
    ImmutableByteSet reject(BytePredicate predicate);

    /**
     * @since 9.0.
     */
    @Override
    default ImmutableByteSet tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> ImmutableSet<V> collect(ByteToObjectFunction<? extends V> function);

    @Override
    ImmutableByteSet newWith(byte element);

    @Override
    ImmutableByteSet newWithout(byte element);

    @Override
    ImmutableByteSet newWithAll(ByteIterable elements);

    @Override
    ImmutableByteSet newWithoutAll(ByteIterable elements);
}
