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

import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortLongHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableShortLongHashMapTest extends AbstractImmutableShortLongMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableShortLongMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortLongMap map1 = this.classUnderTest();
        ImmutableShortLongMap expected = this.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L, (short) 33, 33L);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, 33L));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, 33L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortLongMap map1 = this.classUnderTest();
        ImmutableShortLongMap expected = this.newWithKeysValues((short) 0, 0L, (short) 31, 31L);
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortLongMap map1 = this.classUnderTest();
        ImmutableShortLongMap expected = this.newWithKeysValues((short) 31, 31L);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableShortLongHashMap iterable = new ImmutableShortLongHashMap(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L));
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
