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

import org.eclipse.collections.api.map.primitive.ImmutableCharIntMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharIntHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharIntHashMapTest extends AbstractImmutableCharIntMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableCharIntMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharIntMap map1 = this.classUnderTest();
        ImmutableCharIntMap expected = this.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32, (char) 33, 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharIntMap map1 = this.classUnderTest();
        ImmutableCharIntMap expected = this.newWithKeysValues((char) 0, 0, (char) 31, 31);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharIntMap map1 = this.classUnderTest();
        ImmutableCharIntMap expected = this.newWithKeysValues((char) 31, 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableCharIntHashMap iterable = new ImmutableCharIntHashMap(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3));
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }
}
