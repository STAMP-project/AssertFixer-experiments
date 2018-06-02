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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleByteMap;
import org.eclipse.collections.impl.factory.primitive.DoubleByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableDoubleByteMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(DoubleByteMaps.immutable.of());
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1).toImmutable(), DoubleByteMaps.immutable.of(1.0, (byte) 1));
    }

    @Test
    public void withAll()
    {
        ImmutableDoubleByteMap map = DoubleByteMaps.immutable.of();

        Assert.assertEquals(DoubleByteMaps.mutable.empty().toImmutable(), DoubleByteMaps.immutable.withAll(map));
    }
}
