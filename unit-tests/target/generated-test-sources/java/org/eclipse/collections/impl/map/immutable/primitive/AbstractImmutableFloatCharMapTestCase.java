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

import org.eclipse.collections.api.map.primitive.FloatCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatCharMap;
import org.eclipse.collections.impl.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatCharMapTestCase extends AbstractFloatCharMapTestCase
{
    @Override
    protected ImmutableFloatCharMap classUnderTest()
    {
        return FloatCharMaps.immutable.withAll(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32));
    }

    @Override
    protected ImmutableFloatCharMap newWithKeysValues(float key1, char value1)
    {
        return FloatCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2)
    {
        return FloatCharMaps.immutable.withAll(new FloatCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3)
    {
        return FloatCharMaps.immutable.withAll(new FloatCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4)
    {
        return FloatCharMaps.immutable.withAll(new FloatCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableFloatCharMap getEmptyMap()
    {
        return FloatCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        FloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 32.0f, (char) 32);
        FloatCharMap map2 = this.newWithKeysValues(32.0f, (char) 32, 0.0f, (char) 0, 1.0f, (char) 1);
        FloatCharMap map3 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 2, 32.0f, (char) 32);
        FloatCharMap map4 = this.newWithKeysValues(0.0f, (char) 1, 1.0f, (char) 1, 32.0f, (char) 32);
        FloatCharMap map5 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 32.0f, (char) 33);
        FloatCharMap map6 = this.newWithKeysValues(50.0f, (char) 0, 60.0f, (char) 1, 70.0f, (char) 33);
        FloatCharMap map7 = this.newWithKeysValues(50.0f, (char) 0, 60.0f, (char) 1);
        FloatCharMap map8 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);

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
                () -> this.classUnderTest().keySet().remove(0.0f));
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
        Assert.assertEquals(CharFloatMaps.immutable.empty(), FloatCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharFloatEmptyMap.class, FloatCharMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(CharFloatMaps.immutable.with((char) 2, 1.0f), this.newWithKeysValues(1.0f, (char) 2).flipUniqueValues());

        Assert.assertEquals(
                CharFloatHashMap.newWithKeysValues((char) 2, 1.0f, (char) 3, 2.0f, (char) 4, 3.0f, (char) 5, 4.0f).toImmutable(),
                this.newWithKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 1).flipUniqueValues());
    }
}
