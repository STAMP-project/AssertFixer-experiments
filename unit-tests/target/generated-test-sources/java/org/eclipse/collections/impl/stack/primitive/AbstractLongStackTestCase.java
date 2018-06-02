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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.LongStack;
import org.eclipse.collections.api.stack.primitive.ImmutableLongStack;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractLongIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.LongStacks;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LongStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractLongStackTestCase extends AbstractLongIterableTestCase
{
    @Override
    protected abstract LongStack classUnderTest();

    @Override
    protected abstract LongStack newWith(long... elements);

    @Override
    protected LongStack newMutableCollectionWith(long... elements)
    {
        return LongArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Long> newObjectCollectionWith(Long... elements)
    {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract LongStack newWithTopToBottom(long... elements);

    @Override
    @Test
    public void longIterator()
    {
        LongIterator iterator = this.classUnderTest().longIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(size - i, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().longIterator().next());
    }

    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(LongArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(LongArrayList.newListWith(this.classUnderTest().size(), this.classUnderTest().size() - 1),
                this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex()
    {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals(size - i, this.classUnderTest().peekAt(i));
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
        LongArrayList list = new LongArrayList();
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
        for (long each = 0; each < size; each++)
        {
            expectedString.append((long) (size - each));
            expectedString.append(each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone()
    {
        LongIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(LongPredicates.equal(4L), 0L));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(LongPredicates.equal(2L), 0L));
        Assert.assertEquals(size > 0 ? 3L : 0L, iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));

        LongIterable iterable1 = this.newWith(0L, 1L, 2L, 2L, 3L, 3L, 3L);
        Assert.assertEquals(0L, iterable1.detectIfNone(LongPredicates.lessThan(1L), 4L));
        Assert.assertEquals(3L, iterable1.detectIfNone(LongPredicates.greaterThan(2L), 4L));
        Assert.assertEquals(4L, iterable1.detectIfNone(LongPredicates.greaterThan(4L), 4L));
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
        Verify.assertInstanceOf(ImmutableLongStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        StackIterable<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                LongLists.mutable.with(7L, 9L, 1L, 3L),
                pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                LongLists.mutable.with(7L, 9L, 1L, 3L),
                pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));

        MutableSet<LongIntPair> set = this.newWith(3L, 1L, 9L, 7L)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(LongIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                LongSets.mutable.with(3L, 1L, 9L, 7L),
                pairs.collectLong(LongIntPair::getOne, LongSets.mutable.empty()));
    }

    @Test
    public void chunk()
    {
        LongIterable iterable = this.newWith(5L, 4L, 3L, 2L, 1L, 0L);
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        LongLists.mutable.with(0L),
                        LongLists.mutable.with(1L),
                        LongLists.mutable.with(2L),
                        LongLists.mutable.with(3L),
                        LongLists.mutable.with(4L),
                        LongLists.mutable.with(5L)).toSet(),
                iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        LongLists.mutable.with(0L, 1L),
                        LongLists.mutable.with(2L, 3L),
                        LongLists.mutable.with(4L, 5L)).toSet(),
                iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        LongLists.mutable.with(0L, 1L, 2L),
                        LongLists.mutable.with(3L, 4L, 5L)).toSet(),
                iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        LongLists.mutable.with(0L, 1L, 2L, 3L),
                        LongLists.mutable.with(4L, 5L)).toSet(),
                iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(LongLists.mutable.with(0L, 1L, 2L, 3L, 4L, 5L)).toSet(),
                iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(LongLists.mutable.with(0L, 1L, 2L, 3L, 4L, 5L)).toSet(),
                iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        if (this.newWith() instanceof ImmutableLongStack)
        {
            Verify.assertIterablesEqual(Lists.mutable.with(LongStacks.immutable.with(0L)), this.newWith(0L).chunk(1));
        }
        else
        {
            Verify.assertIterablesEqual(Lists.mutable.with(LongLists.mutable.with(0L)), this.newWith(0L).chunk(1));
        }

        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith(0L).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf()
    {
        this.classUnderTest().indexOf(0L);
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
