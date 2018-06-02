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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.stack.primitive.MutableLongStack;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractLongStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableLongStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableLongStackTestCase extends AbstractLongStackTestCase
{
    @Override
    protected abstract MutableLongStack classUnderTest();

    @Override
    protected abstract MutableLongStack newWith(long... elements);

    @Override
    protected abstract MutableLongStack newMutableCollectionWith(long... elements);

    @Override
    protected abstract MutableLongStack newWithTopToBottom(long... elements);

    protected abstract MutableLongStack newWithIterableTopToBottom(LongIterable iterable);

    protected abstract MutableLongStack newWithIterable(LongIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableLongStack stack = this.classUnderTest();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals(size - i, stack.peek());
            stack.pop();
        }
    }

    @Test
    public void peekWithCount()
    {
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(LongArrayList.newListWith(size, size - 1), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(LongArrayList.newListWith(size - 2), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableLongStack stack = this.newWith(1L, 2L, 3L);
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableLongStack stack = this.newWithIterable(LongArrayList.newListWith(1L, 2L, 3L));
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableLongStack stack = this.newWithTopToBottom(3L, 2L, 1L);
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableLongStack stack = this.newWithIterableTopToBottom(LongArrayList.newListWith(3L, 2L, 1L));
        Assert.assertEquals(3L, stack.pop());
        Assert.assertEquals(2L, stack.pop());
        Assert.assertEquals(1L, stack.pop());
    }

    @Test
    public void push()
    {
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push(5L);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(LongArrayList.newListWith(size, size - 1), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableLongStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals(size - i, stack.pop());
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount()
    {
        int size = this.classUnderTest().size();
        Assert.assertEquals(LongArrayList.newListWith(size, size - 1), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableLongStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableLongStack stack1 = this.newWith();
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
        this.newWith(1L).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith(1L).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedLongStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableLongStack.class, this.classUnderTest().asUnmodifiable());
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
