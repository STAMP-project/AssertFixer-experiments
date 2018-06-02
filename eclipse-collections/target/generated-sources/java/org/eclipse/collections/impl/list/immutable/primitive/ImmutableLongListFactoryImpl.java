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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.factory.list.primitive.ImmutableLongListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import java.util.stream.LongStream;

/**
 * ImmutableLongListFactoryImpl is a factory implementation which creates instances of type {@link ImmutableLongList}.
 * This file was automatically generated from template file immutablePrimitiveListFactoryImpl.stg.
 *
 * @since 3.2.
 */
public enum ImmutableLongListFactoryImpl implements ImmutableLongListFactory
{
    INSTANCE;

    @Override
    public ImmutableLongList empty()
    {
        return ImmutableLongEmptyList.INSTANCE;
    }

    @Override
    public ImmutableLongList of()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongList with()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongList of(long one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableLongList with(long one)
    {
        return new ImmutableLongSingletonList(one);
    }

    @Override
    public ImmutableLongList of(long... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableLongList with(long... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableLongArrayList.newListWith(items);
    }

    @Override
    public ImmutableLongList ofAll(LongIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableLongList withAll(LongIterable items)
    {
        if (items instanceof ImmutableLongList)
        {
            return (ImmutableLongList) items;
        }
        return this.with(items.toArray());
    }

    /**
     * @since 9.0
     */
    @Override
    public ImmutableLongList ofAll(LongStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public ImmutableLongList withAll(LongStream items)
    {
        return this.with(items.toArray());
    }
}
