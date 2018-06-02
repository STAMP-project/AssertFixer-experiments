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

import org.eclipse.collections.api.factory.list.primitive.ImmutableFloatListFactory;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatLists}.
 * This file was automatically generated from template file primitiveListsTest.stg.
 */
public class FloatListsTest
{
    @Test
    public void immutables()
    {
        ImmutableFloatListFactory listFactory = FloatLists.immutable;
        Assert.assertEquals(new FloatArrayList(), listFactory.of());
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), listFactory.of(1.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), listFactory.of(1.0f, 2.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), listFactory.of(1.0f, 2.0f, 3.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f), listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), listFactory.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
        Verify.assertInstanceOf(ImmutableFloatList.class, listFactory.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void emptyList()
    {
        Verify.assertEmpty(FloatLists.immutable.of());
        Assert.assertSame(FloatLists.immutable.of(), FloatLists.immutable.of());
        Verify.assertPostSerializedIdentity(FloatLists.immutable.of());
    }

    @Test
    public void newListWith()
    {
        ImmutableFloatList list = FloatLists.immutable.of();
        Assert.assertEquals(list, FloatLists.immutable.of(list.toArray()));
        Assert.assertEquals(list = list.newWith(1.0f), FloatLists.immutable.of(1.0f));
        Assert.assertEquals(list = list.newWith(2.0f), FloatLists.immutable.of(1.0f, 2.0f));
        Assert.assertEquals(list = list.newWith(3.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(list = list.newWith(4.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f));
        Assert.assertEquals(list = list.newWith(5.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f));
        Assert.assertEquals(list = list.newWith(6.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f));
        Assert.assertEquals(list = list.newWith(7.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f));
        Assert.assertEquals(list = list.newWith(8.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f));
        Assert.assertEquals(list = list.newWith(9.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f));
        Assert.assertEquals(list = list.newWith(10.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f));
        Assert.assertEquals(list = list.newWith(11.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f));
        Assert.assertEquals(list = list.newWith(12.0f), FloatLists.immutable.of(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f, 12.0f));
    }

    @SuppressWarnings("RedundantArrayCreation")
    @Test
    public void newListWithArray()
    {
        ImmutableFloatList list = FloatLists.immutable.of();
        Assert.assertEquals(list = list.newWith(1.0f), FloatLists.immutable.of(new float[]{1}));
        Assert.assertEquals(list = list.newWith(2.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f}));
        Assert.assertEquals(list = list.newWith(3.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f}));
        Assert.assertEquals(list = list.newWith(4.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f}));
        Assert.assertEquals(list = list.newWith(5.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f}));
        Assert.assertEquals(list = list.newWith(6.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f}));
        Assert.assertEquals(list = list.newWith(7.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f}));
        Assert.assertEquals(list = list.newWith(8.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f}));
        Assert.assertEquals(list = list.newWith(9.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f}));
        Assert.assertEquals(list = list.newWith(10.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f}));
        Assert.assertEquals(list = list.newWith(11.0f), FloatLists.immutable.of(new float[]{1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f, 9.0f, 10.0f, 11.0f}));
    }

    @Test
    public void newListWithList()
    {
        ImmutableFloatList list = FloatLists.immutable.of();
        FloatArrayList floatArrayList = FloatArrayList.newListWith(1.0f);
        Assert.assertEquals(list = list.newWith(1.0f), floatArrayList.toImmutable());
        Assert.assertEquals(list = list.newWith(2.0f), floatArrayList.with(2.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(3.0f), floatArrayList.with(3.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(4.0f), floatArrayList.with(4.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(5.0f), floatArrayList.with(5.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(6.0f), floatArrayList.with(6.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(7.0f), floatArrayList.with(7.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(8.0f), floatArrayList.with(8.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(9.0f), floatArrayList.with(9.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(10.0f), floatArrayList.with(10.0f).toImmutable());
        Assert.assertEquals(list = list.newWith(11.0f), floatArrayList.with(11.0f).toImmutable());
    }

    @Test
    public void newListWithWithList()
    {
        Assert.assertEquals(new FloatArrayList(), FloatLists.immutable.ofAll(new FloatArrayList()));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), FloatLists.immutable.ofAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), FloatLists.immutable.ofAll(FloatArrayList.newListWith(1.0f, 2.0f)));
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), FloatLists.immutable.ofAll(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f)));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatLists.class);
    }
}
