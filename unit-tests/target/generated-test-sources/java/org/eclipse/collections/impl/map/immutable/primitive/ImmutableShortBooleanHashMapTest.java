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

import org.eclipse.collections.api.map.primitive.ImmutableShortBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableShortBooleanHashMapTest extends AbstractImmutableShortBooleanMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        ImmutableShortBooleanMap expected = this.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true, (short) 33, false);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        ImmutableShortBooleanMap expected = this.newWithKeysValues((short) 0, true, (short) 31, false);
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortBooleanMap map1 = this.classUnderTest();
        ImmutableShortBooleanMap expected = this.newWithKeysValues((short) 31, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
