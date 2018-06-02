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

import org.eclipse.collections.impl.factory.primitive.DoubleObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImplTest.stg.
 */
public class ImmutableDoubleObjectMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(DoubleObjectMaps.mutable.with().toImmutable(), DoubleObjectMaps.immutable.of());
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, "2").toImmutable(), DoubleObjectMaps.immutable.of(1.0, "2"));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(DoubleObjectMaps.mutable.of().toImmutable(), DoubleObjectMaps.immutable.ofAll(DoubleObjectMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(DoubleObjectMaps.mutable.empty().toImmutable(), DoubleObjectMaps.immutable.withAll(DoubleObjectMaps.immutable.of()));
    }
}
