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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableShortSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractShortSetTestCase extends AbstractMutableShortCollectionTestCase
{
    protected static ShortArrayList generateCollisions1()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortHashSet set = new ShortHashSet();
        for (short i = (short) 32; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask((short) 32))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    private static ShortArrayList generateNonCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortHashSet set = new ShortHashSet();
        for (short i = (short) 32; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) != set.spreadAndMask((short) 32))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableShortSet classUnderTest();

    @Override
    protected abstract MutableShortSet newWith(short... elements);

    @Override
    protected MutableShortSet newMutableCollectionWith(short... elements)
    {
        return ShortHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Short> newObjectCollectionWith(Short... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(5, this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear()
    {
        super.clear();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains((short) 0));
        Assert.assertFalse(set.contains((short) 31));
        Assert.assertFalse(set.contains((short) 1));
        Assert.assertFalse(set.contains(AbstractShortSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractShortSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add()
    {
        super.add();
        MutableShortSet set = this.newWith();
        Assert.assertTrue(set.add((short) 14));
        Assert.assertFalse(set.add((short) 14));
        Assert.assertTrue(set.add((short) 2));
        Assert.assertFalse(set.add((short) 2));
        Assert.assertTrue(set.add((short) 35));
        Assert.assertFalse(set.add((short) 35));
        Assert.assertTrue(set.add((short) 31));
        Assert.assertFalse(set.add((short) 31));
        Assert.assertTrue(set.add((short) 32));
        Assert.assertFalse(set.add((short) 32));
        Assert.assertTrue(set.add((short) 0));
        Assert.assertFalse(set.add((short) 0));
        Assert.assertTrue(set.add((short) 1));
        Assert.assertFalse(set.add((short) 1));
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new ShortArrayList()));
        Assert.assertFalse(set.addAll(ShortArrayList.newListWith((short) 31, AbstractShortSetTestCase.generateCollisions1().get(0), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);

        Assert.assertTrue(set.addAll(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 30, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 30, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1), AbstractShortSetTestCase.generateCollisions1().get(4)), set);

        Assert.assertTrue(set.addAll(ShortHashSet.newSetWith((short) 5)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1), AbstractShortSetTestCase.generateCollisions1().get(4)), set);

        Assert.assertTrue(set.addAll(ShortHashSet.newSetWith(AbstractShortSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1), AbstractShortSetTestCase.generateCollisions1().get(4), AbstractShortSetTestCase.generateCollisions1().get(5)), set);

        ShortHashSet set1 = new ShortHashSet();
        Assert.assertTrue(set1.addAll((short) 2, (short) 35));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 2, (short) 35), set1);
    }

    @Test
    public void testOfAllFactory()
    {
        Assert.assertEquals(
            ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31),
            ShortSets.mutable.ofAll(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31, (short) 0, (short) 1, (short) 2, (short) 5, (short) 30, (short) 31)));
    }

    @Override
    @Test
    public void remove()
    {
        super.remove();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove((short) 15));
        Assert.assertFalse(set.remove((short) 15));
        Assert.assertTrue(set.remove((short) 0));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractShortSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractShortSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractShortSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 31), set);
        Assert.assertTrue(set.remove((short) 31));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), set);
        Assert.assertTrue(set.remove((short) 1));
        Assert.assertEquals(ShortHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll()
    {
        super.removeAll();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll((short) 15, AbstractShortSetTestCase.generateCollisions1().get(2), AbstractShortSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.removeAll((short) 1));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable()
    {
        super.removeAll_iterable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new ShortArrayList()));
        Assert.assertFalse(set.removeAll(ShortArrayList.newListWith((short) 15, AbstractShortSetTestCase.generateCollisions1().get(2), AbstractShortSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.removeAll(ShortHashSet.newSetWith((short) 1)));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void retainAll()
    {
        super.retainAll();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(4), AbstractShortSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.retainAll((short) 1));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable()
    {
        super.retainAll_iterable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(4), AbstractShortSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, AbstractShortSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(ShortHashSet.newSetWith((short) 1, AbstractShortSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new ShortHashSet(), set);
        Assert.assertFalse(set.retainAll(ShortHashSet.newSetWith((short) 1)));
        Assert.assertEquals(new ShortHashSet(), set);
    }

    @Override
    @Test
    public void shortIterator()
    {
        MutableSet<Short> expected = UnifiedSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        MutableSet<Short> actual = UnifiedSet.newSet();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        ShortIterator iterator = set.shortIterator();
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
    public void shortIterator_throws()
    {
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        ShortIterator iterator = set.shortIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        MutableShortSet set = this.newWith((short) 0, (short) 2, (short) 31);
        Short sum = set.injectInto(Short.valueOf((short) 0), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 33), sum);
    }

    @Override
    @Test
    public void forEach()
    {
        super.forEach();
        long[] sum = new long[1];
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        set.forEach((short each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractShortSetTestCase.generateCollisions1().getFirst() + AbstractShortSetTestCase.generateCollisions1().get(1), sum[0]);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(ShortPredicates.greaterThan((short) 0)));
        Assert.assertEquals(3L, set.count(ShortPredicates.lessThan((short) 32)));
        Assert.assertEquals(1L, set.count(ShortPredicates.greaterThan((short) 32)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(ShortPredicates.lessThan((short) 32)));
        Verify.assertSize(4, set.select(ShortPredicates.greaterThan((short) 0)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(ShortPredicates.greaterThan((short) 0)));
        Verify.assertSize(2, set.reject(ShortPredicates.lessThan((short) 32)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals((short) 0, set.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 9));
        Assert.assertEquals(AbstractShortSetTestCase.generateCollisions1().get(1), set.detectIfNone(ShortPredicates.greaterThan(AbstractShortSetTestCase.generateCollisions1().getFirst()), (short) 9));
        Assert.assertEquals((short) 9, set.detectIfNone(ShortPredicates.greaterThan(AbstractShortSetTestCase.generateCollisions1().get(1)), (short) 9));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(
            UnifiedSet.newSetWith((short) -1, (short) 0, (short) 30, (short) (AbstractShortSetTestCase.generateCollisions1().getFirst() - 1), (short) (AbstractShortSetTestCase.generateCollisions1().get(1) - 1)),
            set.collect((short byteParameter) -> (short) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new short[]{(short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1)}, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        MutableShortSet set3 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1);
        MutableShortSet set4 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1, (short) 1);
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
        super.testEquals();
        MutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        MutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31), this.newWith((short) 0, (short) 1, (short) 31).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedShortSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedShortSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        MutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractShortSetTestCase.generateCollisions1().getFirst(), AbstractShortSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableShortSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortSet(set), set.asUnmodifiable());
    }
}
