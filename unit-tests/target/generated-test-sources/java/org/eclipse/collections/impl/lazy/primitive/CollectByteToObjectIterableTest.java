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
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveToObjectIterableTest.stg.
 */
public class CollectByteToObjectIterableTest
{
    private LazyIterable<Byte> newPrimitiveWith(byte... elements)
    {
        return new CollectByteToObjectIterable<>(ByteArrayList.newListWith(elements), Byte::valueOf);
    }

    @Test
    public void forEach()
    {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = Lists.mutable.of();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5), result);
    }

    @Test
    public void forEachWithIndex()
    {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator()
    {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = FastList.newList();
        for (byte each : collect)
        {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5), result);
    }

    @Test
    public void forEachWith()
    {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = Lists.mutable.of();

        collect.forEachWith((argument1, argument2) -> result.add((byte) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith((byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 6, (byte) 6), result);
    }

    @Test
    public void selectInstancesOf()
    {
        Assert.assertEquals(
                FastList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5),
                this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).selectInstancesOf(Byte.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty()
    {
        Verify.assertIterableSize(2, this.newPrimitiveWith((byte) 1, (byte) 2));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows()
    {
        this.newPrimitiveWith().iterator().remove();
    }
}
