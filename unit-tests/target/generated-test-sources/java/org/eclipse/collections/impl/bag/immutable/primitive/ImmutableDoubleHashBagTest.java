/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;

/**
 * JUnit test for {@link ImmutableDoubleHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableDoubleHashBagTest extends AbstractImmutableDoubleBagTestCase
{
    @Override
    protected final ImmutableDoubleBag classUnderTest()
    {
        return DoubleBags.immutable.of(1.0, 2.0, 3.0);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleHashBag iterable = ImmutableDoubleHashBag.newBagWith(1.0, 2.0, 3.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableDoubleBag bag = this.classUnderTest();
        ImmutableDoubleSet expected = DoubleSets.immutable.with(1.0, 2.0, 3.0);
        ImmutableDoubleSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }
}
