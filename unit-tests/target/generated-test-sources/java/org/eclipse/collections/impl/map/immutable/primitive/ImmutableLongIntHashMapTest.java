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

import org.eclipse.collections.api.map.primitive.ImmutableLongIntMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongIntHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableLongIntHashMapTest extends AbstractImmutableLongIntMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableLongIntMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongIntMap map1 = this.classUnderTest();
        ImmutableLongIntMap expected = this.newWithKeysValues(0L, 0, 31L, 31, 32L, 32, 33L, 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongIntMap map1 = this.classUnderTest();
        ImmutableLongIntMap expected = this.newWithKeysValues(0L, 0, 31L, 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongIntMap map1 = this.classUnderTest();
        ImmutableLongIntMap expected = this.newWithKeysValues(31L, 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableLongIntHashMap iterable = new ImmutableLongIntHashMap(LongIntHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3));
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }
}
