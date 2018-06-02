/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.stack.primitive;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.DoubleStack;
import org.eclipse.collections.api.stack.primitive.ImmutableDoubleStack;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractDoubleIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.DoubleStacks;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link DoubleStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractDoubleStackTestCase extends AbstractDoubleIterableTestCase
{
    @Override
    protected abstract DoubleStack classUnderTest();

    @Override
    protected abstract DoubleStack newWith(double... elements);

    @Override
    protected DoubleStack newMutableCollectionWith(double... elements)
    {
        return DoubleArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Double> newObjectCollectionWith(Double... elements)
    {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract DoubleStack newWithTopToBottom(double... elements);

    @Override
    @Test
    public void doubleIterator()
    {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(size - i, iterator.next(), 0.0);
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().doubleIterator().next(), 0.0);
    }

    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek(), 0.0);
        Assert.assertEquals(DoubleArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(DoubleArrayList.newListWith(this.classUnderTest().size(), this.classUnderTest().size() - 1),
                this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex()
    {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals(size - i, this.classUnderTest().peekAt(i), 0.0);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_less_than_zero_throws_exception()
    {
        this.classUnderTest().peekAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_greater_than_size_throws_exception()
    {
        this.classUnderTest().peekAt(this.classUnderTest().size() + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void peek_at_index_equal_to_size_throws_exception()
    {
        this.classUnderTest().peekAt(this.classUnderTest().size());
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals(this.createExpectedString("[", ", ", "]"), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        DoubleArrayList list = new DoubleArrayList();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            list.add(size - i);
        }
        Assert.assertEquals(list, this.classUnderTest().toList());
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals(this.createExpectedString("", ", ", ""), this.classUnderTest().makeString());
        Assert.assertEquals(this.createExpectedString("", "|", ""), this.classUnderTest().makeString("|"));
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), this.classUnderTest().makeString("{", "|", "}"));
    }

    protected String createExpectedString(String start, String sep, String end)
    {
        StringBuilder expectedString = new StringBuilder(start);
        int size = this.classUnderTest().size();
        for (double each = 0; each < size; each++)
        {
            expectedString.append((double) (size - each));
            expectedString.append((int) each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4.0 : 0.0, iterable.detectIfNone(DoublePredicates.equal(4.0), 0.0), 0.0);
        Assert.assertEquals(size >= 2 ? 2.0 : 0.0, iterable.detectIfNone(DoublePredicates.equal(2.0), 0.0), 0.0);
        Assert.assertEquals(size > 0 ? 3.0 : 0.0, iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(size > 3 ? 4.0 : 0.0, iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);

        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(0.0, iterable1.detectIfNone(DoublePredicates.lessThan(1.0), 4.0), 0.0);
        Assert.assertEquals(3.0, iterable1.detectIfNone(DoublePredicates.greaterThan(2.0), 4.0), 0.0);
        Assert.assertEquals(4.0, iterable1.detectIfNone(DoublePredicates.greaterThan(4.0), 4.0), 0.0);
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.classUnderTest().appendString(appendable1);
        Assert.assertEquals(this.createExpectedString("", ", ", ""), appendable1.toString());

        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2, "|");
        Assert.assertEquals(this.createExpectedString("", "|", ""), appendable2.toString());

        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "{", "|", "}");
        Assert.assertEquals(this.createExpectedString("{", "|", "}"), appendable3.toString());
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableDoubleStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        StackIterable<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                DoubleLists.mutable.with(7.0, 9.0, 1.0, 3.0),
                pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                DoubleLists.mutable.with(7.0, 9.0, 1.0, 3.0),
                pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));

        MutableSet<DoubleIntPair> set = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(DoubleIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                DoubleSets.mutable.with(3.0, 1.0, 9.0, 7.0),
                pairs.collectDouble(DoubleIntPair::getOne, DoubleSets.mutable.empty()));
    }

    @Test
    public void chunk()
    {
        DoubleIterable iterable = this.newWith(5.0, 4.0, 3.0, 2.0, 1.0, 0.0);
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        DoubleLists.mutable.with(0.0),
                        DoubleLists.mutable.with(1.0),
                        DoubleLists.mutable.with(2.0),
                        DoubleLists.mutable.with(3.0),
                        DoubleLists.mutable.with(4.0),
                        DoubleLists.mutable.with(5.0)).toSet(),
                iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        DoubleLists.mutable.with(0.0, 1.0),
                        DoubleLists.mutable.with(2.0, 3.0),
                        DoubleLists.mutable.with(4.0, 5.0)).toSet(),
                iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        DoubleLists.mutable.with(0.0, 1.0, 2.0),
                        DoubleLists.mutable.with(3.0, 4.0, 5.0)).toSet(),
                iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        DoubleLists.mutable.with(0.0, 1.0, 2.0, 3.0),
                        DoubleLists.mutable.with(4.0, 5.0)).toSet(),
                iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(DoubleLists.mutable.with(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)).toSet(),
                iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(DoubleLists.mutable.with(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)).toSet(),
                iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        if (this.newWith() instanceof ImmutableDoubleStack)
        {
            Verify.assertIterablesEqual(Lists.mutable.with(DoubleStacks.immutable.with(0.0)), this.newWith(0.0).chunk(1));
        }
        else
        {
            Verify.assertIterablesEqual(Lists.mutable.with(DoubleLists.mutable.with(0.0)), this.newWith(0.0).chunk(1));
        }

        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith(0.0).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf()
    {
        this.classUnderTest().indexOf(0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void injectIntoWithIndex()
    {
        this.classUnderTest().injectIntoWithIndex(null, null);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void forEachWithIndex()
    {
        this.classUnderTest().forEachWithIndex(null);
    }
}
