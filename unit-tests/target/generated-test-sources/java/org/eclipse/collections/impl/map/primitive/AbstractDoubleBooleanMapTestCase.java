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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.LazyBooleanIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.map.primitive.DoubleBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleBooleanMap;
import org.eclipse.collections.api.tuple.primitive.DoubleBooleanPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleBooleanHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractDoubleBooleanMapTestCase
{
    protected abstract DoubleBooleanMap classUnderTest();

    protected abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1);

    protected abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2);

    protected abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3);

    protected abstract DoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3, double key4, boolean value4);

    protected abstract DoubleBooleanMap getEmptyMap();

    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get(0.0));
        Assert.assertFalse(this.classUnderTest().get(31.0));
        Assert.assertTrue(this.classUnderTest().get(32.0));

        Assert.assertFalse(this.classUnderTest().get(1.0));
        Assert.assertFalse(this.classUnderTest().get(33.0));
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0.0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(31.0, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(32.0, false));
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertTrue(this.classUnderTest().getOrThrow(0.0));
        Assert.assertFalse(this.classUnderTest().getOrThrow(31.0));
        Assert.assertTrue(this.classUnderTest().getOrThrow(32.0));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(1.0));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(33.0));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.classUnderTest().containsKey(0.0));
        Assert.assertTrue(this.classUnderTest().containsKey(31.0));
        Assert.assertTrue(this.classUnderTest().containsKey(32.0));
        Assert.assertFalse(this.classUnderTest().containsKey(1.0));
        Assert.assertFalse(this.classUnderTest().containsKey(5.0));
        Assert.assertFalse(this.classUnderTest().containsKey(35.0));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertTrue(this.classUnderTest().containsValue(false));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertTrue(this.classUnderTest().contains(false));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(true, false));
        Assert.assertTrue(this.classUnderTest().containsAll(true, true));
        Assert.assertTrue(this.classUnderTest().containsAll(false, false));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0.0, false));
        Verify.assertSize(1, this.newWithKeysValues(1.0, true));

        Verify.assertSize(2, this.newWithKeysValues(1.0, true, 5.0, false));
        Verify.assertSize(2, this.newWithKeysValues(0.0, false, 5.0, false));
        Verify.assertSize(3, this.newWithKeysValues(1.0, true, 0.0, true, 5.0, true));
        Verify.assertSize(2, this.newWithKeysValues(6.0, false, 5.0, true));
    }

    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.getEmptyMap());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1.0, true).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0.0, false).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50.0, true).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1.0, false).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0.0, true).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50.0, false).notEmpty());
    }

    @Test
    public void testEquals()
    {
        DoubleBooleanMap map1 = this.newWithKeysValues(0.0, true, 1.0, false, 32.0, true);
        DoubleBooleanMap map2 = this.newWithKeysValues(32.0, true, 0.0, true, 1.0, false);
        DoubleBooleanMap map3 = this.newWithKeysValues(0.0, true, 1.0, true, 32.0, true);
        DoubleBooleanMap map4 = this.newWithKeysValues(0.0, false, 1.0, false, 32.0, true);
        DoubleBooleanMap map5 = this.newWithKeysValues(0.0, true, 1.0, false, 32.0, false);
        DoubleBooleanMap map6 = this.newWithKeysValues(50.0, true, 60.0, false, 70.0, false);
        DoubleBooleanMap map7 = this.newWithKeysValues(50.0, true, 60.0, false);
        DoubleBooleanMap map8 = this.newWithKeysValues(0.0, true, 1.0, false);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(0.0, true, 1.0, false, 32.0, true).hashCode(),
                this.newWithKeysValues(32.0, true, 0.0, true, 1.0, false).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(50.0, true, 60.0, false, 70.0, false).hashCode(),
                this.newWithKeysValues(50.0, true, 60.0, false, 70.0, false).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0.0=true}", this.newWithKeysValues(0.0, true).toString());
        Assert.assertEquals("{1.0=false}", this.newWithKeysValues(1.0, false).toString());
        Assert.assertEquals("{5.0=false}", this.newWithKeysValues(5.0, false).toString());

        DoubleBooleanMap map1 = this.newWithKeysValues(0.0, true, 1.0, false);
        Assert.assertTrue(
                map1.toString(),
                "{0.0=true, 1.0=false}".equals(map1.toString())
                        || "{1.0=false, 0.0=true}".equals(map1.toString()));

        DoubleBooleanMap map2 = this.newWithKeysValues(1.0, false, 32.0, true);
        Assert.assertTrue(
                map2.toString(),
                "{1.0=false, 32.0=true}".equals(map2.toString())
                        || "{32.0=true, 1.0=false}".equals(map2.toString()));

        DoubleBooleanMap map3 = this.newWithKeysValues(0.0, true, 32.0, true);
        Assert.assertTrue(
                map3.toString(),
                "{0.0=true, 32.0=true}".equals(map3.toString())
                        || "{32.0=true, 0.0=true}".equals(map3.toString()));

        DoubleBooleanMap map4 = this.newWithKeysValues(32.0, true, 33.0, false);
        Assert.assertTrue(
                map4.toString(),
                "{32.0=true, 33.0=false}".equals(map4.toString())
                        || "{33.0=false, 32.0=true}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        DoubleBooleanMap map0 = this.newWithKeysValues(0.0, false, 3.0, true);
        String[] sum0 = {""};
        map0.forEach((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));

        DoubleBooleanMap map1 = this.newWithKeysValues(1.0, true, 3.0, true);
        String[] sum1 = {""};
        map1.forEach((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);

        DoubleBooleanMap map01 = this.newWithKeysValues(0.0, false, 1.0, true);
        String[] sum01 = {""};
        map01.forEach((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));

        DoubleBooleanMap map = this.newWithKeysValues(3.0, false, 4.0, false);
        String[] sum = {""};
        map.forEach((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachValue()
    {
        DoubleBooleanMap map0 = this.newWithKeysValues(0.0, false, 3.0, true);
        String[] sum0 = {""};
        map0.forEachValue((boolean each) -> sum0[0] += each);
        Assert.assertTrue("truefalse".equals(sum0[0]) || "falsetrue".equals(sum0[0]));

        DoubleBooleanMap map1 = this.newWithKeysValues(1.0, true, 3.0, true);
        String[] sum1 = {""};
        map1.forEachValue((boolean each) -> sum1[0] += each);
        Assert.assertEquals("truetrue", sum1[0]);

        DoubleBooleanMap map01 = this.newWithKeysValues(0.0, false, 1.0, true);
        String[] sum01 = {""};
        map01.forEachValue((boolean each) -> sum01[0] += each);
        Assert.assertTrue("truefalse".equals(sum01[0]) || "falsetrue".equals(sum01[0]));

        DoubleBooleanMap map = this.newWithKeysValues(3.0, false, 4.0, false);
        String[] sum = {""};
        map.forEachValue((boolean each) -> sum[0] += each);
        Assert.assertEquals("falsefalse", sum[0]);
    }

    @Test
    public void forEachKey()
    {
        DoubleBooleanMap map0 = this.newWithKeysValues(0.0, true, 3.0, false);
        double[] sum0 = new double[1];
        map0.forEachKey((double each) -> sum0[0] += each);
        Assert.assertEquals(3.0, sum0[0], 0.0);

        DoubleBooleanMap map1 = this.newWithKeysValues(1.0, false, 3.0, false);
        double[] sum1 = new double[1];
        map1.forEachKey((double each) -> sum1[0] += each);
        Assert.assertEquals(4.0, sum1[0], 0.0);

        DoubleBooleanMap map01 = this.newWithKeysValues(0.0, true, 1.0, true);
        double[] sum01 = new double[1];
        map01.forEachKey((double each) -> sum01[0] += each);
        Assert.assertEquals(1.0, sum01[0], 0.0);

        DoubleBooleanMap map = this.newWithKeysValues(3.0, false, 4.0, true);
        double[] sum = new double[1];
        map.forEachKey((double each) -> sum[0] += each);
        Assert.assertEquals(7, sum[0], 0.0);
    }

    @Test
    public void forEachKeyValue()
    {
        DoubleBooleanMap map0 = this.newWithKeysValues(0.0, true, 3.0, true);
        double[] sumKey0 = new double[1];
        String[] sumValue0 = {""};
        map0.forEachKeyValue((double eachKey, boolean eachValue) ->
            {
                sumKey0[0] += eachKey;
                sumValue0[0] += eachValue;
            });
        Assert.assertEquals(3.0, sumKey0[0], 0.0);
        Assert.assertEquals("truetrue", sumValue0[0]);

        DoubleBooleanMap map1 = this.newWithKeysValues(1.0, true, 3.0, false);
        double[] sumKey1 = new double[1];
        String[] sumValue1 = {""};
        map1.forEachKeyValue((double eachKey, boolean eachValue) ->
            {
                sumKey1[0] += eachKey;
                sumValue1[0] += eachValue;
            });
        Assert.assertEquals(4.0, sumKey1[0], 0.0);
        Assert.assertTrue("truefalse".equals(sumValue1[0]) || "falsetrue".equals(sumValue1[0]));

        DoubleBooleanMap map01 = this.newWithKeysValues(0.0, false, 1.0, false);
        double[] sumKey01 = new double[1];
        String[] sumValue01 = {""};
        map01.forEachKeyValue((double eachKey, boolean eachValue) ->
            {
                sumKey01[0] += eachKey;
                sumValue01[0] += eachValue;
            });
        Assert.assertEquals(1.0, sumKey01[0], 0.0);
        Assert.assertEquals("falsefalse", sumValue01[0]);

        DoubleBooleanMap map = this.newWithKeysValues(3.0, false, 4.0, true);
        double[] sumKey = new double[1];
        String[] sumValue = {""};
        map.forEachKeyValue((double eachKey, boolean eachValue) ->
            {
                sumKey[0] += eachKey;
                sumValue[0] += eachValue;
            });
        Assert.assertEquals(7, sumKey[0], 0.0);
        Assert.assertTrue("truefalse".equals(sumValue[0]) || "falsetrue".equals(sumValue[0]));
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("true", this.newWithKeysValues(0.0, true).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(1.0, false).makeString());
        Assert.assertEquals("false", this.newWithKeysValues(5.0, false).makeString());

        DoubleBooleanMap map1 = this.newWithKeysValues(0.0, true, 1.0, false);
        Assert.assertTrue(
                map1.makeString(),
                "true, false".equals(map1.makeString())
                        || "false, true".equals(map1.makeString()));

        DoubleBooleanMap map2 = this.newWithKeysValues(1.0, false, 32.0, true);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[false/true]".equals(map2.makeString("[", "/", "]"))
                        || "true/false]".equals(map2.makeString("[", "/", "]")));

        DoubleBooleanMap map3 = this.newWithKeysValues(0.0, true, 32.0, true);
        Assert.assertTrue(
                map3.makeString("~"),
                "true~true".equals(map3.makeString("~"))
                        || "true~true".equals(map3.makeString("~")));

        DoubleBooleanMap map4 = this.newWithKeysValues(32.0, true, 33.0, false);
        Assert.assertTrue(
                map4.makeString("[", ", ", "]"),
                "[true, false]".equals(map4.makeString("[", ", ", "]"))
                        || "[false, true]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString()
    {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0.0, true).appendString(appendable0);
        Assert.assertEquals("true", appendable0.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1.0, false).appendString(appendable1);
        Assert.assertEquals("false", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5.0, false).appendString(appendable2);
        Assert.assertEquals("false", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        DoubleBooleanMap map1 = this.newWithKeysValues(0.0, true, 1.0, false);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "true, false".equals(appendable3.toString())
                        || "false, true".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        DoubleBooleanMap map2 = this.newWithKeysValues(1.0, false, 32.0, true);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[false/true]".equals(appendable4.toString())
                        || "[true/false]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        DoubleBooleanMap map3 = this.newWithKeysValues(1.0, false, 32.0, true);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[false/true]".equals(appendable5.toString())
                        || "[true/false]".equals(appendable5.toString()));

        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(
                appendable6.toString(),
                "true/false".equals(appendable6.toString())
                        || "false/true".equals(appendable6.toString()));
    }

    @Test
    public void select()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false, 3.0, true);
        DoubleBooleanMap actual1 = map.select((double key, boolean value)-> Double.compare(key, 1.0) == 0 || value);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 3.0, true, 0.0, true), actual1);
        DoubleBooleanMap actual2 = map.select((double key, boolean value) -> Double.compare(key, 0.0) == 0 || !value);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 2.0, false, 1.0, false), actual2);
    }

    @Test
    public void reject()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false, 3.0, true);
        DoubleBooleanMap actual1 = map.reject((double key, boolean value) -> Double.compare(key, 2.0) == 0 || !value);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 3.0, true), actual1);
        DoubleBooleanMap actual2 = map.reject((double key, boolean value) -> Double.compare(key, 3.0) == 0 || value);
        Assert.assertEquals(DoubleBooleanHashMap.newWithKeysValues(1.0, false, 2.0, false), actual2);
    }

    @Test
    public void select_value()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true, 3.0, false);
        BooleanIterable actual1 = map.select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual1);
        BooleanIterable actual2 = map.select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual2);
    }

    @Test
    public void reject_value()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true, 3.0, false);
        BooleanIterable actual1 = map.reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(false, false), actual1);
        BooleanIterable actual2 = map.reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true, true), actual2);
    }

    @Test
    public void collect()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true);

        RichIterable<Boolean> objects = map.collect((boolean booleanParameter) -> !booleanParameter);

        Assert.assertEquals(HashBag.newBagWith(false, true, false), objects.toBag());
    }

    @Test
    public void count()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true);
        Assert.assertEquals(2, map.count(BooleanPredicates.isTrue()));
        Assert.assertEquals(1, map.count(BooleanPredicates.isFalse()));
    }

    @Test
    public void detectIfNone_value()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, false);
        DoubleBooleanMap map2 = this.newWithKeysValues(0.0, true, 1.0, true, 2.0, false);
        boolean resultNotFound = map.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), true);
        Assert.assertTrue(resultNotFound);
        boolean resultNotFound2 = map.detectIfNone(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse()), false);
        Assert.assertFalse(resultNotFound2);

        Assert.assertTrue(map.detectIfNone(BooleanPredicates.isTrue(), false));
        Assert.assertFalse(map.detectIfNone(BooleanPredicates.isFalse(), true));
        Assert.assertFalse(map2.detectIfNone(BooleanPredicates.isFalse(), true));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.newWithKeysValues(1.0, false, 2.0, true).anySatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues(1.0, true, 2.0, false).allSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertFalse(this.newWithKeysValues(1.0, false, 2.0, true).noneSatisfy(BooleanPredicates.isFalse()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues(0.0, true).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(false), this.newWithKeysValues(1.0, false).toList());
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.newWithKeysValues(2.0, true).toList());
    }

    @Test
    public void toSet()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true, 3.0, false);
        Assert.assertEquals(BooleanHashSet.newSetWith(true, false), map.toSet());
    }

    @Test
    public void toBag()
    {
        DoubleBooleanMap map = this.newWithKeysValues(0.0, true, 1.0, false, 2.0, true, 3.0, false);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true, false), map.toBag());
    }

    @Test
    public void booleanIterator()
    {
        MutableBooleanBag expected = BooleanHashBag.newBagWith(true, false, true);
        MutableBooleanBag actual = BooleanHashBag.newBagWith();

        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().booleanIterator().next());
    }

    @Test
    public void asLazy()
    {
        DoubleBooleanMap map = this.newWithKeysValues(1.0, true, 2.0, true, 3.0, false);
        LazyBooleanIterable lazy = map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(true, true, false));
    }

    @Test
    public void keysView()
    {
        MutableDoubleList keys = this.newWithKeysValues(1.0, true, 2.0, false).keysView().toSortedList();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), keys);
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<DoubleBooleanPair> expected = Bags.mutable.of();
        this.classUnderTest().forEachKeyValue((double key, boolean value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.classUnderTest().keyValuesView().toBag());
    }

    @Test
    public void toArray()
    {
        DoubleBooleanMap map = this.newWithKeysValues(1.0, false, 2.0, true);
        boolean[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new boolean[]{false, true}, array)
                || Arrays.equals(new boolean[]{true, false}, array));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableDoubleBooleanMap.class, this.classUnderTest().toImmutable());
    }
}
