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

import org.eclipse.collections.api.map.primitive.ImmutableIntCharMap;
import org.eclipse.collections.impl.factory.primitive.IntCharMaps;
import org.eclipse.collections.impl.map.mutable.primitive.IntCharHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableIntCharMapFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(IntCharMaps.immutable.of());
        Assert.assertEquals(IntCharHashMap.newWithKeysValues(1, (char) 1).toImmutable(), IntCharMaps.immutable.of(1, (char) 1));
    }

    @Test
    public void withAll()
    {
        ImmutableIntCharMap map = IntCharMaps.immutable.of();

        Assert.assertEquals(IntCharMaps.mutable.empty().toImmutable(), IntCharMaps.immutable.withAll(map));
    }
}
