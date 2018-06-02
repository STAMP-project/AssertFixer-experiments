/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.factory.stack.primitive.MutableLongStackFactory;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import java.util.stream.LongStream;

/**
 * MutableLongStackFactoryImpl is a factory implementation which creates instances of type {@link MutableLongStack}.
 * This file was automatically generated from template file mutablePrimitiveStackFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongStackFactoryImpl implements MutableLongStackFactory
{
    INSTANCE;

    @Override
    public MutableLongStack empty()
    {
        return new LongArrayStack();
    }

    @Override
    public MutableLongStack of()
    {
        return this.empty();
    }

    @Override
    public MutableLongStack with()
    {
        return this.empty();
    }

    @Override
    public MutableLongStack of(long... items)
    {
        return this.with(items);
    }

    @Override
    public MutableLongStack with(long... items)
    {
        if (items.length == 0)
        {
            return this.empty();
        }
        return LongArrayStack.newStackWith(items);
    }

    @Override
    public MutableLongStack ofAll(LongIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableLongStack withAll(LongIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return LongArrayStack.newStack(items);
    }

    @Override
    public MutableLongStack ofAllReversed(LongIterable items)
    {
        return this.withAllReversed(items);
    }

    @Override
    public MutableLongStack withAllReversed(LongIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return LongArrayStack.newStackFromTopToBottom(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongStack ofAll(LongStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public MutableLongStack withAll(LongStream items)
    {
        return this.with(items.toArray());
    }
}
