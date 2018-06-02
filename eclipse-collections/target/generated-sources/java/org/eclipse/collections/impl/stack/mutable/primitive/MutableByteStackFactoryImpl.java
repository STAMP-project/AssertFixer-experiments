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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.factory.stack.primitive.MutableByteStackFactory;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;

/**
 * MutableByteStackFactoryImpl is a factory implementation which creates instances of type {@link MutableByteStack}.
 * This file was automatically generated from template file mutablePrimitiveStackFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableByteStackFactoryImpl implements MutableByteStackFactory
{
    INSTANCE;

    @Override
    public MutableByteStack empty()
    {
        return new ByteArrayStack();
    }

    @Override
    public MutableByteStack of()
    {
        return this.empty();
    }

    @Override
    public MutableByteStack with()
    {
        return this.empty();
    }

    @Override
    public MutableByteStack of(byte... items)
    {
        return this.with(items);
    }

    @Override
    public MutableByteStack with(byte... items)
    {
        if (items.length == 0)
        {
            return this.empty();
        }
        return ByteArrayStack.newStackWith(items);
    }

    @Override
    public MutableByteStack ofAll(ByteIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableByteStack withAll(ByteIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return ByteArrayStack.newStack(items);
    }

    @Override
    public MutableByteStack ofAllReversed(ByteIterable items)
    {
        return this.withAllReversed(items);
    }

    @Override
    public MutableByteStack withAllReversed(ByteIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return ByteArrayStack.newStackFromTopToBottom(items);
    }
}
