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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableBooleanListFactory;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;

/**
 * MutableBooleanListFactoryImpl is a factory implementation which creates instances of type {@link MutableBooleanList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableBooleanListFactoryImpl implements MutableBooleanListFactory
{
    INSTANCE;

    @Override
    public MutableBooleanList empty()
    {
        return new BooleanArrayList();
    }

    @Override
    public MutableBooleanList of()
    {
        return this.empty();
    }

    @Override
    public MutableBooleanList with()
    {
        return this.empty();
    }

    @Override
    public MutableBooleanList of(boolean... items)
    {
        return this.with(items);
    }

    @Override
    public MutableBooleanList with(boolean... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return BooleanArrayList.newListWith(items);
    }

    @Override
    public MutableBooleanList ofAll(BooleanIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableBooleanList withAll(BooleanIterable items)
    {
        return BooleanArrayList.newList(items);
    }
}
