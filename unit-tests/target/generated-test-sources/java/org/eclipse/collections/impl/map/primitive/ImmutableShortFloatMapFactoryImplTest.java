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

import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableShortFloatMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ShortFloatMaps.immutable.of());
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f).toImmutable(), ShortFloatMaps.immutable.of((short) 1, 1.0f));
    }

    @Test
    public void withAll()
    {
        ImmutableShortFloatMap map = ShortFloatMaps.immutable.of();

        Assert.assertEquals(ShortFloatMaps.mutable.empty().toImmutable(), ShortFloatMaps.immutable.withAll(map));
    }
}
