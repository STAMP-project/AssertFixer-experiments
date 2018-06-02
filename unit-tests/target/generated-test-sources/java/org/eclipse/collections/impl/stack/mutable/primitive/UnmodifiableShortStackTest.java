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

import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.stack.primitive.MutableShortStack;
import org.eclipse.collections.impl.stack.primitive.AbstractShortStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableShortStackTest extends AbstractShortStackTestCase
{
    @Override
    protected MutableShortStack classUnderTest()
    {
        return new UnmodifiableShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected MutableShortStack newWith(short... elements)
    {
        return new UnmodifiableShortStack(ShortArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableShortStack newMutableCollectionWith(short... elements)
    {
        return new UnmodifiableShortStack(ShortArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableShortStack newWithTopToBottom(short... elements)
    {
        return new UnmodifiableShortStack(ShortArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push()
    {
        this.classUnderTest().push((short) 5);
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
        MutableShortStack stack1 = new UnmodifiableShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        MutableShortStack stack1 = new UnmodifiableShortStack(ShortArrayStack.newStackWith((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(SynchronizedShortStack.class, stack1.asSynchronized());
    }

    @Test
    public void shortIterator_with_remove()
    {
        UnmodifiableShortStack shortIterable = (UnmodifiableShortStack) this.classUnderTest();
        MutableShortIterator iterator = (MutableShortIterator) shortIterable.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void shortIterator_throws_for_remove_before_next()
    {
        UnmodifiableShortStack shortIterable = (UnmodifiableShortStack) this.classUnderTest();
        MutableShortIterator iterator = (MutableShortIterator) shortIterable.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}
