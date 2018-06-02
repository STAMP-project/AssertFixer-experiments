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

import org.eclipse.collections.api.map.primitive.ShortByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortByteMap;
import org.eclipse.collections.impl.factory.primitive.ShortByteMaps;
import org.eclipse.collections.impl.factory.primitive.ByteShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortByteHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortByteMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortByteMapTestCase extends AbstractShortByteMapTestCase
{
    @Override
    protected ImmutableShortByteMap classUnderTest()
    {
        return ShortByteMaps.immutable.withAll(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32));
    }

    @Override
    protected ImmutableShortByteMap newWithKeysValues(short key1, byte value1)
    {
        return ShortByteMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2)
    {
        return ShortByteMaps.immutable.withAll(new ShortByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3)
    {
        return ShortByteMaps.immutable.withAll(new ShortByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3, short key4, byte value4)
    {
        return ShortByteMaps.immutable.withAll(new ShortByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortByteMap getEmptyMap()
    {
        return ShortByteMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        ShortByteMap map1 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1, (short) 32, (byte) 32);
        ShortByteMap map2 = this.newWithKeysValues((short) 32, (byte) 32, (short) 0, (byte) 0, (short) 1, (byte) 1);
        ShortByteMap map3 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 2, (short) 32, (byte) 32);
        ShortByteMap map4 = this.newWithKeysValues((short) 0, (byte) 1, (short) 1, (byte) 1, (short) 32, (byte) 32);
        ShortByteMap map5 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1, (short) 32, (byte) 33);
        ShortByteMap map6 = this.newWithKeysValues((short) 50, (byte) 0, (short) 60, (byte) 1, (short) 70, (byte) 33);
        ShortByteMap map7 = this.newWithKeysValues((short) 50, (byte) 0, (short) 60, (byte) 1);
        ShortByteMap map8 = this.newWithKeysValues((short) 0, (byte) 0, (short) 1, (byte) 1);

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
                () -> this.classUnderTest().keySet().remove((short) 0));
    }

    @Override
    public void values()
    {
        super.values();
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> this.classUnderTest().values().remove((byte) 0));
    }

    @Test
    public void flipUniqueValues()
    {
        Assert.assertEquals(ByteShortMaps.immutable.empty(), ShortByteMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableByteShortEmptyMap.class, ShortByteMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(ByteShortMaps.immutable.with((byte) 2, (short) 1), this.newWithKeysValues((short) 1, (byte) 2).flipUniqueValues());

        Assert.assertEquals(
                ByteShortHashMap.newWithKeysValues((byte) 2, (short) 1, (byte) 3, (short) 2, (byte) 4, (short) 3, (byte) 5, (short) 4).toImmutable(),
                this.newWithKeysValues((short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4, (byte) 5).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 1).flipUniqueValues());
    }
}
