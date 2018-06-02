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

import org.eclipse.collections.impl.factory.primitive.ShortBooleanMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortBooleanHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveBooleanMapFactoryImplTest.stg.
 */
public class ImmutableShortBooleanMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(new ShortBooleanHashMap().toImmutable(), ShortBooleanMaps.immutable.of());
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true).toImmutable(), ShortBooleanMaps.immutable.of((short) 1, true));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(new ShortBooleanHashMap().toImmutable(), ShortBooleanMaps.immutable.ofAll(ShortBooleanMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(new ShortBooleanHashMap().toImmutable(), ShortBooleanMaps.immutable.withAll(ShortBooleanMaps.immutable.of()));
    }
}
