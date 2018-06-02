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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractDoubleSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleBooleanHashMap#keySet()}.
 *
 * This file was automatically generated from template file primitiveBooleanHashMapKeySetTest.stg.
 */
public class DoubleBooleanHashMapKeySetTest extends AbstractDoubleSetTestCase
{
    @Override
    protected MutableDoubleSet classUnderTest()
    {
        return DoubleBooleanHashMap.newWithKeysValues(1.0, true, 2.0, false, 3.0, true).keySet();
    }

    @Override
    protected MutableDoubleSet newWith(double... elements)
    {
        DoubleBooleanHashMap map = new DoubleBooleanHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], (i & 1) == 0);
        }
        return map.keySet();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new DoubleArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NaN()
    {
        this.newWith(Double.NaN).add(Double.NaN);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_POSITIVE_INFINITY()
    {
        this.newWith(Double.POSITIVE_INFINITY).add(Double.POSITIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NEGATIVE_INFINITY()
    {
        this.newWith(Double.NEGATIVE_INFINITY).add(Double.NEGATIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll(0.0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without(0.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new DoubleArrayList());
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
        this.classUnderTest().withoutAll(new DoubleArrayList());
    }

    @Override
    public void testEquals()
    {
        MutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        MutableDoubleSet set3 = this.newWith(32.0, 32.0, 31.0, 1.0);
        MutableDoubleSet set4 = this.newWith(32.0, 32.0, 31.0, 1.0, 1.0);
        MutableDoubleSet set5 = this.newWith(32.0, 1.0);
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
        Assert.assertFalse(this.newWith(0.0, 1.0, 2.0).noneSatisfy(DoublePredicates.equal(0.0)));
    }

    @Override
    @Test
    public void sum()
    {
        super.sum();
        Assert.assertEquals(3.0, this.newWith(0.0, 1.0, 2.0).sum(), 0.0);
    }

    @Override
    @Test
    public void testHashCode()
    {
        MutableDoubleSet set1 = this.newWith(0.0, 1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0, 0.0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 31.0, 32.0).hashCode(), set1.hashCode());
    }

    @Override
    @Test
    public void chunk()
    {
        DoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        DoubleSets.mutable.with(1.0),
                        DoubleSets.mutable.with(2.0),
                        DoubleSets.mutable.with(3.0)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<DoubleIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        DoubleSets.mutable.with(1.0, 2.0),
                        DoubleSets.mutable.with(3.0)).toSet().equals(chunked)
                || Lists.mutable.with(
                        DoubleSets.mutable.with(2.0, 3.0),
                        DoubleSets.mutable.with(1.0)).toSet().equals(chunked)
                || Lists.mutable.with(
                        DoubleSets.mutable.with(1.0, 3.0),
                        DoubleSets.mutable.with(2.0)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        DoubleSets.mutable.with(1.0, 2.0, 3.0)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(DoubleSets.mutable.with(1.0, 2.0, 3.0)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
