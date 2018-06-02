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

import org.eclipse.collections.impl.factory.primitive.ObjectDoubleMaps;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImplTest.stg.
 */
public class ImmutableObjectDoubleMapFactoryImplTest
{
    @Test
    public void of()
    {
        Assert.assertEquals(ObjectDoubleMaps.mutable.of().toImmutable(), ObjectDoubleMaps.immutable.of());
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 1.0).toImmutable(), ObjectDoubleMaps.immutable.of("2", 1.0));
    }

    @Test
    public void ofAll()
    {
        Assert.assertEquals(ObjectDoubleMaps.mutable.empty().toImmutable(), ObjectDoubleMaps.immutable.ofAll(ObjectDoubleMaps.immutable.of()));
    }

    @Test
    public void withAll()
    {
        Assert.assertEquals(ObjectDoubleMaps.mutable.with().toImmutable(), ObjectDoubleMaps.immutable.withAll(ObjectDoubleMaps.immutable.of()));
    }
}
