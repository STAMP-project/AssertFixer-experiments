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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableByteListFactory;
import org.eclipse.collections.api.list.primitive.MutableByteList;

/**
 * MutableByteListFactoryImpl is a factory implementation which creates instances of type {@link MutableByteList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableByteListFactoryImpl implements MutableByteListFactory
{
    INSTANCE;

    @Override
    public MutableByteList empty()
    {
        return new ByteArrayList();
    }

    @Override
    public MutableByteList of()
    {
        return this.empty();
    }

    @Override
    public MutableByteList with()
    {
        return this.empty();
    }

    @Override
    public MutableByteList of(byte... items)
    {
        return this.with(items);
    }

    @Override
    public MutableByteList with(byte... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return ByteArrayList.newListWith(items);
    }

    @Override
    public MutableByteList ofAll(ByteIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableByteList withAll(ByteIterable items)
    {
        return ByteArrayList.newList(items);
    }
}
