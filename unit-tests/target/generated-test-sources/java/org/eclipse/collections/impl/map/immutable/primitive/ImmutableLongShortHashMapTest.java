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

import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongShortHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableLongShortHashMapTest extends AbstractImmutableLongShortMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableLongShortMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongShortMap map1 = this.classUnderTest();
        ImmutableLongShortMap expected = this.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32, 33L, (short) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, (short) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, (short) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongShortMap map1 = this.classUnderTest();
        ImmutableLongShortMap expected = this.newWithKeysValues(0L, (short) 0, 31L, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongShortMap map1 = this.classUnderTest();
        ImmutableLongShortMap expected = this.newWithKeysValues(31L, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableLongShortHashMap iterable = new ImmutableLongShortHashMap(LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3));
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }
}
