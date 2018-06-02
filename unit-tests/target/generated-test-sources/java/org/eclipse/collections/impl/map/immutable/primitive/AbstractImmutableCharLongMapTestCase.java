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

import org.eclipse.collections.api.map.primitive.CharLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharLongMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharLongMapTestCase extends AbstractCharLongMapTestCase
{
    @Override
    protected ImmutableCharLongMap classUnderTest()
    {
        return CharLongMaps.immutable.withAll(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L));
    }

    @Override
    protected ImmutableCharLongMap newWithKeysValues(char key1, long value1)
    {
        return CharLongMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2)
    {
        return CharLongMaps.immutable.withAll(new CharLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3)
    {
        return CharLongMaps.immutable.withAll(new CharLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4)
    {
        return CharLongMaps.immutable.withAll(new CharLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharLongMap getEmptyMap()
    {
        return CharLongMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        CharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 32, 32L);
        CharLongMap map2 = this.newWithKeysValues((char) 32, 32L, (char) 0, 0L, (char) 1, 1L);
        CharLongMap map3 = this.newWithKeysValues((char) 0, 0L, (char) 1, 2L, (char) 32, 32L);
        CharLongMap map4 = this.newWithKeysValues((char) 0, 1L, (char) 1, 1L, (char) 32, 32L);
        CharLongMap map5 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 32, 33L);
        CharLongMap map6 = this.newWithKeysValues((char) 50, 0L, (char) 60, 1L, (char) 70, 33L);
        CharLongMap map7 = this.newWithKeysValues((char) 50, 0L, (char) 60, 1L);
        CharLongMap map8 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);

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
                () -> this.classUnderTest().keySet().remove((char) 0));
    }

    @Override
    public void values()
    {
        super.values();
        Verify.assertThrows(
                UnsupportedOperationException.class,
                () -> this.classUnderTest().values().remove(0L));
    }

    @Test
    public void flipUniqueValues()
    {
        Assert.assertEquals(LongCharMaps.immutable.empty(), CharLongMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableLongCharEmptyMap.class, CharLongMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(LongCharMaps.immutable.with(2L, (char) 1), this.newWithKeysValues((char) 1, 2L).flipUniqueValues());

        Assert.assertEquals(
                LongCharHashMap.newWithKeysValues(2L, (char) 1, 3L, (char) 2, 4L, (char) 3, 5L, (char) 4).toImmutable(),
                this.newWithKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, 1L, (char) 2, 1L).flipUniqueValues());
    }
}
