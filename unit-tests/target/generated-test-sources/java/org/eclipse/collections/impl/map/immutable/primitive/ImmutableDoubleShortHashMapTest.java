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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleShortMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleShortHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableDoubleShortHashMapTest extends AbstractImmutableDoubleShortMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleShortMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleShortMap map1 = this.classUnderTest();
        ImmutableDoubleShortMap expected = this.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32, 33.0, (short) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, (short) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, (short) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleShortMap map1 = this.classUnderTest();
        ImmutableDoubleShortMap expected = this.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleShortMap map1 = this.classUnderTest();
        ImmutableDoubleShortMap expected = this.newWithKeysValues(31.0, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableDoubleShortHashMap iterable = new ImmutableDoubleShortHashMap(DoubleShortHashMap.newWithKeysValues(1.0, (short) 1, 2.0, (short) 2, 3.0, (short) 3));
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }
}
