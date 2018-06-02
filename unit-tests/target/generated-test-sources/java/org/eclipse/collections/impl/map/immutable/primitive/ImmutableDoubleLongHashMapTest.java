/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableDoubleLongMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleLongHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableDoubleLongHashMapTest extends AbstractImmutableDoubleLongMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleLongMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleLongMap map1 = this.classUnderTest();
        ImmutableDoubleLongMap expected = this.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L, 33.0, 33L);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, 33L));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, 33L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleLongMap map1 = this.classUnderTest();
        ImmutableDoubleLongMap expected = this.newWithKeysValues(0.0, 0L, 31.0, 31L);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleLongMap map1 = this.classUnderTest();
        ImmutableDoubleLongMap expected = this.newWithKeysValues(31.0, 31L);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableDoubleLongHashMap iterable = new ImmutableDoubleLongHashMap(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L));
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
