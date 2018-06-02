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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleLongMap;
import org.eclipse.collections.impl.factory.primitive.DoubleLongMaps;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleLongHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableDoubleLongMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(DoubleLongMaps.immutable.of());
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L).toImmutable(), DoubleLongMaps.immutable.of(1.0, 1L));
    }

    @Test
    public void withAll()
    {
        ImmutableDoubleLongMap map = DoubleLongMaps.immutable.of();

        Assert.assertEquals(DoubleLongMaps.mutable.empty().toImmutable(), DoubleLongMaps.immutable.withAll(map));
    }
}
