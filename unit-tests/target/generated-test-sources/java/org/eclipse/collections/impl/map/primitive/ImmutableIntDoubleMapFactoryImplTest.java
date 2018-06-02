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

import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;
import org.eclipse.collections.impl.factory.primitive.IntDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableIntDoubleMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(IntDoubleMaps.immutable.of());
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0).toImmutable(), IntDoubleMaps.immutable.of(1, 1.0));
    }

    @Test
    public void withAll()
    {
        ImmutableIntDoubleMap map = IntDoubleMaps.immutable.of();

        Assert.assertEquals(IntDoubleMaps.mutable.empty().toImmutable(), IntDoubleMaps.immutable.withAll(map));
    }
}
