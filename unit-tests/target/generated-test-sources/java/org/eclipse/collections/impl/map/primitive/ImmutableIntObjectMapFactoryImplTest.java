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

import org.eclipse.collections.impl.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImplTest.stg.
 */
public class ImmutableIntObjectMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(IntObjectMaps.mutable.with().toImmutable(), IntObjectMaps.immutable.of());
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "2").toImmutable(), IntObjectMaps.immutable.of(1, "2"));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(IntObjectMaps.mutable.of().toImmutable(), IntObjectMaps.immutable.ofAll(IntObjectMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(IntObjectMaps.mutable.empty().toImmutable(), IntObjectMaps.immutable.withAll(IntObjectMaps.immutable.of()));
    }
}
