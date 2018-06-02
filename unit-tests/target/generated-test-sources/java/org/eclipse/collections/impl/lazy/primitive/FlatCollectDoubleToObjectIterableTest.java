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
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectDoubleToObjectIterableTest
{
    private LazyIterable<Double> newPrimitiveWith(double... elements)
    {
        return new FlatCollectDoubleToObjectIterable<>(DoubleArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach()
    {
        InternalIterable<Double> collect = this.newPrimitiveWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0);
        MutableList<Double> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0), result);
    }

    @Test
    public void forEachWithIndex()
    {
        InternalIterable<Double> collect = this.newPrimitiveWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0);
        MutableList<Double> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator()
    {
        InternalIterable<Double> collect = this.newPrimitiveWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0);
        MutableList<Double> result = FastList.newList();
        for (double each : collect)
        {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0), result);
    }

    @Test
    public void forEachWith()
    {
        InternalIterable<Double> collect = this.newPrimitiveWith(1.0, 2.0, 3.0, 4.0, 5.0, 5.0);
        MutableList<Double> result = Lists.mutable.of();

        collect.forEachWith((argument1, argument2) -> result.add((double) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith(2.0, 3.0, 4.0, 5.0, 6.0, 6.0), result);
    }

    @Test
    public void selectInstancesOf()
    {
        Assert.assertEquals(
                FastList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0),
                this.newPrimitiveWith(1.0, 2.0, 3.0, 4.0, 5.0).selectInstancesOf(Double.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty()
    {
        Verify.assertIterableSize(2, this.newPrimitiveWith(1.0, 2.0));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows()
    {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect()
    {
        Assert.assertEquals(Double.valueOf(2.0), this.newPrimitiveWith(1.0, 2.0, 3.0).detect(Predicates.equal(2.0)));
        Assert.assertNull(this.newPrimitiveWith(1.0, 2.0, 3.0).detect(Predicates.equal(4.0)));
    }

    @Test
    public void detectOptional()
    {
        Assert.assertEquals(Double.valueOf(2.0), this.newPrimitiveWith(1.0, 2.0, 3.0).detectOptional(Predicates.equal(2.0)).get());
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).detectOptional(Predicates.equal(4.0)).isPresent());
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0, 3.0).anySatisfy(Predicates.equal(2.0)));
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).anySatisfy(Predicates.equal(4.0)));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0, 3.0).anySatisfyWith(Predicates2.equal(), 2.0));
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).anySatisfyWith(Predicates2.equal(), 4.0));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).allSatisfy(Predicates.equal(2.0)));
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0, 3.0).allSatisfy(Predicates.greaterThan(0.0)));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).allSatisfyWith(Predicates2.equal(), 2.0));
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0, 3.0).allSatisfyWith(Predicates2.greaterThan(), 0.0));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).noneSatisfy(Predicates.equal(2.0)));
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0, 3.0).noneSatisfy(Predicates.lessThan(0.0)));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0, 2.0, 3.0).noneSatisfyWith(Predicates2.equal(), 2.0));
        Assert.assertTrue(this.newPrimitiveWith(1.0, 2.0, 3.0).noneSatisfyWith(Predicates2.lessThan(), 0.0));
    }
}
