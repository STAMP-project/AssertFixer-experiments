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

import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableCharBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link CharBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class CharBagsTest
{
    @Test
    public void immutables()
    {
        ImmutableCharBagFactory bagFactory = CharBags.immutable;
        Assert.assertEquals(CharHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), bagFactory.of((char) 1));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), bagFactory.of((char) 1, (char) 2));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), bagFactory.of((char) 1, (char) 2, (char) 3));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10), bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), bagFactory.ofAll(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3)));
        Verify.assertInstanceOf(ImmutableCharBag.class, bagFactory.ofAll(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3)));
    }

    @Test
    public void emptyBag()
    {
        Assert.assertTrue(CharBags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith()
    {
        ImmutableCharBag bag = CharBags.immutable.of();
        Assert.assertEquals(bag, CharBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith((char) 1), CharBags.immutable.of((char) 1));
        Assert.assertEquals(bag = bag.newWith((char) 2), CharBags.immutable.of((char) 1, (char) 2));
        Assert.assertEquals(bag = bag.newWith((char) 3), CharBags.immutable.of((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(bag = bag.newWith((char) 4), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertEquals(bag = bag.newWith((char) 5), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertEquals(bag = bag.newWith((char) 6), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6));
        Assert.assertEquals(bag = bag.newWith((char) 7), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7));
        Assert.assertEquals(bag = bag.newWith((char) 8), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8));
        Assert.assertEquals(bag = bag.newWith((char) 9), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9));
        Assert.assertEquals(bag = bag.newWith((char) 10), CharBags.immutable.of((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray()
    {
        ImmutableCharBag bag = CharBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith((char) 1), CharBags.immutable.of(new char[]{(char) 1}));
        Assert.assertEquals(bag = bag.newWith((char) 2), CharBags.immutable.of(new char[]{(char) 1, (char) 2}));
        Assert.assertEquals(bag = bag.newWith((char) 3), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3}));
        Assert.assertEquals(bag = bag.newWith((char) 4), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4}));
        Assert.assertEquals(bag = bag.newWith((char) 5), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5}));
        Assert.assertEquals(bag = bag.newWith((char) 6), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6}));
        Assert.assertEquals(bag = bag.newWith((char) 7), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7}));
        Assert.assertEquals(bag = bag.newWith((char) 8), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8}));
        Assert.assertEquals(bag = bag.newWith((char) 9), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9}));
        Assert.assertEquals(bag = bag.newWith((char) 10), CharBags.immutable.of(new char[]{(char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8, (char) 9, (char) 10}));
    }

    @Test
    public void newBagWithBag()
    {
        ImmutableCharBag bag = CharBags.immutable.of();
        CharHashBag hashBag = CharHashBag.newBagWith((char) 1);
        Assert.assertEquals(bag = bag.newWith((char) 1), hashBag.toImmutable());
        hashBag.add((char) 2);
        Assert.assertEquals(bag = bag.newWith((char) 2), hashBag.toImmutable());
        hashBag.add((char) 3);
        Assert.assertEquals(bag = bag.newWith((char) 3), hashBag.toImmutable());
        hashBag.add((char) 4);
        Assert.assertEquals(bag = bag.newWith((char) 4), hashBag.toImmutable());
        hashBag.add((char) 5);
        Assert.assertEquals(bag = bag.newWith((char) 5), hashBag.toImmutable());
        hashBag.add((char) 6);
        Assert.assertEquals(bag = bag.newWith((char) 6), hashBag.toImmutable());
        hashBag.add((char) 7);
        Assert.assertEquals(bag = bag.newWith((char) 7), hashBag.toImmutable());
        hashBag.add((char) 8);
        Assert.assertEquals(bag = bag.newWith((char) 8), hashBag.toImmutable());
        hashBag.add((char) 9);
        Assert.assertEquals(bag = bag.newWith((char) 9), hashBag.toImmutable());
        hashBag.add((char) 10);
        Assert.assertEquals(bag = bag.newWith((char) 10), hashBag.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharBags.class);
    }
}
