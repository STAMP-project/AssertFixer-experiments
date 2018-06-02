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

import org.eclipse.collections.api.map.primitive.ImmutableShortDoubleMap;
import org.eclipse.collections.impl.factory.primitive.ShortDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableShortDoubleMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ShortDoubleMaps.immutable.of());
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0).toImmutable(), ShortDoubleMaps.immutable.of((short) 1, 1.0));
    }

    @Test
    public void withAll()
    {
        ImmutableShortDoubleMap map = ShortDoubleMaps.immutable.of();

        Assert.assertEquals(ShortDoubleMaps.mutable.empty().toImmutable(), ShortDoubleMaps.immutable.withAll(map));
    }
}
