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

import org.eclipse.collections.api.stack.primitive.ImmutableIntStack;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableIntArrayStackTest extends AbstractImmutableIntStackTestCase
{
    @Override
    protected ImmutableIntStack classUnderTest()
    {
        return ImmutableIntArrayStack.newStackWith(1, 2, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableIntArrayStack.newStack(IntStacks.mutable.with(1));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(IntArrayStack.newStackWith(1, 2, 3), this.newWithIterable(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(IntArrayStack.newStackFromTopToBottom(1, 2, 3), this.newWithTopToBottom(1, 2, 3));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntArrayStack iterable = ImmutableIntArrayStack.newStackWith(1, 2, 3);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }
}
