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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableLongStack;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableLongSingletonStackTest extends AbstractImmutableLongStackTestCase
{
    @Override
    protected ImmutableLongStack classUnderTest()
    {
        return new ImmutableLongSingletonStack(1L);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableLongStack stack = this.classUnderTest();
        ImmutableLongStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableLongStack stack = this.classUnderTest();
        ImmutableLongStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableLongStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals(0L, iterable.detectIfNone(LongPredicates.equal(4L), 0L));
        Assert.assertEquals(1L, iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(LongArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(LongArrayList.newListWith(1L),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableLongStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, LongArrayStack.newStackWith(1L));
        Assert.assertNotEquals(stack, this.newWith(1L, 2L));
        Assert.assertNotEquals(stack, LongArrayList.newListWith(1L));
        Assert.assertEquals(stack, this.newWith(1L));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableLongSingletonStack iterable = new ImmutableLongSingletonStack(1L);
        MutableLong result = iterable.injectInto(new MutableLong(1L), MutableLong::add);
        Assert.assertEquals(new MutableLong(2L), result);
    }
}
