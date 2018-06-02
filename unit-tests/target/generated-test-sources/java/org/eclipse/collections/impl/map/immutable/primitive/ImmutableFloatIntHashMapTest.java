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

import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatIntHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableFloatIntHashMapTest extends AbstractImmutableFloatIntMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableFloatIntMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        ImmutableFloatIntMap expected = this.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32, 33.0f, 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0f, 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0f, 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        ImmutableFloatIntMap expected = this.newWithKeysValues(0.0f, 0, 31.0f, 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0f));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        ImmutableFloatIntMap expected = this.newWithKeysValues(31.0f, 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableFloatIntHashMap iterable = new ImmutableFloatIntHashMap(FloatIntHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3));
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }
}
