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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleFloatMap;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableDoubleFloatMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(DoubleFloatMaps.immutable.of());
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f).toImmutable(), DoubleFloatMaps.immutable.of(1.0, 1.0f));
    }

    @Test
    public void withAll()
    {
        ImmutableDoubleFloatMap map = DoubleFloatMaps.immutable.of();

        Assert.assertEquals(DoubleFloatMaps.mutable.empty().toImmutable(), DoubleFloatMaps.immutable.withAll(map));
    }
}
