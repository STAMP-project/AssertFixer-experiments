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

import org.eclipse.collections.impl.factory.primitive.ObjectShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectShortMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectShortMaps.mutable.of().toImmutable(), ObjectShortMaps.immutable.of());
        Assert.assertEquals(ObjectShortHashMap.newWithKeysValues("2", (short) 1).toImmutable(), ObjectShortMaps.immutable.of("2", (short) 1));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectShortMaps.mutable.empty().toImmutable(), ObjectShortMaps.immutable.ofAll(ObjectShortMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectShortMaps.mutable.with().toImmutable(), ObjectShortMaps.immutable.withAll(ObjectShortMaps.immutable.of()));
    }
}
