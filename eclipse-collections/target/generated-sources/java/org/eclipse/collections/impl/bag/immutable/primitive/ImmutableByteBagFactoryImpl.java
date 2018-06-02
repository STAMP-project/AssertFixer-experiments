/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableByteBagFactory;

/**
 * ImmutableByteBagFactoryImpl is a factory implementation which creates instances of type {@link ImmutableByteBag}.
 * This file was automatically generated from template file immutablePrimitiveBagFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableByteBagFactoryImpl implements ImmutableByteBagFactory
{
    INSTANCE;

    @Override
    public ImmutableByteBag empty()
    {
        return ImmutableByteEmptyBag.INSTANCE;
    }

    @Override
    public ImmutableByteBag of()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteBag with()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteBag of(byte one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableByteBag with(byte one)
    {
        return new ImmutableByteSingletonBag(one);
    }

    @Override
    public ImmutableByteBag of(byte... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableByteBag with(byte... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableByteHashBag.newBagWith(items);
    }

    @Override
    public ImmutableByteBag ofAll(ByteIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableByteBag withAll(ByteIterable items)
    {
        if (items instanceof ImmutableByteBag)
        {
            return (ImmutableByteBag) items;
        }
        return this.with(items.toArray());
    }
}
