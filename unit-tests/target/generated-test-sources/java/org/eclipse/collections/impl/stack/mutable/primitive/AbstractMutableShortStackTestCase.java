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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.stack.primitive.AbstractShortStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableShortStack}.
 * This file was automatically generated from template file abstractMutablePrimitiveStackTestCase.stg.
 */
public abstract class AbstractMutableShortStackTestCase extends AbstractShortStackTestCase
{
    @Override
    protected abstract MutableShortStack classUnderTest();

    @Override
    protected abstract MutableShortStack newWith(short... elements);

    @Override
    protected abstract MutableShortStack newMutableCollectionWith(short... elements);

    @Override
    protected abstract MutableShortStack newWithTopToBottom(short... elements);

    protected abstract MutableShortStack newWithIterableTopToBottom(ShortIterable iterable);

    protected abstract MutableShortStack newWithIterable(ShortIterable iterable);

    @Override
    public void peekAtIndex()
    {
        super.peekAtIndex();
        MutableShortStack stack = this.classUnderTest();
        int size = stack.size();
        stack.pop(2);
        Assert.assertEquals(size - 2, stack.peekAt(0));
    }

    @Override
    @Test
    public void peek()
    {
        super.peek();
        MutableShortStack stack = this.classUnderTest();
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
        MutableShortStack stack = this.classUnderTest();
        int size = stack.size();
        Assert.assertEquals(ShortArrayList.newListWith((short) size, (short) (size - 1)), stack.peek(2));
        stack.pop(2);
        Assert.assertEquals(ShortArrayList.newListWith((short) (size - 2)), stack.peek(1));
    }

    @Test(expected = EmptyStackException.class)
    public void peek_empty_stack_throws_exception()
    {
        this.newWith().peek();
    }

    @Test
    public void testNewStackWithOrder()
    {
        MutableShortStack stack = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals((short) 3, stack.pop());
        Assert.assertEquals((short) 2, stack.pop());
        Assert.assertEquals((short) 1, stack.pop());
    }

    @Test
    public void testNewStackIterableOrder()
    {
        MutableShortStack stack = this.newWithIterable(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3));
        Assert.assertEquals((short) 3, stack.pop());
        Assert.assertEquals((short) 2, stack.pop());
        Assert.assertEquals((short) 1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomOrder()
    {
        MutableShortStack stack = this.newWithTopToBottom((short) 3, (short) 2, (short) 1);
        Assert.assertEquals((short) 3, stack.pop());
        Assert.assertEquals((short) 2, stack.pop());
        Assert.assertEquals((short) 1, stack.pop());
    }

    @Test
    public void testNewStackFromTopToBottomIterableOrder()
    {
        MutableShortStack stack = this.newWithIterableTopToBottom(ShortArrayList.newListWith((short) 3, (short) 2, (short) 1));
        Assert.assertEquals((short) 3, stack.pop());
        Assert.assertEquals((short) 2, stack.pop());
        Assert.assertEquals((short) 1, stack.pop());
    }

    @Test
    public void push()
    {
        MutableShortStack stack = this.classUnderTest();
        int size = stack.size();
        stack.push((short) 5);
        Verify.assertSize(size + 1, stack);
        stack.pop();
        Verify.assertSize(size, stack);
        Assert.assertEquals(ShortArrayList.newListWith((short) size, (short) (size - 1)), stack.peek(2));
    }

    @Test
    public void pop()
    {
        MutableShortStack stack = this.classUnderTest();
        int size = stack.size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals((short) (size - i), stack.pop());
            Verify.assertSize(size - i - 1, stack);
        }
    }

    @Test
    public void popWithCount()
    {
        int size = this.classUnderTest().size();
        Assert.assertEquals(ShortArrayList.newListWith((short) size, (short) (size - 1)), this.classUnderTest().pop(2));
    }

    @Test
    public void clear()
    {
        MutableShortStack stack = this.classUnderTest();
        stack.clear();
        Verify.assertSize(0, stack);
        MutableShortStack stack1 = this.newWith();
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
        this.newWith((short) 1).pop(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void pop_with_count_greater_than_stack_size_throws_exception()
    {
        this.newWith((short) 1).pop(2);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortStack.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortStack.class, this.classUnderTest().asUnmodifiable());
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
