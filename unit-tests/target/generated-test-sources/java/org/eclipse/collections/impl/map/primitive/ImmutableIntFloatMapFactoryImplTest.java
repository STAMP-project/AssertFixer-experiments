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

import org.eclipse.collections.api.map.primitive.ImmutableIntFloatMap;
import org.eclipse.collections.impl.factory.primitive.IntFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableIntFloatMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(IntFloatMaps.immutable.of());
        Assert.assertEquals(IntFloatHashMap.newWithKeysValues(1, 1.0f).toImmutable(), IntFloatMaps.immutable.of(1, 1.0f));
    }

    @Test
    public void withAll()
    {
        ImmutableIntFloatMap map = IntFloatMaps.immutable.of();

        Assert.assertEquals(IntFloatMaps.mutable.empty().toImmutable(), IntFloatMaps.immutable.withAll(map));
    }
}
