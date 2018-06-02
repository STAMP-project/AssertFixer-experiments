/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.primitive;

import org.eclipse.collections.impl.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImplTest.stg.
 */
public class ImmutableCharObjectMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(CharObjectMaps.mutable.with().toImmutable(), CharObjectMaps.immutable.of());
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "2").toImmutable(), CharObjectMaps.immutable.of((char) 1, "2"));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(CharObjectMaps.mutable.of().toImmutable(), CharObjectMaps.immutable.ofAll(CharObjectMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(CharObjectMaps.mutable.empty().toImmutable(), CharObjectMaps.immutable.withAll(CharObjectMaps.immutable.of()));
    }
}
