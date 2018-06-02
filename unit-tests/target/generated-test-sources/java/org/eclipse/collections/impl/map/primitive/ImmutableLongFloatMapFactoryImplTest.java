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

import org.eclipse.collections.api.map.primitive.ImmutableLongFloatMap;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableLongFloatMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(LongFloatMaps.immutable.of());
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f).toImmutable(), LongFloatMaps.immutable.of(1L, 1.0f));
    }

    @Test
    public void withAll()
    {
        ImmutableLongFloatMap map = LongFloatMaps.immutable.of();

        Assert.assertEquals(LongFloatMaps.mutable.empty().toImmutable(), LongFloatMaps.immutable.withAll(map));
    }
}
