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

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatEmptyStack}.
 * This file was automatically generated from template file immutablePrimitiveEmptyStackTest.stg.
 */
public class ImmutableFloatEmptyStackTest extends AbstractImmutableFloatStackTestCase
{
    @Override
    protected ImmutableFloatStack classUnderTest()
    {
        return ImmutableFloatEmptyStack.INSTANCE;
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void pop()
    {
        this.classUnderTest().pop();
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.classUnderTest().pop(1);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableFloatStack stack = this.classUnderTest();
        ImmutableFloatStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void floatIterator()
    {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void peek()
    {
        this.classUnderTest().peek();
    }

    @Test
    public void peekWithCount()
    {
        Assert.assertEquals(FloatArrayList.newListWith(), this.classUnderTest().peek(0));
        Verify.assertThrows(EmptyStackException.class, () -> { this.classUnderTest().peek(1); });
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void peek_at_index_equal_to_size_throws_exception()
    {
        this.classUnderTest().peekAt(0);
    }

    @Override
    @Test(expected = EmptyStackException.class)
    public void peek_at_index_greater_than_size_throws_exception()
    {
        this.classUnderTest().peekAt(1);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average()
    {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void averageIfEmpty()
    {
        Assert.assertEquals(1.2, this.classUnderTest().averageIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median()
    {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void medianIfEmpty()
    {
        Assert.assertEquals(1.2, this.classUnderTest().medianIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max()
    {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min()
    {
        this.classUnderTest().min();
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.newWith().notEmpty());
    }

    @Override
    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.newWith());
    }

    @Override
    public void testEquals()
    {
        super.testEquals();
        Verify.assertPostSerializedIdentity(this.classUnderTest());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableFloatEmptyStack iterable = new ImmutableFloatEmptyStack();
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(0.0f), result);
    }
}
