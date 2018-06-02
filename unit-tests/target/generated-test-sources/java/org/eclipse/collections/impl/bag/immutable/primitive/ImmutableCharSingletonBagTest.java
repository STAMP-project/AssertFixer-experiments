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
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;

/**
 * JUnit test for {@link ImmutableCharSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableCharSingletonBagTest extends AbstractImmutableCharBagTestCase
{
    @Override
    protected final ImmutableCharBag classUnderTest()
    {
        return CharBags.immutable.of((char) 1);
    }

    @Override
    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((char argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("\u00011", string);
    }

    @Override
    @Test
    public void selectByOccurrences()
    {
        ImmutableCharSingletonBag bag = new ImmutableCharSingletonBag((char) 1);
        ImmutableCharBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), filtered1);
        ImmutableCharBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(CharBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates()
    {
        ImmutableCharSingletonBag bag = new ImmutableCharSingletonBag((char) 1);
        Assert.assertEquals(CharHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableCharBag bag = this.classUnderTest();
        ImmutableCharSet expected = CharSets.immutable.with((char) 1);
        ImmutableCharSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableCharSingletonBag iterable = new ImmutableCharSingletonBag((char) 1);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 1), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 2), result);
    }
}
