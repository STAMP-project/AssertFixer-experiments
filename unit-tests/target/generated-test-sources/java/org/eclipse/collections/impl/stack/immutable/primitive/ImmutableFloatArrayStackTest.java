/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.immutable.primitive;

import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableFloatArrayStackTest extends AbstractImmutableFloatStackTestCase
{
    @Override
    protected ImmutableFloatStack classUnderTest()
    {
        return ImmutableFloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableFloatArrayStack.newStack(FloatStacks.mutable.with(1.0f));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f), this.newWithIterable(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(FloatArrayStack.newStackFromTopToBottom(1.0f, 2.0f, 3.0f), this.newWithTopToBottom(1.0f, 2.0f, 3.0f));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableFloatArrayStack iterable = ImmutableFloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }
}
