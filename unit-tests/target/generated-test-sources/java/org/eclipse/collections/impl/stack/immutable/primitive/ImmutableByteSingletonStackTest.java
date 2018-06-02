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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableByteStack;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.stack.mutable.primitive.ByteArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableByteSingletonStackTest extends AbstractImmutableByteStackTestCase
{
    @Override
    protected ImmutableByteStack classUnderTest()
    {
        return new ImmutableByteSingletonStack((byte) 1);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableByteStack stack = this.classUnderTest();
        ImmutableByteStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableByteStack stack = this.classUnderTest();
        ImmutableByteStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableByteStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        ByteIterable iterable = this.classUnderTest();
        Assert.assertEquals(0L, iterable.detectIfNone(BytePredicates.equal((byte) 4), (byte) 0));
        Assert.assertEquals(1L, iterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(ByteArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableByteStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, ByteArrayStack.newStackWith((byte) 1));
        Assert.assertNotEquals(stack, this.newWith((byte) 1, (byte) 2));
        Assert.assertNotEquals(stack, ByteArrayList.newListWith((byte) 1));
        Assert.assertEquals(stack, this.newWith((byte) 1));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableByteSingletonStack iterable = new ImmutableByteSingletonStack((byte) 1);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 1), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 2), result);
    }
}
