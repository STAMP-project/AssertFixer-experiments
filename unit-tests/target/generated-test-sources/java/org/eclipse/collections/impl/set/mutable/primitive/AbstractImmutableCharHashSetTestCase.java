/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableCharCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableCharSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableCharHashSetTestCase extends AbstractImmutableCharCollectionTestCase
{
    @Override
    protected abstract ImmutableCharSet classUnderTest();

    @Override
    protected abstract ImmutableCharSet newWith(char... elements);

    @Override
    protected MutableCharSet newMutableCollectionWith(char... elements)
    {
        return CharHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Character> newObjectCollectionWith(Character... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    protected static CharArrayList generateCollisions()
    {
        CharArrayList collisions = new CharArrayList();
        CharHashSet set = new CharHashSet();
        for (char i = (char) 32; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask((char) 32))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(5, this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze()
    {
        ImmutableCharSet immutableCharSet = this.classUnderTest();
        Assert.assertSame(immutableCharSet, immutableCharSet.freeze());
    }

    @Test
    public void toImmutable()
    {
        ImmutableCharSet immutableCharSet = this.classUnderTest();
        Assert.assertSame(immutableCharSet, immutableCharSet.toImmutable());
    }

    @Override
    @Test
    public void charIterator()
    {
        MutableSet<Character> expected = UnifiedSet.newSetWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        MutableSet<Character> actual = UnifiedSet.newSet();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        CharIterator iterator = set.charIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws()
    {
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        CharIterator iterator = set.charIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Override
    @Test
    public void forEach()
    {
        super.forEach();
        long[] sum = new long[1];
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        set.forEach((char each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableCharHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(CharPredicates.greaterThan((char) 0)));
        Assert.assertEquals(3L, set.count(CharPredicates.lessThan((char) 32)));
        Assert.assertEquals(1L, set.count(CharPredicates.greaterThan((char) 32)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(CharPredicates.lessThan((char) 32)));
        Verify.assertSize(4, set.select(CharPredicates.greaterThan((char) 0)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(CharPredicates.greaterThan((char) 0)));
        Verify.assertSize(2, set.reject(CharPredicates.lessThan((char) 32)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals((char) 0, set.detectIfNone(CharPredicates.lessThan((char) 1), (char) 9));
        Assert.assertEquals(AbstractImmutableCharHashSetTestCase.generateCollisions().get(1), set.detectIfNone(CharPredicates.greaterThan(AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst()), (char) 9));
        Assert.assertEquals((char) 9, set.detectIfNone(CharPredicates.greaterThan(AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)), (char) 9));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith((char) -1, (char) 0, (char) 30, (char) (AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst() - 1), (char) (AbstractImmutableCharHashSetTestCase.generateCollisions().get(1) - 1)),
            set.collect(byteParameter -> (char) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new char[]{(char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1)}, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        ImmutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        ImmutableCharSet set3 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1);
        ImmutableCharSet set4 = this.newWith((char) 32, (char) 32, (char) 31, (char) 1, (char) 1);
        Verify.assertEqualsAndHashCode(set1, set2);
        Verify.assertEqualsAndHashCode(set1, set3);
        Verify.assertEqualsAndHashCode(set1, set4);
        Verify.assertEqualsAndHashCode(set2, set3);
        Verify.assertEqualsAndHashCode(set2, set4);
    }

    @Override
    @Test
    public void testHashCode()
    {
        super.testHashCode();
        ImmutableCharSet set1 = this.newWith((char) 1, (char) 31, (char) 32);
        ImmutableCharSet set2 = this.newWith((char) 32, (char) 31, (char) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31), this.newWith((char) 0, (char) 1, (char) 31).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 1, (char) 31, (char) 32).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        ImmutableCharSet set = this.newWith((char) 0, (char) 1, (char) 31, AbstractImmutableCharHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableCharHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, set.asLazy());
    }
}
