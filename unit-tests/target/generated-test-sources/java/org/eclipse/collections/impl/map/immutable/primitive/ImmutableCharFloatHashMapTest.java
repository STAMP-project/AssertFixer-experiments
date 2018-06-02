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

import org.eclipse.collections.api.map.primitive.ImmutableCharFloatMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharFloatHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharFloatHashMapTest extends AbstractImmutableCharFloatMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableCharFloatMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharFloatMap map1 = this.classUnderTest();
        ImmutableCharFloatMap expected = this.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f, (char) 33, 33.0f);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, 33.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, 33.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharFloatMap map1 = this.classUnderTest();
        ImmutableCharFloatMap expected = this.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharFloatMap map1 = this.classUnderTest();
        ImmutableCharFloatMap expected = this.newWithKeysValues((char) 31, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableCharFloatHashMap iterable = new ImmutableCharFloatHashMap(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f));
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }
}
