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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.factory.list.primitive.ImmutableByteListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;

/**
 * ImmutableByteListFactoryImpl is a factory implementation which creates instances of type {@link ImmutableByteList}.
 * This file was automatically generated from template file immutablePrimitiveListFactoryImpl.stg.
 *
 * @since 3.2.
 */
public enum ImmutableByteListFactoryImpl implements ImmutableByteListFactory
{
    INSTANCE;

    @Override
    public ImmutableByteList empty()
    {
        return ImmutableByteEmptyList.INSTANCE;
    }

    @Override
    public ImmutableByteList of()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteList with()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteList of(byte one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableByteList with(byte one)
    {
        return new ImmutableByteSingletonList(one);
    }

    @Override
    public ImmutableByteList of(byte... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableByteList with(byte... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableByteArrayList.newListWith(items);
    }

    @Override
    public ImmutableByteList ofAll(ByteIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableByteList withAll(ByteIterable items)
    {
        if (items instanceof ImmutableByteList)
        {
            return (ImmutableByteList) items;
        }
        return this.with(items.toArray());
    }
}
