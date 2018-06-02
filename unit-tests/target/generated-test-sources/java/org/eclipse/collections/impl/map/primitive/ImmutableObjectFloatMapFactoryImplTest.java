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

import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectFloatMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectFloatMaps.mutable.of().toImmutable(), ObjectFloatMaps.immutable.of());
        Assert.assertEquals(ObjectFloatHashMap.newWithKeysValues("2", 1.0f).toImmutable(), ObjectFloatMaps.immutable.of("2", 1.0f));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectFloatMaps.mutable.empty().toImmutable(), ObjectFloatMaps.immutable.ofAll(ObjectFloatMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectFloatMaps.mutable.with().toImmutable(), ObjectFloatMaps.immutable.withAll(ObjectFloatMaps.immutable.of()));
    }
}
