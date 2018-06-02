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

import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectDoubleHashMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapTest.stg.
 */
public class ImmutableObjectDoubleHashMapTest extends AbstractImmutableObjectDoubleMapTestCase
{
    @Override
    protected ImmutableObjectDoubleMap<String> classUnderTest()
    {
        return ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0).toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0, "3", 3.0).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = this.newWithKeysValues("0", 0.0, "1", 1.0);
        Assert.assertEquals(expected, map1.newWithoutKey("2"));
        Assert.assertNotSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = this.newWithKeysValues("1", 1.0);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectDoubleHashMap<String> iterable = new ImmutableObjectDoubleHashMap<>(ObjectDoubleHashMap.newWithKeysValues("3", 3.0, "1", 1.0, "2", 2.0));
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), (MutableDouble object, double value) -> object.add(value));
        Assert.assertEquals(new MutableDouble(6.0), result);
    }
}
