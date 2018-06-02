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

import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableFloatBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link FloatBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class FloatBagsTest
{
    @Test
    public void immutables()
    {
        ImmutableFloatBagFactory bagFactory = FloatBags.immutable;
        Assert.assertEquals(FloatHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), bagFactory.of(1.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f), bagFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), bagFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), bagFactory.ofAll(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(ImmutableFloatBag.class, bagFactory.ofAll(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void emptyBag()
    {
        Assert.assertTrue(FloatBags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith()
    {
        ImmutableFloatBag bag = FloatBags.immutable.of();
        Assert.assertEquals(bag, FloatBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1.0f), FloatBags.immutable.of(1.0f));
        Assert.assertEquals(bag = bag.newWith(2.0f), FloatBags.immutable.of(1.0f, 2.0f));
        Assert.assertEquals(bag = bag.newWith(3.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(bag = bag.newWith(4.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(bag = bag.newWith(5.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(bag = bag.newWith(6.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(bag = bag.newWith(7.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(bag = bag.newWith(8.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(bag = bag.newWith(9.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(bag = bag.newWith(10.0f), FloatBags.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray()
    {
        ImmutableFloatBag bag = FloatBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1.0f), FloatBags.immutable.of(new float[]{1.0f}));
        Assert.assertEquals(bag = bag.newWith(2.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f}));
        Assert.assertEquals(bag = bag.newWith(3.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f}));
        Assert.assertEquals(bag = bag.newWith(4.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f}));
        Assert.assertEquals(bag = bag.newWith(5.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}));
        Assert.assertEquals(bag = bag.newWith(6.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f}));
        Assert.assertEquals(bag = bag.newWith(7.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f}));
        Assert.assertEquals(bag = bag.newWith(8.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f}));
        Assert.assertEquals(bag = bag.newWith(9.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f}));
        Assert.assertEquals(bag = bag.newWith(10.0f), FloatBags.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f}));
    }

    @Test
    public void newBagWithBag()
    {
        ImmutableFloatBag bag = FloatBags.immutable.of();
        FloatHashBag hashBag = FloatHashBag.newBagWith(1.0f);
        Assert.assertEquals(bag = bag.newWith(1.0f), hashBag.toImmutable());
        hashBag.add(2.0f);
        Assert.assertEquals(bag = bag.newWith(2.0f), hashBag.toImmutable());
        hashBag.add(3.0f);
        Assert.assertEquals(bag = bag.newWith(3.0f), hashBag.toImmutable());
        hashBag.add(4.0f);
        Assert.assertEquals(bag = bag.newWith(4.0f), hashBag.toImmutable());
        hashBag.add(5.0f);
        Assert.assertEquals(bag = bag.newWith(5.0f), hashBag.toImmutable());
        hashBag.add(6.0f);
        Assert.assertEquals(bag = bag.newWith(6.0f), hashBag.toImmutable());
        hashBag.add(7.0f);
        Assert.assertEquals(bag = bag.newWith(7.0f), hashBag.toImmutable());
        hashBag.add(8.0f);
        Assert.assertEquals(bag = bag.newWith(8.0f), hashBag.toImmutable());
        hashBag.add(9.0f);
        Assert.assertEquals(bag = bag.newWith(9.0f), hashBag.toImmutable());
        hashBag.add(10.0f);
        Assert.assertEquals(bag = bag.newWith(10.0f), hashBag.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatBags.class);
    }
}
