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

import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongDoubleHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableLongDoubleHashMapTest extends AbstractImmutableLongDoubleMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        ImmutableLongDoubleMap expected = this.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0, 33L, 33.0);
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, 33.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, 33.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        ImmutableLongDoubleMap expected = this.newWithKeysValues(0L, 0.0, 31L, 31.0);
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        ImmutableLongDoubleMap expected = this.newWithKeysValues(31L, 31.0);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableLongDoubleHashMap iterable = new ImmutableLongDoubleHashMap(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 2L, 2.0, 3L, 3.0));
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }
}
