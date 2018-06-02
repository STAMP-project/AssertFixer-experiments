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

import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharLongHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharLongHashMapTest extends AbstractImmutableCharLongMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableCharLongMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharLongMap map1 = this.classUnderTest();
        ImmutableCharLongMap expected = this.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L, (char) 33, 33L);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, 33L));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, 33L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharLongMap map1 = this.classUnderTest();
        ImmutableCharLongMap expected = this.newWithKeysValues((char) 0, 0L, (char) 31, 31L);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharLongMap map1 = this.classUnderTest();
        ImmutableCharLongMap expected = this.newWithKeysValues((char) 31, 31L);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableCharLongHashMap iterable = new ImmutableCharLongHashMap(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L));
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
