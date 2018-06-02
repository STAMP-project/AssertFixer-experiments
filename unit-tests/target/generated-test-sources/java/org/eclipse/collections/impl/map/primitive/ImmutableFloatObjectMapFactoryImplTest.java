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

import org.eclipse.collections.impl.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImplTest.stg.
 */
public class ImmutableFloatObjectMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(FloatObjectMaps.mutable.with().toImmutable(), FloatObjectMaps.immutable.of());
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "2").toImmutable(), FloatObjectMaps.immutable.of(1.0f, "2"));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(FloatObjectMaps.mutable.of().toImmutable(), FloatObjectMaps.immutable.ofAll(FloatObjectMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(FloatObjectMaps.mutable.empty().toImmutable(), FloatObjectMaps.immutable.withAll(FloatObjectMaps.immutable.of()));
    }
}
