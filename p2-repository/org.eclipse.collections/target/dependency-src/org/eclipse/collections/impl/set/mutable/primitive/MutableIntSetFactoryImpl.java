/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.factory.set.primitive.MutableIntSetFactory;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import java.util.stream.IntStream;

/**
 * MutableIntSetFactoryImpl is a factory implementation which creates instances of type {@link MutableIntSet}.
 * This file was automatically generated from template file mutablePrimitiveSetFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableIntSetFactoryImpl implements MutableIntSetFactory
{
    INSTANCE;

    @Override
    public MutableIntSet empty()
    {
        return new IntHashSet();
    }

    @Override
    public MutableIntSet of()
    {
        return this.empty();
    }

    @Override
    public MutableIntSet with()
    {
        return this.empty();
    }

    @Override
    public MutableIntSet of(int... items)
    {
        return this.with(items);
    }

    @Override
    public MutableIntSet with(int... items)
    {
        if (items == null || items.length == 0)
        {
            return this.empty();
        }
        return IntHashSet.newSetWith(items);
    }

    @Override
    public MutableIntSet ofAll(IntIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableIntSet withAll(IntIterable items)
    {
        return IntHashSet.newSet(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableIntSet ofAll(IntStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableIntSet withAll(IntStream items)
    {
        return this.with(items.toArray());
    }
}
