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
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveToObjectIterableTest.stg.
 */
public class CollectShortToObjectIterableTest
{
    private LazyIterable<Short> newPrimitiveWith(short... elements)
    {
        return new CollectShortToObjectIterable<>(ShortArrayList.newListWith(elements), Short::valueOf);
    }

    @Test
    public void forEach()
    {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> result = Lists.mutable.of();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5), result);
    }

    @Test
    public void forEachWithIndex()
    {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator()
    {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> result = FastList.newList();
        for (short each : collect)
        {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5), result);
    }

    @Test
    public void forEachWith()
    {
        InternalIterable<Short> collect = this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 5);
        MutableList<Short> result = Lists.mutable.of();

        collect.forEachWith((argument1, argument2) -> result.add((short) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith((short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 6), result);
    }

    @Test
    public void selectInstancesOf()
    {
        Assert.assertEquals(
                FastList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5),
                this.newPrimitiveWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).selectInstancesOf(Short.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty()
    {
        Verify.assertIterableSize(2, this.newPrimitiveWith((short) 1, (short) 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith((short) 1, (short) 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows()
    {
        this.newPrimitiveWith().iterator().remove();
    }
}
