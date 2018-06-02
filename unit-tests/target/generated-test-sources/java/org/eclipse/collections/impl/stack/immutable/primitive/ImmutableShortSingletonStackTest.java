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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableShortStack;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableShortSingletonStackTest extends AbstractImmutableShortStackTestCase
{
    @Override
    protected ImmutableShortStack classUnderTest()
    {
        return new ImmutableShortSingletonStack((short) 1);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableShortStack stack = this.classUnderTest();
        ImmutableShortStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableShortStack stack = this.classUnderTest();
        ImmutableShortStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableShortStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        ShortIterable iterable = this.classUnderTest();
        Assert.assertEquals(0L, iterable.detectIfNone(ShortPredicates.equal((short) 4), (short) 0));
        Assert.assertEquals(1L, iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(ShortArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(ShortArrayList.newListWith((short) 1),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableShortStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, ShortArrayStack.newStackWith((short) 1));
        Assert.assertNotEquals(stack, this.newWith((short) 1, (short) 2));
        Assert.assertNotEquals(stack, ShortArrayList.newListWith((short) 1));
        Assert.assertEquals(stack, this.newWith((short) 1));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableShortSingletonStack iterable = new ImmutableShortSingletonStack((short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 1), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 2), result);
    }
}
