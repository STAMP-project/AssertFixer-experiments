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

import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntDoubleHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableIntDoubleHashMapTest extends AbstractImmutableIntDoubleMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableIntDoubleMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableIntDoubleMap map1 = this.classUnderTest();
        ImmutableIntDoubleMap expected = this.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0, 33, 33.0);
        Assert.assertEquals(expected, map1.newWithKeyValue(33, 33.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33, 33.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableIntDoubleMap map1 = this.classUnderTest();
        ImmutableIntDoubleMap expected = this.newWithKeysValues(0, 0.0, 31, 31.0);
        Assert.assertEquals(expected, map1.newWithoutKey(32));
        Assert.assertNotSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableIntDoubleMap map1 = this.classUnderTest();
        ImmutableIntDoubleMap expected = this.newWithKeysValues(31, 31.0);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableIntDoubleHashMap iterable = new ImmutableIntDoubleHashMap(IntDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0));
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }
}
