/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharSet}.
 * This file was automatically generated from template file unmodifiablePrimitiveSetTest.stg.
 */
public class UnmodifiableCharSetTest extends AbstractCharSetTestCase
{
    @Override
    protected final UnmodifiableCharSet classUnderTest()
    {
        return new UnmodifiableCharSet(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected UnmodifiableCharSet newWith(char... elements)
    {
        return new UnmodifiableCharSet(CharHashSet.newSetWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.classUnderTest().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newWith().add((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(CharPredicates.equal((char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll()
    {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable()
    {
        this.classUnderTest().removeAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll()
    {
        this.classUnderTest().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable()
    {
        this.classUnderTest().retainAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.newWith().with((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith((char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).without((char) 9);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).withoutAll(this.newMutableCollectionWith((char) 8, (char) 9));
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableCharSet set = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(set.contains((char) 29));
        Assert.assertFalse(set.contains((char) 49));

        char[] numbers = {(char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1};
        for (char number : numbers)
        {
            Assert.assertTrue(set.contains(number));
        }

        Assert.assertFalse(set.contains((char) -1));
        Assert.assertFalse(set.contains((char) 29));
        Assert.assertFalse(set.contains((char) 49));

        UnmodifiableCharSet set1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(set1.contains((char) 0));
        Assert.assertTrue(set1.contains((char) 1));
        Assert.assertTrue(set1.contains((char) 2));
        Assert.assertFalse(set1.contains((char) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws_non_empty_collection()
    {
        UnmodifiableCharSet set = this.newWith((char) 1, (char) 2, (char) 3);
        CharIterator iterator = set.charIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        UnmodifiableCharSet set = this.classUnderTest();
        super.asUnmodifiable();
        Assert.assertSame(set, set.asUnmodifiable());
        Assert.assertEquals(set, set.asUnmodifiable());
    }

    @Override
    public void charIterator_with_remove()
    {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void charIterator_throws_for_remove_before_next()
    {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void charIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable
    }
}
