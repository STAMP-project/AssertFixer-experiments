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

import org.eclipse.collections.impl.factory.primitive.ByteBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveBooleanMapFactoryImplTest.stg.
 */
public class ImmutableByteBooleanMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(new ByteBooleanHashMap().toImmutable(), ByteBooleanMaps.immutable.of());
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 1, true).toImmutable(), ByteBooleanMaps.immutable.of((byte) 1, true));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(new ByteBooleanHashMap().toImmutable(), ByteBooleanMaps.immutable.ofAll(ByteBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(new ByteBooleanHashMap().toImmutable(), ByteBooleanMaps.immutable.withAll(ByteBooleanMaps.immutable.of()));
    }
}
