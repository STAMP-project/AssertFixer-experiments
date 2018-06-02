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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.bag.primitive.ImmutableBooleanBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableBooleanBagFactory;

/**
 * ImmutableBooleanBagFactoryImpl is a factory implementation which creates instances of type {@link ImmutableBooleanBag}.
 * This file was automatically generated from template file immutablePrimitiveBagFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableBooleanBagFactoryImpl implements ImmutableBooleanBagFactory
{
    INSTANCE;

    @Override
    public ImmutableBooleanBag empty()
    {
        return ImmutableBooleanEmptyBag.INSTANCE;
    }

    @Override
    public ImmutableBooleanBag of()
    {
        return this.empty();
    }

    @Override
    public ImmutableBooleanBag with()
    {
        return this.empty();
    }

    @Override
    public ImmutableBooleanBag of(boolean one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableBooleanBag with(boolean one)
    {
        return new ImmutableBooleanSingletonBag(one);
    }

    @Override
    public ImmutableBooleanBag of(boolean... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableBooleanBag with(boolean... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableBooleanHashBag.newBagWith(items);
    }

    @Override
    public ImmutableBooleanBag ofAll(BooleanIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableBooleanBag withAll(BooleanIterable items)
    {
        if (items instanceof ImmutableBooleanBag)
        {
            return (ImmutableBooleanBag) items;
        }
        return this.with(items.toArray());
    }
}
