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
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.factory.set.primitive.ImmutableCharSetFactory;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharSets}
 * This file was automatically generated from template file primitiveSetsTest.stg
 */
public class CharSetsTest
{
    @Test
    public void immutables()
    {
        ImmutableCharSetFactory setFactory = CharSets.immutable;
        Assert.assertEquals(CharHashSet.newSetWith(), setFactory.empty());
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.empty());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), setFactory.with((char) 1));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), setFactory.with((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), setFactory.with((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), setFactory.withAll(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharSet.class, setFactory.withAll(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void emptySet()
    {
        Assert.assertTrue(CharSets.immutable.empty().isEmpty());
    }

    @Test
    public void newSetWith()
    {
        ImmutableCharSet set = CharSets.immutable.empty();
        Assert.assertEquals(set, CharSets.immutable.of(set.toArray()));
        Assert.assertEquals(set = set.newWith((char) 1), CharSets.immutable.with((char) 1));
        Assert.assertEquals(set = set.newWith((char) 2), CharSets.immutable.with((char) 1, (char) 2));
        Assert.assertEquals(set = set.newWith((char) 3), CharSets.immutable.with((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(set = set.newWith((char) 4), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(set = set.newWith((char) 5), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(set = set.newWith((char) 6), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(set = set.newWith((char) 7), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(set = set.newWith((char) 8), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(set = set.newWith((char) 9), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(set = set.newWith((char) 10), CharSets.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newSetWithArray()
    {
        ImmutableCharSet set = CharSets.immutable.empty();
        Assert.assertEquals(set = set.newWith((char) 1), CharSets.immutable.with(new char[]{(char) 1}));
        Assert.assertEquals(set = set.newWith((char) 2), CharSets.immutable.with(new char[]{(char) 1, (char) 2}));
        Assert.assertEquals(set = set.newWith((char) 3), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3}));
        Assert.assertEquals(set = set.newWith((char) 4), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4}));
        Assert.assertEquals(set = set.newWith((char) 5), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5}));
        Assert.assertEquals(set = set.newWith((char) 6), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6}));
        Assert.assertEquals(set = set.newWith((char) 7), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7}));
        Assert.assertEquals(set = set.newWith((char) 8), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8}));
        Assert.assertEquals(set = set.newWith((char) 9), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9}));
        Assert.assertEquals(set = set.newWith((char) 10), CharSets.immutable.with(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10}));
    }

    @Test
    public void newSetWithSet()
    {
        ImmutableCharSet set = CharSets.immutable.empty();
        CharHashSet hashSet = CharHashSet.newSetWith((char) 1);
        Assert.assertEquals(set = set.newWith((char) 1), hashSet.toImmutable());
        hashSet.add((char) 2);
        Assert.assertEquals(set = set.newWith((char) 2), hashSet.toImmutable());
        hashSet.add((char) 3);
        Assert.assertEquals(set = set.newWith((char) 3), hashSet.toImmutable());
        hashSet.add((char) 4);
        Assert.assertEquals(set = set.newWith((char) 4), hashSet.toImmutable());
        hashSet.add((char) 5);
        Assert.assertEquals(set = set.newWith((char) 5), hashSet.toImmutable());
        hashSet.add((char) 6);
        Assert.assertEquals(set = set.newWith((char) 6), hashSet.toImmutable());
        hashSet.add((char) 7);
        Assert.assertEquals(set = set.newWith((char) 7), hashSet.toImmutable());
        hashSet.add((char) 8);
        Assert.assertEquals(set = set.newWith((char) 8), hashSet.toImmutable());
        hashSet.add((char) 9);
        Assert.assertEquals(set = set.newWith((char) 9), hashSet.toImmutable());
        hashSet.add((char) 10);
        Assert.assertEquals(set = set.newWith((char) 10), hashSet.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharSets.class);
    }

    @Test
    public void cartesianProduct()
    {
        LazyIterable<CharCharPair> charCharPairs1 =
                CharSets.cartesianProduct(
                        CharSets.mutable.with((char) 1, (char) 2),
                        CharSets.mutable.with((char) 3, (char) 4, (char) 5));

        Set<CharCharPair> expected1 = Sets.mutable.with(
                PrimitiveTuples.pair((char) 1, (char) 3),
                PrimitiveTuples.pair((char) 1, (char) 4),
                PrimitiveTuples.pair((char) 1, (char) 5),
                PrimitiveTuples.pair((char) 2, (char) 3),
                PrimitiveTuples.pair((char) 2, (char) 4),
                PrimitiveTuples.pair((char) 2, (char) 5)
        );

        Assert.assertEquals(expected1, charCharPairs1.toSet());

        LazyIterable<CharCharPair> charCharPairs2 =
                CharSets.cartesianProduct(
                        CharSets.mutable.with((char) 3, (char) 4, (char) 5),
                        CharSets.mutable.with((char) 1, (char) 2));

        Set<CharCharPair> expected2 = Sets.mutable.with(
                PrimitiveTuples.pair((char) 3, (char) 1),
                PrimitiveTuples.pair((char) 3, (char) 2),
                PrimitiveTuples.pair((char) 4, (char) 1),
                PrimitiveTuples.pair((char) 4, (char) 2),
                PrimitiveTuples.pair((char) 5, (char) 1),
                PrimitiveTuples.pair((char) 5, (char) 2)
        );

        Assert.assertEquals(expected2, charCharPairs2.toSet());
    }

    @Test
    public void cartesianProductSameElements()
    {
        LazyIterable<CharCharPair> charCharPairs =
                CharSets.cartesianProduct(
                        CharSets.mutable.with((char) 1, (char) 2),
                        CharSets.mutable.with((char) 1, (char) 2));

        Set<CharCharPair> expected = Sets.mutable.with(
                PrimitiveTuples.pair((char) 1, (char) 1),
                PrimitiveTuples.pair((char) 1, (char) 2),
                PrimitiveTuples.pair((char) 2, (char) 2),
                PrimitiveTuples.pair((char) 2, (char) 1)
        );

        Assert.assertEquals(expected, charCharPairs.toSet());
    }
}
