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

import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableLongDoubleMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(LongDoubleMaps.immutable.of());
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0).toImmutable(), LongDoubleMaps.immutable.of(1L, 1.0));
    }

    @Test
    public void withAll()
    {
        ImmutableLongDoubleMap map = LongDoubleMaps.immutable.of();

        Assert.assertEquals(LongDoubleMaps.mutable.empty().toImmutable(), LongDoubleMaps.immutable.withAll(map));
    }
}
