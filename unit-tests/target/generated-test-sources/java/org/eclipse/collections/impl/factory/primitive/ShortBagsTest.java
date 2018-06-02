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

import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableShortBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ShortBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class ShortBagsTest
{
    @Test
    public void immutables()
    {
        ImmutableShortBagFactory bagFactory = ShortBags.immutable;
        Assert.assertEquals(ShortHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), bagFactory.of((short) 1));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), bagFactory.of((short) 1, (short) 2));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), bagFactory.of((short) 1, (short) 2, (short) 3));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10), bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), bagFactory.ofAll(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3)));
        Verify.assertInstanceOf(ImmutableShortBag.class, bagFactory.ofAll(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3)));
    }

    @Test
    public void emptyBag()
    {
        Assert.assertTrue(ShortBags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith()
    {
        ImmutableShortBag bag = ShortBags.immutable.of();
        Assert.assertEquals(bag, ShortBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith((short) 1), ShortBags.immutable.of((short) 1));
        Assert.assertEquals(bag = bag.newWith((short) 2), ShortBags.immutable.of((short) 1, (short) 2));
        Assert.assertEquals(bag = bag.newWith((short) 3), ShortBags.immutable.of((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(bag = bag.newWith((short) 4), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4));
        Assert.assertEquals(bag = bag.newWith((short) 5), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5));
        Assert.assertEquals(bag = bag.newWith((short) 6), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6));
        Assert.assertEquals(bag = bag.newWith((short) 7), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7));
        Assert.assertEquals(bag = bag.newWith((short) 8), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8));
        Assert.assertEquals(bag = bag.newWith((short) 9), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9));
        Assert.assertEquals(bag = bag.newWith((short) 10), ShortBags.immutable.of((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray()
    {
        ImmutableShortBag bag = ShortBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith((short) 1), ShortBags.immutable.of(new short[]{(short) 1}));
        Assert.assertEquals(bag = bag.newWith((short) 2), ShortBags.immutable.of(new short[]{(short) 1, (short) 2}));
        Assert.assertEquals(bag = bag.newWith((short) 3), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3}));
        Assert.assertEquals(bag = bag.newWith((short) 4), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4}));
        Assert.assertEquals(bag = bag.newWith((short) 5), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4, (short) 5}));
        Assert.assertEquals(bag = bag.newWith((short) 6), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6}));
        Assert.assertEquals(bag = bag.newWith((short) 7), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7}));
        Assert.assertEquals(bag = bag.newWith((short) 8), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8}));
        Assert.assertEquals(bag = bag.newWith((short) 9), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9}));
        Assert.assertEquals(bag = bag.newWith((short) 10), ShortBags.immutable.of(new short[]{(short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8, (short) 9, (short) 10}));
    }

    @Test
    public void newBagWithBag()
    {
        ImmutableShortBag bag = ShortBags.immutable.of();
        ShortHashBag hashBag = ShortHashBag.newBagWith((short) 1);
        Assert.assertEquals(bag = bag.newWith((short) 1), hashBag.toImmutable());
        hashBag.add((short) 2);
        Assert.assertEquals(bag = bag.newWith((short) 2), hashBag.toImmutable());
        hashBag.add((short) 3);
        Assert.assertEquals(bag = bag.newWith((short) 3), hashBag.toImmutable());
        hashBag.add((short) 4);
        Assert.assertEquals(bag = bag.newWith((short) 4), hashBag.toImmutable());
        hashBag.add((short) 5);
        Assert.assertEquals(bag = bag.newWith((short) 5), hashBag.toImmutable());
        hashBag.add((short) 6);
        Assert.assertEquals(bag = bag.newWith((short) 6), hashBag.toImmutable());
        hashBag.add((short) 7);
        Assert.assertEquals(bag = bag.newWith((short) 7), hashBag.toImmutable());
        hashBag.add((short) 8);
        Assert.assertEquals(bag = bag.newWith((short) 8), hashBag.toImmutable());
        hashBag.add((short) 9);
        Assert.assertEquals(bag = bag.newWith((short) 9), hashBag.toImmutable());
        hashBag.add((short) 10);
        Assert.assertEquals(bag = bag.newWith((short) 10), hashBag.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortBags.class);
    }
}
