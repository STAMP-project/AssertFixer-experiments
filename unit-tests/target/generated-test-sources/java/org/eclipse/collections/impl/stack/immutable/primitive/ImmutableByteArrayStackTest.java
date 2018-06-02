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

import org.eclipse.collections.api.stack.primitive.ImmutableByteStack;
import org.eclipse.collections.impl.factory.primitive.ByteStacks;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.stack.mutable.primitive.ByteArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableByteArrayStackTest extends AbstractImmutableByteStackTestCase
{
    @Override
    protected ImmutableByteStack classUnderTest()
    {
        return ImmutableByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableByteArrayStack.newStack(ByteStacks.mutable.with((byte) 1));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3), this.newWithIterable(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(ByteArrayStack.newStackFromTopToBottom((byte) 1, (byte) 2, (byte) 3), this.newWithTopToBottom((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableByteArrayStack iterable = ImmutableByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }
}
