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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.IntStack;
import org.eclipse.collections.api.stack.primitive.ImmutableIntStack;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractIntIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntStacks;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link IntStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractIntStackTestCase extends AbstractIntIterableTestCase
{
    @Override
    protected abstract IntStack classUnderTest();

    @Override
    protected abstract IntStack newWith(int... elements);

    @Override
    protected IntStack newMutableCollectionWith(int... elements)
    {
        return IntArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Integer> newObjectCollectionWith(Integer... elements)
    {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract IntStack newWithTopToBottom(int... elements);

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.classUnderTest().intIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(size - i, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().intIterator().next());
    }

    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(IntArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(IntArrayList.newListWith(this.classUnderTest().size(), this.classUnderTest().size() - 1),
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
        IntArrayList list = new IntArrayList();
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
        for (int each = 0; each < size; each++)
        {
            expectedString.append(size - each);
            expectedString.append(each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone()
    {
        IntIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(IntPredicates.equal(4), 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(IntPredicates.equal(2), 0));
        Assert.assertEquals(size > 0 ? 3L : 0L, iterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(IntPredicates.greaterThan(3), 0));

        IntIterable iterable1 = this.newWith(0, 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(IntPredicates.lessThan(1), 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(IntPredicates.greaterThan(2), 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(IntPredicates.greaterThan(4), 4));
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
        Verify.assertInstanceOf(ImmutableIntStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        StackIterable<IntIntPair> pairs = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(IntIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                IntLists.mutable.with(7, 9, 1, 3),
                pairs.collectInt(IntIntPair::getOne, IntLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<IntIntPair> pairs = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(IntIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                IntLists.mutable.with(7, 9, 1, 3),
                pairs.collectInt(IntIntPair::getOne, IntLists.mutable.empty()));

        MutableSet<IntIntPair> set = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(IntIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                IntSets.mutable.with(3, 1, 9, 7),
                pairs.collectInt(IntIntPair::getOne, IntSets.mutable.empty()));
    }

    @Test
    public void chunk()
    {
        IntIterable iterable = this.newWith(5, 4, 3, 2, 1, 0);
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        IntLists.mutable.with(0),
                        IntLists.mutable.with(1),
                        IntLists.mutable.with(2),
                        IntLists.mutable.with(3),
                        IntLists.mutable.with(4),
                        IntLists.mutable.with(5)).toSet(),
                iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        IntLists.mutable.with(0, 1),
                        IntLists.mutable.with(2, 3),
                        IntLists.mutable.with(4, 5)).toSet(),
                iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        IntLists.mutable.with(0, 1, 2),
                        IntLists.mutable.with(3, 4, 5)).toSet(),
                iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        IntLists.mutable.with(0, 1, 2, 3),
                        IntLists.mutable.with(4, 5)).toSet(),
                iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(IntLists.mutable.with(0, 1, 2, 3, 4, 5)).toSet(),
                iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(IntLists.mutable.with(0, 1, 2, 3, 4, 5)).toSet(),
                iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        if (this.newWith() instanceof ImmutableIntStack)
        {
            Verify.assertIterablesEqual(Lists.mutable.with(IntStacks.immutable.with(0)), this.newWith(0).chunk(1));
        }
        else
        {
            Verify.assertIterablesEqual(Lists.mutable.with(IntLists.mutable.with(0)), this.newWith(0).chunk(1));
        }

        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith(0).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf()
    {
        this.classUnderTest().indexOf(0);
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
