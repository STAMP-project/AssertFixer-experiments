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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.factory.stack.primitive.MutableShortStackFactory;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;

/**
 * MutableShortStackFactoryImpl is a factory implementation which creates instances of type {@link MutableShortStack}.
 * This file was automatically generated from template file mutablePrimitiveStackFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortStackFactoryImpl implements MutableShortStackFactory
{
    INSTANCE;

    @Override
    public MutableShortStack empty()
    {
        return new ShortArrayStack();
    }

    @Override
    public MutableShortStack of()
    {
        return this.empty();
    }

    @Override
    public MutableShortStack with()
    {
        return this.empty();
    }

    @Override
    public MutableShortStack of(short... items)
    {
        return this.with(items);
    }

    @Override
    public MutableShortStack with(short... items)
    {
        if (items.length == 0)
        {
            return this.empty();
        }
        return ShortArrayStack.newStackWith(items);
    }

    @Override
    public MutableShortStack ofAll(ShortIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableShortStack withAll(ShortIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return ShortArrayStack.newStack(items);
    }

    @Override
    public MutableShortStack ofAllReversed(ShortIterable items)
    {
        return this.withAllReversed(items);
    }

    @Override
    public MutableShortStack withAllReversed(ShortIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return ShortArrayStack.newStackFromTopToBottom(items);
    }
}
