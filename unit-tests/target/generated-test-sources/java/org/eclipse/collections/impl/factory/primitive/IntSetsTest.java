/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory.primitive;

import java.util.Set;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableIntSetFactory;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link IntSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class IntSetsTest
{
    @Test
    public void immutables()
    {
        ImmutableIntSetFactory setFactory = IntSets.immutable;
        Assert.assertEquals(IntHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.empty());
        Assert.assertEquals(IntHashSet.newSetWith(1), setFactory.with(1));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2), setFactory.with(1, 2));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), setFactory.with(1, 2, 3));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4), setFactory.with(1, 2, 3, 4));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5), setFactory.with(1, 2, 3, 4, 5));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4, 5));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5, 6), setFactory.with(1, 2, 3, 4, 5, 6));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5, 6, 7), setFactory.with(1, 2, 3, 4, 5, 6, 7));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8), setFactory.with(1, 2, 3, 4, 5, 6, 7, 8));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8, 9), setFactory.with(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), setFactory.with(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.with(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), setFactory.withAll(IntHashSet.newSetWith(1, 2, 3)));
        Verify.assertInstanceOf(ImmutableIntSet.class, setFactory.withAll(IntHashSet.newSetWith(1, 2, 3)));
    }

    @Test
    public void emptySet()
    {
        Assert.assertTrue(IntSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith()
    {
        ImmutableIntSet set = IntSets.immutable.empty();
        Assert.assertEquals(set, IntSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith(1), IntSets.immutable.with(1));
        Assert.assertEquals(set = set.newWith(2), IntSets.immutable.with(1, 2));
        Assert.assertEquals(set = set.newWith(3), IntSets.immutable.with(1, 2, 3));
        Assert.assertEquals(set = set.newWith(4), IntSets.immutable.with(1, 2, 3, 4));
        Assert.assertEquals(set = set.newWith(5), IntSets.immutable.with(1, 2, 3, 4, 5));
        Assert.assertEquals(set = set.newWith(6), IntSets.immutable.with(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(set = set.newWith(7), IntSets.immutable.with(1, 2, 3, 4, 5, 6, 7));
        Assert.assertEquals(set = set.newWith(8), IntSets.immutable.with(1, 2, 3, 4, 5, 6, 7, 8));
        Assert.assertEquals(set = set.newWith(9), IntSets.immutable.with(1, 2, 3, 4, 5, 6, 7, 8, 9));
        Assert.assertEquals(set = set.newWith(10), IntSets.immutable.with(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray()
    {
        ImmutableIntSet set = IntSets.immutable.empty();
        Assert.assertEquals(set = set.newWith(1), IntSets.immutable.with(new int[]{1}));
        Assert.assertEquals(set = set.newWith(2), IntSets.immutable.with(new int[]{1, 2}));
        Assert.assertEquals(set = set.newWith(3), IntSets.immutable.with(new int[]{1, 2, 3}));
        Assert.assertEquals(set = set.newWith(4), IntSets.immutable.with(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(set = set.newWith(5), IntSets.immutable.with(new int[]{1, 2, 3, 4, 5}));
        Assert.assertEquals(set = set.newWith(6), IntSets.immutable.with(new int[]{1, 2, 3, 4, 5, 6}));
        Assert.assertEquals(set = set.newWith(7), IntSets.immutable.with(new int[]{1, 2, 3, 4, 5, 6, 7}));
        Assert.assertEquals(set = set.newWith(8), IntSets.immutable.with(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        Assert.assertEquals(set = set.newWith(9), IntSets.immutable.with(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        Assert.assertEquals(set = set.newWith(10), IntSets.immutable.with(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }

    @Test
    public void newSetWithSet()
    {
        ImmutableIntSet set = IntSets.immutable.empty();
        IntHashSet hashSet = IntHashSet.newSetWith(1);
        Assert.assertEquals(set = set.newWith(1), hashSet.toImmutable());
        hashSet.add(2);
        Assert.assertEquals(set = set.newWith(2), hashSet.toImmutable());
        hashSet.add(3);
        Assert.assertEquals(set = set.newWith(3), hashSet.toImmutable());
        hashSet.add(4);
        Assert.assertEquals(set = set.newWith(4), hashSet.toImmutable());
        hashSet.add(5);
        Assert.assertEquals(set = set.newWith(5), hashSet.toImmutable());
        hashSet.add(6);
        Assert.assertEquals(set = set.newWith(6), hashSet.toImmutable());
        hashSet.add(7);
        Assert.assertEquals(set = set.newWith(7), hashSet.toImmutable());
        hashSet.add(8);
        Assert.assertEquals(set = set.newWith(8), hashSet.toImmutable());
        hashSet.add(9);
        Assert.assertEquals(set = set.newWith(9), hashSet.toImmutable());
        hashSet.add(10);
        Assert.assertEquals(set = set.newWith(10), hashSet.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntSets.class);
    }

    @Test
    public void cartesianProduct()
    {
        LazyIterable<IntIntPair> intIntPairs1 =
                IntSets.cartesianProduct(
                        IntSets.mutable.with(1, 2),
                        IntSets.mutable.with(3, 4, 5));

        Set<IntIntPair> expected1 = Sets.mutable.with(
                PrimitiveTuples.pair(1, 3),
                PrimitiveTuples.pair(1, 4),
                PrimitiveTuples.pair(1, 5),
                PrimitiveTuples.pair(2, 3),
                PrimitiveTuples.pair(2, 4),
                PrimitiveTuples.pair(2, 5)
        );

        Assert.assertEquals(expected1, intIntPairs1.toSet());

        LazyIterable<IntIntPair> intIntPairs2 =
                IntSets.cartesianProduct(
                        IntSets.mutable.with(3, 4, 5),
                        IntSets.mutable.with(1, 2));

        Set<IntIntPair> expected2 = Sets.mutable.with(
                PrimitiveTuples.pair(3, 1),
                PrimitiveTuples.pair(3, 2),
                PrimitiveTuples.pair(4, 1),
                PrimitiveTuples.pair(4, 2),
                PrimitiveTuples.pair(5, 1),
                PrimitiveTuples.pair(5, 2)
        );

        Assert.assertEquals(expected2, intIntPairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements()
    {
        LazyIterable<IntIntPair> intIntPairs =
                IntSets.cartesianProduct(
                        IntSets.mutable.with(1, 2),
                        IntSets.mutable.with(1, 2));

        Set<IntIntPair> expected = Sets.mutable.with(
                PrimitiveTuples.pair(1, 1),
                PrimitiveTuples.pair(1, 2),
                PrimitiveTuples.pair(2, 2),
                PrimitiveTuples.pair(2, 1)
        );

        Assert.assertEquals(expected, intIntPairs.toSet());
    }
}
