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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.LongCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.tuple.primitive.LongCharPair;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.LongCharMaps;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongCharHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractLongCharMapTestCase
{
    protected final LongCharMap map = this.classUnderTest();

    protected abstract LongCharMap classUnderTest();

    protected abstract LongCharMap newWithKeysValues(long key1, char value1);

    protected abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2);

    protected abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3);

    protected abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4);

    protected abstract LongCharMap getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L), this.newWithKeysValues(0L, (char) 0).keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L, 31L, 32L),
                this.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        LongCharMap map = this.newWithKeysValues(0L, (char) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((char) 0));

        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((char) 0));
        Assert.assertTrue(map1.values().contains((char) 31));
        Assert.assertTrue(map1.values().contains((char) 32));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0L));
        Assert.assertEquals(31L, this.map.get(31L));
        Assert.assertEquals(32L, this.map.get(32L));

        Assert.assertEquals(0L, this.map.get(1L));
        Assert.assertEquals(0L, this.map.get(33L));
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, (char) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, (char) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, (char) 5));
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0L));
        Assert.assertEquals(31L, this.map.getOrThrow(31L));
        Assert.assertEquals(32L, this.map.getOrThrow(32L));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1L));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33L));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0L));
        Assert.assertTrue(this.map.containsKey(31L));
        Assert.assertTrue(this.map.containsKey(32L));
        Assert.assertFalse(this.map.containsKey(1L));
        Assert.assertFalse(this.map.containsKey(5L));
        Assert.assertFalse(this.map.containsKey(35L));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertTrue(this.map.containsValue((char) 31));
        Assert.assertTrue(this.map.containsValue((char) 32));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertTrue(this.map.contains((char) 31));
        Assert.assertTrue(this.map.contains((char) 32));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll((char) 0, (char) 31, (char) 32));
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 32)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 35)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0L, (char) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, (char) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1L, (char) 1, 5L, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, (char) 0, 5L, (char) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, (char) 1, 0L, (char) 0, 5L, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, (char) 6, 5L, (char) 5).size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0L, (char) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50L, (char) 50).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0L, (char) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50L, (char) 50).notEmpty());
    }

    @Test
    public void testEquals()
    {
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 32);
        LongCharMap map2 = this.newWithKeysValues(32L, (char) 32, 0L, (char) 0, 1L, (char) 1);
        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 2, 32L, (char) 32);
        LongCharMap map4 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 1, 32L, (char) 32);
        LongCharMap map5 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 33);
        LongCharMap map6 = this.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33);
        LongCharMap map7 = this.newWithKeysValues(50L, (char) 0, 60L, (char) 1);
        LongCharMap map8 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        LongCharMap map9 = this.newWithKeysValues(0L, (char) 0);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(CharArrayList.newListWith((char) 0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);

        Assert.assertEquals(map1, LongCharMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, LongCharMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 32L, (char) 32).hashCode(),
                this.newWithKeysValues(32L, (char) 32, 0L, (char) 0, 1L, (char) 1).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33).hashCode(),
                this.newWithKeysValues(50L, (char) 0, 60L, (char) 1, 70L, (char) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1L, (char) 2).hashCode(), this.newWithKeysValues(1L, (char) 2).hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=\u0000}", this.newWithKeysValues(0L, (char) 0).toString());
        Assert.assertEquals("{1=\u0001}", this.newWithKeysValues(1L, (char) 1).toString());
        Assert.assertEquals("{5=\u0005}", this.newWithKeysValues(5L, (char) 5).toString());

        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertTrue(
                map1.toString(),
                "{0=\u0000, 1=\u0001}".equals(map1.toString())
                        || "{1=\u0001, 0=\u0000}".equals(map1.toString()));

        LongCharMap map2 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        Assert.assertTrue(
                map2.toString(),
                "{1=\u0001, 32=\u0020}".equals(map2.toString())
                        || "{32=\u0020, 1=\u0001}".equals(map2.toString()));

        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 32L, (char) 32);
        Assert.assertTrue(
                map3.toString(),
                "{0=\u0000, 32=\u0020}".equals(map3.toString())
                        || "{32=\u0020, 0=\u0000}".equals(map3.toString()));

        LongCharMap map4 = this.newWithKeysValues(32L, (char) 32, 33L, (char) 33);
        Assert.assertTrue(
                map4.toString(),
                "{32=\u0020, 33=\u0021}".equals(map4.toString())
                        || "{33=\u0021, 32=\u0020}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        char[] sum0 = new char[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        char[] sum1 = new char[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        char[] sum01 = new char[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        char[] sum = new char[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        LongCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        LongCharMap map3 = this.newWithKeysValues(1L, (char) 2);
        char[] sum3 = new char[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue()
    {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        char[] sum0 = new char[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        char[] sum1 = new char[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        char[] sum01 = new char[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        char[] sum = new char[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        LongCharMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        LongCharMap map3 = this.newWithKeysValues(1L, (char) 2);
        char[] sum3 = new char[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey()
    {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        long[] sum0 = new long[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);

        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        long[] sum1 = new long[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);

        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        long[] sum01 = new long[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);

        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        long[] sum = new long[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);

        LongCharMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        LongCharMap map3 = this.newWithKeysValues(1L, (char) 1);
        long[] sum3 = new long[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue()
    {
        LongCharMap map0 = this.newWithKeysValues(0L, (char) 1, 3L, (char) 4);
        long[] sumKey0 = new long[1];
        char[] sumValue0 = new char[1];
        map0.forEachKeyValue((long eachKey, char eachValue) ->
        {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);

        LongCharMap map1 = this.newWithKeysValues(1L, (char) 2, 3L, (char) 4);
        long[] sumKey1 = new long[1];
        char[] sumValue1 = new char[1];
        map1.forEachKeyValue((long eachKey, char eachValue) ->
        {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);

        LongCharMap map01 = this.newWithKeysValues(0L, (char) 1, 1L, (char) 2);
        long[] sumKey01 = new long[1];
        char[] sumValue01 = new char[1];
        map01.forEachKeyValue((long eachKey, char eachValue) ->
        {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);

        LongCharMap map = this.newWithKeysValues(3L, (char) 4, 4L, (char) 5);
        long[] sumKey = new long[1];
        char[] sumValue = new char[1];
        map.forEachKeyValue((long eachKey, char eachValue) ->
        {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);

        LongCharMap map2 = this.getEmptyMap();
        long[] sumKey2 = new long[1];
        char[] sumValue2 = new char[1];
        map2.forEachKeyValue((long eachKey, char eachValue) ->
        {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);

        LongCharMap map3 = this.newWithKeysValues(3L, (char) 5);
        long[] sumKey3 = new long[1];
        char[] sumValue3 = new char[1];
        map3.forEachKeyValue((long eachKey, char eachValue) ->
        {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("\u0000", this.newWithKeysValues(0L, (char) 0).makeString());
        Assert.assertEquals("\u0000", this.newWithKeysValues(0L, (char) 0).makeString(", "));
        Assert.assertEquals("[\u0000]", this.newWithKeysValues(0L, (char) 0).makeString("[", "/", "]"));
        Assert.assertEquals("\u0001", this.newWithKeysValues(1L, (char) 1).makeString());
        Assert.assertEquals("\u0005", this.newWithKeysValues(5L, (char) 5).makeString());

        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertTrue(
                map1.makeString(),
                "\u0000, \u0001".equals(map1.makeString())
                        || "\u0001, \u0000".equals(map1.makeString()));

        LongCharMap map2 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[\u0001/\u0020]".equals(map2.makeString("[", "/", "]"))
                        || "[\u0020/\u0001]".equals(map2.makeString("[", "/", "]")));

        LongCharMap map3 = this.newWithKeysValues(0L, (char) 0, 32L, (char) 32);
        Assert.assertTrue(
                map3.makeString("~"),
                "\u0000~\u0020".equals(map3.makeString("~"))
                        || "\u0020~\u0000".equals(map3.makeString("~")));

        LongCharMap map4 = this.newWithKeysValues(32L, (char) 32, 33L, (char) 33);
        Assert.assertTrue(
                map4.makeString("[", ", ", "]"),
                "[\u0020, \u0021]".equals(map4.makeString("[", ", ", "]"))
                        || "[\u0021, \u0020]".equals(map4.makeString("[", ", ", "]")));
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
        this.newWithKeysValues(0L, (char) 0).appendString(appendable0);
        Assert.assertEquals("\u0000", appendable0.toString());

        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0L, (char) 0).appendString(appendable01, "/");
        Assert.assertEquals("\u0000", appendable01.toString());

        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0L, (char) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{\u0000}", appendable02.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1L, (char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5L, (char) 5).appendString(appendable2);
        Assert.assertEquals("\u0005", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        LongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "\u0000, \u0001".equals(appendable3.toString())
                        || "\u0001, \u0000".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        LongCharMap map2 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[\u0001/\u0020]".equals(appendable4.toString())
                        || "[\u0020/\u0001]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 1, 32L, (char) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[\u0001/\u0020]".equals(appendable5.toString())
                        || "[\u0020/\u0001]".equals(appendable5.toString()));

        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(
                appendable6.toString(),
                "\u0000/\u0001".equals(appendable6.toString())
                        || "\u0001/\u0000".equals(appendable6.toString()));
    }

    @Test
    public void select()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        LongCharMap actual1 = map.select((long key, char value) -> key == 1L || value == (char) 3);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 3L, (char) 3), actual1);
        LongCharMap actual2 = map.select((long key, char value) -> key == 0L || value == (char) 2);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 2L, (char) 2), actual2);
    }

    @Test
    public void reject()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        LongCharMap actual1 = map.reject((long key, char value) -> key == 1L || value == (char) 3);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 2L, (char) 2), actual1);
        LongCharMap actual2 = map.reject((long key, char value)-> key == 0L || value == (char) 2);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 3L, (char) 3), actual2);
    }

    @Test
    public void select_value()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        CharIterable actual1 = map.select(CharPredicates.greaterThan((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 2, (char) 3), actual1);
        CharIterable actual2 = map.select(CharPredicates.lessThan((char) 2));
        Assert.assertEquals(CharBags.immutable.with((char) 0, (char) 1), actual2);
    }

    @Test
    public void reject_value()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        CharIterable actual1 = map.reject(CharPredicates.lessThan((char) 2));
        Assert.assertEquals(CharBags.immutable.with((char) 2, (char) 3), actual1);
        CharIterable actual2 = map.reject(CharPredicates.greaterThan((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 0, (char) 1), actual2);
    }

    @Test
    public void collect()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);

        CharToObjectFunction<Character> function = (parameter) -> (char) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((char) 1, (char) 2, (char) 3, (char) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((char) 2), this.newWithKeysValues(1L, (char) 1).collect(function));
    }

    @Test
    public void count()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(2, map.count(CharPredicates.greaterThan((char) 1)));
        Assert.assertEquals(2, map.count(CharPredicates.lessThan((char) 2)));
    }

    @Test
    public void detectIfNone_value()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        char resultNotFound = map.detectIfNone(CharPredicates.greaterThan((char) 5), (char) 5);
        Assert.assertEquals((char) 5, resultNotFound);

        Assert.assertEquals((char) 5, this.getEmptyMap().detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 5, this.newWithKeysValues(1L, (char) 1).detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 1, this.newWithKeysValues(1L, (char) 1).detectIfNone(CharPredicates.equal((char) 1), (char) 5));
        Assert.assertEquals((char) 0, map.detectIfNone(CharPredicates.equal((char) 0), (char) 5));
        Assert.assertEquals((char) 1, map.detectIfNone(CharPredicates.equal((char) 1), (char) 5));
        Assert.assertEquals((char) 2, map.detectIfNone(CharPredicates.equal((char) 2), (char) 5));
    }

    @Test
    public void anySatisfy()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertTrue(map.anySatisfy(CharPredicates.equal((char) 2)));
        Assert.assertFalse(map.anySatisfy(CharPredicates.greaterThan((char) 5)));
    }

    @Test
    public void allSatisfy()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).allSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.allSatisfy(CharPredicates.equal((char) 2)));
        Assert.assertTrue(map.allSatisfy(CharPredicates.lessThan((char) 5)));
        LongCharMap map1 = this.newWithKeysValues(2L, (char) 2, 3L, (char) 3);
        Assert.assertFalse(map1.allSatisfy(CharPredicates.equal((char) 0)));
    }

    @Test
    public void noneSatisfy()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (char) 1).noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (char) 1).noneSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(map.noneSatisfy(CharPredicates.equal((char) 2)));
        Assert.assertTrue(map.noneSatisfy(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void max()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals((char) 3, map.max());
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).max());
    }

    @Test
    public void min()
    {
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 0L, (char) 0);
        Assert.assertEquals((char) 0, map.min());
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty((char) 5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty((char) 0));
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 0L, (char) 0, 9L, (char) 9, 7L, (char) 7);
        Assert.assertEquals(0L, map.minIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).maxIfEmpty((char) 5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((char) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((char) 0));
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 0L, (char) 0, 9L, (char) 9, 7L, (char) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.newWithKeysValues(3L, (char) 3).minIfEmpty((char) 5));
    }

    @Test
    public void sum()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals((char) 6, map.sum());
        LongCharMap map2 = this.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Assert.assertEquals((char) 9, map2.sum());
        LongCharMap map3 = this.newWithKeysValues(2L, (char) 2);
        Assert.assertEquals((char) 2, map3.sum());
    }

    @Test
    public void average()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        LongCharMap map1 = this.newWithKeysValues(1L, (char) 1);
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
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        LongCharMap map2 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        LongCharMap map3 = this.newWithKeysValues(1L, (char) 1);
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
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.newWithKeysValues(0L, (char) 0).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues(1L, (char) 1).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 2), this.newWithKeysValues(2L, (char) 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2L, (char) 2, 3L, (char) 3).toList().equals(CharArrayList.newListWith((char) 2, (char) 3))
                || this.newWithKeysValues(2L, (char) 2, 3L, (char) 3).toList().equals(CharArrayList.newListWith((char) 3, (char) 2)));
    }

    @Test
    public void toSortedList()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3), map.toSortedList());
        Assert.assertEquals(CharArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues(1L, (char) 1).toSortedList());
    }

    @Test
    public void toSet()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 2, (char) 3), map.toSet());
        Assert.assertEquals(CharHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), this.newWithKeysValues(1L, (char) 1).toSet());
    }

    @Test
    public void toBag()
    {
        LongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 2, (char) 3), map.toBag());
        Assert.assertEquals(CharHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.newWithKeysValues(1L, (char) 1).toBag());
    }

    @Test
    public void charIterator()
    {
        MutableCharSet expected = CharHashSet.newSetWith((char) 0, (char) 31, (char) 32);
        MutableCharSet actual = CharHashSet.newSetWith();

        CharIterator iterator = this.map.charIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().charIterator().next());
    }

    @Test
    public void asLazy()
    {
        LazyCharIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll((char) 0, (char) 31, (char) 32));
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(LongArrayList.newListWith(0L, 31L, 32L), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<LongCharPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((long key, char value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new char[]{(char) 0, (char) 31, (char) 32}, this.map.toSortedArray()));
    }

    @Test
    public void toArray()
    {
        LongCharMap map = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2);
        char[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new char[]{(char) 1, (char) 2}, array)
                || Arrays.equals(new char[]{(char) 2, (char) 1}, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new char[]{(char) 1}, this.newWithKeysValues(1L, (char) 1).toArray()));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableLongCharMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk()
    {
        CharIterable iterable = this.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        Assert.assertEquals(
                Lists.mutable.with(
                        CharBags.mutable.with((char) 1),
                        CharBags.mutable.with((char) 2),
                        CharBags.mutable.with((char) 3)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertTrue(
                Lists.mutable.with(
                        CharBags.mutable.with((char) 1, (char) 2),
                        CharBags.mutable.with((char) 3)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        CharBags.mutable.with((char) 2, (char) 3),
                        CharBags.mutable.with((char) 1)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        CharBags.mutable.with((char) 1, (char) 3),
                        CharBags.mutable.with((char) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(
                Lists.mutable.with(
                        CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(CharBags.mutable.with((char) 1, (char) 2, (char) 3)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(CharBags.mutable.with((char) 1)).toSet(),
                this.newWithKeysValues(1L, (char) 1).chunk(1).toSet());

        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1L, (char) 1).chunk(-1));
    }
}
