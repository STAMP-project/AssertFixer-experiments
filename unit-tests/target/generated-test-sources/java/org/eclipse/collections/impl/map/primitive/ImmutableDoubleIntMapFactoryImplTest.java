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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleIntMap;
import org.eclipse.collections.impl.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableDoubleIntMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(DoubleIntMaps.immutable.of());
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1).toImmutable(), DoubleIntMaps.immutable.of(1.0, 1));
    }

    @Test
    public void withAll()
    {
        ImmutableDoubleIntMap map = DoubleIntMaps.immutable.of();

        Assert.assertEquals(DoubleIntMaps.mutable.empty().toImmutable(), DoubleIntMaps.immutable.withAll(map));
    }
}
