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

import org.eclipse.collections.api.map.primitive.IntCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntCharMap;
import org.eclipse.collections.impl.factory.primitive.IntCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableIntCharMapTestCase extends AbstractIntCharMapTestCase
{
    @Override
    protected ImmutableIntCharMap classUnderTest()
    {
        return IntCharMaps.immutable.withAll(IntCharHashMap.newWithKeysValues(0, (char) 0, 31, (char) 31, 32, (char) 32));
    }

    @Override
    protected ImmutableIntCharMap newWithKeysValues(int key1, char value1)
    {
        return IntCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2)
    {
        return IntCharMaps.immutable.withAll(new IntCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2, int key3, char value3)
    {
        return IntCharMaps.immutable.withAll(new IntCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableIntCharMap newWithKeysValues(int key1, char value1, int key2, char value2, int key3, char value3, int key4, char value4)
    {
        return IntCharMaps.immutable.withAll(new IntCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableIntCharMap getEmptyMap()
    {
        return IntCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        IntCharMap map1 = this.newWithKeysValues(0, (char) 0, 1, (char) 1, 32, (char) 32);
        IntCharMap map2 = this.newWithKeysValues(32, (char) 32, 0, (char) 0, 1, (char) 1);
        IntCharMap map3 = this.newWithKeysValues(0, (char) 0, 1, (char) 2, 32, (char) 32);
        IntCharMap map4 = this.newWithKeysValues(0, (char) 1, 1, (char) 1, 32, (char) 32);
        IntCharMap map5 = this.newWithKeysValues(0, (char) 0, 1, (char) 1, 32, (char) 33);
        IntCharMap map6 = this.newWithKeysValues(50, (char) 0, 60, (char) 1, 70, (char) 33);
        IntCharMap map7 = this.newWithKeysValues(50, (char) 0, 60, (char) 1);
        IntCharMap map8 = this.newWithKeysValues(0, (char) 0, 1, (char) 1);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedIdentity(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Override
    @Test
    public void keySet()
    {
        super.keySet();
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> this.classUnderTest().keySet().remove(0));
    }

    @Override
    public void values()
    {
        super.values();
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues()
    {
        Assert.assertEquals(CharIntMaps.immutable.empty(), IntCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharIntEmptyMap.class, IntCharMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(CharIntMaps.immutable.with((char) 2, 1), this.newWithKeysValues(1, (char) 2).flipUniqueValues());

        Assert.assertEquals(
                CharIntHashMap.newWithKeysValues((char) 2, 1, (char) 3, 2, (char) 4, 3, (char) 5, 4).toImmutable(),
                this.newWithKeysValues(1, (char) 2, 2, (char) 3, 3, (char) 4, 4, (char) 5).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, (char) 1, 2, (char) 1).flipUniqueValues());
    }
}
