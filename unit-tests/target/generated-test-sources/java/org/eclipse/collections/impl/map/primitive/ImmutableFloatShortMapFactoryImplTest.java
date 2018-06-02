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

import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.impl.factory.primitive.FloatShortMaps;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableFloatShortMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(FloatShortMaps.immutable.of());
        Assert.assertEquals(FloatShortHashMap.newWithKeysValues(1.0f, (short) 1).toImmutable(), FloatShortMaps.immutable.of(1.0f, (short) 1));
    }

    @Test
    public void withAll()
    {
        ImmutableFloatShortMap map = FloatShortMaps.immutable.of();

        Assert.assertEquals(FloatShortMaps.mutable.empty().toImmutable(), FloatShortMaps.immutable.withAll(map));
    }
}
