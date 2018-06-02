/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractCharSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharObjectHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitiveObjectHashMapKeySetTest.stg.
 */
public class CharObjectHashMapKeySetTest extends AbstractCharSetTestCase
{
    @Override
    protected MutableCharSet classUnderTest()
    {
        return CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).keySet();
    }

    @Override
    protected MutableCharSet newWith(char... elements)
    {
        CharObjectHashMap<Integer> map = new CharObjectHashMap<>();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], i);
        }
        return map.keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll((char) 0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without((char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new CharArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new CharArrayList());
    }

    @Override
    public void testEquals()
    {
        MutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        MutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        MutableCharSet set3 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1);
        MutableCharSet set4 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1, (char) 1);
        MutableCharSet set5 = this.newWith((char) 32, (char) 1);
        Verify.assertEqualsAndHashCode(set1, set2);
        Verify.assertEqualsAndHashCode(set1, set3);
        Verify.assertEqualsAndHashCode(set1, set4);
        Verify.assertEqualsAndHashCode(set2, set3);
        Verify.assertEqualsAndHashCode(set2, set4);
        Assert.assertNotEquals(set1, set5);
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        super.noneSatisfy();
        Assert.assertFalse(this.newWith((char) 0, (char) 1, (char) 2).noneSatisfy(CharPredicates.equal((char) 0)));
    }

    @Override
    @Test
    public void sum()
    {
        super.sum();
        Assert.assertEquals(3L, this.newWith((char) 0, (char) 1, (char) 2).sum());
    }

    @Override
    public void testHashCode()
    {
        MutableCharSet set1 = this.newWith((char) 0, (char) 1, (char) 31, (char) 32);
        MutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1, (char) 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 31, (char) 32).hashCode(), set1.hashCode());
    }

    @Override
    @Test
    public void chunk()
    {
        CharIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        CharSets.mutable.with((char) 1),
                        CharSets.mutable.with((char) 2),
                        CharSets.mutable.with((char) 3)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<CharIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        CharSets.mutable.with((char) 1, (char) 2),
                        CharSets.mutable.with((char) 3)).toSet().equals(chunked)
                || Lists.mutable.with(
                        CharSets.mutable.with((char) 2, (char) 3),
                        CharSets.mutable.with((char) 1)).toSet().equals(chunked)
                || Lists.mutable.with(
                        CharSets.mutable.with((char) 1, (char) 3),
                        CharSets.mutable.with((char) 2)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        CharSets.mutable.with((char) 1, (char) 2, (char) 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(CharSets.mutable.with((char) 1, (char) 2, (char) 3)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
