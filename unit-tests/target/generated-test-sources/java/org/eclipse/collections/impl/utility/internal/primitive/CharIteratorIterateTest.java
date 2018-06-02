/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.utility.internal.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class CharIteratorIterateTest
{
    private final CharIterable iterable = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);

    @Test
    public void select_target()
    {
        Verify.assertSize(2, CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(2)));
        Verify.assertSize(2, CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(3)));
        Verify.assertEmpty(CharIteratorIterate.select(this.iterable.charIterator(), CharPredicates.lessThan((char) 0), new CharArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, CharIteratorIterate.reject(this.iterable.charIterator(), CharPredicates.greaterThan((char) 1), new CharArrayList(1)));
        Verify.assertEmpty(CharIteratorIterate.reject(this.iterable.charIterator(), CharPredicates.greaterThan((char) 0), new CharArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, CharIteratorIterate.collect(this.iterable.charIterator(), String::valueOf, FastList.<String>newList()));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, CharIteratorIterate.sum(this.iterable.charIterator()));
        Assert.assertEquals(0L, CharIteratorIterate.sum(new CharArrayList().charIterator()));
    }

    @Test
    public void min()
    {
        Assert.assertEquals((char) 1, CharIteratorIterate.min(this.iterable.charIterator()));
        Verify.assertThrows(NoSuchElementException.class, () -> CharIteratorIterate.min(new CharArrayList().charIterator()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals((char) 1, CharIteratorIterate.min(this.iterable.charIterator()));
        Verify.assertThrows(NoSuchElementException.class, () -> CharIteratorIterate.max(new CharArrayList().charIterator()));
    }
}
