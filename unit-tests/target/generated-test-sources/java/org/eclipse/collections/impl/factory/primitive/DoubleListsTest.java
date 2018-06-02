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

import org.eclipse.collections.api.factory.list.primitive.ImmutableDoubleListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class DoubleListsTest
{
    @Test
    public void immutables()
    {
        ImmutableDoubleListFactory listFactory = DoubleLists.immutable;
        Assert.assertEquals(new DoubleArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), listFactory.of(1.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), listFactory.of(1.0, 2.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), listFactory.of(1.0, 2.0, 3.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0), listFactory.of(1.0, 2.0, 3.0, 4.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0), listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), listFactory.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Verify.assertInstanceOf(ImmutableDoubleList.class, listFactory.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void emptyList()
    {
        Verify.assertEmpty(DoubleLists.immutable.of());
        Assert.assertSame(DoubleLists.immutable.of(), DoubleLists.immutable.of());
        Verify.assertPostSerializedIdentity(DoubleLists.immutable.of());
    }

    @Test
    public void newListWith()
    {
        ImmutableDoubleList list = DoubleLists.immutable.of();
        Assert.assertEquals(list, DoubleLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1.0), DoubleLists.immutable.of(1.0));
        Assert.assertEquals(list = list.newWith(2.0), DoubleLists.immutable.of(1.0, 2.0));
        Assert.assertEquals(list = list.newWith(3.0), DoubleLists.immutable.of(1.0, 2.0, 3.0));
        Assert.assertEquals(list = list.newWith(4.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(list = list.newWith(5.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertEquals(list = list.newWith(6.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0));
        Assert.assertEquals(list = list.newWith(7.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0));
        Assert.assertEquals(list = list.newWith(8.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0));
        Assert.assertEquals(list = list.newWith(9.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0));
        Assert.assertEquals(list = list.newWith(10.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0));
        Assert.assertEquals(list = list.newWith(11.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0));
        Assert.assertEquals(list = list.newWith(12.0), DoubleLists.immutable.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0, 12.0));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray()
    {
        ImmutableDoubleList list = DoubleLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1.0), DoubleLists.immutable.of(new double[]{1}));
        Assert.assertEquals(list = list.newWith(2.0), DoubleLists.immutable.of(new double[]{1.0, 2.0}));
        Assert.assertEquals(list = list.newWith(3.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0}));
        Assert.assertEquals(list = list.newWith(4.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0}));
        Assert.assertEquals(list = list.newWith(5.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0}));
        Assert.assertEquals(list = list.newWith(6.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0}));
        Assert.assertEquals(list = list.newWith(7.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0}));
        Assert.assertEquals(list = list.newWith(8.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0}));
        Assert.assertEquals(list = list.newWith(9.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0}));
        Assert.assertEquals(list = list.newWith(10.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}));
        Assert.assertEquals(list = list.newWith(11.0), DoubleLists.immutable.of(new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0}));
    }

    @Test
    public void newListWithList()
    {
        ImmutableDoubleList list = DoubleLists.immutable.of();
        DoubleArrayList doubleArrayList = DoubleArrayList.newListWith(1.0);
        Assert.assertEquals(list = list.newWith(1.0), doubleArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2.0), doubleArrayList.with(2.0).toImmutable());
        Assert.assertEquals(list = list.newWith(3.0), doubleArrayList.with(3.0).toImmutable());
        Assert.assertEquals(list = list.newWith(4.0), doubleArrayList.with(4.0).toImmutable());
        Assert.assertEquals(list = list.newWith(5.0), doubleArrayList.with(5.0).toImmutable());
        Assert.assertEquals(list = list.newWith(6.0), doubleArrayList.with(6.0).toImmutable());
        Assert.assertEquals(list = list.newWith(7.0), doubleArrayList.with(7.0).toImmutable());
        Assert.assertEquals(list = list.newWith(8.0), doubleArrayList.with(8.0).toImmutable());
        Assert.assertEquals(list = list.newWith(9.0), doubleArrayList.with(9.0).toImmutable());
        Assert.assertEquals(list = list.newWith(10.0), doubleArrayList.with(10.0).toImmutable());
        Assert.assertEquals(list = list.newWith(11.0), doubleArrayList.with(11.0).toImmutable());
    }

    @Test
    public void newListWithWithList()
    {
        Assert.assertEquals(new DoubleArrayList(), DoubleLists.immutable.ofAll(new DoubleArrayList()));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), DoubleLists.immutable.ofAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), DoubleLists.immutable.ofAll(DoubleArrayList.newListWith(1.0, 2.0)));
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleLists.immutable.ofAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleLists.class);
    }
}
