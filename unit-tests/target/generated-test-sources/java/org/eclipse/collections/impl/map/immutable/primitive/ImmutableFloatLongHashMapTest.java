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

import org.eclipse.collections.api.map.primitive.ImmutableFloatLongMap;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatLongHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableFloatLongHashMapTest extends AbstractImmutableFloatLongMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableFloatLongMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatLongMap map1 = this.classUnderTest();
        ImmutableFloatLongMap expected = this.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L, 33.0f, 33L);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0f, 33L));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0f, 33L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatLongMap map1 = this.classUnderTest();
        ImmutableFloatLongMap expected = this.newWithKeysValues(0.0f, 0L, 31.0f, 31L);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0f));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatLongMap map1 = this.classUnderTest();
        ImmutableFloatLongMap expected = this.newWithKeysValues(31.0f, 31L);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableFloatLongHashMap iterable = new ImmutableFloatLongHashMap(FloatLongHashMap.newWithKeysValues(1.0f, 1L, 2.0f, 2L, 3.0f, 3L));
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
