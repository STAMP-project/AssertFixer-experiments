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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableIntListFactory;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import java.util.stream.IntStream;

/**
 * MutableIntListFactoryImpl is a factory implementation which creates instances of type {@link MutableIntList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableIntListFactoryImpl implements MutableIntListFactory
{
    INSTANCE;

    @Override
    public MutableIntList empty()
    {
        return new IntArrayList();
    }

    @Override
    public MutableIntList of()
    {
        return this.empty();
    }

    @Override
    public MutableIntList with()
    {
        return this.empty();
    }

    @Override
    public MutableIntList of(int... items)
    {
        return this.with(items);
    }

    @Override
    public MutableIntList with(int... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return IntArrayList.newListWith(items);
    }

    @Override
    public MutableIntList ofAll(IntIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableIntList withAll(IntIterable items)
    {
        return IntArrayList.newList(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableIntList ofAll(IntStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableIntList withAll(IntStream items)
    {
        return this.with(items.toArray());
    }
}
