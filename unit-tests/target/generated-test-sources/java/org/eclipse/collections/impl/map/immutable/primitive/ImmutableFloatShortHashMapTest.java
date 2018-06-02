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

import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatShortHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableFloatShortHashMapTest extends AbstractImmutableFloatShortMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableFloatShortMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatShortMap map1 = this.classUnderTest();
        ImmutableFloatShortMap expected = this.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31, 32.0f, (short) 32, 33.0f, (short) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0f, (short) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0f, (short) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatShortMap map1 = this.classUnderTest();
        ImmutableFloatShortMap expected = this.newWithKeysValues(0.0f, (short) 0, 31.0f, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0f));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatShortMap map1 = this.classUnderTest();
        ImmutableFloatShortMap expected = this.newWithKeysValues(31.0f, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableFloatShortHashMap iterable = new ImmutableFloatShortHashMap(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3));
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }
}
