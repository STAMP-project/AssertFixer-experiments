/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableLongListFactory;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import java.util.stream.LongStream;

/**
 * MutableLongListFactoryImpl is a factory implementation which creates instances of type {@link MutableLongList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongListFactoryImpl implements MutableLongListFactory
{
    INSTANCE;

    @Override
    public MutableLongList empty()
    {
        return new LongArrayList();
    }

    @Override
    public MutableLongList of()
    {
        return this.empty();
    }

    @Override
    public MutableLongList with()
    {
        return this.empty();
    }

    @Override
    public MutableLongList of(long... items)
    {
        return this.with(items);
    }

    @Override
    public MutableLongList with(long... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return LongArrayList.newListWith(items);
    }

    @Override
    public MutableLongList ofAll(LongIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableLongList withAll(LongIterable items)
    {
        return LongArrayList.newList(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongList ofAll(LongStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongList withAll(LongStream items)
    {
        return this.with(items.toArray());
    }
}
