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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.stack.StackIterable;
import org.eclipse.collections.api.stack.primitive.CharStack;
import org.eclipse.collections.api.stack.primitive.ImmutableCharStack;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractCharIterableTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.CharStacks;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link CharStack}.
 * This file was automatically generated from template file abstractPrimitiveStackTestCase.stg.
 */
public abstract class AbstractCharStackTestCase extends AbstractCharIterableTestCase
{
    @Override
    protected abstract CharStack classUnderTest();

    @Override
    protected abstract CharStack newWith(char... elements);

    @Override
    protected CharStack newMutableCollectionWith(char... elements)
    {
        return CharArrayStack.newStackWith(elements);
    }

    @Override
    protected RichIterable<Character> newObjectCollectionWith(Character... elements)
    {
        return ArrayStack.newStackWith(elements);
    }

    protected abstract CharStack newWithTopToBottom(char... elements);

    @Override
    @Test
    public void charIterator()
    {
        CharIterator iterator = this.classUnderTest().charIterator();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals((char) (size - i), iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(size, this.classUnderTest().charIterator().next());
    }

    @Test
    public void peek()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().peek());
        Assert.assertEquals(CharArrayList.newListWith(), this.classUnderTest().peek(0));
        Assert.assertEquals(CharArrayList.newListWith((char) this.classUnderTest().size(), (char) (this.classUnderTest().size() - 1)),
                this.classUnderTest().peek(2));
    }

    @Test
    public void peekAtIndex()
    {
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            Assert.assertEquals((char) (size - i), this.classUnderTest().peekAt(i));
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
        CharArrayList list = new CharArrayList();
        int size = this.classUnderTest().size();
        for (int i = 0; i < size; i++)
        {
            list.add((char) (size - i));
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
        for (char each = 0; each < size; each++)
        {
            expectedString.append((char) (size - each));
            expectedString.append(each == size - 1 ? "" : sep);
        }
        expectedString.append(end);
        return expectedString.toString();
    }

    @Override
    @Test
    public void detectIfNone()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(CharPredicates.equal((char) 4), (char) 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(CharPredicates.equal((char) 2), (char) 0));
        Assert.assertEquals(size > 0 ? 3L : 0L, iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));

        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(CharPredicates.lessThan((char) 1), (char) 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(CharPredicates.greaterThan((char) 2), (char) 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(CharPredicates.greaterThan((char) 4), (char) 4));
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
        Verify.assertInstanceOf(ImmutableCharStack.class, this.classUnderTest().toImmutable());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        StackIterable<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                CharLists.mutable.with((char) 7, (char) 9, (char) 1, (char) 3),
                pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                CharLists.mutable.with((char) 7, (char) 9, (char) 1, (char) 3),
                pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));

        MutableSet<CharIntPair> set = this.newWith((char) 3, (char) 1, (char) 9, (char) 7)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(CharIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                CharSets.mutable.with((char) 3, (char) 1, (char) 9, (char) 7),
                pairs.collectChar(CharIntPair::getOne, CharSets.mutable.empty()));
    }

    @Test
    public void chunk()
    {
        CharIterable iterable = this.newWith((char) 5, (char) 4, (char) 3, (char) 2, (char) 1, (char) 0);
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        CharLists.mutable.with((char) 0),
                        CharLists.mutable.with((char) 1),
                        CharLists.mutable.with((char) 2),
                        CharLists.mutable.with((char) 3),
                        CharLists.mutable.with((char) 4),
                        CharLists.mutable.with((char) 5)).toSet(),
                iterable.chunk(1).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        CharLists.mutable.with((char) 0, (char) 1),
                        CharLists.mutable.with((char) 2, (char) 3),
                        CharLists.mutable.with((char) 4, (char) 5)).toSet(),
                iterable.chunk(2).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        CharLists.mutable.with((char) 0, (char) 1, (char) 2),
                        CharLists.mutable.with((char) 3, (char) 4, (char) 5)).toSet(),
                iterable.chunk(3).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(
                        CharLists.mutable.with((char) 0, (char) 1, (char) 2, (char) 3),
                        CharLists.mutable.with((char) 4, (char) 5)).toSet(),
                iterable.chunk(4).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(CharLists.mutable.with((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5)).toSet(),
                iterable.chunk(6).toSet());
        Verify.assertIterablesEqual(
                Lists.mutable.with(CharLists.mutable.with((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5)).toSet(),
                iterable.chunk(7).toSet());
        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        if (this.newWith() instanceof ImmutableCharStack)
        {
            Verify.assertIterablesEqual(Lists.mutable.with(CharStacks.immutable.with((char) 0)), this.newWith((char) 0).chunk(1));
        }
        else
        {
            Verify.assertIterablesEqual(Lists.mutable.with(CharLists.mutable.with((char) 0)), this.newWith((char) 0).chunk(1));
        }

        Verify.assertIterablesEqual(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith((char) 0).chunk(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void indexOf()
    {
        this.classUnderTest().indexOf((char) 0);
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
