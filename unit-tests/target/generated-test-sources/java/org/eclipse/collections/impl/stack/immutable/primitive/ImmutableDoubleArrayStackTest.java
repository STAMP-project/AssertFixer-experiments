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

import org.eclipse.collections.api.stack.primitive.ImmutableDoubleStack;
import org.eclipse.collections.impl.factory.primitive.DoubleStacks;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableDoubleArrayStackTest extends AbstractImmutableDoubleStackTestCase
{
    @Override
    protected ImmutableDoubleStack classUnderTest()
    {
        return ImmutableDoubleArrayStack.newStackWith(1.0, 2.0, 3.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableDoubleArrayStack.newStack(DoubleStacks.mutable.with(1.0));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(DoubleArrayStack.newStackWith(1.0, 2.0, 3.0), this.newWithIterable(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(DoubleArrayStack.newStackFromTopToBottom(1.0, 2.0, 3.0), this.newWithTopToBottom(1.0, 2.0, 3.0));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleArrayStack iterable = ImmutableDoubleArrayStack.newStackWith(1.0, 2.0, 3.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }
}
