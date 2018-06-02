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

import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractShortSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortDoubleMap#keySet()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableShortDoubleMapKeySetTest extends AbstractShortSetTestCase
{
    @Override
    protected MutableShortSet classUnderTest()
    {
        return new UnmodifiableShortDoubleMap(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0)).keySet();
    }

    @Override
    protected MutableShortSet newWith(short... elements)
    {
        ShortDoubleHashMap map = new ShortDoubleHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], i);
        }
        return map.asUnmodifiable().keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll((short) 0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without((short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove((short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(ShortPredicates.equal((short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable()
    {
        this.classUnderTest().removeAll(new ShortArrayList());
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
        this.classUnderTest().retainAll(new ShortArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll()
    {
        this.classUnderTest().retainAll();
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
        Assert.assertTrue(this.classUnderTest().contains((short) 1));
    }

    @Override
    public void testEquals()
    {
        MutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        MutableShortSet set3 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1);
        MutableShortSet set4 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1, (short) 1);
        MutableShortSet set5 = this.newWith((short) 32, (short) 1);
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
        Assert.assertFalse(this.newWith((short) 0, (short) 1, (short) 2).noneSatisfy(ShortPredicates.equal((short) 0)));
    }

    @Override
    @Test
    public void sum()
    {
        super.sum();
        Assert.assertEquals(3L, this.newWith((short) 0, (short) 1, (short) 2).sum());
    }

    @Override
    public void testHashCode()
    {
        MutableShortSet set1 = this.newWith((short) 0, (short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1, (short) 0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((short) 0, (short) 1, (short) 31, (short) 32).hashCode(), set1.hashCode());
    }

    @Override
    public void shortIterator_with_remove()
    {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void shortIterator_throws_for_remove_before_next()
    {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void shortIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable
    }
}
