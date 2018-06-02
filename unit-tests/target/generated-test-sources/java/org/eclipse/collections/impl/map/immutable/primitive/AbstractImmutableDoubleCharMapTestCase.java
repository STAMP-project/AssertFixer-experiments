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

import org.eclipse.collections.api.map.primitive.DoubleCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleCharMap;
import org.eclipse.collections.impl.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleCharHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharDoubleHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableDoubleCharMapTestCase extends AbstractDoubleCharMapTestCase
{
    @Override
    protected ImmutableDoubleCharMap classUnderTest()
    {
        return DoubleCharMaps.immutable.withAll(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32));
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1)
    {
        return DoubleCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2)
    {
        return DoubleCharMaps.immutable.withAll(new DoubleCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3)
    {
        return DoubleCharMaps.immutable.withAll(new DoubleCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3, double key4, char value4)
    {
        return DoubleCharMaps.immutable.withAll(new DoubleCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableDoubleCharMap getEmptyMap()
    {
        return DoubleCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        DoubleCharMap map1 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 32.0, (char) 32);
        DoubleCharMap map2 = this.newWithKeysValues(32.0, (char) 32, 0.0, (char) 0, 1.0, (char) 1);
        DoubleCharMap map3 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 2, 32.0, (char) 32);
        DoubleCharMap map4 = this.newWithKeysValues(0.0, (char) 1, 1.0, (char) 1, 32.0, (char) 32);
        DoubleCharMap map5 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 32.0, (char) 33);
        DoubleCharMap map6 = this.newWithKeysValues(50.0, (char) 0, 60.0, (char) 1, 70.0, (char) 33);
        DoubleCharMap map7 = this.newWithKeysValues(50.0, (char) 0, 60.0, (char) 1);
        DoubleCharMap map8 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);

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
                () -> this.classUnderTest().keySet().remove(0.0));
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
        Assert.assertEquals(CharDoubleMaps.immutable.empty(), DoubleCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharDoubleEmptyMap.class, DoubleCharMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(CharDoubleMaps.immutable.with((char) 2, 1.0), this.newWithKeysValues(1.0, (char) 2).flipUniqueValues());

        Assert.assertEquals(
                CharDoubleHashMap.newWithKeysValues((char) 2, 1.0, (char) 3, 2.0, (char) 4, 3.0, (char) 5, 4.0).toImmutable(),
                this.newWithKeysValues(1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0, (char) 5).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0, (char) 1, 2.0, (char) 1).flipUniqueValues());
    }
}
