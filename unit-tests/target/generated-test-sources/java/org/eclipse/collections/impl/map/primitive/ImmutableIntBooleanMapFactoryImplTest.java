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

import org.eclipse.collections.impl.factory.primitive.IntBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveBooleanMapFactoryImplTest.stg.
 */
public class ImmutableIntBooleanMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(new IntBooleanHashMap().toImmutable(), IntBooleanMaps.immutable.of());
        Assert.assertEquals(IntBooleanHashMap.newWithKeysValues(1, true).toImmutable(), IntBooleanMaps.immutable.of(1, true));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(new IntBooleanHashMap().toImmutable(), IntBooleanMaps.immutable.ofAll(IntBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(new IntBooleanHashMap().toImmutable(), IntBooleanMaps.immutable.withAll(IntBooleanMaps.immutable.of()));
    }
}
