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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableIntStack;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableIntSingletonStackTest extends AbstractImmutableIntStackTestCase
{
    @Override
    protected ImmutableIntStack classUnderTest()
    {
        return new ImmutableIntSingletonStack(1);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableIntStack stack = this.classUnderTest();
        ImmutableIntStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableIntStack stack = this.classUnderTest();
        ImmutableIntStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableIntStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        IntIterable iterable = this.classUnderTest();
        Assert.assertEquals(0L, iterable.detectIfNone(IntPredicates.equal(4), 0));
        Assert.assertEquals(1L, iterable.detectIfNone(IntPredicates.lessThan(4), 0));
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(IntArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(IntArrayList.newListWith(1),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableIntStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, IntArrayStack.newStackWith(1));
        Assert.assertNotEquals(stack, this.newWith(1, 2));
        Assert.assertNotEquals(stack, IntArrayList.newListWith(1));
        Assert.assertEquals(stack, this.newWith(1));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntSingletonStack iterable = new ImmutableIntSingletonStack(1);
        MutableInteger result = iterable.injectInto(new MutableInteger(1), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(2), result);
    }
}
