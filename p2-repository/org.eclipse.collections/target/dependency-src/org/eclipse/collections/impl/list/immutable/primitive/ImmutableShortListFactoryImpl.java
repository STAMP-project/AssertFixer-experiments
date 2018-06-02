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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.factory.list.primitive.ImmutableShortListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableShortList;

/**
 * ImmutableShortListFactoryImpl is a factory implementation which creates instances of type {@link ImmutableShortList}.
 * This file was automatically generated from template file immutablePrimitiveListFactoryImpl.stg.
 *
 * @since 3.2.
 */
public enum ImmutableShortListFactoryImpl implements ImmutableShortListFactory
{
    INSTANCE;

    @Override
    public ImmutableShortList empty()
    {
        return ImmutableShortEmptyList.INSTANCE;
    }

    @Override
    public ImmutableShortList of()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortList with()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortList of(short one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableShortList with(short one)
    {
        return new ImmutableShortSingletonList(one);
    }

    @Override
    public ImmutableShortList of(short... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableShortList with(short... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableShortArrayList.newListWith(items);
    }

    @Override
    public ImmutableShortList ofAll(ShortIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableShortList withAll(ShortIterable items)
    {
        if (items instanceof ImmutableShortList)
        {
            return (ImmutableShortList) items;
        }
        return this.with(items.toArray());
    }
}
