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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractLongSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongBooleanMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapKeySetTest.stg.
 */
public class UnmodifiableLongBooleanMapKeySetTest extends AbstractLongSetTestCase
{
    @Override
    protected MutableLongSet classUnderTest()
    {
        return new UnmodifiableLongBooleanMap(LongBooleanHashMap.newWithKeysValues(1L, true, 2L, false, 3L, true)).keySet();
    }

    @Override
    protected MutableLongSet newWith(long... elements)
    {
        LongBooleanHashMap map = new LongBooleanHashMap();
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
        this.classUnderTest().addAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll(0L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new LongArrayList());
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
        this.classUnderTest().withoutAll(new LongArrayList());
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
        Assert.assertTrue(this.classUnderTest().contains(1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove(1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(LongPredicates.equal(1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable()
    {
        this.classUnderTest().removeAll(new LongArrayList());
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
        this.classUnderTest().retainAll(new LongArrayList());
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
        MutableLongSet set1 = this.newWith(1L, 31L, 32L);
        MutableLongSet set2 = this.newWith(32L, 31L, 1L);
        MutableLongSet set3 = this.newWith(32L, 32L, 31L, 1L);
        MutableLongSet set4 = this.newWith(32L, 32L, 31L, 1L, 1L);
        MutableLongSet set5 = this.newWith(32L, 1L);
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
        Assert.assertFalse(this.newWith(0L, 1L, 2L).noneSatisfy(LongPredicates.equal(0L)));
    }

    @Override
    @Test
    public void sum()
    {
        super.sum();
        Assert.assertEquals(3L, this.newWith(0L, 1L, 2L).sum());
    }

    @Override
    @Test
    public void testHashCode()
    {
        MutableLongSet set1 = this.newWith(0L, 1L, 31L, 32L);
        MutableLongSet set2 = this.newWith(32L, 31L, 1L, 0L);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 31L, 32L).hashCode(), set1.hashCode());
    }

    @Override
    @Test
    public void longIterator_with_remove()
    {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void longIterator_throws_for_remove_before_next()
    {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void longIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test
    public void chunk()
    {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        LongSets.mutable.with(1L),
                        LongSets.mutable.with(2L),
                        LongSets.mutable.with(3L)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<LongIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        LongSets.mutable.with(1L, 2L),
                        LongSets.mutable.with(3L)).toSet().equals(chunked)
                || Lists.mutable.with(
                        LongSets.mutable.with(2L, 3L),
                        LongSets.mutable.with(1L)).toSet().equals(chunked)
                || Lists.mutable.with(
                        LongSets.mutable.with(1L, 3L),
                        LongSets.mutable.with(2L)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        LongSets.mutable.with(1L, 2L, 3L)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(LongSets.mutable.with(1L, 2L, 3L)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
