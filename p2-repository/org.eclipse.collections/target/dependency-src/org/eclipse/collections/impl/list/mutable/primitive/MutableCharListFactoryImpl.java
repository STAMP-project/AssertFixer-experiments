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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.factory.list.primitive.MutableCharListFactory;
import org.eclipse.collections.api.list.primitive.MutableCharList;

/**
 * MutableCharListFactoryImpl is a factory implementation which creates instances of type {@link MutableCharList}.
 * This file was automatically generated from template file mutablePrimitiveListFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableCharListFactoryImpl implements MutableCharListFactory
{
    INSTANCE;

    @Override
    public MutableCharList empty()
    {
        return new CharArrayList();
    }

    @Override
    public MutableCharList of()
    {
        return this.empty();
    }

    @Override
    public MutableCharList with()
    {
        return this.empty();
    }

    @Override
    public MutableCharList of(char... items)
    {
        return this.with(items);
    }

    @Override
    public MutableCharList with(char... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        return CharArrayList.newListWith(items);
    }

    @Override
    public MutableCharList ofAll(CharIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableCharList withAll(CharIterable items)
    {
        return CharArrayList.newList(items);
    }
}
