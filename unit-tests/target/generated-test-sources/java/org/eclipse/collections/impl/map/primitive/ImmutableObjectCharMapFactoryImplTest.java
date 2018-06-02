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

import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectCharMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectCharMaps.mutable.of().toImmutable(), ObjectCharMaps.immutable.of());
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 1).toImmutable(), ObjectCharMaps.immutable.of("2", (char) 1));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectCharMaps.mutable.empty().toImmutable(), ObjectCharMaps.immutable.ofAll(ObjectCharMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectCharMaps.mutable.with().toImmutable(), ObjectCharMaps.immutable.withAll(ObjectCharMaps.immutable.of()));
    }
}
