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

import org.eclipse.collections.api.map.primitive.ImmutableLongLongMap;
import org.eclipse.collections.impl.factory.primitive.LongLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableLongLongMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(LongLongMaps.immutable.of());
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L).toImmutable(), LongLongMaps.immutable.of(1L, 1L));
    }

    @Test
    public void withAll()
    {
        ImmutableLongLongMap map = LongLongMaps.immutable.of();

        Assert.assertEquals(LongLongMaps.mutable.empty().toImmutable(), LongLongMaps.immutable.withAll(map));
    }
}
