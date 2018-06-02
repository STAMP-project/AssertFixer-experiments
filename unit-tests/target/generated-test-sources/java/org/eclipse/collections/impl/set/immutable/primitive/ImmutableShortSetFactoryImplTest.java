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

import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortSetFactoryImpl}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImplTest.stg.
 */
public class ImmutableShortSetFactoryImplTest
{
    @Test
    public void of()
    {
        Verify.assertEmpty(ShortSets.immutable.of());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1).toImmutable(), ShortSets.immutable.of((short) 1));
    }

    @Test
    public void with()
    {
        Verify.assertEmpty(ShortSets.immutable.with(null));
    }

    @Test
    public void ofAll()
    {
        ImmutableShortSet set = ShortSets.immutable.of((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(ShortHashSet.newSet(set).toImmutable(), ShortSets.immutable.ofAll(set));
    }
}
