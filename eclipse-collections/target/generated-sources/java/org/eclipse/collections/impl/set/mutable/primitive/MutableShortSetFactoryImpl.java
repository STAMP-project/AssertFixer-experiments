/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.factory.set.primitive.MutableShortSetFactory;
import org.eclipse.collections.api.set.primitive.MutableShortSet;

/**
 * MutableShortSetFactoryImpl is a factory implementation which creates instances of type {@link MutableShortSet}.
 * This file was automatically generated from template file mutablePrimitiveSetFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortSetFactoryImpl implements MutableShortSetFactory
{
    INSTANCE;

    @Override
    public MutableShortSet empty()
    {
        return new ShortHashSet();
    }

    @Override
    public MutableShortSet of()
    {
        return this.empty();
    }

    @Override
    public MutableShortSet with()
    {
        return this.empty();
    }

    @Override
    public MutableShortSet of(short... items)
    {
        return this.with(items);
    }

    @Override
    public MutableShortSet with(short... items)
    {
        if (items == null || items.length == 0)
        {
            return this.empty();
        }
        return ShortHashSet.newSetWith(items);
    }

    @Override
    public MutableShortSet ofAll(ShortIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableShortSet withAll(ShortIterable items)
    {
        return ShortHashSet.newSet(items);
    }
}
