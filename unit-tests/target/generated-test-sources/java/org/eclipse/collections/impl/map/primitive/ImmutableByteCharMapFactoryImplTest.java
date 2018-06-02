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

import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;
import org.eclipse.collections.impl.factory.primitive.ByteCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableByteCharMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ByteCharMaps.immutable.of());
        Assert.assertEquals(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1).toImmutable(), ByteCharMaps.immutable.of((byte) 1, (char) 1));
    }

    @Test
    public void withAll()
    {
        ImmutableByteCharMap map = ByteCharMaps.immutable.of();

        Assert.assertEquals(ByteCharMaps.mutable.empty().toImmutable(), ByteCharMaps.immutable.withAll(map));
    }
}
