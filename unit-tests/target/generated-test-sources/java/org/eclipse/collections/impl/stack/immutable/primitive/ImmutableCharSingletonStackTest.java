/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.immutable.primitive;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.stack.primitive.ImmutableCharStack;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharSingletonStack}.
 * This file was automatically generated from template file immutablePrimitiveSingletonStackTest.stg.
 */
public class ImmutableCharSingletonStackTest extends AbstractImmutableCharStackTestCase
{
    @Override
    protected ImmutableCharStack classUnderTest()
    {
        return new ImmutableCharSingletonStack((char) 1);
    }

    @Override
    @Test
    public void pop()
    {
        ImmutableCharStack stack = this.classUnderTest();
        ImmutableCharStack modified = stack.pop();
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void popWithCount()
    {
        ImmutableCharStack stack = this.classUnderTest();
        ImmutableCharStack stack1 = stack.pop(0);
        Assert.assertSame(stack1, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
        ImmutableCharStack modified = stack.pop(1);
        Verify.assertEmpty(modified);
        Verify.assertSize(1, stack);
        Assert.assertNotSame(modified, stack);
        Assert.assertEquals(this.classUnderTest(), stack);
    }

    @Override
    @Test
    public void detectIfNone()
    {
        CharIterable iterable = this.classUnderTest();
        Assert.assertEquals(0L, iterable.detectIfNone(CharPredicates.equal((char) 4), (char) 0));
        Assert.assertEquals(1L, iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
    }

    @Override
    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(CharArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(CharArrayList.newListWith((char) 1),
                this.classUnderTest().peek(1));
        Verify.assertThrows(IllegalArgumentException.class, () -> { this.classUnderTest().peek(2); });
    }

    @Override
    @Test
    public void testEquals()
    {
        ImmutableCharStack stack = this.classUnderTest();
        Assert.assertEquals(stack, stack);
        Verify.assertPostSerializedEqualsAndHashCode(stack);
        Assert.assertEquals(stack, CharArrayStack.newStackWith((char) 1));
        Assert.assertNotEquals(stack, this.newWith((char) 1, (char) 2));
        Assert.assertNotEquals(stack, CharArrayList.newListWith((char) 1));
        Assert.assertEquals(stack, this.newWith((char) 1));
        Assert.assertNotEquals(stack, this.newWith());
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableCharSingletonStack iterable = new ImmutableCharSingletonStack((char) 1);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 1), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 2), result);
    }
}
