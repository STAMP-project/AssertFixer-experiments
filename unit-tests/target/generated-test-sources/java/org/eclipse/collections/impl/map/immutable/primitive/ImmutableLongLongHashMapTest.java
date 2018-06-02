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

import org.eclipse.collections.api.map.primitive.ImmutableLongLongMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongLongHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableLongLongHashMapTest extends AbstractImmutableLongLongMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableLongLongMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongLongMap map1 = this.classUnderTest();
        ImmutableLongLongMap expected = this.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L, 33L, 33L);
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, 33L));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, 33L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongLongMap map1 = this.classUnderTest();
        ImmutableLongLongMap expected = this.newWithKeysValues(0L, 0L, 31L, 31L);
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongLongMap map1 = this.classUnderTest();
        ImmutableLongLongMap expected = this.newWithKeysValues(31L, 31L);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableLongLongHashMap iterable = new ImmutableLongLongHashMap(LongLongHashMap.newWithKeysValues(1L, 1L, 2L, 2L, 3L, 3L));
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
