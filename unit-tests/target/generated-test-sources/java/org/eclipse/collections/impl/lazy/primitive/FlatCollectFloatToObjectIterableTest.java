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
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file flatCollectPrimitiveToObjectIterableTest.stg.
 */
public class FlatCollectFloatToObjectIterableTest
{
    private LazyIterable<Float> newPrimitiveWith(float... elements)
    {
        return new FlatCollectFloatToObjectIterable<>(FloatArrayList.newListWith(elements), Lists.mutable::with);
    }

    @Test
    public void forEach()
    {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> result = Lists.mutable.empty();
        collect.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f), result);
    }

    @Test
    public void forEachWithIndex()
    {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> elements = FastList.newList();
        MutableList<Integer> indexes = FastList.newList();
        collect.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f), elements);
        Assert.assertEquals(FastList.newListWith(0, 1, 2, 3, 4, 5), indexes);
    }

    @Test
    public void iterator()
    {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> result = FastList.newList();
        for (float each : collect)
        {
            result.add(each);
        }
        Assert.assertEquals(FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f), result);
    }

    @Test
    public void forEachWith()
    {
        InternalIterable<Float> collect = this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 5.0f);
        MutableList<Float> result = Lists.mutable.of();

        collect.forEachWith((argument1, argument2) -> result.add((float) (argument1 + argument2)), 1);
        Assert.assertEquals(FastList.newListWith(2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 6.0f), result);
    }

    @Test
    public void selectInstancesOf()
    {
        Assert.assertEquals(
                FastList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f),
                this.newPrimitiveWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).selectInstancesOf(Float.class).toList());
    }

    @Test
    public void sizeEmptyNotEmpty()
    {
        Verify.assertIterableSize(2, this.newPrimitiveWith(1.0f, 2.0f));
        Verify.assertIterableEmpty(this.newPrimitiveWith());
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f).notEmpty());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeThrows()
    {
        this.newPrimitiveWith().iterator().remove();
    }

    @Test
    public void detect()
    {
        Assert.assertEquals(Float.valueOf(2.0f), this.newPrimitiveWith(1.0f, 2.0f, 3.0f).detect(Predicates.equal(2.0f)));
        Assert.assertNull(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).detect(Predicates.equal(4.0f)));
    }

    @Test
    public void detectOptional()
    {
        Assert.assertEquals(Float.valueOf(2.0f), this.newPrimitiveWith(1.0f, 2.0f, 3.0f).detectOptional(Predicates.equal(2.0f)).get());
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).detectOptional(Predicates.equal(4.0f)).isPresent());
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).anySatisfy(Predicates.equal(2.0f)));
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).anySatisfy(Predicates.equal(4.0f)));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).anySatisfyWith(Predicates2.equal(), 2.0f));
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).anySatisfyWith(Predicates2.equal(), 4.0f));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).allSatisfy(Predicates.equal(2.0f)));
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).allSatisfy(Predicates.greaterThan(0.0f)));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).allSatisfyWith(Predicates2.equal(), 2.0f));
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).allSatisfyWith(Predicates2.greaterThan(), 0.0f));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).noneSatisfy(Predicates.equal(2.0f)));
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).noneSatisfy(Predicates.lessThan(0.0f)));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertFalse(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).noneSatisfyWith(Predicates2.equal(), 2.0f));
        Assert.assertTrue(this.newPrimitiveWith(1.0f, 2.0f, 3.0f).noneSatisfyWith(Predicates2.lessThan(), 0.0f));
    }
}
