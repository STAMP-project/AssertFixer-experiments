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

import org.eclipse.collections.api.map.primitive.CharCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.impl.factory.primitive.CharCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharCharHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharCharMap}.
 * This file was automatically generated from template file abstractImmutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractImmutableCharCharMapTestCase extends AbstractCharCharMapTestCase
{
    @Override
    protected ImmutableCharCharMap classUnderTest()
    {
        return CharCharMaps.immutable.withAll(CharCharHashMap.newWithKeysValues((char) 0, (char) 0, (char) 31, (char) 31, (char) 32, (char) 32));
    }

    @Override
    protected ImmutableCharCharMap newWithKeysValues(char key1, char value1)
    {
        return CharCharMaps.immutable.with(key1, value1);
    }

    @Override
    protected ImmutableCharCharMap newWithKeysValues(char key1, char value1, char key2, char value2)
    {
        return CharCharMaps.immutable.withAll(new CharCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected ImmutableCharCharMap newWithKeysValues(char key1, char value1, char key2, char value2, char key3, char value3)
    {
        return CharCharMaps.immutable.withAll(new CharCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected ImmutableCharCharMap newWithKeysValues(char key1, char value1, char key2, char value2, char key3, char value3, char key4, char value4)
    {
        return CharCharMaps.immutable.withAll(new CharCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected ImmutableCharCharMap getEmptyMap()
    {
        return CharCharMaps.immutable.with();
    }

    @Override
    @Test
    public void testEquals()
    {
        CharCharMap map1 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 32, (char) 32);
        CharCharMap map2 = this.newWithKeysValues((char) 32, (char) 32, (char) 0, (char) 0, (char) 1, (char) 1);
        CharCharMap map3 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 2, (char) 32, (char) 32);
        CharCharMap map4 = this.newWithKeysValues((char) 0, (char) 1, (char) 1, (char) 1, (char) 32, (char) 32);
        CharCharMap map5 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1, (char) 32, (char) 33);
        CharCharMap map6 = this.newWithKeysValues((char) 50, (char) 0, (char) 60, (char) 1, (char) 70, (char) 33);
        CharCharMap map7 = this.newWithKeysValues((char) 50, (char) 0, (char) 60, (char) 1);
        CharCharMap map8 = this.newWithKeysValues((char) 0, (char) 0, (char) 1, (char) 1);

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
                () -> this.classUnderTest().values().remove((char) 0));
    }

    @Test
    public void flipUniqueValues()
    {
        Assert.assertEquals(CharCharMaps.immutable.empty(), CharCharMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableCharCharEmptyMap.class, CharCharMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(CharCharMaps.immutable.with((char) 2, (char) 1), this.newWithKeysValues((char) 1, (char) 2).flipUniqueValues());

        Assert.assertEquals(
                CharCharHashMap.newWithKeysValues((char) 2, (char) 1, (char) 3, (char) 2, (char) 4, (char) 3, (char) 5, (char) 4).toImmutable(),
                this.newWithKeysValues((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 4, (char) 4, (char) 5).flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 1).flipUniqueValues());
    }
}
