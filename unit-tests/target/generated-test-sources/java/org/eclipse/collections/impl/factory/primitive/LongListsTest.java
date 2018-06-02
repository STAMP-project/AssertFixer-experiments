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

import org.eclipse.collections.api.factory.list.primitive.ImmutableLongListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class LongListsTest
{
    @Test
    public void immutables()
    {
        ImmutableLongListFactory listFactory = LongLists.immutable;
        Assert.assertEquals(new LongArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of());
        Assert.assertEquals(LongArrayList.newListWith(1L), listFactory.of(1L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), listFactory.of(1L, 2L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), listFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L), listFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), listFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), listFactory.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(ImmutableLongList.class, listFactory.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void emptyList()
    {
        Verify.assertEmpty(LongLists.immutable.of());
        Assert.assertSame(LongLists.immutable.of(), LongLists.immutable.of());
        Verify.assertPostSerializedIdentity(LongLists.immutable.of());
    }

    @Test
    public void newListWith()
    {
        ImmutableLongList list = LongLists.immutable.of();
        Assert.assertEquals(list, LongLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1L), LongLists.immutable.of(1L));
        Assert.assertEquals(list = list.newWith(2L), LongLists.immutable.of(1L, 2L));
        Assert.assertEquals(list = list.newWith(3L), LongLists.immutable.of(1L, 2L, 3L));
        Assert.assertEquals(list = list.newWith(4L), LongLists.immutable.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(list = list.newWith(5L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(list = list.newWith(6L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(list = list.newWith(7L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(list = list.newWith(8L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(list = list.newWith(9L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(list = list.newWith(10L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(list = list.newWith(11L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L));
        Assert.assertEquals(list = list.newWith(12L), LongLists.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray()
    {
        ImmutableLongList list = LongLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1L), LongLists.immutable.of(new long[]{1}));
        Assert.assertEquals(list = list.newWith(2L), LongLists.immutable.of(new long[]{1L, 2L}));
        Assert.assertEquals(list = list.newWith(3L), LongLists.immutable.of(new long[]{1L, 2L, 3L}));
        Assert.assertEquals(list = list.newWith(4L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L}));
        Assert.assertEquals(list = list.newWith(5L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L}));
        Assert.assertEquals(list = list.newWith(6L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L}));
        Assert.assertEquals(list = list.newWith(7L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L}));
        Assert.assertEquals(list = list.newWith(8L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L}));
        Assert.assertEquals(list = list.newWith(9L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L}));
        Assert.assertEquals(list = list.newWith(10L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}));
        Assert.assertEquals(list = list.newWith(11L), LongLists.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L}));
    }

    @Test
    public void newListWithList()
    {
        ImmutableLongList list = LongLists.immutable.of();
        LongArrayList longArrayList = LongArrayList.newListWith(1L);
        Assert.assertEquals(list = list.newWith(1L), longArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2L), longArrayList.with(2L).toImmutable());
        Assert.assertEquals(list = list.newWith(3L), longArrayList.with(3L).toImmutable());
        Assert.assertEquals(list = list.newWith(4L), longArrayList.with(4L).toImmutable());
        Assert.assertEquals(list = list.newWith(5L), longArrayList.with(5L).toImmutable());
        Assert.assertEquals(list = list.newWith(6L), longArrayList.with(6L).toImmutable());
        Assert.assertEquals(list = list.newWith(7L), longArrayList.with(7L).toImmutable());
        Assert.assertEquals(list = list.newWith(8L), longArrayList.with(8L).toImmutable());
        Assert.assertEquals(list = list.newWith(9L), longArrayList.with(9L).toImmutable());
        Assert.assertEquals(list = list.newWith(10L), longArrayList.with(10L).toImmutable());
        Assert.assertEquals(list = list.newWith(11L), longArrayList.with(11L).toImmutable());
    }

    @Test
    public void newListWithWithList()
    {
        Assert.assertEquals(new LongArrayList(), LongLists.immutable.ofAll(new LongArrayList()));
        Assert.assertEquals(LongArrayList.newListWith(1L), LongLists.immutable.ofAll(LongArrayList.newListWith(1L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), LongLists.immutable.ofAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), LongLists.immutable.ofAll(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongLists.class);
    }
}
