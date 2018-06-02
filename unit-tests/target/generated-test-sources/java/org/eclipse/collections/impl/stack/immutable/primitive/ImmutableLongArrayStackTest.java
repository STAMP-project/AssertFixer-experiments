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

import org.eclipse.collections.api.stack.primitive.ImmutableLongStack;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableLongArrayStackTest extends AbstractImmutableLongStackTestCase
{
    @Override
    protected ImmutableLongStack classUnderTest()
    {
        return ImmutableLongArrayStack.newStackWith(1L, 2L, 3L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableLongArrayStack.newStack(LongStacks.mutable.with(1L));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(LongArrayStack.newStackWith(1L, 2L, 3L), this.newWithIterable(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(LongArrayStack.newStackFromTopToBottom(1L, 2L, 3L), this.newWithTopToBottom(1L, 2L, 3L));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableLongArrayStack iterable = ImmutableLongArrayStack.newStackWith(1L, 2L, 3L);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
