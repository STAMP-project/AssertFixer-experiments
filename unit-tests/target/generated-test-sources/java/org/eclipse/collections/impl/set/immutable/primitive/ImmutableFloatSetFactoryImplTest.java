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

import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableFloatSetFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(FloatSets.immutable.of());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f).toImmutable(), FloatSets.immutable.of(1.0f));
    }

    @Test
    public void with()
    {
        Verify.assertEmpty(FloatSets.immutable.with(null));
    }

    @Test
    public void ofAll()
    {
        ImmutableFloatSet set = FloatSets.immutable.of(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(FloatHashSet.newSet(set).toImmutable(), FloatSets.immutable.ofAll(set));
    }
}
