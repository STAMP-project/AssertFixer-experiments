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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.DoubleIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.DoubleIntMaps;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractDoubleIntMapTestCase
{
    protected final DoubleIntMap map = this.classUnderTest();

    protected abstract DoubleIntMap classUnderTest();

    protected abstract DoubleIntMap newWithKeysValues(double key1, int value1);

    protected abstract DoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2);

    protected abstract DoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3);

    protected abstract DoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3, double key4, int value4);

    protected abstract DoubleIntMap getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0), this.newWithKeysValues(0.0, 0).keySet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, 32.0),
                this.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        DoubleIntMap map = this.newWithKeysValues(0.0, 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0));

        DoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0));
        Assert.assertTrue(map1.values().contains(31));
        Assert.assertTrue(map1.values().contains(32));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0.0));
        Assert.assertEquals(31L, this.map.get(31.0));
        Assert.assertEquals(32L, this.map.get(32.0));

        Assert.assertEquals(0L, this.map.get(1.0));
        Assert.assertEquals(0L, this.map.get(33.0));
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0, 5));
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0));
        Assert.assertEquals(31L, this.map.getOrThrow(31.0));
        Assert.assertEquals(32L, this.map.getOrThrow(32.0));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0.0));
        Assert.assertTrue(this.map.containsKey(31.0));
        Assert.assertTrue(this.map.containsKey(32.0));
        Assert.assertFalse(this.map.containsKey(1.0));
        Assert.assertFalse(this.map.containsKey(5.0));
        Assert.assertFalse(this.map.containsKey(35.0));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(31));
        Assert.assertTrue(this.map.containsValue(32));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertTrue(this.map.contains(31));
        Assert.assertTrue(this.map.contains(32));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll(0, 31, 32));
        Assert.assertFalse(this.map.containsAll(0, 31, 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(IntArrayList.newListWith(0, 31, 32)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 35)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1.0, 1, 5.0, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, 0, 5.0, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, 1, 0.0, 0, 5.0, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, 6, 5.0, 5).size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0, 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0, 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0, 50).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0, 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0, 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0, 50).notEmpty());
    }

    @Test
    public void testEquals()
    {
        DoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1, 32.0, 32);
        DoubleIntMap map2 = this.newWithKeysValues(32.0, 32, 0.0, 0, 1.0, 1);
        DoubleIntMap map3 = this.newWithKeysValues(0.0, 0, 1.0, 2, 32.0, 32);
        DoubleIntMap map4 = this.newWithKeysValues(0.0, 1, 1.0, 1, 32.0, 32);
        DoubleIntMap map5 = this.newWithKeysValues(0.0, 0, 1.0, 1, 32.0, 33);
        DoubleIntMap map6 = this.newWithKeysValues(50.0, 0, 60.0, 1, 70.0, 33);
        DoubleIntMap map7 = this.newWithKeysValues(50.0, 0, 60.0, 1);
        DoubleIntMap map8 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        DoubleIntMap map9 = this.newWithKeysValues(0.0, 0);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(IntArrayList.newListWith(0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);

        Assert.assertEquals(map1, DoubleIntMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, DoubleIntMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(0.0, 0, 1.0, 1, 32.0, 32).hashCode(),
                this.newWithKeysValues(32.0, 32, 0.0, 0, 1.0, 1).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(50.0, 0, 60.0, 1, 70.0, 33).hashCode(),
                this.newWithKeysValues(50.0, 0, 60.0, 1, 70.0, 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1.0, 2).hashCode(), this.newWithKeysValues(1.0, 2).hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=0}", this.newWithKeysValues(0.0, 0).toString());
        Assert.assertEquals("{1.0=1}", this.newWithKeysValues(1.0, 1).toString());
        Assert.assertEquals("{5.0=5}", this.newWithKeysValues(5.0, 5).toString());

        DoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        Assert.assertTrue(
                map1.toString(),
                "{0.0=0, 1.0=1}".equals(map1.toString())
                        || "{1.0=1, 0.0=0}".equals(map1.toString()));

        DoubleIntMap map2 = this.newWithKeysValues(1.0, 1, 32.0, 32);
        Assert.assertTrue(
                map2.toString(),
                "{1.0=1, 32.0=32}".equals(map2.toString())
                        || "{32.0=32, 1.0=1}".equals(map2.toString()));

        DoubleIntMap map3 = this.newWithKeysValues(0.0, 0, 32.0, 32);
        Assert.assertTrue(
                map3.toString(),
                "{0.0=0, 32.0=32}".equals(map3.toString())
                        || "{32.0=32, 0.0=0}".equals(map3.toString()));

        DoubleIntMap map4 = this.newWithKeysValues(32.0, 32, 33.0, 33);
        Assert.assertTrue(
                map4.toString(),
                "{32.0=32, 33.0=33}".equals(map4.toString())
                        || "{33.0=33, 32.0=32}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        DoubleIntMap map0 = this.newWithKeysValues(0.0, 1, 3.0, 4);
        int[] sum0 = new int[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        DoubleIntMap map1 = this.newWithKeysValues(1.0, 2, 3.0, 4);
        int[] sum1 = new int[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        DoubleIntMap map01 = this.newWithKeysValues(0.0, 1, 1.0, 2);
        int[] sum01 = new int[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        DoubleIntMap map = this.newWithKeysValues(3.0, 4, 4.0, 5);
        int[] sum = new int[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        DoubleIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        DoubleIntMap map3 = this.newWithKeysValues(1.0, 2);
        int[] sum3 = new int[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue()
    {
        DoubleIntMap map0 = this.newWithKeysValues(0.0, 1, 3.0, 4);
        int[] sum0 = new int[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        DoubleIntMap map1 = this.newWithKeysValues(1.0, 2, 3.0, 4);
        int[] sum1 = new int[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        DoubleIntMap map01 = this.newWithKeysValues(0.0, 1, 1.0, 2);
        int[] sum01 = new int[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        DoubleIntMap map = this.newWithKeysValues(3.0, 4, 4.0, 5);
        int[] sum = new int[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        DoubleIntMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        DoubleIntMap map3 = this.newWithKeysValues(1.0, 2);
        int[] sum3 = new int[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey()
    {
        DoubleIntMap map0 = this.newWithKeysValues(0.0, 1, 3.0, 4);
        double[] sum0 = new double[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);

        DoubleIntMap map1 = this.newWithKeysValues(1.0, 2, 3.0, 4);
        double[] sum1 = new double[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);

        DoubleIntMap map01 = this.newWithKeysValues(0.0, 1, 1.0, 2);
        double[] sum01 = new double[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);

        DoubleIntMap map = this.newWithKeysValues(3.0, 4, 4.0, 5);
        double[] sum = new double[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7.0, sum[0], 0.0);

        DoubleIntMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);

        DoubleIntMap map3 = this.newWithKeysValues(1.0, 1);
        double[] sum3 = new double[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKeyValue()
    {
        DoubleIntMap map0 = this.newWithKeysValues(0.0, 1, 3.0, 4);
        double[] sumKey0 = new double[1];
        int[] sumValue0 = new int[1];
        map0.forEachKeyValue((double eachKey, int eachValue) ->
        {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals(5L, sumValue0[0]);

        DoubleIntMap map1 = this.newWithKeysValues(1.0, 2, 3.0, 4);
        double[] sumKey1 = new double[1];
        int[] sumValue1 = new int[1];
        map1.forEachKeyValue((double eachKey, int eachValue) ->
        {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertEquals(6L, sumValue1[0]);

        DoubleIntMap map01 = this.newWithKeysValues(0.0, 1, 1.0, 2);
        double[] sumKey01 = new double[1];
        int[] sumValue01 = new int[1];
        map01.forEachKeyValue((double eachKey, int eachValue) ->
        {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals(3L, sumValue01[0]);

        DoubleIntMap map = this.newWithKeysValues(3.0, 4, 4.0, 5);
        double[] sumKey = new double[1];
        int[] sumValue = new int[1];
        map.forEachKeyValue((double eachKey, int eachValue) ->
        {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7.0, sumKey[0], 0.0);
        Assert.assertEquals(9L, sumValue[0]);

        DoubleIntMap map2 = this.getEmptyMap();
        double[] sumKey2 = new double[1];
        int[] sumValue2 = new int[1];
        map2.forEachKeyValue((double eachKey, int eachValue) ->
        {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0.0, sumKey2[0], 0.0);
        Assert.assertEquals(0L, sumValue2[0]);

        DoubleIntMap map3 = this.newWithKeysValues(3.0, 5);
        double[] sumKey3 = new double[1];
        int[] sumValue3 = new int[1];
        map3.forEachKeyValue((double eachKey, int eachValue) ->
        {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3.0, sumKey3[0], 0.0);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0.0, 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0.0, 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0.0, 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1.0, 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5.0, 5).makeString());

        DoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        Assert.assertTrue(
                map1.makeString(),
                "0, 1".equals(map1.makeString())
                        || "1, 0".equals(map1.makeString()));

        DoubleIntMap map2 = this.newWithKeysValues(1.0, 1, 32.0, 32);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[1/32]".equals(map2.makeString("[", "/", "]"))
                        || "[32/1]".equals(map2.makeString("[", "/", "]")));

        DoubleIntMap map3 = this.newWithKeysValues(0.0, 0, 32.0, 32);
        Assert.assertTrue(
                map3.makeString("~"),
                "0~32".equals(map3.makeString("~"))
                        || "32~0".equals(map3.makeString("~")));

        DoubleIntMap map4 = this.newWithKeysValues(32.0, 32, 33.0, 33);
        Assert.assertTrue(
                map4.makeString("[", ", ", "]"),
                "[32, 33]".equals(map4.makeString("[", ", ", "]"))
                        || "[33, 32]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString()
    {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        this.getEmptyMap().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());

        this.getEmptyMap().appendString(appendable, "{", "/", "}");
        Assert.assertEquals("{}", appendable.toString());

        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0.0, 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());

        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0.0, 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());

        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0.0, 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0, 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0, 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        DoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "0, 1".equals(appendable3.toString())
                        || "1, 0".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        DoubleIntMap map2 = this.newWithKeysValues(1.0, 1, 32.0, 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[1/32]".equals(appendable4.toString())
                        || "[32/1]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        DoubleIntMap map3 = this.newWithKeysValues(1.0, 1, 32.0, 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[1/32]".equals(appendable5.toString())
                        || "[32/1]".equals(appendable5.toString()));

        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(
                appendable6.toString(),
                "0/1".equals(appendable6.toString())
                        || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        DoubleIntMap actual1 = map.select((double key, int value) -> Double.compare(key, 1.0) == 0 || value == 3);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 3.0, 3), actual1);
        DoubleIntMap actual2 = map.select((double key, int value) -> Double.compare(key, 0.0) == 0 || value == 2);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 2.0, 2), actual2);
    }

    @Test
    public void reject()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        DoubleIntMap actual1 = map.reject((double key, int value) -> Double.compare(key, 1.0) == 0 || value == 3);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 2.0, 2), actual1);
        DoubleIntMap actual2 = map.reject((double key, int value)-> Double.compare(key, 0.0) == 0 || value == 2);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 3.0, 3), actual2);
    }

    @Test
    public void select_value()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        IntIterable actual1 = map.select(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.select(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void reject_value()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        IntIterable actual1 = map.reject(IntPredicates.lessThan(2));
        Assert.assertEquals(IntBags.immutable.with(2, 3), actual1);
        IntIterable actual2 = map.reject(IntPredicates.greaterThan(1));
        Assert.assertEquals(IntBags.immutable.with(0, 1), actual2);
    }

    @Test
    public void collect()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);

        IntToObjectFunction<Integer> function = (parameter) -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1, 2, 3, 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2), this.newWithKeysValues(1.0, 1).collect(function));
    }

    @Test
    public void count()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(2, map.count(IntPredicates.greaterThan(1)));
        Assert.assertEquals(2, map.count(IntPredicates.lessThan(2)));
    }

    @Test
    public void detectIfNone_value()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        int resultNotFound = map.detectIfNone(IntPredicates.greaterThan(5), 5);
        Assert.assertEquals(5, resultNotFound);

        Assert.assertEquals(5, this.getEmptyMap().detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(5, this.newWithKeysValues(1.0, 1).detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, this.newWithKeysValues(1.0, 1).detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(0, map.detectIfNone(IntPredicates.equal(0), 5));
        Assert.assertEquals(1, map.detectIfNone(IntPredicates.equal(1), 5));
        Assert.assertEquals(2, map.detectIfNone(IntPredicates.equal(2), 5));
    }

    @Test
    public void anySatisfy()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, 1).anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, 1).anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(1)));
        Assert.assertTrue(map.anySatisfy(IntPredicates.equal(2)));
        Assert.assertFalse(map.anySatisfy(IntPredicates.greaterThan(5)));
    }

    @Test
    public void allSatisfy()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, 1).allSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, 1).allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.allSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.allSatisfy(IntPredicates.lessThan(5)));
        DoubleIntMap map1 = this.newWithKeysValues(2.0, 2, 3.0, 3);
        Assert.assertFalse(map1.allSatisfy(IntPredicates.equal(0)));
    }

    @Test
    public void noneSatisfy()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(IntPredicates.equal(0)));
        Assert.assertTrue(this.newWithKeysValues(1.0, 1).noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(this.newWithKeysValues(1.0, 1).noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(0)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(map.noneSatisfy(IntPredicates.equal(2)));
        Assert.assertTrue(map.noneSatisfy(IntPredicates.lessThan(0)));
    }

    @Test
    public void max()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(3, map.max());
        Assert.assertEquals(3, this.newWithKeysValues(3.0, 3).max());
    }

    @Test
    public void min()
    {
        DoubleIntMap map = this.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 0.0, 0);
        Assert.assertEquals(0, map.min());
        Assert.assertEquals(3, this.newWithKeysValues(3.0, 3).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws()
    {
        this.getEmptyMap().max();
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws()
    {
        this.getEmptyMap().min();
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty(0));
        DoubleIntMap map = this.newWithKeysValues(1.0, 1, 0.0, 0, 9.0, 9, 7.0, 7);
        Assert.assertEquals(0L, map.minIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(3.0, 3).maxIfEmpty(5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0));
        DoubleIntMap map = this.newWithKeysValues(1.0, 1, 0.0, 0, 9.0, 9, 7.0, 7);
        Assert.assertEquals(9L, map.maxIfEmpty(5));
        Assert.assertEquals(3, this.newWithKeysValues(3.0, 3).minIfEmpty(5));
    }

    @Test
    public void sum()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(6, map.sum());
        DoubleIntMap map2 = this.newWithKeysValues(2.0, 2, 3.0, 3, 4.0, 4);
        Assert.assertEquals(9, map2.sum());
        DoubleIntMap map3 = this.newWithKeysValues(2.0, 2);
        Assert.assertEquals(2, map3.sum());
    }

    @Test
    public void average()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        DoubleIntMap map1 = this.newWithKeysValues(1.0, 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        this.getEmptyMap().average();
    }

    @Test
    public void median()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        DoubleIntMap map2 = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        DoubleIntMap map3 = this.newWithKeysValues(1.0, 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        this.getEmptyMap().median();
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(IntArrayList.newListWith(0), this.newWithKeysValues(0.0, 0).toList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues(1.0, 1).toList());
        Assert.assertEquals(IntArrayList.newListWith(2), this.newWithKeysValues(2.0, 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2.0, 2, 3.0, 3).toList().equals(IntArrayList.newListWith(2, 3))
                || this.newWithKeysValues(2.0, 2, 3.0, 3).toList().equals(IntArrayList.newListWith(3, 2)));
    }

    @Test
    public void toSortedList()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(IntArrayList.newListWith(0, 1, 2, 3), map.toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(IntArrayList.newListWith(1), this.newWithKeysValues(1.0, 1).toSortedList());
    }

    @Test
    public void toSet()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(IntHashSet.newSetWith(0, 1, 2, 3), map.toSet());
        Assert.assertEquals(IntHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(IntHashSet.newSetWith(1), this.newWithKeysValues(1.0, 1).toSet());
    }

    @Test
    public void toBag()
    {
        DoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 2, 3), map.toBag());
        Assert.assertEquals(IntHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(1), this.newWithKeysValues(1.0, 1).toBag());
    }

    @Test
    public void intIterator()
    {
        MutableIntSet expected = IntHashSet.newSetWith(0, 31, 32);
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
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().intIterator().next());
    }

    @Test
    public void asLazy()
    {
        LazyIntIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0, 31, 32));
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 31.0, 32.0), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<DoubleIntPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((double key, int value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new int[]{0, 31, 32}, this.map.toSortedArray()));
    }

    @Test
    public void toArray()
    {
        DoubleIntMap map = this.newWithKeysValues(1.0, 1, 2.0, 2);
        int[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new int[]{1, 2}, array)
                || Arrays.equals(new int[]{2, 1}, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new int[]{1}, this.newWithKeysValues(1.0, 1).toArray()));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableDoubleIntMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk()
    {
        IntIterable iterable = this.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertEquals(
                Lists.mutable.with(
                        IntBags.mutable.with(1),
                        IntBags.mutable.with(2),
                        IntBags.mutable.with(3)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertTrue(
                Lists.mutable.with(
                        IntBags.mutable.with(1, 2),
                        IntBags.mutable.with(3)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        IntBags.mutable.with(2, 3),
                        IntBags.mutable.with(1)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        IntBags.mutable.with(1, 3),
                        IntBags.mutable.with(2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(
                Lists.mutable.with(
                        IntBags.mutable.with(1, 2, 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(IntBags.mutable.with(1)).toSet(),
                this.newWithKeysValues(1.0, 1).chunk(1).toSet());

        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1.0, 1).chunk(-1));
    }
}
