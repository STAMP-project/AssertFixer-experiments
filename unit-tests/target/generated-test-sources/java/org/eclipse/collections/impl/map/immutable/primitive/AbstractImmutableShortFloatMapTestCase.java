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

import org.eclipse.collections.api.map.primitive.ShortFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractShortFloatMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortFloatMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableShortFloatMapTestCase extends AbstractShortFloatMapTestCase
{
    @Override
    protected ImmutableShortFloatMap classUnderTest()
    {
        return ShortFloatMaps.immutable.withAll(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f));
    }

    @Override
    protected ImmutableShortFloatMap newWithKeysValues(short key1, float value1)
    {
        return ShortFloatMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2)
    {
        return ShortFloatMaps.immutable.withAll(new ShortFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3)
    {
        return ShortFloatMaps.immutable.withAll(new ShortFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4)
    {
        return ShortFloatMaps.immutable.withAll(new ShortFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableShortFloatMap getEmptyMap()
    {
        return ShortFloatMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        ShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 32, 32.0f);
        ShortFloatMap map2 = this.newWithKeysValues((short) 32, 32.0f, (short) 0, 0.0f, (short) 1, 1.0f);
        ShortFloatMap map3 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 2.0f, (short) 32, 32.0f);
        ShortFloatMap map4 = this.newWithKeysValues((short) 0, 1.0f, (short) 1, 1.0f, (short) 32, 32.0f);
        ShortFloatMap map5 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 32, 33.0f);
        ShortFloatMap map6 = this.newWithKeysValues((short) 50, 0.0f, (short) 60, 1.0f, (short) 70, 33.0f);
        ShortFloatMap map7 = this.newWithKeysValues((short) 50, 0.0f, (short) 60, 1.0f);
        ShortFloatMap map8 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);

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
                () -> this.classUnderTest().values().remove(0.0f));
    }

    @Test
    public void flipUniqueValues()
    {
        Assert.assertEquals(FloatShortMaps.immutable.empty(), ShortFloatMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableFloatShortEmptyMap.class, ShortFloatMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(FloatShortMaps.immutable.with(2.0f, (short) 1), this.newWithKeysValues((short) 1, 2.0f).flipUniqueValues());

        Assert.assertEquals(
                FloatShortHashMap.newWithKeysValues(2.0f, (short) 1, 3.0f, (short) 2, 4.0f, (short) 3, 5.0f, (short) 4).toImmutable(),
                this.newWithKeysValues((short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4, 5.0f).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((short) 1, 1.0f, (short) 2, 1.0f).flipUniqueValues());
    }
}
