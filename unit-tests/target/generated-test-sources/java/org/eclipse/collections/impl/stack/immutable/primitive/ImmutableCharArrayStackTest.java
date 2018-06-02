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

import org.eclipse.collections.api.stack.primitive.ImmutableCharStack;
import org.eclipse.collections.impl.factory.primitive.CharStacks;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharArrayStack}.
 * This file was automatically generated from template file immutablePrimitiveArrayStackTest.stg.
 */
public class ImmutableCharArrayStackTest extends AbstractImmutableCharStackTestCase
{
    @Override
    protected ImmutableCharStack classUnderTest()
    {
        return ImmutableCharArrayStack.newStackWith((char) 1, (char) 2, (char) 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewStack_throws()
    {
        ImmutableCharArrayStack.newStack(CharStacks.mutable.with((char) 1));
    }

    @Test
    public void newWithIterable()
    {
        Assert.assertEquals(CharArrayStack.newStackWith((char) 1, (char) 2, (char) 3), this.newWithIterable(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void newWithTopToBottom()
    {
        Assert.assertEquals(CharArrayStack.newStackFromTopToBottom((char) 1, (char) 2, (char) 3), this.newWithTopToBottom((char) 1, (char) 2, (char) 3));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableCharArrayStack iterable = ImmutableCharArrayStack.newStackWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }
}
