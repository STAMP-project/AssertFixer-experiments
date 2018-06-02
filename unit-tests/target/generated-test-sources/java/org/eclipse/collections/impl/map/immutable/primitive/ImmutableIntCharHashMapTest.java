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

import org.eclipse.collections.api.map.primitive.ImmutableIntCharMap;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntCharHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableIntCharHashMapTest extends AbstractImmutableIntCharMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableIntCharMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableIntCharMap map1 = this.classUnderTest();
        ImmutableIntCharMap expected = this.newWithKeysValues(0, (char) 0, 31, (char) 31, 32, (char) 32, 33, (char) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33, (char) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33, (char) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableIntCharMap map1 = this.classUnderTest();
        ImmutableIntCharMap expected = this.newWithKeysValues(0, (char) 0, 31, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32));
        Assert.assertNotSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableIntCharMap map1 = this.classUnderTest();
        ImmutableIntCharMap expected = this.newWithKeysValues(31, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableIntCharHashMap iterable = new ImmutableIntCharHashMap(IntCharHashMap.newWithKeysValues(1, (char) 1, 2, (char) 2, 3, (char) 3));
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }
}
