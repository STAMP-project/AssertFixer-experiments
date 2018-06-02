/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file synchronizedPrimitiveStackTest.stg.
 */
public class SynchronizedFloatStackTest extends AbstractMutableFloatStackTestCase
{
    @Override
    protected MutableFloatStack classUnderTest()
    {
        return new SynchronizedFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected MutableFloatStack newWith(float... elements)
    {
        return new SynchronizedFloatStack(FloatArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableFloatStack newWithTopToBottom(float... elements)
    {
        return new SynchronizedFloatStack(FloatArrayStack.newStackFromTopToBottom(elements));
    }

    @Override
    protected MutableFloatStack newMutableCollectionWith(float... elements)
    {
        return new SynchronizedFloatStack(FloatArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableFloatStack newWithIterableTopToBottom(FloatIterable iterable)
    {
        return new SynchronizedFloatStack(FloatArrayStack.newStackFromTopToBottom(iterable));
    }

    @Override
    protected MutableFloatStack newWithIterable(FloatIterable iterable)
    {
        return new SynchronizedFloatStack(FloatArrayStack.newStack(iterable));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        MutableFloatStack stack1 = new SynchronizedFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f), new Object());
        Assert.assertEquals(stack1, stack1.asSynchronized());
        Assert.assertSame(stack1, stack1.asSynchronized());
    }
}
