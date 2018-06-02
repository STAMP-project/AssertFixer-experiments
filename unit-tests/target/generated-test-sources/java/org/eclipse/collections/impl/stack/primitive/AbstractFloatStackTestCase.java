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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.FloatStack;
import org.eclipse.collections.api.stack.primitive.ImmutableFloatStack;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractFloatIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.FloatStacks;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link FloatStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractFloatStackTestCase extends AbstractFloatIterableTestCase
{
    @Override
    protected abstract FloatStack classUnderTest();

    @Override
    protected abstract FloatStack newWith(float... elements);

    @Override
    protected FloatStack newMutableCollectionWith(float... elements)
    {
        return FloatArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Float> newObjectCollectionWith(Float... elements)
    {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract FloatStack newWithTopToBottom(float... elements);

    @Override
    @Test
    public void floatIterator()
    {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(size - i, iterator.next(), 0.0);
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().floatIterator().next(), 0.0);
    }

    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek(), 0.0);
        Assert.assertEquals(FloatArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(FloatArrayList.newListWith(this.classUnderTest().size(), this.classUnderTest().size() - 1),
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
        FloatArrayList list = new FloatArrayList();
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
        for (float each = 0; each < size; each++)
        {
            expectedString.append((float) (size - each));
            expectedString.append((int) each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone()
    {
        FloatIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4.0 : 0.0, iterable.detectIfNone(FloatPredicates.equal(4.0f), 0.0f), 0.0);
        Assert.assertEquals(size >= 2 ? 2.0 : 0.0, iterable.detectIfNone(FloatPredicates.equal(2.0f), 0.0f), 0.0);
        Assert.assertEquals(size > 0 ? 3.0 : 0.0, iterable.detectIfNone(FloatPredicates.lessThan(4.0f), 0.0f), 0.0);
        Assert.assertEquals(size > 3 ? 4.0 : 0.0, iterable.detectIfNone(FloatPredicates.greaterThan(3.0f), 0.0f), 0.0);

        FloatIterable iterable1 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(0.0, iterable1.detectIfNone(FloatPredicates.lessThan(1.0f), 4.0f), 0.0);
        Assert.assertEquals(3.0, iterable1.detectIfNone(FloatPredicates.greaterThan(2.0f), 4.0f), 0.0);
        Assert.assertEquals(4.0, iterable1.detectIfNone(FloatPredicates.greaterThan(4.0f), 4.0f), 0.0);
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
        Verify.assertInstanceOf(ImmutableFloatStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        StackIterable<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                FloatLists.mutable.with(7.0f, 9.0f, 1.0f, 3.0f),
                pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                FloatLists.mutable.with(7.0f, 9.0f, 1.0f, 3.0f),
                pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));

        MutableSet<FloatIntPair> set = this.newWith(3.0f, 1.0f, 9.0f, 7.0f)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(FloatIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                FloatSets.mutable.with(3.0f, 1.0f, 9.0f, 7.0f),
                pairs.collectFloat(FloatIntPair::getOne, FloatSets.mutable.empty()));
    }

    @Test
    public void chunk()
    {
        FloatIterable iterable = this.newWith(5.0f, 4.0f, 3.0f, 2.0f, 1.0f, 0.0f);
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        FloatLists.mutable.with(0.0f),
                        FloatLists.mutable.with(1.0f),
                        FloatLists.mutable.with(2.0f),
                        FloatLists.mutable.with(3.0f),
                        FloatLists.mutable.with(4.0f),
                        FloatLists.mutable.with(5.0f)).toSet(),
                iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        FloatLists.mutable.with(0.0f, 1.0f),
                        FloatLists.mutable.with(2.0f, 3.0f),
                        FloatLists.mutable.with(4.0f, 5.0f)).toSet(),
                iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        FloatLists.mutable.with(0.0f, 1.0f, 2.0f),
                        FloatLists.mutable.with(3.0f, 4.0f, 5.0f)).toSet(),
                iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        FloatLists.mutable.with(0.0f, 1.0f, 2.0f, 3.0f),
                        FloatLists.mutable.with(4.0f, 5.0f)).toSet(),
                iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f)).toSet(),
                iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(FloatLists.mutable.with(0.0f, 1.0f, 2.0f, 3.0f, 4.0f, 5.0f)).toSet(),
                iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        if (this.newWith() instanceof ImmutableFloatStack)
        {
            Verify.assertIterablesEqual(Lists.mutable.with(FloatStacks.immutable.with(0.0f)), this.newWith(0.0f).chunk(1));
        }
        else
        {
            Verify.assertIterablesEqual(Lists.mutable.with(FloatLists.mutable.with(0.0f)), this.newWith(0.0f).chunk(1));
        }

        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith(0.0f).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf()
    {
        this.classUnderTest().indexOf(0.0f);
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
