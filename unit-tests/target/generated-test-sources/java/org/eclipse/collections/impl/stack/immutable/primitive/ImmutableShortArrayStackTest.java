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

import org.eclipse.collections.api.stack.primitive.ImmutableShortStack;
import org.eclipse.collections.impl.factory.primitive.ShortStacks;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableShortArrayStackTest extends AbstractImmutableShortStackTestCase
{
    @Override
    protected ImmutableShortStack classUnderTest()
    {
        return ImmutableShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableShortArrayStack.newStack(ShortStacks.mutable.with((short) 1));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3), this.newWithIterable(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(ShortArrayStack.newStackFromTopToBottom((short) 1, (short) 2, (short) 3), this.newWithTopToBottom((short) 1, (short) 2, (short) 3));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableShortArrayStack iterable = ImmutableShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }
}
