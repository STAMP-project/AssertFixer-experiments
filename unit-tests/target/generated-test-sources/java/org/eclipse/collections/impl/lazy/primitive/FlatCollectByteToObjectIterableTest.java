/*
 * Copyright (c) 2018 Goldman Sachs and others.
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
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectByteToObjectIterableTest
{
    private LazyIterable<Byte> newPrimitiveWith(byte... elements)
    {
        return new FlatCollectByteToObjectIterable<>(ByteArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach()
    {
        InternalIterable<Byte> collect = this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 5);
        MutableList<Byte> result = Lists.mutable.empty();
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

    @Test
    public void detect()
    {
        Assert.assertEquals(Byte.valueOf((byte) 2), this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detect(Predicates.equal((byte) 2)));
        Assert.assertNull(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detect(Predicates.equal((byte) 4)));
    }

    @Test
    public void detectOptional()
    {
        Assert.assertEquals(Byte.valueOf((byte) 2), this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detectOptional(Predicates.equal((byte) 2)).get());
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).detectOptional(Predicates.equal((byte) 4)).isPresent());
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfy(Predicates.equal((byte) 2)));
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfy(Predicates.equal((byte) 4)));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfyWith(Predicates2.equal(), (byte) 2));
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).anySatisfyWith(Predicates2.equal(), (byte) 4));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfy(Predicates.equal((byte) 2)));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfy(Predicates.greaterThan((byte) 0)));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfyWith(Predicates2.equal(), (byte) 2));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).allSatisfyWith(Predicates2.greaterThan(), (byte) 0));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfy(Predicates.equal((byte) 2)));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfy(Predicates.lessThan((byte) 0)));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertFalse(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfyWith(Predicates2.equal(), (byte) 2));
        Assert.assertTrue(this.newPrimitiveWith((byte) 1, (byte) 2, (byte) 3).noneSatisfyWith(Predicates2.lessThan(), (byte) 0));
    }
}
