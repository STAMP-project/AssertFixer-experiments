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

import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.factory.bag.primitive.ImmutableByteBagFactory;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Junit test for {@link ByteBags}
 * This file was automatically generated from template file primitiveBagsTest.stg
 */
public class ByteBagsTest
{
    @Test
    public void immutables()
    {
        ImmutableByteBagFactory bagFactory = ByteBags.immutable;
        Assert.assertEquals(ByteHashBag.newBagWith(), bagFactory.of());
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1), bagFactory.of((byte) 1));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), bagFactory.of((byte) 1, (byte) 2));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), bagFactory.of((byte) 1, (byte) 2, (byte) 3));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10), bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), bagFactory.ofAll(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3)));
        Verify.assertInstanceOf(ImmutableByteBag.class, bagFactory.ofAll(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test
    public void emptyBag()
    {
        Assert.assertTrue(ByteBags.immutable.of().isEmpty());
    }

    @Test
    public void newBagWith()
    {
        ImmutableByteBag bag = ByteBags.immutable.of();
        Assert.assertEquals(bag, ByteBags.immutable.of(bag.toArray()));
        Assert.assertEquals(bag = bag.newWith((byte) 1), ByteBags.immutable.of((byte) 1));
        Assert.assertEquals(bag = bag.newWith((byte) 2), ByteBags.immutable.of((byte) 1, (byte) 2));
        Assert.assertEquals(bag = bag.newWith((byte) 3), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3));
        Assert.assertEquals(bag = bag.newWith((byte) 4), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4));
        Assert.assertEquals(bag = bag.newWith((byte) 5), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5));
        Assert.assertEquals(bag = bag.newWith((byte) 6), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6));
        Assert.assertEquals(bag = bag.newWith((byte) 7), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7));
        Assert.assertEquals(bag = bag.newWith((byte) 8), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8));
        Assert.assertEquals(bag = bag.newWith((byte) 9), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9));
        Assert.assertEquals(bag = bag.newWith((byte) 10), ByteBags.immutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newBagWithArray()
    {
        ImmutableByteBag bag = ByteBags.immutable.of();
        Assert.assertEquals(bag = bag.newWith((byte) 1), ByteBags.immutable.of(new byte[]{(byte) 1}));
        Assert.assertEquals(bag = bag.newWith((byte) 2), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2}));
        Assert.assertEquals(bag = bag.newWith((byte) 3), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3}));
        Assert.assertEquals(bag = bag.newWith((byte) 4), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4}));
        Assert.assertEquals(bag = bag.newWith((byte) 5), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5}));
        Assert.assertEquals(bag = bag.newWith((byte) 6), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6}));
        Assert.assertEquals(bag = bag.newWith((byte) 7), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7}));
        Assert.assertEquals(bag = bag.newWith((byte) 8), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8}));
        Assert.assertEquals(bag = bag.newWith((byte) 9), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9}));
        Assert.assertEquals(bag = bag.newWith((byte) 10), ByteBags.immutable.of(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 10}));
    }

    @Test
    public void newBagWithBag()
    {
        ImmutableByteBag bag = ByteBags.immutable.of();
        ByteHashBag hashBag = ByteHashBag.newBagWith((byte) 1);
        Assert.assertEquals(bag = bag.newWith((byte) 1), hashBag.toImmutable());
        hashBag.add((byte) 2);
        Assert.assertEquals(bag = bag.newWith((byte) 2), hashBag.toImmutable());
        hashBag.add((byte) 3);
        Assert.assertEquals(bag = bag.newWith((byte) 3), hashBag.toImmutable());
        hashBag.add((byte) 4);
        Assert.assertEquals(bag = bag.newWith((byte) 4), hashBag.toImmutable());
        hashBag.add((byte) 5);
        Assert.assertEquals(bag = bag.newWith((byte) 5), hashBag.toImmutable());
        hashBag.add((byte) 6);
        Assert.assertEquals(bag = bag.newWith((byte) 6), hashBag.toImmutable());
        hashBag.add((byte) 7);
        Assert.assertEquals(bag = bag.newWith((byte) 7), hashBag.toImmutable());
        hashBag.add((byte) 8);
        Assert.assertEquals(bag = bag.newWith((byte) 8), hashBag.toImmutable());
        hashBag.add((byte) 9);
        Assert.assertEquals(bag = bag.newWith((byte) 9), hashBag.toImmutable());
        hashBag.add((byte) 10);
        Assert.assertEquals(bag = bag.newWith((byte) 10), hashBag.toImmutable());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteBags.class);
    }
}
