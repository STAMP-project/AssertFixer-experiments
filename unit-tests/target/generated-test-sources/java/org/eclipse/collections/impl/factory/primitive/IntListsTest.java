/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.list.primitive.ImmutableIntListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class IntListsTest
{
    @Test
    public void immutables()
    {
        ImmutableIntListFactory listFactory = IntLists.immutable;
        Assert.assertEquals(new IntArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of());
        Assert.assertEquals(IntArrayList.newListWith(1), listFactory.of(1));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), listFactory.of(1, 2));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), listFactory.of(1, 2, 3));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4), listFactory.of(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), listFactory.of(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6), listFactory.of(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7), listFactory.of(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), listFactory.ofAll(IntArrayList.newListWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableIntList.class, listFactory.ofAll(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test
    public void emptyList()
    {
        Verify.assertEmpty(IntLists.immutable.of());
        Assert.assertSame(IntLists.immutable.of(), IntLists.immutable.of());
        Verify.assertPostSerializedIdentity(IntLists.immutable.of());
    }

    @Test
    public void newListWith()
    {
        ImmutableIntList list = IntLists.immutable.of();
        Assert.assertEquals(list, IntLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1), IntLists.immutable.of(1));
        Assert.assertEquals(list = list.newWith(2), IntLists.immutable.of(1, 2));
        Assert.assertEquals(list = list.newWith(3), IntLists.immutable.of(1, 2, 3));
        Assert.assertEquals(list = list.newWith(4), IntLists.immutable.of(1, 2, 3, 4));
        Assert.assertEquals(list = list.newWith(5), IntLists.immutable.of(1, 2, 3, 4, 5));
        Assert.assertEquals(list = list.newWith(6), IntLists.immutable.of(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(list = list.newWith(7), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(list = list.newWith(8), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(list = list.newWith(9), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(list = list.newWith(10), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(list = list.newWith(11), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Assert.assertEquals(list = list.newWith(12), IntLists.immutable.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray()
    {
        ImmutableIntList list = IntLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1), IntLists.immutable.of(new int[]{1}));
        Assert.assertEquals(list = list.newWith(2), IntLists.immutable.of(new int[]{1, 2}));
        Assert.assertEquals(list = list.newWith(3), IntLists.immutable.of(new int[]{1, 2, 3}));
        Assert.assertEquals(list = list.newWith(4), IntLists.immutable.of(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(list = list.newWith(5), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(list = list.newWith(6), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(list = list.newWith(7), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(list = list.newWith(8), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        Assert.assertEquals(list = list.newWith(9), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals(list = list.newWith(10), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        Assert.assertEquals(list = list.newWith(11), IntLists.immutable.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}));
    }

    @Test
    public void newListWithList()
    {
        ImmutableIntList list = IntLists.immutable.of();
        IntArrayList intArrayList = IntArrayList.newListWith(1);
        Assert.assertEquals(list = list.newWith(1), intArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2), intArrayList.with(2).toImmutable());
        Assert.assertEquals(list = list.newWith(3), intArrayList.with(3).toImmutable());
        Assert.assertEquals(list = list.newWith(4), intArrayList.with(4).toImmutable());
        Assert.assertEquals(list = list.newWith(5), intArrayList.with(5).toImmutable());
        Assert.assertEquals(list = list.newWith(6), intArrayList.with(6).toImmutable());
        Assert.assertEquals(list = list.newWith(7), intArrayList.with(7).toImmutable());
        Assert.assertEquals(list = list.newWith(8), intArrayList.with(8).toImmutable());
        Assert.assertEquals(list = list.newWith(9), intArrayList.with(9).toImmutable());
        Assert.assertEquals(list = list.newWith(10), intArrayList.with(10).toImmutable());
        Assert.assertEquals(list = list.newWith(11), intArrayList.with(11).toImmutable());
    }

    @Test
    public void newListWithWithList()
    {
        Assert.assertEquals(new IntArrayList(), IntLists.immutable.ofAll(new IntArrayList()));
        Assert.assertEquals(IntArrayList.newListWith(1), IntLists.immutable.ofAll(IntArrayList.newListWith(1)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2), IntLists.immutable.ofAll(IntArrayList.newListWith(1, 2)));
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), IntLists.immutable.ofAll(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntLists.class);
    }
}
