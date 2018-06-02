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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableDoubleStack;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableDoubleSingletonStackTest extends AbstractImmutableDoubleStackTestCase
{
    @Override
    protected ImmutableDoubleStack classUnderTest()
    {
        return new ImmutableDoubleSingletonStack(1.0);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableDoubleStack stack = this.classUnderTest();
        ImmutableDoubleStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableDoubleStack stack = this.classUnderTest();
        ImmutableDoubleStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableDoubleStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        DoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals(0.0, iterable.detectIfNone(DoublePredicates.equal(4.0), 0.0), 0.0);
        Assert.assertEquals(1.0, iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek(), 0.0);
        Assert.assertEquals(DoubleArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableDoubleStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, DoubleArrayStack.newStackWith(1.0));
        Assert.assertNotEquals(stack, this.newWith(1.0, 2.0));
        Assert.assertNotEquals(stack, DoubleArrayList.newListWith(1.0));
        Assert.assertEquals(stack, this.newWith(1.0));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleSingletonStack iterable = new ImmutableDoubleSingletonStack(1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(1.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(2.0), result);
    }
}
