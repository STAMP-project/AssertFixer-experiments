/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableLongSetFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(LongSets.immutable.of());
        Assert.assertEquals(LongHashSet.newSetWith(1L).toImmutable(), LongSets.immutable.of(1L));
    }

    @Test
    public void with()
    {
        Verify.assertEmpty(LongSets.immutable.with(null));
    }

    @Test
    public void ofAll()
    {
        ImmutableLongSet set = LongSets.immutable.of(1L, 2L, 3L);
        Assert.assertEquals(LongHashSet.newSet(set).toImmutable(), LongSets.immutable.ofAll(set));
    }
}
