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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractByteStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableByteStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableByteStackTestCase extends AbstractByteStackTestCase
{
    @Override
    protected abstract MutableByteStack classUnderTest();

    @Override
    protected abstract MutableByteStack newWith(byte... elements);

    @Override
    protected abstract MutableByteStack newMutableCollectionWith(byte... elements);

    @Override
    protected abstract MutableByteStack newWithTopToBottom(byte... elements);

    protected abstract MutableByteStack newWithIterableTopToBottom(ByteIterable iterable);

    protected abstract MutableByteStack newWithIterable(ByteIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableByteStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableByteStack stack = this.classUnderTest();
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
        MutableByteStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(ByteArrayList.newListWith((byte) size, (byte) (size - 1)), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(ByteArrayList.newListWith((byte) (size - 2)), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableByteStack stack = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals((byte) 3, stack.pop());
        Assert.assertEquals((byte) 2, stack.pop());
        Assert.assertEquals((byte) 1, stack.pop());
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableByteStack stack = this.newWithIterable(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals((byte) 3, stack.pop());
        Assert.assertEquals((byte) 2, stack.pop());
        Assert.assertEquals((byte) 1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableByteStack stack = this.newWithTopToBottom((byte) 3, (byte) 2, (byte) 1);
        Assert.assertEquals((byte) 3, stack.pop());
        Assert.assertEquals((byte) 2, stack.pop());
        Assert.assertEquals((byte) 1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableByteStack stack = this.newWithIterableTopToBottom(ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1));
        Assert.assertEquals((byte) 3, stack.pop());
        Assert.assertEquals((byte) 2, stack.pop());
        Assert.assertEquals((byte) 1, stack.pop());
    }

    @Test
    public void push()
    {
        MutableByteStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push((byte) 5);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(ByteArrayList.newListWith((byte) size, (byte) (size - 1)), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableByteStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals((byte) (size - i), stack.pop());
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount()
    {
        int size = this.classUnderTest().size();
        Assert.assertEquals(ByteArrayList.newListWith((byte) size, (byte) (size - 1)), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableByteStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableByteStack stack1 = this.newWith();
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
        this.newWith((byte) 1).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith((byte) 1).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedByteStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableByteStack.class, this.classUnderTest().asUnmodifiable());
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
