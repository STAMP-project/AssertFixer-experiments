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

import org.eclipse.collections.impl.factory.primitive.LongObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImplTest.stg.
 */
public class ImmutableLongObjectMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(LongObjectMaps.mutable.with().toImmutable(), LongObjectMaps.immutable.of());
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, "2").toImmutable(), LongObjectMaps.immutable.of(1L, "2"));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(LongObjectMaps.mutable.of().toImmutable(), LongObjectMaps.immutable.ofAll(LongObjectMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(LongObjectMaps.mutable.empty().toImmutable(), LongObjectMaps.immutable.withAll(LongObjectMaps.immutable.of()));
    }
}
