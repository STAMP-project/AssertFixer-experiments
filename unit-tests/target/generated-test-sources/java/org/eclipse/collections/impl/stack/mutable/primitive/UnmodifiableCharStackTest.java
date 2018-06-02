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

import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.stack.primitive.MutableCharStack;
import org.eclipse.collections.impl.stack.primitive.AbstractCharStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableCharStackTest extends AbstractCharStackTestCase
{
    @Override
    protected MutableCharStack classUnderTest()
    {
        return new UnmodifiableCharStack(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected MutableCharStack newWith(char... elements)
    {
        return new UnmodifiableCharStack(CharArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableCharStack newMutableCollectionWith(char... elements)
    {
        return new UnmodifiableCharStack(CharArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableCharStack newWithTopToBottom(char... elements)
    {
        return new UnmodifiableCharStack(CharArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push()
    {
        this.classUnderTest().push((char) 5);
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
        MutableCharStack stack1 = new UnmodifiableCharStack(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        MutableCharStack stack1 = new UnmodifiableCharStack(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(SynchronizedCharStack.class, stack1.asSynchronized());
    }

    @Test
    public void charIterator_with_remove()
    {
        UnmodifiableCharStack charIterable = (UnmodifiableCharStack) this.classUnderTest();
        MutableCharIterator iterator = (MutableCharIterator) charIterable.charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void charIterator_throws_for_remove_before_next()
    {
        UnmodifiableCharStack charIterable = (UnmodifiableCharStack) this.classUnderTest();
        MutableCharIterator iterator = (MutableCharIterator) charIterable.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}
