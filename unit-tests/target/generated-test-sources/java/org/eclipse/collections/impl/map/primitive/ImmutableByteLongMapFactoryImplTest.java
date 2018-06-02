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

import org.eclipse.collections.api.map.primitive.ImmutableByteLongMap;
import org.eclipse.collections.impl.factory.primitive.ByteLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableByteLongMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ByteLongMaps.immutable.of());
        Assert.assertEquals(ByteLongHashMap.newWithKeysValues((byte) 1, 1L).toImmutable(), ByteLongMaps.immutable.of((byte) 1, 1L));
    }

    @Test
    public void withAll()
    {
        ImmutableByteLongMap map = ByteLongMaps.immutable.of();

        Assert.assertEquals(ByteLongMaps.mutable.empty().toImmutable(), ByteLongMaps.immutable.withAll(map));
    }
}
