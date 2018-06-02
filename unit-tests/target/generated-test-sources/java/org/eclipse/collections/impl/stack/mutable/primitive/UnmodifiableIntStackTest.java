/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.mutable.primitive;

import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.stack.primitive.MutableIntStack;
import org.eclipse.collections.impl.stack.primitive.AbstractIntStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableIntStackTest extends AbstractIntStackTestCase
{
    @Override
    protected MutableIntStack classUnderTest()
    {
        return new UnmodifiableIntStack(IntArrayStack.newStackWith(1, 2, 3));
    }

    @Override
    protected MutableIntStack newWith(int... elements)
    {
        return new UnmodifiableIntStack(IntArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableIntStack newMutableCollectionWith(int... elements)
    {
        return new UnmodifiableIntStack(IntArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableIntStack newWithTopToBottom(int... elements)
    {
        return new UnmodifiableIntStack(IntArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push()
    {
        this.classUnderTest().push(5);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void pop()
    {
        this.classUnderTest().pop();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void popWithCount()
    {
        this.classUnderTest().pop(2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.classUnderTest().clear();
    }

    @Test
    public void asUnmodifiable()
    {
        MutableIntStack stack1 = new UnmodifiableIntStack(IntArrayStack.newStackWith(1, 2, 3));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        MutableIntStack stack1 = new UnmodifiableIntStack(IntArrayStack.newStackWith(1, 2, 3));
        Verify.assertInstanceOf(SynchronizedIntStack.class, stack1.asSynchronized());
    }

    @Test
    public void intIterator_with_remove()
    {
        UnmodifiableIntStack intIterable = (UnmodifiableIntStack) this.classUnderTest();
        MutableIntIterator iterator = (MutableIntIterator) intIterable.intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void intIterator_throws_for_remove_before_next()
    {
        UnmodifiableIntStack intIterable = (UnmodifiableIntStack) this.classUnderTest();
        MutableIntIterator iterator = (MutableIntIterator) intIterable.intIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}
