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

import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.stack.primitive.MutableFloatStack;
import org.eclipse.collections.impl.stack.primitive.AbstractFloatStackTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file unmodifiablePrimitiveStackTest.stg.
 */
public class UnmodifiableFloatStackTest extends AbstractFloatStackTestCase
{
    @Override
    protected MutableFloatStack classUnderTest()
    {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected MutableFloatStack newWith(float... elements)
    {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableFloatStack newMutableCollectionWith(float... elements)
    {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackWith(elements));
    }

    @Override
    protected MutableFloatStack newWithTopToBottom(float... elements)
    {
        return new UnmodifiableFloatStack(FloatArrayStack.newStackFromTopToBottom(elements));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void push()
    {
        this.classUnderTest().push(5.0f);
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
        MutableFloatStack stack1 = new UnmodifiableFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(stack1, stack1.asUnmodifiable());
        Assert.assertSame(stack1, stack1.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        MutableFloatStack stack1 = new UnmodifiableFloatStack(FloatArrayStack.newStackWith(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(SynchronizedFloatStack.class, stack1.asSynchronized());
    }

    @Test
    public void floatIterator_with_remove()
    {
        UnmodifiableFloatStack floatIterable = (UnmodifiableFloatStack) this.classUnderTest();
        MutableFloatIterator iterator = (MutableFloatIterator) floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Test
    public void floatIterator_throws_for_remove_before_next()
    {
        UnmodifiableFloatStack floatIterable = (UnmodifiableFloatStack) this.classUnderTest();
        MutableFloatIterator iterator = (MutableFloatIterator) floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}
