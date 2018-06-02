/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.factory.bag.primitive.MutableLongBagFactory;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import java.util.stream.LongStream;

/**
 * MutableLongBagFactoryImpl is a factory implementation which creates instances of type {@link MutableLongBag}.
 * This file was automatically generated from template file mutablePrimitiveBagFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongBagFactoryImpl implements MutableLongBagFactory
{
    INSTANCE;

    @Override
    public MutableLongBag empty()
    {
        return new LongHashBag();
    }

    @Override
    public MutableLongBag of()
    {
        return this.empty();
    }

    @Override
    public MutableLongBag with()
    {
        return this.empty();
    }

    @Override
    public MutableLongBag of(long... items)
    {
        return this.with(items);
    }

    @Override
    public MutableLongBag with(long... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return LongHashBag.newBagWith(items);
    }

    @Override
    public MutableLongBag ofAll(LongIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableLongBag withAll(LongIterable items)
    {
        return LongHashBag.newBag(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongBag ofAll(LongStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongBag withAll(LongStream items)
    {
        return this.with(items.toArray());
    }
}
