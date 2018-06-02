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

import org.eclipse.collections.impl.factory.primitive.ObjectByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectByteMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectByteMaps.mutable.of().toImmutable(), ObjectByteMaps.immutable.of());
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("2", (byte) 1).toImmutable(), ObjectByteMaps.immutable.of("2", (byte) 1));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectByteMaps.mutable.empty().toImmutable(), ObjectByteMaps.immutable.ofAll(ObjectByteMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectByteMaps.mutable.with().toImmutable(), ObjectByteMaps.immutable.withAll(ObjectByteMaps.immutable.of()));
    }
}
