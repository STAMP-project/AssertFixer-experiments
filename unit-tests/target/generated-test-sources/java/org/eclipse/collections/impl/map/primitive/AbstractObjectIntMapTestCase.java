/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractObjectIntMapTestCase
{
    private final ObjectIntMap<String> map = this.classUnderTest();

    protected abstract ObjectIntMap<String> classUnderTest();

    protected abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1);

    protected abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2);

    protected abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3);

    protected abstract <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4);

    protected abstract <T> ObjectIntMap<T> getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0"), this.newWithKeysValues("0", 0).keySet());
        Assert.assertEquals(UnifiedSet.newSetWith("0", "1", "2"),
                this.newWithKeysValues("0", 0, "1", 1, "2", 2).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        ObjectIntMap<String> map = this.newWithKeysValues("0", 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0));

        ObjectIntMap<String> map1 = this.newWithKeysValues("0", 0, "1", 1, "2", 2);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0));
        Assert.assertTrue(map1.values().contains(1));
        Assert.assertTrue(map1.values().contains(2));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0, this.map.get("0"));
        Assert.assertEquals(1, this.map.get("1"));
        Assert.assertEquals(2, this.map.get("2"));
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0, this.map.getOrThrow("0"));
        Assert.assertEquals(1, this.map.getOrThrow("1"));
        Assert.assertEquals(2, this.map.getOrThrow("2"));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(null));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey("0"));
        Assert.assertTrue(this.map.containsKey("1"));
        Assert.assertTrue(this.map.containsKey("2"));
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertFalse(this.map.containsKey(null));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(1));
        Assert.assertTrue(this.map.containsValue(2));
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0));
        Verify.assertSize(1, this.newWithKeysValues(1, 1));
        Verify.assertSize(1, this.newWithKeysValues(null, 2));
        Verify.assertSize(2, this.newWithKeysValues(1, 1, 5, 5));
        Verify.assertSize(2, this.newWithKeysValues(0, 0, 5, 5));
        Verify.assertSize(3, this.newWithKeysValues(1, 1, 0, 0, 5, 5));
        Verify.assertSize(2, this.newWithKeysValues(6, 6, 5, 5));
    }

    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(null, 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(null, 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50).notEmpty());
    }

    @Test
    public void asLazy()
    {
        Verify.assertSize(this.map.toList().size(), this.map.asLazy().toList());
        Assert.assertTrue(this.map.asLazy().toList().containsAll(this.map.toList()));
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0, this.map.getIfAbsent("0", 1));
        Assert.assertEquals(1, this.map.getIfAbsent("1", 2));
        Assert.assertEquals(2, this.map.getIfAbsent("2", 3));
        Assert.assertEquals(1, this.map.getIfAbsent("5", 1));
        Assert.assertEquals(0, this.map.getIfAbsent("5", 0));

        Assert.assertEquals(1, this.map.getIfAbsent(null, 1));
        Assert.assertEquals(0, this.map.getIfAbsent(null, 0));
    }

    @Test
    public void testEquals()
    {
        ObjectIntMap<Integer> map1 = this.newWithKeysValues(0, 0, 1, 1, null, 2);
        ObjectIntMap<Integer> map2 = this.newWithKeysValues(null, 2, 0, 0, 1, 1);
        ObjectIntMap<Integer> map3 = this.newWithKeysValues(0, 0, 1, 2, null, 2);
        ObjectIntMap<Integer> map5 = this.newWithKeysValues(0, 0, 1, 1, null, 3);
        ObjectIntMap<Integer> map7 = this.newWithKeysValues(null, 2, 1, 1);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map7);

        Assert.assertEquals(map1, ObjectIntMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ObjectIntMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(0, 0, 1, 1).hashCode(),
                this.newWithKeysValues(0, 0, 1, 1).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(50, 0, null, 1).hashCode(),
                this.newWithKeysValues(50, 0, null, 1).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.<Integer>getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0, 0).toString());

        ObjectIntMap<Integer> map1 = this.newWithKeysValues(0, 0, 1, 1);
        Assert.assertTrue(
                map1.toString(),
                "{0=0, 1=1}".equals(map1.toString())
                        || "{1=1, 0=0}".equals(map1.toString()));

        ObjectIntMap<Integer> map2 = this.newWithKeysValues(1, 1, null, 0);
        Assert.assertTrue(
                map2.toString(),
                "{1=1, null=0}".equals(map2.toString())
                        || "{null=0, 1=1}".equals(map2.toString()));
    }

    @Test
    public void intIterator()
    {
        MutableIntSet expected = IntHashSet.newSetWith(0, 1, 2);
        MutableIntSet actual = IntHashSet.newSetWith();

        IntIterator iterator = this.map.intIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> { this.getEmptyMap().intIterator().next(); });
    }

    @Test
    public void forEach()
    {
        ObjectIntMap<Integer> map01 = this.newWithKeysValues(0, 1, 1, 2);
        int[] sum01 = new int[1];
        map01.forEach(each -> { sum01[0] += each; });
        Assert.assertEquals(3, sum01[0]);

        ObjectIntMap<Integer> map = this.newWithKeysValues(3, 4, 4, 5);
        int[] sum = new int[1];
        map.forEach(each -> { sum[0] += each; });
        Assert.assertEquals(9, sum[0]);

        ObjectIntMap<Integer> map1 = this.newWithKeysValues(3, 4, null, 5);
        int[] sum1 = new int[1];
        map1.forEach(each -> { sum1[0] += each; });
        Assert.assertEquals(9, sum1[0]);
    }

    @Test
    public void forEachValue()
    {
        ObjectIntMap<Integer> map01 = this.newWithKeysValues(0, 1, 1, 2);
        int[] sum01 = new int[1];
        map01.forEachValue((int each) -> sum01[0] += each);
        Assert.assertEquals(3, sum01[0]);

        ObjectIntMap<Integer> map = this.newWithKeysValues(3, 4, null, 5);
        int[] sum = new int[1];
        map.forEachValue((int each) -> sum[0] += each);
        Assert.assertEquals(9, sum[0]);
    }

    @Test
    public void forEachKey()
    {
        ObjectIntMap<Integer> map01 = this.newWithKeysValues(0, 1, 1, 2);
        int[] sum01 = new int[1];
        map01.forEachKey((Integer each) -> sum01[0] += each);
        Assert.assertEquals(1, sum01[0]);

        ObjectIntMap<Integer> map = this.newWithKeysValues(3, 4, null, 5);
        String[] sum = new String[1];
        sum[0] = "";
        map.forEachKey(each -> sum[0] += String.valueOf(each));
        Assert.assertTrue("3null".equals(sum[0]) || "null3".equals(sum[0]));
    }

    @Test
    public void forEachKeyValue()
    {
        ObjectIntMap<Integer> map01 = this.newWithKeysValues(0, 1, 1, 2);
        int[] sumKey01 = new int[1];
        int[] sumValue01 = new int[1];
        map01.forEachKeyValue((Integer eachKey, int eachValue) ->
            {
                sumKey01[0] += eachKey;
                sumValue01[0] += eachValue;
            });
        Assert.assertEquals(1, sumKey01[0]);
        Assert.assertEquals(3, sumValue01[0]);

        ObjectIntMap<Integer> map = this.newWithKeysValues(3, 4, null, 5);
        String[] sumKey = new String[1];
        sumKey[0] = "";
        int[] sumValue = new int[1];
        map.forEachKeyValue((Integer eachKey, int eachValue) ->
            {
                sumKey[0] += String.valueOf(eachKey);
                sumValue[0] += eachValue;
            });
        Assert.assertTrue("3null".equals(sumKey[0]) || "null3".equals(sumKey[0]));
        Assert.assertEquals(9, sumValue[0]);
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.<String>getEmptyMap().makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0, 0).makeString());
        Assert.assertEquals("1", this.newWithKeysValues(1, 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(null, 5).makeString());

        ObjectIntMap<Integer> map2 = this.newWithKeysValues(1, 1, 32, 32);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[1/32]".equals(map2.makeString("[", "/", "]"))
                        || "[32/1]".equals(map2.makeString("[", "/", "]")));

        Assert.assertTrue(
                map2.makeString("/"),
                "1/32".equals(map2.makeString("/"))
                        || "32/1".equals(map2.makeString("/")));
    }

    @Test
    public void appendString()
    {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0, 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(null, 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        ObjectIntMap<Integer> map1 = this.newWithKeysValues(0, 0, 1, 1);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "0, 1".equals(appendable3.toString())
                        || "1, 0".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        map1.appendString(appendable4, "/");
        Assert.assertTrue(
                appendable4.toString(),
                "0/1".equals(appendable4.toString())
                        || "1/0".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        map1.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[0/1]".equals(appendable5.toString())
                        || "[1/0]".equals(appendable5.toString()));
    }

    @Test
    public void select()
    {
        Assert.assertEquals(this.map, this.map.select((String object, int value) -> ((Integer.parseInt(object) + value) % 2) == 0));

        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1),
            this.map.select((String object, int value) -> Integer.parseInt(object) + value < 4));

        Assert.assertEquals(this.getEmptyMap(), this.map.select((String object, int value) -> ((Integer.parseInt(object) + value) % 2) != 0));

        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2),
            this.map.select(value -> value < 3).toBag());

        Assert.assertEquals(IntHashBag.newBagWith(0, 1), this.map.select(value -> value < 2).toBag());

        Assert.assertEquals(new IntHashBag(), this.map.select(value -> value > 2).toBag());
    }

    @Test
    public void reject()
    {
        Assert.assertEquals(this.getEmptyMap(), this.map.reject((String object, int value) -> ((Integer.parseInt(object) + value) % 2) == 0));

        Assert.assertEquals(ObjectIntHashMap.newWithKeysValues("2", 2),
            this.map.reject((String object, int value)-> Integer.parseInt(object) + value < 4));

        Assert.assertEquals(this.map, this.map.reject((String object, int value) -> ((Integer.parseInt(object) + value) % 2) != 0));

        Assert.assertEquals(new IntHashBag(), this.map.reject(value -> value < 3).toBag());

        Assert.assertEquals(IntHashBag.newBagWith(2), this.map.reject(value -> value < 2).toBag());

        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2),
            this.map.reject(value -> value > 2).toBag());
    }

    @Test
    public void tap()
    {
        MutableIntList tapResult = IntLists.mutable.empty();
        Assert.assertSame(this.map, this.map.tap(tapResult::add));
        Assert.assertEquals(this.map.toList(), tapResult);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(3L, this.map.count(value -> value < 3));

        Assert.assertEquals(2L, this.map.count(value -> value < 2));

        Assert.assertEquals(0L, this.map.count(value -> value > 2));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.map.anySatisfy(value -> value < 3));

        Assert.assertTrue(this.map.anySatisfy(value -> value < 2));

        Assert.assertFalse(this.map.anySatisfy(value -> value > 2));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.map.allSatisfy(value -> value < 3));

        Assert.assertFalse(this.map.allSatisfy(value -> value < 2));

        Assert.assertFalse(this.map.allSatisfy(value -> value > 2));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.map.noneSatisfy(value -> value < 0));

        Assert.assertFalse(this.map.noneSatisfy(value -> value < 2));
    }

    @Test
    public void detectIfNone()
    {
        int detect = this.map.detectIfNone(value -> value < 3, 5);
        Assert.assertTrue(detect == 0 || detect == 1 || detect == 2);

        int detect1 = this.map.detectIfNone(value -> value < 2, 5);
        Assert.assertTrue(detect1 == 0 || detect1 == 1);

        Assert.assertEquals(5, this.map.detectIfNone(value -> value > 2, 5));
    }

    @Test
    public void collect()
    {
        IntToObjectFunction<String> toString = String::valueOf;
        ObjectIntMap<Integer> map1 = this.newWithKeysValues(0, 0, 1, 1);
        Assert.assertTrue(map1.collect(toString).toString(), FastList.newListWith("1", "0").equals(map1.collect(toString))
                || FastList.newListWith("0", "1").equals(map1.collect(toString)));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(3L, this.map.sum());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(2, this.map.max());
        Assert.assertEquals(3, this.newWithKeysValues(null, 3, 0, 0, 2, 2).max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList()
    {
        this.<Integer>getEmptyMap().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0, this.map.min());
        Assert.assertEquals(0, this.newWithKeysValues(null, 0, 5, 5, 1, 1).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList()
    {
        this.<Integer>getEmptyMap().min();
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(2, this.map.maxIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(null, 3, 0, 0, 2, 2).maxIfEmpty(5));
        Assert.assertEquals(9, this.getEmptyMap().maxIfEmpty(9));
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(0, this.map.minIfEmpty(6));
        Assert.assertEquals(0, this.newWithKeysValues(null, 0, 5, 5, 1, 1).minIfEmpty(6));
        Assert.assertEquals(5, this.getEmptyMap().minIfEmpty(5));
    }

    @Test
    public void average()
    {
        Assert.assertEquals(1.0, this.map.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        this.getEmptyMap().average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.0, this.map.median(), 0.0);
        Assert.assertEquals(1.5, this.newWithKeysValues("0", 0, "1", 1, "2", 2, "3", 3).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        this.getEmptyMap().median();
    }

    @Test
    public void toArray()
    {
        Assert.assertTrue(Arrays.equals(new int[]{0, 1}, this.newWithKeysValues("0", 0, "1", 1).toArray())
                || Arrays.equals(new int[]{1, 0}, this.newWithKeysValues("0", 0, "1", 1).toArray()));
        Assert.assertArrayEquals(new int[]{}, this.getEmptyMap().toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new int[]{0, 2, 9}, this.newWithKeysValues("9", 9, "0", 0, "2", 2).toSortedArray());
        Assert.assertArrayEquals(new int[]{}, this.getEmptyMap().toSortedArray());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertTrue(this.map.contains(1));
        Assert.assertTrue(this.map.contains(2));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll(0, 1, 2));
        Assert.assertFalse(this.map.containsAll(0, 1, 5));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(IntArrayList.newListWith(0, 1, 2)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 1, 5)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
    }

    @Test
    public void toList()
    {
        Assert.assertTrue(IntArrayList.newListWith(0, 1).equals(this.newWithKeysValues("0", 0, "1", 1).toList())
                || IntArrayList.newListWith(1, 0).equals(this.newWithKeysValues("0", 0, "1", 1).toList()));
        Assert.assertEquals(IntArrayList.newListWith(), this.getEmptyMap().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(IntArrayList.newListWith(0, 2, 9), this.newWithKeysValues("9", 9, "0", 0, "2", 2).toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(), this.getEmptyMap().toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2), this.map.toSet());
        Assert.assertEquals(IntHashSet.newSetWith(), this.getEmptyMap().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2), this.map.toBag());
        Assert.assertEquals(IntHashBag.newBagWith(), this.getEmptyMap().toBag());
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableObjectIntMap.class, this.classUnderTest().toImmutable());
    }
}
