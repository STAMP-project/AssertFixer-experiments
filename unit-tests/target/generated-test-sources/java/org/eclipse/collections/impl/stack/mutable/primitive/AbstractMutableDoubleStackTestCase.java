/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.mutable.primitive;

import java.util.EmptyStackException;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.stack.primitive.MutableDoubleStack;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractDoubleStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableDoubleStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableDoubleStackTestCase extends AbstractDoubleStackTestCase
{
    @Override
    protected abstract MutableDoubleStack classUnderTest();

    @Override
    protected abstract MutableDoubleStack newWith(double... elements);

    @Override
    protected abstract MutableDoubleStack newMutableCollectionWith(double... elements);

    @Override
    protected abstract MutableDoubleStack newWithTopToBottom(double... elements);

    protected abstract MutableDoubleStack newWithIterableTopToBottom(DoubleIterable iterable);

    protected abstract MutableDoubleStack newWithIterable(DoubleIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableDoubleStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0), 0.0);
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableDoubleStack stack = this.classUnderTest();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals(size - i, stack.peek(), 0.0);
            stack.pop();
        }
    }

    @Test
    public void peekWithCount()
    {
        MutableDoubleStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(DoubleArrayList.newListWith(size, size - 1), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(DoubleArrayList.newListWith(size - 2), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableDoubleStack stack = this.newWith(1.0, 2.0, 3.0);
        Assert.assertEquals(3.0, stack.pop(), 0.0);
        Assert.assertEquals(2.0, stack.pop(), 0.0);
        Assert.assertEquals(1.0, stack.pop(), 0.0);
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableDoubleStack stack = this.newWithIterable(DoubleArrayList.newListWith(1.0, 2.0, 3.0));
        Assert.assertEquals(3.0, stack.pop(), 0.0);
        Assert.assertEquals(2.0, stack.pop(), 0.0);
        Assert.assertEquals(1.0, stack.pop(), 0.0);
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableDoubleStack stack = this.newWithTopToBottom(3.0, 2.0, 1.0);
        Assert.assertEquals(3.0, stack.pop(), 0.0);
        Assert.assertEquals(2.0, stack.pop(), 0.0);
        Assert.assertEquals(1.0, stack.pop(), 0.0);
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableDoubleStack stack = this.newWithIterableTopToBottom(DoubleArrayList.newListWith(3.0, 2.0, 1.0));
        Assert.assertEquals(3.0, stack.pop(), 0.0);
        Assert.assertEquals(2.0, stack.pop(), 0.0);
        Assert.assertEquals(1.0, stack.pop(), 0.0);
    }

    @Test
    public void push()
    {
        MutableDoubleStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push(5.0);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(DoubleArrayList.newListWith(size, size - 1), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableDoubleStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals(size - i, stack.pop(), 0.0);
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount()
    {
        int size = this.classUnderTest().size();
        Assert.assertEquals(DoubleArrayList.newListWith(size, size - 1), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableDoubleStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableDoubleStack stack1 = this.newWith();
        Verify.assertSize(0, stack1);
        stack1.clear();
        Verify.assertSize(0, stack1);
    }

    @Test(expected = EmptyStackException.class)
    public void pop_empty_stack_throws_exception()
    {
        this.newWith().pop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_negative_count_throws_exception()
    {
        this.newWith(1.0).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith(1.0).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedDoubleStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableDoubleStack.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asUnmodifiable());
    }

    /**
     * @since 9.2.
     */
    @Test
    public void newEmpty()
    {
        Assert.assertTrue(this.classUnderTest().newEmpty().isEmpty());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().newEmpty());
    }
}
