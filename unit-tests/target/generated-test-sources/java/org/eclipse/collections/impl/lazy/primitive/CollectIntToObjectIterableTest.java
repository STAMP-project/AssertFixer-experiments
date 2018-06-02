/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.primitive;

import org.eclipse.collections.api.InternalIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveToObjectIterableTest.stg.
 */
public class CollectIntToObjectIterableTest
{
    private LazyIterable<Integer> newPrimitiveWith(int... elements)
    {
        return new CollectIntToObjectIterable<>(IntArrayList.newListWith(elements), Integer::valueOf);
    }

    @Test
    public void forEach()
    {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> result = Lists.mutable.of();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 5), result);
    }

    @Test
    public void forEachWithIndex()
    {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator()
    {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> result = FastList.newList();
        for (int each : collect)
        {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 5, 5), result);
    }

    @Test
    public void forEachWith()
    {
        InternalIterable<Integer> collect = this.newPrimitiveWith(1, 2, 3, 4, 5, 5);
        MutableList<Integer> result = Lists.mutable.of();

        collect.forEachWith((argument1, argument2) -> result.add((int) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith(2, 3, 4, 5, 6, 6), result);
    }

    @Test
    public void selectInstancesOf()
    {
        Assert.assertEquals(
                FastList.newListWith(1, 2, 3, 4, 5),
                this.newPrimitiveWith(1, 2, 3, 4, 5).selectInstancesOf(Integer.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty()
    {
        Verify.assertIterableSize(2, this.newPrimitiveWith(1, 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(1, 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows()
    {
        this.newPrimitiveWith().iterator().remove();
    }
}
