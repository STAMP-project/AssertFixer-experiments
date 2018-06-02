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

import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectIntMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectIntMaps.mutable.of().toImmutable(), ObjectIntMaps.immutable.of());
        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 1).toImmutable(), ObjectIntMaps.immutable.of("2", 1));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectIntMaps.mutable.empty().toImmutable(), ObjectIntMaps.immutable.ofAll(ObjectIntMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectIntMaps.mutable.with().toImmutable(), ObjectIntMaps.immutable.withAll(ObjectIntMaps.immutable.of()));
    }
}
