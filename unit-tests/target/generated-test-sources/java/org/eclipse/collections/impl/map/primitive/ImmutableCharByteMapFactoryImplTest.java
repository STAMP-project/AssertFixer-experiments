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

import org.eclipse.collections.api.map.primitive.ImmutableCharByteMap;
import org.eclipse.collections.impl.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.map.mutable.primitive.CharByteHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableCharByteMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(CharByteMaps.immutable.of());
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1).toImmutable(), CharByteMaps.immutable.of((char) 1, (byte) 1));
    }

    @Test
    public void withAll()
    {
        ImmutableCharByteMap map = CharByteMaps.immutable.of();

        Assert.assertEquals(CharByteMaps.mutable.empty().toImmutable(), CharByteMaps.immutable.withAll(map));
    }
}
