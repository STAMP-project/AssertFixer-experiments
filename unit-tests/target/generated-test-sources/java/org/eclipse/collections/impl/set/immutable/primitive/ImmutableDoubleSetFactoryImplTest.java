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

import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableDoubleSetFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(DoubleSets.immutable.of());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0).toImmutable(), DoubleSets.immutable.of(1.0));
    }

    @Test
    public void with()
    {
        Verify.assertEmpty(DoubleSets.immutable.with(null));
    }

    @Test
    public void ofAll()
    {
        ImmutableDoubleSet set = DoubleSets.immutable.of(1.0, 2.0, 3.0);
        Assert.assertEquals(DoubleHashSet.newSet(set).toImmutable(), DoubleSets.immutable.ofAll(set));
    }
}
