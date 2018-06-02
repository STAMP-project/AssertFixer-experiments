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

import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharShortHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharShortHashMapTest extends AbstractImmutableCharShortMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableCharShortMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32, (char) 33, (short) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, (short) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, (short) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharShortMap map1 = this.classUnderTest();
        ImmutableCharShortMap expected = this.newWithKeysValues((char) 31, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableCharShortHashMap iterable = new ImmutableCharShortHashMap(CharShortHashMap.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3));
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }
}
