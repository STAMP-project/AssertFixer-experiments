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

import org.eclipse.collections.api.map.primitive.ImmutableFloatObjectMap;
import org.eclipse.collections.impl.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatObjectMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatObjectMap}.
 * This file was automatically generated from template file abstractImmutablePrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractImmutableFloatObjectMapTestCase extends AbstractFloatObjectMapTestCase
{
    @Override
    protected abstract ImmutableFloatObjectMap<String> classUnderTest();

    @Override
    protected <T> ImmutableFloatObjectMap<T> newWithKeysValues(float key1, T value1)
    {
        return FloatObjectMaps.immutable.with(key1, value1);
    }

    @Override
    protected <T> ImmutableFloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2)
    {
        return FloatObjectMaps.immutable.withAll(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> ImmutableFloatObjectMap<T> newWithKeysValues(float key1, T value1, float key2, T value2, float key3, T value3)
    {
        return FloatObjectMaps.immutable.withAll(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> ImmutableFloatObjectMap<T> getEmptyMap()
    {
        return FloatObjectMaps.immutable.with();
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableFloatObjectMap<String> map = this.classUnderTest();
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
        Verify.assertThrows(UnsupportedOperationException.class, () -> { this.classUnderTest().keySet().remove(0.0f); });
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
        Assert.assertEquals(ObjectFloatMaps.immutable.empty(), FloatObjectMaps.immutable.empty().flipUniqueValues());
        Verify.assertInstanceOf(ImmutableObjectFloatEmptyMap.class, FloatObjectMaps.immutable.empty().flipUniqueValues());

        Assert.assertEquals(ObjectFloatMaps.immutable.with("2", 1.0f), this.newWithKeysValues(1.0f, "2").flipUniqueValues());

        Assert.assertEquals(
                ObjectFloatHashMap.newWithKeysValues("2", 1.0f, "3", 2.0f).toImmutable(),
                this.newWithKeysValues(1.0f, "2", 2.0f, "3").flipUniqueValues());

        Verify.assertThrows(IllegalStateException.class, () -> this.newWithKeysValues(1.0f, "1", 2.0f, "1").flipUniqueValues());
    }
}
