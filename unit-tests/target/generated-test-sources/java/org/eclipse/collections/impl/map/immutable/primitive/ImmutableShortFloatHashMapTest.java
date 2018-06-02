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

import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortFloatHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableShortFloatHashMapTest extends AbstractImmutableShortFloatMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableShortFloatMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortFloatMap map1 = this.classUnderTest();
        ImmutableShortFloatMap expected = this.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f, (short) 33, 33.0f);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, 33.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, 33.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortFloatMap map1 = this.classUnderTest();
        ImmutableShortFloatMap expected = this.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortFloatMap map1 = this.classUnderTest();
        ImmutableShortFloatMap expected = this.newWithKeysValues((short) 31, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableShortFloatHashMap iterable = new ImmutableShortFloatHashMap(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f));
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }
}
