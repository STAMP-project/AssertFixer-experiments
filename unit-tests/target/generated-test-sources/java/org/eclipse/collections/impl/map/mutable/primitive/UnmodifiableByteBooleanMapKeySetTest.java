/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractByteSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteBooleanMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapKeySetTest.stg.
 */
public class UnmodifiableByteBooleanMapKeySetTest extends AbstractByteSetTestCase
{
    @Override
    protected MutableByteSet classUnderTest()
    {
        return new UnmodifiableByteBooleanMap(ByteBooleanHashMap.newWithKeysValues((byte) 1, true, (byte) 2, false, (byte) 3, true)).keySet();
    }

    @Override
    protected MutableByteSet newWith(byte... elements)
    {
        ByteBooleanHashMap map = new ByteBooleanHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], (i & 1) == 0);
        }
        return map.asUnmodifiable().keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll((byte) 0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new ByteArrayList());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void freeze()
    {
        this.classUnderTest().freeze();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.classUnderTest().clear();
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.classUnderTest().contains((byte) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove((byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(BytePredicates.equal((byte) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable()
    {
        this.classUnderTest().removeAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll()
    {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable()
    {
        this.classUnderTest().retainAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll()
    {
        this.classUnderTest().retainAll();
    }

    @Override
    public void testEquals()
    {
        MutableByteSet set1 = this.newWith((byte) 1, (byte) 31, (byte) 32);
        MutableByteSet set2 = this.newWith((byte) 32, (byte) 31, (byte) 1);
        MutableByteSet set3 = this.newWith((byte) 32, (byte) 32, (byte) 31, (byte) 1);
        MutableByteSet set4 = this.newWith((byte) 32, (byte) 32, (byte) 31, (byte) 1, (byte) 1);
        MutableByteSet set5 = this.newWith((byte) 32, (byte) 1);
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
        Assert.assertFalse(this.newWith((byte) 0, (byte) 1, (byte) 2).noneSatisfy(BytePredicates.equal((byte) 0)));
    }

    @Override
    @Test
    public void sum()
    {
        super.sum();
        Assert.assertEquals(3L, this.newWith((byte) 0, (byte) 1, (byte) 2).sum());
    }

    @Override
    @Test
    public void testHashCode()
    {
        MutableByteSet set1 = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32);
        MutableByteSet set2 = this.newWith((byte) 32, (byte) 31, (byte) 1, (byte) 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 31, (byte) 32).hashCode(), set1.hashCode());
    }

    @Override
    @Test
    public void byteIterator_with_remove()
    {
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_remove_before_next()
    {
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test
    public void chunk()
    {
        ByteIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        ByteSets.mutable.with((byte) 1),
                        ByteSets.mutable.with((byte) 2),
                        ByteSets.mutable.with((byte) 3)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<ByteIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        ByteSets.mutable.with((byte) 1, (byte) 2),
                        ByteSets.mutable.with((byte) 3)).toSet().equals(chunked)
                || Lists.mutable.with(
                        ByteSets.mutable.with((byte) 2, (byte) 3),
                        ByteSets.mutable.with((byte) 1)).toSet().equals(chunked)
                || Lists.mutable.with(
                        ByteSets.mutable.with((byte) 1, (byte) 3),
                        ByteSets.mutable.with((byte) 2)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        ByteSets.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(ByteSets.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
