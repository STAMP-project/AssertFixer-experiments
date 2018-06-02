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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.factory.bag.primitive.MutableIntBagFactory;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import java.util.stream.IntStream;

/**
 * MutableIntBagFactoryImpl is a factory implementation which creates instances of type {@link MutableIntBag}.
 * This file was automatically generated from template file mutablePrimitiveBagFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableIntBagFactoryImpl implements MutableIntBagFactory
{
    INSTANCE;

    @Override
    public MutableIntBag empty()
    {
        return new IntHashBag();
    }

    @Override
    public MutableIntBag of()
    {
        return this.empty();
    }

    @Override
    public MutableIntBag with()
    {
        return this.empty();
    }

    @Override
    public MutableIntBag of(int... items)
    {
        return this.with(items);
    }

    @Override
    public MutableIntBag with(int... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return IntHashBag.newBagWith(items);
    }

    @Override
    public MutableIntBag ofAll(IntIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableIntBag withAll(IntIterable items)
    {
        return IntHashBag.newBag(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableIntBag ofAll(IntStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableIntBag withAll(IntStream items)
    {
        return this.with(items.toArray());
    }
}
