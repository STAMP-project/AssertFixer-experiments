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

import org.eclipse.collections.api.factory.list.primitive.ImmutableCharListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class CharListsTest
{
    @Test
    public void immutables()
    {
        ImmutableCharListFactory listFactory = CharLists.immutable;
        Assert.assertEquals(new CharArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), listFactory.of((char) 1));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), listFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), listFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), listFactory.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharList.class, listFactory.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void emptyList()
    {
        Verify.assertEmpty(CharLists.immutable.of());
        Assert.assertSame(CharLists.immutable.of(), CharLists.immutable.of());
        Verify.assertPostSerializedIdentity(CharLists.immutable.of());
    }

    @Test
    public void newListWith()
    {
        ImmutableCharList list = CharLists.immutable.of();
        Assert.assertEquals(list, CharLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith((char) 1), CharLists.immutable.of((char) 1));
        Assert.assertEquals(list = list.newWith((char) 2), CharLists.immutable.of((char) 1, (char) 2));
        Assert.assertEquals(list = list.newWith((char) 3), CharLists.immutable.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(list = list.newWith((char) 4), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(list = list.newWith((char) 5), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(list = list.newWith((char) 6), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(list = list.newWith((char) 7), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(list = list.newWith((char) 8), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(list = list.newWith((char) 9), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(list = list.newWith((char) 10), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(list = list.newWith((char) 11), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11));
        Assert.assertEquals(list = list.newWith((char) 12), CharLists.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11, (char) 12));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray()
    {
        ImmutableCharList list = CharLists.immutable.of();
        Assert.assertEquals(list = list.newWith((char) 1), CharLists.immutable.of(new char[]{1}));
        Assert.assertEquals(list = list.newWith((char) 2), CharLists.immutable.of(new char[]{(char) 1, (char) 2}));
        Assert.assertEquals(list = list.newWith((char) 3), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3}));
        Assert.assertEquals(list = list.newWith((char) 4), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4}));
        Assert.assertEquals(list = list.newWith((char) 5), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5}));
        Assert.assertEquals(list = list.newWith((char) 6), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6}));
        Assert.assertEquals(list = list.newWith((char) 7), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7}));
        Assert.assertEquals(list = list.newWith((char) 8), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8}));
        Assert.assertEquals(list = list.newWith((char) 9), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9}));
        Assert.assertEquals(list = list.newWith((char) 10), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10}));
        Assert.assertEquals(list = list.newWith((char) 11), CharLists.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10, (char) 11}));
    }

    @Test
    public void newListWithList()
    {
        ImmutableCharList list = CharLists.immutable.of();
        CharArrayList charArrayList = CharArrayList.newListWith((char) 1);
        Assert.assertEquals(list = list.newWith((char) 1), charArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith((char) 2), charArrayList.with((char) 2).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 3), charArrayList.with((char) 3).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 4), charArrayList.with((char) 4).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 5), charArrayList.with((char) 5).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 6), charArrayList.with((char) 6).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 7), charArrayList.with((char) 7).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 8), charArrayList.with((char) 8).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 9), charArrayList.with((char) 9).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 10), charArrayList.with((char) 10).toImmutable());
        Assert.assertEquals(list = list.newWith((char) 11), charArrayList.with((char) 11).toImmutable());
    }

    @Test
    public void newListWithWithList()
    {
        Assert.assertEquals(new CharArrayList(), CharLists.immutable.ofAll(new CharArrayList()));
        Assert.assertEquals(CharArrayList.newListWith((char) 1), CharLists.immutable.ofAll(CharArrayList.newListWith((char) 1)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), CharLists.immutable.ofAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), CharLists.immutable.ofAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharLists.class);
    }
}
