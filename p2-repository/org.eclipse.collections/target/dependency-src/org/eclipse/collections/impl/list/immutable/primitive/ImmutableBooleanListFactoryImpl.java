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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.factory.list.primitive.ImmutableBooleanListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableBooleanList;

/**
 * ImmutableBooleanListFactoryImpl is a factory implementation which creates instances of type {@link ImmutableBooleanList}.
 * This file was automatically generated from template file immutablePrimitiveListFactoryImpl.stg.
 *
 * @since 3.2.
 */
public enum ImmutableBooleanListFactoryImpl implements ImmutableBooleanListFactory
{
    INSTANCE;

    @Override
    public ImmutableBooleanList empty()
    {
        return ImmutableBooleanEmptyList.INSTANCE;
    }

    @Override
    public ImmutableBooleanList of()
    {
        return this.empty();
    }

    @Override
    public ImmutableBooleanList with()
    {
        return this.empty();
    }

    @Override
    public ImmutableBooleanList of(boolean one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableBooleanList with(boolean one)
    {
        return new ImmutableBooleanSingletonList(one);
    }

    @Override
    public ImmutableBooleanList of(boolean... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableBooleanList with(boolean... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableBooleanArrayList.newListWith(items);
    }

    @Override
    public ImmutableBooleanList ofAll(BooleanIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableBooleanList withAll(BooleanIterable items)
    {
        if (items instanceof ImmutableBooleanList)
        {
            return (ImmutableBooleanList) items;
        }
        return this.with(items.toArray());
    }
}
