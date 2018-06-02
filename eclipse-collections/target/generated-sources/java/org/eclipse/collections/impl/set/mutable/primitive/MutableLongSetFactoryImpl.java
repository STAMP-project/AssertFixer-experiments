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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.factory.set.primitive.MutableLongSetFactory;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import java.util.stream.LongStream;

/**
 * MutableLongSetFactoryImpl is a factory implementation which creates instances of type {@link MutableLongSet}.
 * This file was automatically generated from template file mutablePrimitiveSetFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongSetFactoryImpl implements MutableLongSetFactory
{
    INSTANCE;

    @Override
    public MutableLongSet empty()
    {
        return new LongHashSet();
    }

    @Override
    public MutableLongSet of()
    {
        return this.empty();
    }

    @Override
    public MutableLongSet with()
    {
        return this.empty();
    }

    @Override
    public MutableLongSet of(long... items)
    {
        return this.with(items);
    }

    @Override
    public MutableLongSet with(long... items)
    {
        if (items == null || items.length == 0)
        {
            return this.empty();
        }
        return LongHashSet.newSetWith(items);
    }

    @Override
    public MutableLongSet ofAll(LongIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableLongSet withAll(LongIterable items)
    {
        return LongHashSet.newSet(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongSet ofAll(LongStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongSet withAll(LongStream items)
    {
        return this.with(items.toArray());
    }
}
