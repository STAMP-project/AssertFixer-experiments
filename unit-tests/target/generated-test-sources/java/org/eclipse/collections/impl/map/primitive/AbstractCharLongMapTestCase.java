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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.CharLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.CharLongPair;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractCharLongMapTestCase
{
    protected final CharLongMap map = this.classUnderTest();

    protected abstract CharLongMap classUnderTest();

    protected abstract CharLongMap newWithKeysValues(char key1, long value1);

    protected abstract CharLongMap newWithKeysValues(char key1, long value1, char key2, long value2);

    protected abstract CharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3);

    protected abstract CharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4);

    protected abstract CharLongMap getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0), this.newWithKeysValues((char) 0, 0L).keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 31, (char) 32),
                this.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        CharLongMap map = this.newWithKeysValues((char) 0, 0L);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0L));

        CharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0L));
        Assert.assertTrue(map1.values().contains(31L));
        Assert.assertTrue(map1.values().contains(32L));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(31L, this.map.get((char) 31));
        Assert.assertEquals(32L, this.map.get((char) 32));

        Assert.assertEquals(0L, this.map.get((char) 1));
        Assert.assertEquals(0L, this.map.get((char) 33));
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent((char) 0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent((char) 31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent((char) 32, 5L));
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow((char) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((char) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((char) 32));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 33));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey((char) 0));
        Assert.assertTrue(this.map.containsKey((char) 31));
        Assert.assertTrue(this.map.containsKey((char) 32));
        Assert.assertFalse(this.map.containsKey((char) 1));
        Assert.assertFalse(this.map.containsKey((char) 5));
        Assert.assertFalse(this.map.containsKey((char) 35));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertTrue(this.map.containsValue(31L));
        Assert.assertTrue(this.map.containsValue(32L));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0L));
        Assert.assertTrue(this.map.contains(31L));
        Assert.assertTrue(this.map.contains(32L));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll(0L, 31L, 32L));
        Assert.assertFalse(this.map.containsAll(0L, 31L, 35L));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 32L)));
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 35L)));
        Assert.assertTrue(this.map.containsAll(new LongArrayList()));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, 1L).size());

        Assert.assertEquals(2, this.newWithKeysValues((char) 1, 1L, (char) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, 0L, (char) 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, 1L, (char) 0, 0L, (char) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, 6L, (char) 5, 5L).size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 0, 0L).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 50, 50L).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 0, 0L).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 50, 50L).notEmpty());
    }

    @Test
    public void testEquals()
    {
        CharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 32, 32L);
        CharLongMap map2 = this.newWithKeysValues((char) 32, 32L, (char) 0, 0L, (char) 1, 1L);
        CharLongMap map3 = this.newWithKeysValues((char) 0, 0L, (char) 1, 2L, (char) 32, 32L);
        CharLongMap map4 = this.newWithKeysValues((char) 0, 1L, (char) 1, 1L, (char) 32, 32L);
        CharLongMap map5 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 32, 33L);
        CharLongMap map6 = this.newWithKeysValues((char) 50, 0L, (char) 60, 1L, (char) 70, 33L);
        CharLongMap map7 = this.newWithKeysValues((char) 50, 0L, (char) 60, 1L);
        CharLongMap map8 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        CharLongMap map9 = this.newWithKeysValues((char) 0, 0L);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(LongArrayList.newListWith(0L), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);

        Assert.assertEquals(map1, CharLongMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, CharLongMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 32, 32L).hashCode(),
                this.newWithKeysValues((char) 32, 32L, (char) 0, 0L, (char) 1, 1L).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues((char) 50, 0L, (char) 60, 1L, (char) 70, 33L).hashCode(),
                this.newWithKeysValues((char) 50, 0L, (char) 60, 1L, (char) 70, 33L).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 1, 2L).hashCode(), this.newWithKeysValues((char) 1, 2L).hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{\u0000=0}", this.newWithKeysValues((char) 0, 0L).toString());
        Assert.assertEquals("{\u0001=1}", this.newWithKeysValues((char) 1, 1L).toString());
        Assert.assertEquals("{\u0005=5}", this.newWithKeysValues((char) 5, 5L).toString());

        CharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        Assert.assertTrue(
                map1.toString(),
                "{\u0000=0, \u0001=1}".equals(map1.toString())
                        || "{\u0001=1, \u0000=0}".equals(map1.toString()));

        CharLongMap map2 = this.newWithKeysValues((char) 1, 1L, (char) 32, 32L);
        Assert.assertTrue(
                map2.toString(),
                "{\u0001=1, \u0020=32}".equals(map2.toString())
                        || "{\u0020=32, \u0001=1}".equals(map2.toString()));

        CharLongMap map3 = this.newWithKeysValues((char) 0, 0L, (char) 32, 32L);
        Assert.assertTrue(
                map3.toString(),
                "{\u0000=0, \u0020=32}".equals(map3.toString())
                        || "{\u0020=32, \u0000=0}".equals(map3.toString()));

        CharLongMap map4 = this.newWithKeysValues((char) 32, 32L, (char) 33, 33L);
        Assert.assertTrue(
                map4.toString(),
                "{\u0020=32, \u0021=33}".equals(map4.toString())
                        || "{\u0021=33, \u0020=32}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        CharLongMap map0 = this.newWithKeysValues((char) 0, 1L, (char) 3, 4L);
        long[] sum0 = new long[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        CharLongMap map1 = this.newWithKeysValues((char) 1, 2L, (char) 3, 4L);
        long[] sum1 = new long[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        CharLongMap map01 = this.newWithKeysValues((char) 0, 1L, (char) 1, 2L);
        long[] sum01 = new long[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        CharLongMap map = this.newWithKeysValues((char) 3, 4L, (char) 4, 5L);
        long[] sum = new long[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        CharLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        CharLongMap map3 = this.newWithKeysValues((char) 1, 2L);
        long[] sum3 = new long[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue()
    {
        CharLongMap map0 = this.newWithKeysValues((char) 0, 1L, (char) 3, 4L);
        long[] sum0 = new long[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        CharLongMap map1 = this.newWithKeysValues((char) 1, 2L, (char) 3, 4L);
        long[] sum1 = new long[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        CharLongMap map01 = this.newWithKeysValues((char) 0, 1L, (char) 1, 2L);
        long[] sum01 = new long[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        CharLongMap map = this.newWithKeysValues((char) 3, 4L, (char) 4, 5L);
        long[] sum = new long[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        CharLongMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        CharLongMap map3 = this.newWithKeysValues((char) 1, 2L);
        long[] sum3 = new long[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey()
    {
        CharLongMap map0 = this.newWithKeysValues((char) 0, 1L, (char) 3, 4L);
        char[] sum0 = new char[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);

        CharLongMap map1 = this.newWithKeysValues((char) 1, 2L, (char) 3, 4L);
        char[] sum1 = new char[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);

        CharLongMap map01 = this.newWithKeysValues((char) 0, 1L, (char) 1, 2L);
        char[] sum01 = new char[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);

        CharLongMap map = this.newWithKeysValues((char) 3, 4L, (char) 4, 5L);
        char[] sum = new char[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);

        CharLongMap map2 = this.getEmptyMap();
        char[] sum2 = new char[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        CharLongMap map3 = this.newWithKeysValues((char) 1, 1L);
        char[] sum3 = new char[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue()
    {
        CharLongMap map0 = this.newWithKeysValues((char) 0, 1L, (char) 3, 4L);
        char[] sumKey0 = new char[1];
        long[] sumValue0 = new long[1];
        map0.forEachKeyValue((char eachKey, long eachValue) ->
        {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);

        CharLongMap map1 = this.newWithKeysValues((char) 1, 2L, (char) 3, 4L);
        char[] sumKey1 = new char[1];
        long[] sumValue1 = new long[1];
        map1.forEachKeyValue((char eachKey, long eachValue) ->
        {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);

        CharLongMap map01 = this.newWithKeysValues((char) 0, 1L, (char) 1, 2L);
        char[] sumKey01 = new char[1];
        long[] sumValue01 = new long[1];
        map01.forEachKeyValue((char eachKey, long eachValue) ->
        {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);

        CharLongMap map = this.newWithKeysValues((char) 3, 4L, (char) 4, 5L);
        char[] sumKey = new char[1];
        long[] sumValue = new long[1];
        map.forEachKeyValue((char eachKey, long eachValue) ->
        {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);

        CharLongMap map2 = this.getEmptyMap();
        char[] sumKey2 = new char[1];
        long[] sumValue2 = new long[1];
        map2.forEachKeyValue((char eachKey, long eachValue) ->
        {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);

        CharLongMap map3 = this.newWithKeysValues((char) 3, 5L);
        char[] sumKey3 = new char[1];
        long[] sumValue3 = new long[1];
        map3.forEachKeyValue((char eachKey, long eachValue) ->
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
        Assert.assertEquals("0", this.newWithKeysValues((char) 0, 0L).makeString());
        Assert.assertEquals("0", this.newWithKeysValues((char) 0, 0L).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues((char) 0, 0L).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues((char) 1, 1L).makeString());
        Assert.assertEquals("5", this.newWithKeysValues((char) 5, 5L).makeString());

        CharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        Assert.assertTrue(
                map1.makeString(),
                "0, 1".equals(map1.makeString())
                        || "1, 0".equals(map1.makeString()));

        CharLongMap map2 = this.newWithKeysValues((char) 1, 1L, (char) 32, 32L);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[1/32]".equals(map2.makeString("[", "/", "]"))
                        || "[32/1]".equals(map2.makeString("[", "/", "]")));

        CharLongMap map3 = this.newWithKeysValues((char) 0, 0L, (char) 32, 32L);
        Assert.assertTrue(
                map3.makeString("~"),
                "0~32".equals(map3.makeString("~"))
                        || "32~0".equals(map3.makeString("~")));

        CharLongMap map4 = this.newWithKeysValues((char) 32, 32L, (char) 33, 33L);
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
        this.newWithKeysValues((char) 0, 0L).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());

        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((char) 0, 0L).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());

        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((char) 0, 0L).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((char) 1, 1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((char) 5, 5L).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        CharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "0, 1".equals(appendable3.toString())
                        || "1, 0".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        CharLongMap map2 = this.newWithKeysValues((char) 1, 1L, (char) 32, 32L);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[1/32]".equals(appendable4.toString())
                        || "[32/1]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        CharLongMap map3 = this.newWithKeysValues((char) 1, 1L, (char) 32, 32L);
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
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        CharLongMap actual1 = map.select((char key, long value) -> key == (char) 1 || value == 3L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 3, 3L), actual1);
        CharLongMap actual2 = map.select((char key, long value) -> key == (char) 0 || value == 2L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 2, 2L), actual2);
    }

    @Test
    public void reject()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        CharLongMap actual1 = map.reject((char key, long value) -> key == (char) 1 || value == 3L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 2, 2L), actual1);
        CharLongMap actual2 = map.reject((char key, long value)-> key == (char) 0 || value == 2L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 3, 3L), actual2);
    }

    @Test
    public void select_value()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        LongIterable actual1 = map.select(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.select(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void reject_value()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        LongIterable actual1 = map.reject(LongPredicates.lessThan(2L));
        Assert.assertEquals(LongBags.immutable.with(2L, 3L), actual1);
        LongIterable actual2 = map.reject(LongPredicates.greaterThan(1L));
        Assert.assertEquals(LongBags.immutable.with(0L, 1L), actual2);
    }

    @Test
    public void collect()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);

        LongToObjectFunction<Long> function = (parameter) -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1L, 2L, 3L, 4L), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2L), this.newWithKeysValues((char) 1, 1L).collect(function));
    }

    @Test
    public void count()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(2, map.count(LongPredicates.greaterThan(1L)));
        Assert.assertEquals(2, map.count(LongPredicates.lessThan(2L)));
    }

    @Test
    public void detectIfNone_value()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        long resultNotFound = map.detectIfNone(LongPredicates.greaterThan(5L), 5L);
        Assert.assertEquals(5L, resultNotFound);

        Assert.assertEquals(5L, this.getEmptyMap().detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(5L, this.newWithKeysValues((char) 1, 1L).detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, this.newWithKeysValues((char) 1, 1L).detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(0L, map.detectIfNone(LongPredicates.equal(0L), 5L));
        Assert.assertEquals(1L, map.detectIfNone(LongPredicates.equal(1L), 5L));
        Assert.assertEquals(2L, map.detectIfNone(LongPredicates.equal(2L), 5L));
    }

    @Test
    public void anySatisfy()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1L).anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1L).anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(1L)));
        Assert.assertTrue(map.anySatisfy(LongPredicates.equal(2L)));
        Assert.assertFalse(map.anySatisfy(LongPredicates.greaterThan(5L)));
    }

    @Test
    public void allSatisfy()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1L).allSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1L).allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.allSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.allSatisfy(LongPredicates.lessThan(5L)));
        CharLongMap map1 = this.newWithKeysValues((char) 2, 2L, (char) 3, 3L);
        Assert.assertFalse(map1.allSatisfy(LongPredicates.equal(0L)));
    }

    @Test
    public void noneSatisfy()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertTrue(this.newWithKeysValues((char) 1, 1L).noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(this.newWithKeysValues((char) 1, 1L).noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(0L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(map.noneSatisfy(LongPredicates.equal(2L)));
        Assert.assertTrue(map.noneSatisfy(LongPredicates.lessThan(0L)));
    }

    @Test
    public void max()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(3L, map.max());
        Assert.assertEquals(3L, this.newWithKeysValues((char) 3, 3L).max());
    }

    @Test
    public void min()
    {
        CharLongMap map = this.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L, (char) 0, 0L);
        Assert.assertEquals(0L, map.min());
        Assert.assertEquals(3L, this.newWithKeysValues((char) 3, 3L).min());
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
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5L));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty(0L));
        CharLongMap map = this.newWithKeysValues((char) 1, 1L, (char) 0, 0L, (char) 9, 9L, (char) 7, 7L);
        Assert.assertEquals(0L, map.minIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues((char) 3, 3L).maxIfEmpty(5L));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty(5L));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty(0L));
        CharLongMap map = this.newWithKeysValues((char) 1, 1L, (char) 0, 0L, (char) 9, 9L, (char) 7, 7L);
        Assert.assertEquals(9L, map.maxIfEmpty(5L));
        Assert.assertEquals(3L, this.newWithKeysValues((char) 3, 3L).minIfEmpty(5L));
    }

    @Test
    public void sum()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(6L, map.sum());
        CharLongMap map2 = this.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        Assert.assertEquals(9L, map2.sum());
        CharLongMap map3 = this.newWithKeysValues((char) 2, 2L);
        Assert.assertEquals(2L, map3.sum());
    }

    @Test
    public void average()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(1.5, map.average(), 0.0);
        CharLongMap map1 = this.newWithKeysValues((char) 1, 1L);
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
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(1.5, map.median(), 0.0);
        CharLongMap map2 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        CharLongMap map3 = this.newWithKeysValues((char) 1, 1L);
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
        Assert.assertEquals(LongArrayList.newListWith(0L), this.newWithKeysValues((char) 0, 0L).toList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues((char) 1, 1L).toList());
        Assert.assertEquals(LongArrayList.newListWith(2L), this.newWithKeysValues((char) 2, 2L).toList());
        Assert.assertTrue(this.newWithKeysValues((char) 2, 2L, (char) 3, 3L).toList().equals(LongArrayList.newListWith(2L, 3L))
                || this.newWithKeysValues((char) 2, 2L, (char) 3, 3L).toList().equals(LongArrayList.newListWith(3L, 2L)));
    }

    @Test
    public void toSortedList()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(LongArrayList.newListWith(0L, 1L, 2L, 3L), map.toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(LongArrayList.newListWith(1L), this.newWithKeysValues((char) 1, 1L).toSortedList());
    }

    @Test
    public void toSet()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(LongHashSet.newSetWith(0L, 1L, 2L, 3L), map.toSet());
        Assert.assertEquals(LongHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(LongHashSet.newSetWith(1L), this.newWithKeysValues((char) 1, 1L).toSet());
    }

    @Test
    public void toBag()
    {
        CharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 2L, 3L), map.toBag());
        Assert.assertEquals(LongHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(1L), this.newWithKeysValues((char) 1, 1L).toBag());
    }

    @Test
    public void longIterator()
    {
        MutableLongSet expected = LongHashSet.newSetWith(0L, 31L, 32L);
        MutableLongSet actual = LongHashSet.newSetWith();

        LongIterator iterator = this.map.longIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().longIterator().next());
    }

    @Test
    public void asLazy()
    {
        LazyLongIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0L, 31L, 32L));
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 31, (char) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<CharLongPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((char key, long value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new long[]{0L, 31L, 32L}, this.map.toSortedArray()));
    }

    @Test
    public void toArray()
    {
        CharLongMap map = this.newWithKeysValues((char) 1, 1L, (char) 2, 2L);
        long[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new long[]{1L, 2L}, array)
                || Arrays.equals(new long[]{2L, 1L}, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new long[]{1L}, this.newWithKeysValues((char) 1, 1L).toArray()));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableCharLongMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk()
    {
        LongIterable iterable = this.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        Assert.assertEquals(
                Lists.mutable.with(
                        LongBags.mutable.with(1L),
                        LongBags.mutable.with(2L),
                        LongBags.mutable.with(3L)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertTrue(
                Lists.mutable.with(
                        LongBags.mutable.with(1L, 2L),
                        LongBags.mutable.with(3L)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        LongBags.mutable.with(2L, 3L),
                        LongBags.mutable.with(1L)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        LongBags.mutable.with(1L, 3L),
                        LongBags.mutable.with(2L)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(
                Lists.mutable.with(
                        LongBags.mutable.with(1L, 2L, 3L)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(LongBags.mutable.with(1L)).toSet(),
                this.newWithKeysValues((char) 1, 1L).chunk(1).toSet());

        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((char) 1, 1L).chunk(-1));
    }
}
