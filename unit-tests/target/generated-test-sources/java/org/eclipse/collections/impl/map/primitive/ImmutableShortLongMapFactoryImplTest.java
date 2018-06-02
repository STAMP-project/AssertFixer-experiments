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

import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableShortLongMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ShortLongMaps.immutable.of());
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L).toImmutable(), ShortLongMaps.immutable.of((short) 1, 1L));
    }

    @Test
    public void withAll()
    {
        ImmutableShortLongMap map = ShortLongMaps.immutable.of();

        Assert.assertEquals(ShortLongMaps.mutable.empty().toImmutable(), ShortLongMaps.immutable.withAll(map));
    }
}
