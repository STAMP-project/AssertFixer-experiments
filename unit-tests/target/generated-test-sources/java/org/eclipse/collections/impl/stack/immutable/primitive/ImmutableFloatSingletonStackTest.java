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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableFloatSingletonStackTest extends AbstractImmutableFloatStackTestCase
{
    @Override
    protected ImmutableFloatStack classUnderTest()
    {
        return new ImmutableFloatSingletonStack(1.0f);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableFloatStack stack = this.classUnderTest();
        ImmutableFloatStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableFloatStack stack = this.classUnderTest();
        ImmutableFloatStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableFloatStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(0.0, iterable.detectIfNone(FloatPredicates.equal(4.0f), 0.0f), 0.0);
        Assert.assertEquals(1.0, iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek(), 0.0);
        Assert.assertEquals(FloatArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableFloatStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, FloatArrayStack.newStackWith(1.0f));
        Assert.assertNotEquals(stack, this.newWith(1.0f, 2.0f));
        Assert.assertNotEquals(stack, FloatArrayList.newListWith(1.0f));
        Assert.assertEquals(stack, this.newWith(1.0f));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableFloatSingletonStack iterable = new ImmutableFloatSingletonStack(1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(1.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(2.0f), result);
    }
}
