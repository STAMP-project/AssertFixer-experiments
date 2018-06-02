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

import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableByteFloatMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ByteFloatMaps.immutable.of());
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f).toImmutable(), ByteFloatMaps.immutable.of((byte) 1, 1.0f));
    }

    @Test
    public void withAll()
    {
        ImmutableByteFloatMap map = ByteFloatMaps.immutable.of();

        Assert.assertEquals(ByteFloatMaps.mutable.empty().toImmutable(), ByteFloatMaps.immutable.withAll(map));
    }
}
