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

import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.stack.primitive.MutableByteStack;
import org.eclipse.collections.impl.stack.primitive.AbstractByteStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableByteStackTest extends AbstractByteStackTestCase
{
    @Override
    protected MutableByteStack classUnderTest()
    {
        return new UnmodifiableByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected MutableByteStack newWith(byte... elements)
    {
        return new UnmodifiableByteStack(ByteArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableByteStack newMutableCollectionWith(byte... elements)
    {
        return new UnmodifiableByteStack(ByteArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableByteStack newWithTopToBottom(byte... elements)
    {
        return new UnmodifiableByteStack(ByteArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push()
    {
        this.classUnderTest().push((byte) 5);
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
        MutableByteStack stack1 = new UnmodifiableByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        MutableByteStack stack1 = new UnmodifiableByteStack(ByteArrayStack.newStackWith((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(SynchronizedByteStack.class, stack1.asSynchronized());
    }

    @Test
    public void byteIterator_with_remove()
    {
        UnmodifiableByteStack byteIterable = (UnmodifiableByteStack) this.classUnderTest();
        MutableByteIterator iterator = (MutableByteIterator) byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void byteIterator_throws_for_remove_before_next()
    {
        UnmodifiableByteStack byteIterable = (UnmodifiableByteStack) this.classUnderTest();
        MutableByteIterator iterator = (MutableByteIterator) byteIterable.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}
