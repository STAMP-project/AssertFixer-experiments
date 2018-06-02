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

import org.eclipse.collections.api.map.primitive.LongByteMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongByteMap;
import org.eclipse.collections.impl.factory.primitive.LongByteMaps;
import org.eclipse.collections.impl.factory.primitive.ByteLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongByteHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteLongHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongByteMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongByteMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableLongByteMapTestCase extends AbstractLongByteMapTestCase
{
    @Override
    protected ImmutableLongByteMap classUnderTest()
    {
        return LongByteMaps.immutable.withAll(LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32));
    }

    @Override
    protected ImmutableLongByteMap newWithKeysValues(long key1, byte value1)
    {
        return LongByteMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2)
    {
        return LongByteMaps.immutable.withAll(new LongByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3)
    {
        return LongByteMaps.immutable.withAll(new LongByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3, long key4, byte value4)
    {
        return LongByteMaps.immutable.withAll(new LongByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableLongByteMap getEmptyMap()
    {
        return LongByteMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        LongByteMap map1 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1, 32L, (byte) 32);
        LongByteMap map2 = this.newWithKeysValues(32L, (byte) 32, 0L, (byte) 0, 1L, (byte) 1);
        LongByteMap map3 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 2, 32L, (byte) 32);
        LongByteMap map4 = this.newWithKeysValues(0L, (byte) 1, 1L, (byte) 1, 32L, (byte) 32);
        LongByteMap map5 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1, 32L, (byte) 33);
        LongByteMap map6 = this.newWithKeysValues(50L, (byte) 0, 60L, (byte) 1, 70L, (byte) 33);
        LongByteMap map7 = this.newWithKeysValues(50L, (byte) 0, 60L, (byte) 1);
        LongByteMap map8 = this.newWithKeysValues(0L, (byte) 0, 1L, (byte) 1);

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
                () -> this.classUnderTest().keySet().remove(0L));
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
        Assert.assertEquals(ByteLongMaps.immutable.empty(), LongByteMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableByteLongEmptyMap.class, LongByteMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(ByteLongMaps.immutable.with((byte) 2, 1L), this.newWithKeysValues(1L, (byte) 2).flipUniqueValues());

        Assert.assertEquals(
                ByteLongHashMap.newWithKeysValues((byte) 2, 1L, (byte) 3, 2L, (byte) 4, 3L, (byte) 5, 4L).toImmutable(),
                this.newWithKeysValues(1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L, (byte) 5).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1L, (byte) 1, 2L, (byte) 1).flipUniqueValues());
    }
}
