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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractIntStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableIntStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableIntStackTestCase extends AbstractIntStackTestCase
{
    @Override
    protected abstract MutableIntStack classUnderTest();

    @Override
    protected abstract MutableIntStack newWith(int... elements);

    @Override
    protected abstract MutableIntStack newMutableCollectionWith(int... elements);

    @Override
    protected abstract MutableIntStack newWithTopToBottom(int... elements);

    protected abstract MutableIntStack newWithIterableTopToBottom(IntIterable iterable);

    protected abstract MutableIntStack newWithIterable(IntIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableIntStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableIntStack stack = this.classUnderTest();
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
        MutableIntStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(IntArrayList.newListWith(size, size - 1), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(IntArrayList.newListWith(size - 2), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableIntStack stack = this.newWith(1, 2, 3);
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableIntStack stack = this.newWithIterable(IntArrayList.newListWith(1, 2, 3));
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableIntStack stack = this.newWithTopToBottom(3, 2, 1);
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableIntStack stack = this.newWithIterableTopToBottom(IntArrayList.newListWith(3, 2, 1));
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
    }

    @Test
    public void push()
    {
        MutableIntStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push(5);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(IntArrayList.newListWith(size, size - 1), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableIntStack stack = this.classUnderTest();
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
        Assert.assertEquals(IntArrayList.newListWith(size, size - 1), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableIntStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableIntStack stack1 = this.newWith();
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
        this.newWith(1).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith(1).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedIntStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableIntStack.class, this.classUnderTest().asUnmodifiable());
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
