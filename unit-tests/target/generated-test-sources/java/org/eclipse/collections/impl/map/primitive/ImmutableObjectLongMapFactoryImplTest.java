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

import org.eclipse.collections.impl.factory.primitive.ObjectLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectLongMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectLongMaps.mutable.of().toImmutable(), ObjectLongMaps.immutable.of());
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 1L).toImmutable(), ObjectLongMaps.immutable.of("2", 1L));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectLongMaps.mutable.empty().toImmutable(), ObjectLongMaps.immutable.ofAll(ObjectLongMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectLongMaps.mutable.with().toImmutable(), ObjectLongMaps.immutable.withAll(ObjectLongMaps.immutable.of()));
    }
}
