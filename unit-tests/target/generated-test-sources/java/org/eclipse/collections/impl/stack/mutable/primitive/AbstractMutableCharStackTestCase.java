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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.stack.primitive.MutableCharStack;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractCharStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableCharStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableCharStackTestCase extends AbstractCharStackTestCase
{
    @Override
    protected abstract MutableCharStack classUnderTest();

    @Override
    protected abstract MutableCharStack newWith(char... elements);

    @Override
    protected abstract MutableCharStack newMutableCollectionWith(char... elements);

    @Override
    protected abstract MutableCharStack newWithTopToBottom(char... elements);

    protected abstract MutableCharStack newWithIterableTopToBottom(CharIterable iterable);

    protected abstract MutableCharStack newWithIterable(CharIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableCharStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableCharStack stack = this.classUnderTest();
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
        MutableCharStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(CharArrayList.newListWith((char) size, (char) (size - 1)), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(CharArrayList.newListWith((char) (size - 2)), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableCharStack stack = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals((char) 3, stack.pop());
        Assert.assertEquals((char) 2, stack.pop());
        Assert.assertEquals((char) 1, stack.pop());
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableCharStack stack = this.newWithIterable(CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
        Assert.assertEquals((char) 3, stack.pop());
        Assert.assertEquals((char) 2, stack.pop());
        Assert.assertEquals((char) 1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableCharStack stack = this.newWithTopToBottom((char) 3, (char) 2, (char) 1);
        Assert.assertEquals((char) 3, stack.pop());
        Assert.assertEquals((char) 2, stack.pop());
        Assert.assertEquals((char) 1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableCharStack stack = this.newWithIterableTopToBottom(CharArrayList.newListWith((char) 3, (char) 2, (char) 1));
        Assert.assertEquals((char) 3, stack.pop());
        Assert.assertEquals((char) 2, stack.pop());
        Assert.assertEquals((char) 1, stack.pop());
    }

    @Test
    public void push()
    {
        MutableCharStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push((char) 5);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(CharArrayList.newListWith((char) size, (char) (size - 1)), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableCharStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals((char) (size - i), stack.pop());
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount()
    {
        int size = this.classUnderTest().size();
        Assert.assertEquals(CharArrayList.newListWith((char) size, (char) (size - 1)), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableCharStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableCharStack stack1 = this.newWith();
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
        this.newWith((char) 1).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith((char) 1).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedCharStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableCharStack.class, this.classUnderTest().asUnmodifiable());
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
