/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntHashBag}.
 * This file was automatically generated from template file primitiveHashBagTest.stg.
 */
public class IntHashBagTest extends AbstractMutableIntBagTestCase
{
    @Override
    protected final IntHashBag classUnderTest()
    {
        return IntHashBag.newBagWith(1, 2, 3);
    }

    @Override
    protected IntHashBag newWith(int... elements)
    {
        return IntHashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new IntHashBag(3));
        Verify.assertSize(0, IntHashBag.newBag(3));
        Verify.assertSize(3, IntHashBag.newBagWith(0, 1, 2));
        Verify.assertSize(3, new IntHashBag(IntHashBag.newBagWith(0, 1, 2)));
        Verify.assertSize(3, IntHashBag.newBag(IntHashBag.newBagWith(0, 1, 2)));
        Verify.assertSize(3, IntHashBag.newBag(IntArrayList.newListWith(0, 1, 2)));
        Verify.assertSize(3, new IntHashBag(IntArrayList.newListWith(0, 1, 2)));
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        IntHashBag hashBag = new IntHashBag().with(1);
        IntHashBag hashBag0 = new IntHashBag().with(1, 2);
        IntHashBag hashBag1 = new IntHashBag().with(1, 2, 3);
        IntHashBag hashBag2 = new IntHashBag().with(1).with(2).with(3).with(4);
        IntHashBag hashBag3 = new IntHashBag().with(1).with(2).with(3).with(4).with(5);
        Assert.assertEquals(IntHashBag.newBagWith(1), hashBag);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), hashBag0);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), hashBag1);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4), hashBag2);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5), hashBag3);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        IntHashBag hashBag = IntHashBag.newBagWith(1, 1, 2, 2, 2, 2, 3);
        Integer sum = hashBag.injectInto(Integer.valueOf(4), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(17), sum);
    }
}
