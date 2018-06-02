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

import org.eclipse.collections.impl.factory.primitive.ByteObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImplTest.stg.
 */
public class ImmutableByteObjectMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ByteObjectMaps.mutable.with().toImmutable(), ByteObjectMaps.immutable.of());
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "2").toImmutable(), ByteObjectMaps.immutable.of((byte) 1, "2"));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ByteObjectMaps.mutable.of().toImmutable(), ByteObjectMaps.immutable.ofAll(ByteObjectMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ByteObjectMaps.mutable.empty().toImmutable(), ByteObjectMaps.immutable.withAll(ByteObjectMaps.immutable.of()));
    }
}
