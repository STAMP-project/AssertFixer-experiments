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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableShortListFactory;
import org.eclipse.collections.api.list.primitive.MutableShortList;

/**
 * MutableShortListFactoryImpl is a factory implementation which creates instances of type {@link MutableShortList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortListFactoryImpl implements MutableShortListFactory
{
    INSTANCE;

    @Override
    public MutableShortList empty()
    {
        return new ShortArrayList();
    }

    @Override
    public MutableShortList of()
    {
        return this.empty();
    }

    @Override
    public MutableShortList with()
    {
        return this.empty();
    }

    @Override
    public MutableShortList of(short... items)
    {
        return this.with(items);
    }

    @Override
    public MutableShortList with(short... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return ShortArrayList.newListWith(items);
    }

    @Override
    public MutableShortList ofAll(ShortIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableShortList withAll(ShortIterable items)
    {
        return ShortArrayList.newList(items);
    }
}
