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

import org.eclipse.collections.api.factory.list.primitive.ImmutableByteListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class ByteListsTest
{
    @Test
    public void immutables()
    {
        ImmutableByteListFactory listFactory = ByteLists.immutable;
        Assert.assertEquals(new ByteArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of());
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), listFactory.of((byte) 1));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), listFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), listFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), listFactory.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(ImmutableByteList.class, listFactory.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void emptyList()
    {
        Verify.assertEmpty(ByteLists.immutable.of());
        Assert.assertSame(ByteLists.immutable.of(), ByteLists.immutable.of());
        Verify.assertPostSerializedIdentity(ByteLists.immutable.of());
    }

    @Test
    public void newListWith()
    {
        ImmutableByteList list = ByteLists.immutable.of();
        Assert.assertEquals(list, ByteLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith((byte) 1), ByteLists.immutable.of((byte) 1));
        Assert.assertEquals(list = list.newWith((byte) 2), ByteLists.immutable.of((byte) 1, (byte) 2));
        Assert.assertEquals(list = list.newWith((byte) 3), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(list = list.newWith((byte) 4), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(list = list.newWith((byte) 5), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(list = list.newWith((byte) 6), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(list = list.newWith((byte) 7), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(list = list.newWith((byte) 8), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(list = list.newWith((byte) 9), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(list = list.newWith((byte) 10), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(list = list.newWith((byte) 11), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11));
        Assert.assertEquals(list = list.newWith((byte) 12), ByteLists.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray()
    {
        ImmutableByteList list = ByteLists.immutable.of();
        Assert.assertEquals(list = list.newWith((byte) 1), ByteLists.immutable.of(new byte[]{1}));
        Assert.assertEquals(list = list.newWith((byte) 2), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2}));
        Assert.assertEquals(list = list.newWith((byte) 3), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3}));
        Assert.assertEquals(list = list.newWith((byte) 4), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4}));
        Assert.assertEquals(list = list.newWith((byte) 5), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5}));
        Assert.assertEquals(list = list.newWith((byte) 6), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6}));
        Assert.assertEquals(list = list.newWith((byte) 7), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7}));
        Assert.assertEquals(list = list.newWith((byte) 8), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8}));
        Assert.assertEquals(list = list.newWith((byte) 9), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9}));
        Assert.assertEquals(list = list.newWith((byte) 10), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10}));
        Assert.assertEquals(list = list.newWith((byte) 11), ByteLists.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10, (byte) 11}));
    }

    @Test
    public void newListWithList()
    {
        ImmutableByteList list = ByteLists.immutable.of();
        ByteArrayList byteArrayList = ByteArrayList.newListWith((byte) 1);
        Assert.assertEquals(list = list.newWith((byte) 1), byteArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 2), byteArrayList.with((byte) 2).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 3), byteArrayList.with((byte) 3).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 4), byteArrayList.with((byte) 4).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 5), byteArrayList.with((byte) 5).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 6), byteArrayList.with((byte) 6).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 7), byteArrayList.with((byte) 7).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 8), byteArrayList.with((byte) 8).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 9), byteArrayList.with((byte) 9).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 10), byteArrayList.with((byte) 10).toImmutable());
        Assert.assertEquals(list = list.newWith((byte) 11), byteArrayList.with((byte) 11).toImmutable());
    }

    @Test
    public void newListWithWithList()
    {
        Assert.assertEquals(new ByteArrayList(), ByteLists.immutable.ofAll(new ByteArrayList()));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), ByteLists.immutable.ofAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), ByteLists.immutable.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2)));
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ByteLists.immutable.ofAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteLists.class);
    }
}
