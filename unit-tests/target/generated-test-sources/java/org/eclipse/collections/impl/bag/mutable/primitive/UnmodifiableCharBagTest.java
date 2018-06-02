/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharBag}.
 * This file was automatically generated from template file unmodifiablePrimitiveBagTest.stg.
 */
public class UnmodifiableCharBagTest extends AbstractMutableCharBagTestCase
{
    private final UnmodifiableCharBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableCharBag classUnderTest()
    {
        return new UnmodifiableCharBag(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected UnmodifiableCharBag newWith(char... elements)
    {
        return new UnmodifiableCharBag(CharHashBag.newBagWith(elements));
    }

    @Override
    protected MutableCharBag newWithOccurrences(CharIntPair... elementsWithOccurrences)
    {
        MutableCharBag bag = CharBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            CharIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences()
    {
        this.bag.addOccurrences((char) 1, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences((char) 1, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences()
    {
        this.bag.removeOccurrences((char) 1, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences((char) 1, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.bag.clear();
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
        UnmodifiableCharBag collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));

        char[] numbers = {(char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1};
        for (char number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains((char) -1));
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));

        UnmodifiableCharBag collection1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(collection1.contains((char) 0));
        Assert.assertTrue(collection1.contains((char) 1));
        Assert.assertTrue(collection1.contains((char) 2));
        Assert.assertFalse(collection1.contains((char) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws_non_empty_collection()
    {
        UnmodifiableCharBag collection = this.newWith((char) 1, (char) 2, (char) 3);
        CharIterator iterator = collection.charIterator();
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
        super.asUnmodifiable();
        Assert.assertSame(this.bag, this.bag.asUnmodifiable());
        Assert.assertEquals(this.bag, this.bag.asUnmodifiable());
    }

    @Override
    @Test
    public void charIterator_with_remove()
    {
        UnmodifiableCharBag unmodifiableCharBag = this.classUnderTest();
        MutableCharIterator iterator = unmodifiableCharBag.charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_remove_before_next()
    {
        UnmodifiableCharBag unmodifiableCharBag = this.classUnderTest();
        MutableCharIterator iterator = unmodifiableCharBag.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
