/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.immutable.primitive;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.factory.stack.primitive.ImmutableCharStackFactory;
import org.eclipse.collections.api.stack.primitive.ImmutableCharStack;

/**
 * ImmutableCharStackFactoryImpl is a factory implementation which creates instances of type {@link ImmutableCharStack}.
 * This file was automatically generated from template file immutablePrimitiveStackFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableCharStackFactoryImpl implements ImmutableCharStackFactory
{
    INSTANCE;

    @Override
    public ImmutableCharStack empty()
    {
        return ImmutableCharEmptyStack.INSTANCE;
    }

    @Override
    public ImmutableCharStack of()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharStack with()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharStack of(char one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableCharStack with(char one)
    {
        return new ImmutableCharSingletonStack(one);
    }

    @Override
    public ImmutableCharStack of(char... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableCharStack with(char... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return ImmutableCharArrayStack.newStackWith(items);
    }

    @Override
    public ImmutableCharStack ofAll(CharIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableCharStack withAll(CharIterable items)
    {
        if (items instanceof ImmutableCharStack)
        {
            return (ImmutableCharStack) items;
        }
        return this.with(items.toArray());
    }

    @Override
    public ImmutableCharStack ofAllReversed(CharIterable items)
    {
        return this.withAllReversed(items);
    }

    @Override
    public ImmutableCharStack withAllReversed(CharIterable items)
    {
        if (items == null || items.isEmpty())
        {
            return this.with();
        }
        if (items.size() == 1)
        {
            return this.with(items.toArray());
        }
        return ImmutableCharArrayStack.newStackFromTopToBottom(items);
    }
}
