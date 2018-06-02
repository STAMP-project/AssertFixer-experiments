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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.ShortStack;
import org.eclipse.collections.api.stack.primitive.ImmutableShortStack;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractShortIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.ShortStacks;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ShortStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractShortStackTestCase extends AbstractShortIterableTestCase
{
    @Override
    protected abstract ShortStack classUnderTest();

    @Override
    protected abstract ShortStack newWith(short... elements);

    @Override
    protected ShortStack newMutableCollectionWith(short... elements)
    {
        return ShortArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Short> newObjectCollectionWith(Short... elements)
    {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract ShortStack newWithTopToBottom(short... elements);

    @Override
    @Test
    public void shortIterator()
    {
        ShortIterator iterator = this.classUnderTest().shortIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals((short) (size - i), iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().shortIterator().next());
    }

    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(ShortArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(ShortArrayList.newListWith((short) this.classUnderTest().size(), (short) (this.classUnderTest().size() - 1)),
                this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex()
    {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals((short) (size - i), this.classUnderTest().peekAt(i));
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
        ShortArrayList list = new ShortArrayList();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            list.add((short) (size - i));
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
        for (short each = 0; each < size; each++)
        {
            expectedString.append((short) (size - each));
            expectedString.append(each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone()
    {
        ShortIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(ShortPredicates.equal((short) 4), (short) 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(ShortPredicates.equal((short) 2), (short) 0));
        Assert.assertEquals(size > 0 ? 3L : 0L, iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));

        ShortIterable iterable1 = this.newWith((short) 0, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(ShortPredicates.greaterThan((short) 2), (short) 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(ShortPredicates.greaterThan((short) 4), (short) 4));
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
        Verify.assertInstanceOf(ImmutableShortStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        StackIterable<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                ShortLists.mutable.with((short) 7, (short) 9, (short) 1, (short) 3),
                pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                ShortLists.mutable.with((short) 7, (short) 9, (short) 1, (short) 3),
                pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));

        MutableSet<ShortIntPair> set = this.newWith((short) 3, (short) 1, (short) 9, (short) 7)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(ShortIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                ShortSets.mutable.with((short) 3, (short) 1, (short) 9, (short) 7),
                pairs.collectShort(ShortIntPair::getOne, ShortSets.mutable.empty()));
    }

    @Test
    public void chunk()
    {
        ShortIterable iterable = this.newWith((short) 5, (short) 4, (short) 3, (short) 2, (short) 1, (short) 0);
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        ShortLists.mutable.with((short) 0),
                        ShortLists.mutable.with((short) 1),
                        ShortLists.mutable.with((short) 2),
                        ShortLists.mutable.with((short) 3),
                        ShortLists.mutable.with((short) 4),
                        ShortLists.mutable.with((short) 5)).toSet(),
                iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        ShortLists.mutable.with((short) 0, (short) 1),
                        ShortLists.mutable.with((short) 2, (short) 3),
                        ShortLists.mutable.with((short) 4, (short) 5)).toSet(),
                iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        ShortLists.mutable.with((short) 0, (short) 1, (short) 2),
                        ShortLists.mutable.with((short) 3, (short) 4, (short) 5)).toSet(),
                iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        ShortLists.mutable.with((short) 0, (short) 1, (short) 2, (short) 3),
                        ShortLists.mutable.with((short) 4, (short) 5)).toSet(),
                iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5)).toSet(),
                iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(ShortLists.mutable.with((short) 0, (short) 1, (short) 2, (short) 3, (short) 4, (short) 5)).toSet(),
                iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        if (this.newWith() instanceof ImmutableShortStack)
        {
            Verify.assertIterablesEqual(Lists.mutable.with(ShortStacks.immutable.with((short) 0)), this.newWith((short) 0).chunk(1));
        }
        else
        {
            Verify.assertIterablesEqual(Lists.mutable.with(ShortLists.mutable.with((short) 0)), this.newWith((short) 0).chunk(1));
        }

        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith((short) 0).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf()
    {
        this.classUnderTest().indexOf((short) 0);
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
