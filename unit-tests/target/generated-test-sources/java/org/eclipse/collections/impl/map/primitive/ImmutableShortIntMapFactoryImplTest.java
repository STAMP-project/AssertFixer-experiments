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

import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortIntHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableShortIntMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ShortIntMaps.immutable.of());
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1).toImmutable(), ShortIntMaps.immutable.of((short) 1, 1));
    }

    @Test
    public void withAll()
    {
        ImmutableShortIntMap map = ShortIntMaps.immutable.of();

        Assert.assertEquals(ShortIntMaps.mutable.empty().toImmutable(), ShortIntMaps.immutable.withAll(map));
    }
}
