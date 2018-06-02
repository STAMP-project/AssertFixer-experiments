/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.factory.list.primitive.ImmutableIntListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import java.util.stream.IntStream;

/**
 * ImmutableIntListFactoryImpl is a factory implementation which creates instances of type {@link ImmutableIntList}.
 * This file was automatically generated from template file immutablePrimitiveListFactoryImpl.stg.
 *
 * @since 3.2.
 */
public enum ImmutableIntListFactoryImpl implements ImmutableIntListFactory
{
    INSTANCE;

    @Override
    public ImmutableIntList empty()
    {
        return ImmutableIntEmptyList.INSTANCE;
    }

    @Override
    public ImmutableIntList of()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntList with()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntList of(int one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableIntList with(int one)
    {
        return new ImmutableIntSingletonList(one);
    }

    @Override
    public ImmutableIntList of(int... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableIntList with(int... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableIntArrayList.newListWith(items);
    }

    @Override
    public ImmutableIntList ofAll(IntIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableIntList withAll(IntIterable items)
    {
        if (items instanceof ImmutableIntList)
        {
            return (ImmutableIntList) items;
        }
        return this.with(items.toArray());
    }

    /**
     * @since 9.0
     */
    @Override
    public ImmutableIntList ofAll(IntStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public ImmutableIntList withAll(IntStream items)
    {
        return this.with(items.toArray());
    }
}
