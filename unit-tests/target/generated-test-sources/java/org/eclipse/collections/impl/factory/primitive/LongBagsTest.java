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

import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableLongBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link LongBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class LongBagsTest
{
    @Test
    public void immutables()
    {
        ImmutableLongBagFactory bagFactory = LongBags.immutable;
        Assert.assertEquals(LongHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of());
        Assert.assertEquals(LongHashBag.newBagWith(1L), bagFactory.of(1L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), bagFactory.of(1L, 2L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), bagFactory.of(1L, 2L, 3L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L), bagFactory.of(1L, 2L, 3L, 4L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), bagFactory.of(1L, 2L, 3L, 4L, 5L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L), bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), bagFactory.ofAll(LongHashBag.newBagWith(1L, 2L, 3L)));
        Verify.assertInstanceOf(ImmutableLongBag.class, bagFactory.ofAll(LongHashBag.newBagWith(1L, 2L, 3L)));
    }

    @Test
    public void emptyBag()
    {
        Assert.assertTrue(LongBags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith()
    {
        ImmutableLongBag bag = LongBags.immutable.of();
        Assert.assertEquals(bag, LongBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1L), LongBags.immutable.of(1L));
        Assert.assertEquals(bag = bag.newWith(2L), LongBags.immutable.of(1L, 2L));
        Assert.assertEquals(bag = bag.newWith(3L), LongBags.immutable.of(1L, 2L, 3L));
        Assert.assertEquals(bag = bag.newWith(4L), LongBags.immutable.of(1L, 2L, 3L, 4L));
        Assert.assertEquals(bag = bag.newWith(5L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L));
        Assert.assertEquals(bag = bag.newWith(6L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L));
        Assert.assertEquals(bag = bag.newWith(7L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L));
        Assert.assertEquals(bag = bag.newWith(8L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L));
        Assert.assertEquals(bag = bag.newWith(9L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L));
        Assert.assertEquals(bag = bag.newWith(10L), LongBags.immutable.of(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray()
    {
        ImmutableLongBag bag = LongBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1L), LongBags.immutable.of(new long[]{1L}));
        Assert.assertEquals(bag = bag.newWith(2L), LongBags.immutable.of(new long[]{1L, 2L}));
        Assert.assertEquals(bag = bag.newWith(3L), LongBags.immutable.of(new long[]{1L, 2L, 3L}));
        Assert.assertEquals(bag = bag.newWith(4L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L}));
        Assert.assertEquals(bag = bag.newWith(5L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L}));
        Assert.assertEquals(bag = bag.newWith(6L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L}));
        Assert.assertEquals(bag = bag.newWith(7L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L}));
        Assert.assertEquals(bag = bag.newWith(8L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L}));
        Assert.assertEquals(bag = bag.newWith(9L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L}));
        Assert.assertEquals(bag = bag.newWith(10L), LongBags.immutable.of(new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L}));
    }

    @Test
    public void newBagWithBag()
    {
        ImmutableLongBag bag = LongBags.immutable.of();
        LongHashBag hashBag = LongHashBag.newBagWith(1L);
        Assert.assertEquals(bag = bag.newWith(1L), hashBag.toImmutable());
        hashBag.add(2L);
        Assert.assertEquals(bag = bag.newWith(2L), hashBag.toImmutable());
        hashBag.add(3L);
        Assert.assertEquals(bag = bag.newWith(3L), hashBag.toImmutable());
        hashBag.add(4L);
        Assert.assertEquals(bag = bag.newWith(4L), hashBag.toImmutable());
        hashBag.add(5L);
        Assert.assertEquals(bag = bag.newWith(5L), hashBag.toImmutable());
        hashBag.add(6L);
        Assert.assertEquals(bag = bag.newWith(6L), hashBag.toImmutable());
        hashBag.add(7L);
        Assert.assertEquals(bag = bag.newWith(7L), hashBag.toImmutable());
        hashBag.add(8L);
        Assert.assertEquals(bag = bag.newWith(8L), hashBag.toImmutable());
        hashBag.add(9L);
        Assert.assertEquals(bag = bag.newWith(9L), hashBag.toImmutable());
        hashBag.add(10L);
        Assert.assertEquals(bag = bag.newWith(10L), hashBag.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongBags.class);
    }
}
