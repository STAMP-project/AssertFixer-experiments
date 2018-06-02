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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.factory.stack.primitive.MutableBooleanStackFactory;
import org.eclipse.collections.api.stack.primitive.MutableBooleanStack;

/**
 * MutableBooleanStackFactoryImpl is a factory implementation which creates instances of type {@link MutableBooleanStack}.
 * This file was automatically generated from template file mutablePrimitiveStackFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableBooleanStackFactoryImpl implements MutableBooleanStackFactory
{
    INSTANCE;

    @Override
    public MutableBooleanStack empty()
    {
        return new BooleanArrayStack();
    }

    @Override
    public MutableBooleanStack of()
    {
        return this.empty();
    }

    @Override
    public MutableBooleanStack with()
    {
        return this.empty();
    }

    @Override
    public MutableBooleanStack of(boolean... items)
    {
        return this.with(items);
    }

    @Override
    public MutableBooleanStack with(boolean... items)
    {
        if (items.length == 0)
        {
            return this.empty();
        }
        return BooleanArrayStack.newStackWith(items);
    }

    @Override
    public MutableBooleanStack ofAll(BooleanIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public MutableBooleanStack withAll(BooleanIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return BooleanArrayStack.newStack(items);
    }

    @Override
    public MutableBooleanStack ofAllReversed(BooleanIterable items)
    {
        return this.withAllReversed(items);
    }

    @Override
    public MutableBooleanStack withAllReversed(BooleanIterable items)
    {
        if (items.isEmpty())
        {
            return this.empty();
        }
        return BooleanArrayStack.newStackFromTopToBottom(items);
    }
}
