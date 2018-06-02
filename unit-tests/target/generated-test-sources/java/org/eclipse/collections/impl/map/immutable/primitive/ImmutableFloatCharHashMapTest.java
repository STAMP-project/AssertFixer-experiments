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

import org.eclipse.collections.api.map.primitive.ImmutableFloatCharMap;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatCharHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableFloatCharHashMapTest extends AbstractImmutableFloatCharMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableFloatCharMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatCharMap map1 = this.classUnderTest();
        ImmutableFloatCharMap expected = this.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32, 33.0f, (char) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0f, (char) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0f, (char) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatCharMap map1 = this.classUnderTest();
        ImmutableFloatCharMap expected = this.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0f));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatCharMap map1 = this.classUnderTest();
        ImmutableFloatCharMap expected = this.newWithKeysValues(31.0f, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableFloatCharHashMap iterable = new ImmutableFloatCharHashMap(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3));
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }
}
