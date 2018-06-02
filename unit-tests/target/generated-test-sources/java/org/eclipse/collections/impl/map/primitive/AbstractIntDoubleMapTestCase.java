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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.IntDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.IntDoublePair;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.factory.primitive.IntDoubleMaps;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntDoubleHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractIntDoubleMapTestCase
{
    protected final IntDoubleMap map = this.classUnderTest();

    protected abstract IntDoubleMap classUnderTest();

    protected abstract IntDoubleMap newWithKeysValues(int key1, double value1);

    protected abstract IntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2);

    protected abstract IntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3);

    protected abstract IntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3, int key4, double value4);

    protected abstract IntDoubleMap getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(IntHashSet.newSetWith(0), this.newWithKeysValues(0, 0.0).keySet());
        Assert.assertEquals(IntHashSet.newSetWith(0, 31, 32),
                this.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        IntDoubleMap map = this.newWithKeysValues(0, 0.0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0));

        IntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0));
        Assert.assertTrue(map1.values().contains(31.0));
        Assert.assertTrue(map1.values().contains(32.0));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get(0), 0.0);
        Assert.assertEquals(31.0, this.map.get(31), 0.0);
        Assert.assertEquals(32.0, this.map.get(32), 0.0);

        Assert.assertEquals(0.0, this.map.get(1), 0.0);
        Assert.assertEquals(0.0, this.map.get(33), 0.0);
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32, 5.0), 0.0);
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow(0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertTrue(this.map.containsKey(31));
        Assert.assertTrue(this.map.containsKey(32));
        Assert.assertFalse(this.map.containsKey(1));
        Assert.assertFalse(this.map.containsKey(5));
        Assert.assertFalse(this.map.containsKey(35));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertTrue(this.map.containsValue(31.0));
        Assert.assertTrue(this.map.containsValue(32.0));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertTrue(this.map.contains(31.0));
        Assert.assertTrue(this.map.contains(32.0));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll(0.0, 31.0, 32.0));
        Assert.assertFalse(this.map.containsAll(0.0, 31.0, 35.0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 32.0)));
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 35.0)));
        Assert.assertTrue(this.map.containsAll(new DoubleArrayList()));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1, 1.0).size());

        Assert.assertEquals(2, this.newWithKeysValues(1, 1.0, 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(0, 0.0, 5, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues(1, 1.0, 0, 0.0, 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(6, 6.0, 5, 5.0).size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1, 1.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0, 0.0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50, 50.0).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1, 1.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0, 0.0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50, 50.0).notEmpty());
    }

    @Test
    public void testEquals()
    {
        IntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0, 32, 32.0);
        IntDoubleMap map2 = this.newWithKeysValues(32, 32.0, 0, 0.0, 1, 1.0);
        IntDoubleMap map3 = this.newWithKeysValues(0, 0.0, 1, 2.0, 32, 32.0);
        IntDoubleMap map4 = this.newWithKeysValues(0, 1.0, 1, 1.0, 32, 32.0);
        IntDoubleMap map5 = this.newWithKeysValues(0, 0.0, 1, 1.0, 32, 33.0);
        IntDoubleMap map6 = this.newWithKeysValues(50, 0.0, 60, 1.0, 70, 33.0);
        IntDoubleMap map7 = this.newWithKeysValues(50, 0.0, 60, 1.0);
        IntDoubleMap map8 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        IntDoubleMap map9 = this.newWithKeysValues(0, 0.0);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(DoubleArrayList.newListWith(0.0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);

        Assert.assertEquals(map1, IntDoubleMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, IntDoubleMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(0, 0.0, 1, 1.0, 32, 32.0).hashCode(),
                this.newWithKeysValues(32, 32.0, 0, 0.0, 1, 1.0).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(50, 0.0, 60, 1.0, 70, 33.0).hashCode(),
                this.newWithKeysValues(50, 0.0, 60, 1.0, 70, 33.0).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 2.0).hashCode(), this.newWithKeysValues(1, 2.0).hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0.0}", this.newWithKeysValues(0, 0.0).toString());
        Assert.assertEquals("{1=1.0}", this.newWithKeysValues(1, 1.0).toString());
        Assert.assertEquals("{5=5.0}", this.newWithKeysValues(5, 5.0).toString());

        IntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertTrue(
                map1.toString(),
                "{0=0.0, 1=1.0}".equals(map1.toString())
                        || "{1=1.0, 0=0.0}".equals(map1.toString()));

        IntDoubleMap map2 = this.newWithKeysValues(1, 1.0, 32, 32.0);
        Assert.assertTrue(
                map2.toString(),
                "{1=1.0, 32=32.0}".equals(map2.toString())
                        || "{32=32.0, 1=1.0}".equals(map2.toString()));

        IntDoubleMap map3 = this.newWithKeysValues(0, 0.0, 32, 32.0);
        Assert.assertTrue(
                map3.toString(),
                "{0=0.0, 32=32.0}".equals(map3.toString())
                        || "{32=32.0, 0=0.0}".equals(map3.toString()));

        IntDoubleMap map4 = this.newWithKeysValues(32, 32.0, 33, 33.0);
        Assert.assertTrue(
                map4.toString(),
                "{32=32.0, 33=33.0}".equals(map4.toString())
                        || "{33=33.0, 32=32.0}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        IntDoubleMap map0 = this.newWithKeysValues(0, 1.0, 3, 4.0);
        double[] sum0 = new double[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);

        IntDoubleMap map1 = this.newWithKeysValues(1, 2.0, 3, 4.0);
        double[] sum1 = new double[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);

        IntDoubleMap map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        double[] sum01 = new double[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);

        IntDoubleMap map = this.newWithKeysValues(3, 4.0, 4, 5.0);
        double[] sum = new double[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);

        IntDoubleMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);

        IntDoubleMap map3 = this.newWithKeysValues(1, 2.0);
        double[] sum3 = new double[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachValue()
    {
        IntDoubleMap map0 = this.newWithKeysValues(0, 1.0, 3, 4.0);
        double[] sum0 = new double[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);

        IntDoubleMap map1 = this.newWithKeysValues(1, 2.0, 3, 4.0);
        double[] sum1 = new double[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);

        IntDoubleMap map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        double[] sum01 = new double[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);

        IntDoubleMap map = this.newWithKeysValues(3, 4.0, 4, 5.0);
        double[] sum = new double[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);

        IntDoubleMap map2 = this.getEmptyMap();
        double[] sum2 = new double[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);

        IntDoubleMap map3 = this.newWithKeysValues(1, 2.0);
        double[] sum3 = new double[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKey()
    {
        IntDoubleMap map0 = this.newWithKeysValues(0, 1.0, 3, 4.0);
        int[] sum0 = new int[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);

        IntDoubleMap map1 = this.newWithKeysValues(1, 2.0, 3, 4.0);
        int[] sum1 = new int[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);

        IntDoubleMap map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        int[] sum01 = new int[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);

        IntDoubleMap map = this.newWithKeysValues(3, 4.0, 4, 5.0);
        int[] sum = new int[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);

        IntDoubleMap map2 = this.getEmptyMap();
        int[] sum2 = new int[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        IntDoubleMap map3 = this.newWithKeysValues(1, 1.0);
        int[] sum3 = new int[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue()
    {
        IntDoubleMap map0 = this.newWithKeysValues(0, 1.0, 3, 4.0);
        int[] sumKey0 = new int[1];
        double[] sumValue0 = new double[1];
        map0.forEachKeyValue((int eachKey, double eachValue) ->
        {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5.0, sumValue0[0], 0.0);

        IntDoubleMap map1 = this.newWithKeysValues(1, 2.0, 3, 4.0);
        int[] sumKey1 = new int[1];
        double[] sumValue1 = new double[1];
        map1.forEachKeyValue((int eachKey, double eachValue) ->
        {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6.0, sumValue1[0], 0.0);

        IntDoubleMap map01 = this.newWithKeysValues(0, 1.0, 1, 2.0);
        int[] sumKey01 = new int[1];
        double[] sumValue01 = new double[1];
        map01.forEachKeyValue((int eachKey, double eachValue) ->
        {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);

        IntDoubleMap map = this.newWithKeysValues(3, 4.0, 4, 5.0);
        int[] sumKey = new int[1];
        double[] sumValue = new double[1];
        map.forEachKeyValue((int eachKey, double eachValue) ->
        {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9.0, sumValue[0], 0.0);

        IntDoubleMap map2 = this.getEmptyMap();
        int[] sumKey2 = new int[1];
        double[] sumValue2 = new double[1];
        map2.forEachKeyValue((int eachKey, double eachValue) ->
        {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0.0, sumValue2[0], 0.0);

        IntDoubleMap map3 = this.newWithKeysValues(3, 5.0);
        int[] sumKey3 = new int[1];
        double[] sumValue3 = new double[1];
        map3.forEachKeyValue((int eachKey, double eachValue) ->
        {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5.0, sumValue3[0], 0.0);
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0.0", this.newWithKeysValues(0, 0.0).makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues(0, 0.0).makeString(", "));
        Assert.assertEquals("[0.0]", this.newWithKeysValues(0, 0.0).makeString("[", "/", "]"));
        Assert.assertEquals("1.0", this.newWithKeysValues(1, 1.0).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues(5, 5.0).makeString());

        IntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertTrue(
                map1.makeString(),
                "0.0, 1.0".equals(map1.makeString())
                        || "1.0, 0.0".equals(map1.makeString()));

        IntDoubleMap map2 = this.newWithKeysValues(1, 1.0, 32, 32.0);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[1.0/32.0]".equals(map2.makeString("[", "/", "]"))
                        || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));

        IntDoubleMap map3 = this.newWithKeysValues(0, 0.0, 32, 32.0);
        Assert.assertTrue(
                map3.makeString("~"),
                "0.0~32.0".equals(map3.makeString("~"))
                        || "32.0~0.0".equals(map3.makeString("~")));

        IntDoubleMap map4 = this.newWithKeysValues(32, 32.0, 33, 33.0);
        Assert.assertTrue(
                map4.makeString("[", ", ", "]"),
                "[32.0, 33.0]".equals(map4.makeString("[", ", ", "]"))
                        || "[33.0, 32.0]".equals(map4.makeString("[", ", ", "]")));
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
        this.newWithKeysValues(0, 0.0).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());

        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0, 0.0).appendString(appendable01, "/");
        Assert.assertEquals("0.0", appendable01.toString());

        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0, 0.0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0.0}", appendable02.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1, 1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5, 5.0).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        IntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "0.0, 1.0".equals(appendable3.toString())
                        || "1.0, 0.0".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        IntDoubleMap map2 = this.newWithKeysValues(1, 1.0, 32, 32.0);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[1.0/32.0]".equals(appendable4.toString())
                        || "[32.0/1.0]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        IntDoubleMap map3 = this.newWithKeysValues(1, 1.0, 32, 32.0);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[1.0/32.0]".equals(appendable5.toString())
                        || "[32.0/1.0]".equals(appendable5.toString()));

        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(
                appendable6.toString(),
                "0.0/1.0".equals(appendable6.toString())
                        || "1.0/0.0".equals(appendable6.toString()));
    }

    @Test
    public void select()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        IntDoubleMap actual1 = map.select((int key, double value) -> key == 1 || Double.compare(value, 3.0) == 0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 3, 3.0), actual1);
        IntDoubleMap actual2 = map.select((int key, double value) -> key == 0 || Double.compare(value, 2.0) == 0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 2, 2.0), actual2);
    }

    @Test
    public void reject()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        IntDoubleMap actual1 = map.reject((int key, double value) -> key == 1 || Double.compare(value, 3.0) == 0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 2, 2.0), actual1);
        IntDoubleMap actual2 = map.reject((int key, double value)-> key == 0 || Double.compare(value, 2.0) == 0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 3, 3.0), actual2);
    }

    @Test
    public void select_value()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        DoubleIterable actual1 = map.select(DoublePredicates.greaterThan(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(2.0, 3.0), actual1);
        DoubleIterable actual2 = map.select(DoublePredicates.lessThan(2.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0, 1.0), actual2);
    }

    @Test
    public void reject_value()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        DoubleIterable actual1 = map.reject(DoublePredicates.lessThan(2.0));
        Assert.assertEquals(DoubleBags.immutable.with(2.0, 3.0), actual1);
        DoubleIterable actual2 = map.reject(DoublePredicates.greaterThan(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0, 1.0), actual2);
    }

    @Test
    public void collect()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);

        DoubleToObjectFunction<Double> function = (parameter) -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1.0, 2.0, 3.0, 4.0), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2.0), this.newWithKeysValues(1, 1.0).collect(function));
    }

    @Test
    public void count()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(2, map.count(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(2, map.count(DoublePredicates.lessThan(2.0)));
    }

    @Test
    public void detectIfNone_value()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        double resultNotFound = map.detectIfNone(DoublePredicates.greaterThan(5.0), 5.0);
        Assert.assertEquals(5.0, resultNotFound, 0.0);

        Assert.assertEquals(5.0, this.getEmptyMap().detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(5.0, this.newWithKeysValues(1, 1.0).detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(1.0, this.newWithKeysValues(1, 1.0).detectIfNone(DoublePredicates.equal(1.0), 5.0), 0.0);
        Assert.assertEquals(0.0, map.detectIfNone(DoublePredicates.equal(0.0), 5.0), 0.0);
        Assert.assertEquals(1.0, map.detectIfNone(DoublePredicates.equal(1.0), 5.0), 0.0);
        Assert.assertEquals(2.0, map.detectIfNone(DoublePredicates.equal(2.0), 5.0), 0.0);
    }

    @Test
    public void anySatisfy()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues(1, 1.0).anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues(1, 1.0).anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertTrue(map.anySatisfy(DoublePredicates.equal(2.0)));
        Assert.assertFalse(map.anySatisfy(DoublePredicates.greaterThan(5.0)));
    }

    @Test
    public void allSatisfy()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues(1, 1.0).allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues(1, 1.0).allSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.allSatisfy(DoublePredicates.equal(2.0)));
        Assert.assertTrue(map.allSatisfy(DoublePredicates.lessThan(5.0)));
        IntDoubleMap map1 = this.newWithKeysValues(2, 2.0, 3, 3.0);
        Assert.assertFalse(map1.allSatisfy(DoublePredicates.equal(0.0)));
    }

    @Test
    public void noneSatisfy()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWithKeysValues(1, 1.0).noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.newWithKeysValues(1, 1.0).noneSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(map.noneSatisfy(DoublePredicates.equal(2.0)));
        Assert.assertTrue(map.noneSatisfy(DoublePredicates.lessThan(0.0)));
    }

    @Test
    public void max()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(3.0, map.max(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3, 3.0).max(), 0.0);
    }

    @Test
    public void min()
    {
        IntDoubleMap map = this.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0, 0, 0.0);
        Assert.assertEquals(0.0, map.min(), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3, 3.0).min(), 0.0);
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
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().minIfEmpty(0.0), 0.0);
        IntDoubleMap map = this.newWithKeysValues(1, 1.0, 0, 0.0, 9, 9.0, 7, 7.0);
        Assert.assertEquals(0.0, map.minIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3, 3.0).maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5.0, this.getEmptyMap().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().maxIfEmpty(0.0), 0.0);
        IntDoubleMap map = this.newWithKeysValues(1, 1.0, 0, 0.0, 9, 9.0, 7, 7.0);
        Assert.assertEquals(9.0, map.maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(3.0, this.newWithKeysValues(3, 3.0).minIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(6.0, map.sum(), 0.0);
        IntDoubleMap map2 = this.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);
        Assert.assertEquals(9.0, map2.sum(), 0.0);
        IntDoubleMap map3 = this.newWithKeysValues(2, 2.0);
        Assert.assertEquals(2.0, map3.sum(), 0.0);
    }

    @Test
    public void average()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(1.5, map.average(), 0.0);
        IntDoubleMap map1 = this.newWithKeysValues(1, 1.0);
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
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(1.5, map.median(), 0.0);
        IntDoubleMap map2 = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        IntDoubleMap map3 = this.newWithKeysValues(1, 1.0);
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
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.newWithKeysValues(0, 0.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWithKeysValues(1, 1.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(2.0), this.newWithKeysValues(2, 2.0).toList());
        Assert.assertTrue(this.newWithKeysValues(2, 2.0, 3, 3.0).toList().equals(DoubleArrayList.newListWith(2.0, 3.0))
                || this.newWithKeysValues(2, 2.0, 3, 3.0).toList().equals(DoubleArrayList.newListWith(3.0, 2.0)));
    }

    @Test
    public void toSortedList()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0), map.toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWithKeysValues(1, 1.0).toSortedList());
    }

    @Test
    public void toSet()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 3.0), map.toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), this.newWithKeysValues(1, 1.0).toSet());
    }

    @Test
    public void toBag()
    {
        IntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 2.0, 3.0), map.toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.newWithKeysValues(1, 1.0).toBag());
    }

    @Test
    public void doubleIterator()
    {
        MutableDoubleSet expected = DoubleHashSet.newSetWith(0.0, 31.0, 32.0);
        MutableDoubleSet actual = DoubleHashSet.newSetWith();

        DoubleIterator iterator = this.map.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().doubleIterator().next());
    }

    @Test
    public void asLazy()
    {
        LazyDoubleIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0.0, 31.0, 32.0));
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(IntArrayList.newListWith(0, 31, 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<IntDoublePair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((int key, double value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new double[]{0.0, 31.0, 32.0}, this.map.toSortedArray()));
    }

    @Test
    public void toArray()
    {
        IntDoubleMap map = this.newWithKeysValues(1, 1.0, 2, 2.0);
        double[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new double[]{1.0, 2.0}, array)
                || Arrays.equals(new double[]{2.0, 1.0}, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new double[]{1.0}, this.newWithKeysValues(1, 1.0).toArray()));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableIntDoubleMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk()
    {
        DoubleIterable iterable = this.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0);
        Assert.assertEquals(
                Lists.mutable.with(
                        DoubleBags.mutable.with(1.0),
                        DoubleBags.mutable.with(2.0),
                        DoubleBags.mutable.with(3.0)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertTrue(
                Lists.mutable.with(
                        DoubleBags.mutable.with(1.0, 2.0),
                        DoubleBags.mutable.with(3.0)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        DoubleBags.mutable.with(2.0, 3.0),
                        DoubleBags.mutable.with(1.0)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        DoubleBags.mutable.with(1.0, 3.0),
                        DoubleBags.mutable.with(2.0)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(
                Lists.mutable.with(
                        DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(DoubleBags.mutable.with(1.0, 2.0, 3.0)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(DoubleBags.mutable.with(1.0)).toSet(),
                this.newWithKeysValues(1, 1.0).chunk(1).toSet());

        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1, 1.0).chunk(-1));
    }
}
