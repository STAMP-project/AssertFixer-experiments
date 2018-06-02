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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractFloatStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableFloatStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableFloatStackTestCase extends AbstractFloatStackTestCase
{
    @Override
    protected abstract MutableFloatStack classUnderTest();

    @Override
    protected abstract MutableFloatStack newWith(float... elements);

    @Override
    protected abstract MutableFloatStack newMutableCollectionWith(float... elements);

    @Override
    protected abstract MutableFloatStack newWithTopToBottom(float... elements);

    protected abstract MutableFloatStack newWithIterableTopToBottom(FloatIterable iterable);

    protected abstract MutableFloatStack newWithIterable(FloatIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableFloatStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0), 0.0);
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableFloatStack stack = this.classUnderTest();
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
        MutableFloatStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(FloatArrayList.newListWith(size, size - 1), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(FloatArrayList.newListWith(size - 2), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableFloatStack stack = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(3.0f, stack.pop(), 0.0);
        Assert.assertEquals(2.0f, stack.pop(), 0.0);
        Assert.assertEquals(1.0f, stack.pop(), 0.0);
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableFloatStack stack = this.newWithIterable(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(3.0f, stack.pop(), 0.0);
        Assert.assertEquals(2.0f, stack.pop(), 0.0);
        Assert.assertEquals(1.0f, stack.pop(), 0.0);
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableFloatStack stack = this.newWithTopToBottom(3.0f, 2.0f, 1.0f);
        Assert.assertEquals(3.0f, stack.pop(), 0.0);
        Assert.assertEquals(2.0f, stack.pop(), 0.0);
        Assert.assertEquals(1.0f, stack.pop(), 0.0);
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableFloatStack stack = this.newWithIterableTopToBottom(FloatArrayList.newListWith(3.0f, 2.0f, 1.0f));
        Assert.assertEquals(3.0f, stack.pop(), 0.0);
        Assert.assertEquals(2.0f, stack.pop(), 0.0);
        Assert.assertEquals(1.0f, stack.pop(), 0.0);
    }

    @Test
    public void push()
    {
        MutableFloatStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push(5.0f);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(FloatArrayList.newListWith(size, size - 1), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableFloatStack stack = this.classUnderTest();
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
        Assert.assertEquals(FloatArrayList.newListWith(size, size - 1), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableFloatStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableFloatStack stack1 = this.newWith();
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
        this.newWith(1.0f).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith(1.0f).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedFloatStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableFloatStack.class, this.classUnderTest().asUnmodifiable());
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
