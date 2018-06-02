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

import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableDoubleBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link DoubleBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class DoubleBagsTest
{
    @Test
    public void immutables()
    {
        ImmutableDoubleBagFactory bagFactory = DoubleBags.immutable;
        Assert.assertEquals(DoubleHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), bagFactory.of(1.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0), bagFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), bagFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0), bagFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), bagFactory.ofAll(DoubleHashBag.newBagWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(ImmutableDoubleBag.class, bagFactory.ofAll(DoubleHashBag.newBagWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void emptyBag()
    {
        Assert.assertTrue(DoubleBags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith()
    {
        ImmutableDoubleBag bag = DoubleBags.immutable.of();
        Assert.assertEquals(bag, DoubleBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith(1.0), DoubleBags.immutable.of(1.0));
        Assert.assertEquals(bag = bag.newWith(2.0), DoubleBags.immutable.of(1.0, 2.0));
        Assert.assertEquals(bag = bag.newWith(3.0), DoubleBags.immutable.of(1.0, 2.0, 3.0));
        Assert.assertEquals(bag = bag.newWith(4.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(bag = bag.newWith(5.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(bag = bag.newWith(6.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(bag = bag.newWith(7.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(bag = bag.newWith(8.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(bag = bag.newWith(9.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(bag = bag.newWith(10.0), DoubleBags.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray()
    {
        ImmutableDoubleBag bag = DoubleBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith(1.0), DoubleBags.immutable.of(new double[]{1.0}));
        Assert.assertEquals(bag = bag.newWith(2.0), DoubleBags.immutable.of(new double[]{1.0, 2.0}));
        Assert.assertEquals(bag = bag.newWith(3.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0}));
        Assert.assertEquals(bag = bag.newWith(4.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0}));
        Assert.assertEquals(bag = bag.newWith(5.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}));
        Assert.assertEquals(bag = bag.newWith(6.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}));
        Assert.assertEquals(bag = bag.newWith(7.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0}));
        Assert.assertEquals(bag = bag.newWith(8.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0}));
        Assert.assertEquals(bag = bag.newWith(9.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0}));
        Assert.assertEquals(bag = bag.newWith(10.0), DoubleBags.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}));
    }

    @Test
    public void newBagWithBag()
    {
        ImmutableDoubleBag bag = DoubleBags.immutable.of();
        DoubleHashBag hashBag = DoubleHashBag.newBagWith(1.0);
        Assert.assertEquals(bag = bag.newWith(1.0), hashBag.toImmutable());
        hashBag.add(2.0);
        Assert.assertEquals(bag = bag.newWith(2.0), hashBag.toImmutable());
        hashBag.add(3.0);
        Assert.assertEquals(bag = bag.newWith(3.0), hashBag.toImmutable());
        hashBag.add(4.0);
        Assert.assertEquals(bag = bag.newWith(4.0), hashBag.toImmutable());
        hashBag.add(5.0);
        Assert.assertEquals(bag = bag.newWith(5.0), hashBag.toImmutable());
        hashBag.add(6.0);
        Assert.assertEquals(bag = bag.newWith(6.0), hashBag.toImmutable());
        hashBag.add(7.0);
        Assert.assertEquals(bag = bag.newWith(7.0), hashBag.toImmutable());
        hashBag.add(8.0);
        Assert.assertEquals(bag = bag.newWith(8.0), hashBag.toImmutable());
        hashBag.add(9.0);
        Assert.assertEquals(bag = bag.newWith(9.0), hashBag.toImmutable());
        hashBag.add(10.0);
        Assert.assertEquals(bag = bag.newWith(10.0), hashBag.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleBags.class);
    }
}
