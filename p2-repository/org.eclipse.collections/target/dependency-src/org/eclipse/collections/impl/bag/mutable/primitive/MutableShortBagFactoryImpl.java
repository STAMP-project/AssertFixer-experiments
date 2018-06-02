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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.factory.bag.primitive.MutableShortBagFactory;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;

/**
 * MutableShortBagFactoryImpl is a factory implementation which creates instances of type {@link MutableShortBag}.
 * This file was automatically generated from template file mutablePrimitiveBagFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortBagFactoryImpl implements MutableShortBagFactory
{
    INSTANCE;

    @Override
    public MutableShortBag empty()
    {
        return new ShortHashBag();
    }

    @Override
    public MutableShortBag of()
    {
        return this.empty();
    }

    @Override
    public MutableShortBag with()
    {
        return this.empty();
    }

    @Override
    public MutableShortBag of(short... items)
    {
        return this.with(items);
    }

    @Override
    public MutableShortBag with(short... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return ShortHashBag.newBagWith(items);
    }

    @Override
    public MutableShortBag ofAll(ShortIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableShortBag withAll(ShortIterable items)
    {
        return ShortHashBag.newBag(items);
    }
}
