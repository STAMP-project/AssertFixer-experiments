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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleCharMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleCharHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableDoubleCharHashMapTest extends AbstractImmutableDoubleCharMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleCharMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleCharMap map1 = this.classUnderTest();
        ImmutableDoubleCharMap expected = this.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32, 33.0, (char) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, (char) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, (char) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleCharMap map1 = this.classUnderTest();
        ImmutableDoubleCharMap expected = this.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleCharMap map1 = this.classUnderTest();
        ImmutableDoubleCharMap expected = this.newWithKeysValues(31.0, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableDoubleCharHashMap iterable = new ImmutableDoubleCharHashMap(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1, 2.0, (char) 2, 3.0, (char) 3));
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }
}
