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

import java.util.Iterator;

import org.eclipse.collections.api.map.primitive.ImmutableIntObjectMap;
import org.eclipse.collections.impl.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntObjectMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntObjectMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractImmutableIntObjectMapTestCase extends AbstractIntObjectMapTestCase
{
    @Override
    protected abstract ImmutableIntObjectMap<String> classUnderTest();

    @Override
    protected <T> ImmutableIntObjectMap<T> newWithKeysValues(int key1, T value1)
    {
        return IntObjectMaps.immutable.with(key1, value1);
    }

    @Override
    protected <T> ImmutableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2)
    {
        return IntObjectMaps.immutable.withAll(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> ImmutableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2, int key3, T value3)
    {
        return IntObjectMaps.immutable.withAll(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> ImmutableIntObjectMap<T> getEmptyMap()
    {
        return IntObjectMaps.immutable.with();
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableIntObjectMap<String> map = this.classUnderTest();
        Assert.assertSame(map, map.toImmutable());
    }

    @Override
    @Test
    public void iterator()
    {
        super.iterator();
        Iterator<String> iterator = this.classUnderTest().iterator();
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void keySet()
    {
        super.keySet();
        Verify.assertThrows(UnsupportedOperationException.class, () -> { this.classUnderTest().keySet().remove(0); });
    }

    @Override
    public void values()
    {
        super.values();
        Verify.assertThrows(UnsupportedOperationException.class, () -> { this.classUnderTest().values().remove("zero"); });
    }

    @Test
    public void flipUniqueValues()
    {
        Assert.assertEquals(ObjectIntMaps.immutable.empty(), IntObjectMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableObjectIntEmptyMap.class, IntObjectMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(ObjectIntMaps.immutable.with("2", 1), this.newWithKeysValues(1, "2").flipUniqueValues());

        Assert.assertEquals(
                ObjectIntHashMap.newWithKeysValues("2", 1, "3", 2).toImmutable(),
                this.newWithKeysValues(1, "2", 2, "3").flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1, "1", 2, "1").flipUniqueValues());
    }
}
