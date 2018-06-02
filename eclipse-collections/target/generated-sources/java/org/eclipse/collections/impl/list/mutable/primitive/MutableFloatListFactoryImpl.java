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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableFloatListFactory;
import org.eclipse.collections.api.list.primitive.MutableFloatList;

/**
 * MutableFloatListFactoryImpl is a factory implementation which creates instances of type {@link MutableFloatList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableFloatListFactoryImpl implements MutableFloatListFactory
{
    INSTANCE;

    @Override
    public MutableFloatList empty()
    {
        return new FloatArrayList();
    }

    @Override
    public MutableFloatList of()
    {
        return this.empty();
    }

    @Override
    public MutableFloatList with()
    {
        return this.empty();
    }

    @Override
    public MutableFloatList of(float... items)
    {
        return this.with(items);
    }

    @Override
    public MutableFloatList with(float... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return FloatArrayList.newListWith(items);
    }

    @Override
    public MutableFloatList ofAll(FloatIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableFloatList withAll(FloatIterable items)
    {
        return FloatArrayList.newList(items);
    }
}
