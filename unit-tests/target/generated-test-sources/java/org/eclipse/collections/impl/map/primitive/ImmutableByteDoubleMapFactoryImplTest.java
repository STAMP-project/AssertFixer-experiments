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

import org.eclipse.collections.api.map.primitive.ImmutableByteDoubleMap;
import org.eclipse.collections.impl.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableByteDoubleMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ByteDoubleMaps.immutable.of());
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0).toImmutable(), ByteDoubleMaps.immutable.of((byte) 1, 1.0));
    }

    @Test
    public void withAll()
    {
        ImmutableByteDoubleMap map = ByteDoubleMaps.immutable.of();

        Assert.assertEquals(ByteDoubleMaps.mutable.empty().toImmutable(), ByteDoubleMaps.immutable.withAll(map));
    }
}
