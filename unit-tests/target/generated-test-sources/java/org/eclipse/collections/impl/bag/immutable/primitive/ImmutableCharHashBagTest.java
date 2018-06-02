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

import org.eclipse.collections.api.bag.primitive.ImmutableCharBag;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;

/**
 * JUnit test for {@link ImmutableCharHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableCharHashBagTest extends AbstractImmutableCharBagTestCase
{
    @Override
    protected final ImmutableCharBag classUnderTest()
    {
        return CharBags.immutable.of((char) 1, (char) 2, (char) 3);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableCharHashBag iterable = ImmutableCharHashBag.newBagWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableCharBag bag = this.classUnderTest();
        ImmutableCharSet expected = CharSets.immutable.with((char) 1, (char) 2, (char) 3);
        ImmutableCharSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }
}
