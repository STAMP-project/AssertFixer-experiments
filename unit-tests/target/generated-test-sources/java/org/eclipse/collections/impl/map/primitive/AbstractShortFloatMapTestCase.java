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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.ShortFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.ShortFloatPair;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractShortFloatMapTestCase
{
    protected final ShortFloatMap map = this.classUnderTest();

    protected abstract ShortFloatMap classUnderTest();

    protected abstract ShortFloatMap newWithKeysValues(short key1, float value1);

    protected abstract ShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2);

    protected abstract ShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3);

    protected abstract ShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4);

    protected abstract ShortFloatMap getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0), this.newWithKeysValues((short) 0, 0.0f).keySet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 31, (short) 32),
                this.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains(0.0f));

        ShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains(0.0f));
        Assert.assertTrue(map1.values().contains(31.0f));
        Assert.assertTrue(map1.values().contains(32.0f));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get((short) 0), 0.0);
        Assert.assertEquals(31.0, this.map.get((short) 31), 0.0);
        Assert.assertEquals(32.0, this.map.get((short) 32), 0.0);

        Assert.assertEquals(0.0, this.map.get((short) 1), 0.0);
        Assert.assertEquals(0.0, this.map.get((short) 33), 0.0);
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent((short) 0, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((short) 31, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((short) 32, 5.0f), 0.0);
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow((short) 0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow((short) 31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow((short) 32), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 33));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey((short) 0));
        Assert.assertTrue(this.map.containsKey((short) 31));
        Assert.assertTrue(this.map.containsKey((short) 32));
        Assert.assertFalse(this.map.containsKey((short) 1));
        Assert.assertFalse(this.map.containsKey((short) 5));
        Assert.assertFalse(this.map.containsKey((short) 35));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(31.0f));
        Assert.assertTrue(this.map.containsValue(32.0f));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(31.0f));
        Assert.assertTrue(this.map.contains(32.0f));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll(0.0f, 31.0f, 32.0f));
        Assert.assertFalse(this.map.containsAll(0.0f, 31.0f, 35.0f));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f)));
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 35.0f)));
        Assert.assertTrue(this.map.containsAll(new FloatArrayList()));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1.0f).size());

        Assert.assertEquals(2, this.newWithKeysValues((short) 1, 1.0f, (short) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, 0.0f, (short) 5, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, 1.0f, (short) 0, 0.0f, (short) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, 6.0f, (short) 5, 5.0f).size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 0, 0.0f).isEmpty());
        Assert.assertFalse(this.newWithKeysValues((short) 50, 50.0f).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 0, 0.0f).notEmpty());
        Assert.assertTrue(this.newWithKeysValues((short) 50, 50.0f).notEmpty());
    }

    @Test
    public void testEquals()
    {
        ShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 32, 32.0f);
        ShortFloatMap map2 = this.newWithKeysValues((short) 32, 32.0f, (short) 0, 0.0f, (short) 1, 1.0f);
        ShortFloatMap map3 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 2.0f, (short) 32, 32.0f);
        ShortFloatMap map4 = this.newWithKeysValues((short) 0, 1.0f, (short) 1, 1.0f, (short) 32, 32.0f);
        ShortFloatMap map5 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 32, 33.0f);
        ShortFloatMap map6 = this.newWithKeysValues((short) 50, 0.0f, (short) 60, 1.0f, (short) 70, 33.0f);
        ShortFloatMap map7 = this.newWithKeysValues((short) 50, 0.0f, (short) 60, 1.0f);
        ShortFloatMap map8 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        ShortFloatMap map9 = this.newWithKeysValues((short) 0, 0.0f);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(FloatArrayList.newListWith(0.0f), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);

        Assert.assertEquals(map1, ShortFloatMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, ShortFloatMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 32, 32.0f).hashCode(),
                this.newWithKeysValues((short) 32, 32.0f, (short) 0, 0.0f, (short) 1, 1.0f).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues((short) 50, 0.0f, (short) 60, 1.0f, (short) 70, 33.0f).hashCode(),
                this.newWithKeysValues((short) 50, 0.0f, (short) 60, 1.0f, (short) 70, 33.0f).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((short) 1, 2.0f).hashCode(), this.newWithKeysValues((short) 1, 2.0f).hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0.0}", this.newWithKeysValues((short) 0, 0.0f).toString());
        Assert.assertEquals("{1=1.0}", this.newWithKeysValues((short) 1, 1.0f).toString());
        Assert.assertEquals("{5=5.0}", this.newWithKeysValues((short) 5, 5.0f).toString());

        ShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        Assert.assertTrue(
                map1.toString(),
                "{0=0.0, 1=1.0}".equals(map1.toString())
                        || "{1=1.0, 0=0.0}".equals(map1.toString()));

        ShortFloatMap map2 = this.newWithKeysValues((short) 1, 1.0f, (short) 32, 32.0f);
        Assert.assertTrue(
                map2.toString(),
                "{1=1.0, 32=32.0}".equals(map2.toString())
                        || "{32=32.0, 1=1.0}".equals(map2.toString()));

        ShortFloatMap map3 = this.newWithKeysValues((short) 0, 0.0f, (short) 32, 32.0f);
        Assert.assertTrue(
                map3.toString(),
                "{0=0.0, 32=32.0}".equals(map3.toString())
                        || "{32=32.0, 0=0.0}".equals(map3.toString()));

        ShortFloatMap map4 = this.newWithKeysValues((short) 32, 32.0f, (short) 33, 33.0f);
        Assert.assertTrue(
                map4.toString(),
                "{32=32.0, 33=33.0}".equals(map4.toString())
                        || "{33=33.0, 32=32.0}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        ShortFloatMap map0 = this.newWithKeysValues((short) 0, 1.0f, (short) 3, 4.0f);
        float[] sum0 = new float[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);

        ShortFloatMap map1 = this.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f);
        float[] sum1 = new float[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);

        ShortFloatMap map01 = this.newWithKeysValues((short) 0, 1.0f, (short) 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);

        ShortFloatMap map = this.newWithKeysValues((short) 3, 4.0f, (short) 4, 5.0f);
        float[] sum = new float[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);

        ShortFloatMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);

        ShortFloatMap map3 = this.newWithKeysValues((short) 1, 2.0f);
        float[] sum3 = new float[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachValue()
    {
        ShortFloatMap map0 = this.newWithKeysValues((short) 0, 1.0f, (short) 3, 4.0f);
        float[] sum0 = new float[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5.0, sum0[0], 0.0);

        ShortFloatMap map1 = this.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f);
        float[] sum1 = new float[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6.0, sum1[0], 0.0);

        ShortFloatMap map01 = this.newWithKeysValues((short) 0, 1.0f, (short) 1, 2.0f);
        float[] sum01 = new float[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3.0, sum01[0], 0.0);

        ShortFloatMap map = this.newWithKeysValues((short) 3, 4.0f, (short) 4, 5.0f);
        float[] sum = new float[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9.0, sum[0], 0.0);

        ShortFloatMap map2 = this.getEmptyMap();
        float[] sum2 = new float[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0.0, sum2[0], 0.0);

        ShortFloatMap map3 = this.newWithKeysValues((short) 1, 2.0f);
        float[] sum3 = new float[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2.0, sum3[0], 0.0);
    }

    @Test
    public void forEachKey()
    {
        ShortFloatMap map0 = this.newWithKeysValues((short) 0, 1.0f, (short) 3, 4.0f);
        short[] sum0 = new short[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);

        ShortFloatMap map1 = this.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f);
        short[] sum1 = new short[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);

        ShortFloatMap map01 = this.newWithKeysValues((short) 0, 1.0f, (short) 1, 2.0f);
        short[] sum01 = new short[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);

        ShortFloatMap map = this.newWithKeysValues((short) 3, 4.0f, (short) 4, 5.0f);
        short[] sum = new short[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);

        ShortFloatMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        ShortFloatMap map3 = this.newWithKeysValues((short) 1, 1.0f);
        short[] sum3 = new short[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue()
    {
        ShortFloatMap map0 = this.newWithKeysValues((short) 0, 1.0f, (short) 3, 4.0f);
        short[] sumKey0 = new short[1];
        float[] sumValue0 = new float[1];
        map0.forEachKeyValue((short eachKey, float eachValue) ->
        {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5.0, sumValue0[0], 0.0);

        ShortFloatMap map1 = this.newWithKeysValues((short) 1, 2.0f, (short) 3, 4.0f);
        short[] sumKey1 = new short[1];
        float[] sumValue1 = new float[1];
        map1.forEachKeyValue((short eachKey, float eachValue) ->
        {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6.0, sumValue1[0], 0.0);

        ShortFloatMap map01 = this.newWithKeysValues((short) 0, 1.0f, (short) 1, 2.0f);
        short[] sumKey01 = new short[1];
        float[] sumValue01 = new float[1];
        map01.forEachKeyValue((short eachKey, float eachValue) ->
        {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3.0, sumValue01[0], 0.0);

        ShortFloatMap map = this.newWithKeysValues((short) 3, 4.0f, (short) 4, 5.0f);
        short[] sumKey = new short[1];
        float[] sumValue = new float[1];
        map.forEachKeyValue((short eachKey, float eachValue) ->
        {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9.0, sumValue[0], 0.0);

        ShortFloatMap map2 = this.getEmptyMap();
        short[] sumKey2 = new short[1];
        float[] sumValue2 = new float[1];
        map2.forEachKeyValue((short eachKey, float eachValue) ->
        {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0.0, sumValue2[0], 0.0);

        ShortFloatMap map3 = this.newWithKeysValues((short) 3, 5.0f);
        short[] sumKey3 = new short[1];
        float[] sumValue3 = new float[1];
        map3.forEachKeyValue((short eachKey, float eachValue) ->
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
        Assert.assertEquals("0.0", this.newWithKeysValues((short) 0, 0.0f).makeString());
        Assert.assertEquals("0.0", this.newWithKeysValues((short) 0, 0.0f).makeString(", "));
        Assert.assertEquals("[0.0]", this.newWithKeysValues((short) 0, 0.0f).makeString("[", "/", "]"));
        Assert.assertEquals("1.0", this.newWithKeysValues((short) 1, 1.0f).makeString());
        Assert.assertEquals("5.0", this.newWithKeysValues((short) 5, 5.0f).makeString());

        ShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        Assert.assertTrue(
                map1.makeString(),
                "0.0, 1.0".equals(map1.makeString())
                        || "1.0, 0.0".equals(map1.makeString()));

        ShortFloatMap map2 = this.newWithKeysValues((short) 1, 1.0f, (short) 32, 32.0f);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[1.0/32.0]".equals(map2.makeString("[", "/", "]"))
                        || "[32.0/1.0]".equals(map2.makeString("[", "/", "]")));

        ShortFloatMap map3 = this.newWithKeysValues((short) 0, 0.0f, (short) 32, 32.0f);
        Assert.assertTrue(
                map3.makeString("~"),
                "0.0~32.0".equals(map3.makeString("~"))
                        || "32.0~0.0".equals(map3.makeString("~")));

        ShortFloatMap map4 = this.newWithKeysValues((short) 32, 32.0f, (short) 33, 33.0f);
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
        this.newWithKeysValues((short) 0, 0.0f).appendString(appendable0);
        Assert.assertEquals("0.0", appendable0.toString());

        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues((short) 0, 0.0f).appendString(appendable01, "/");
        Assert.assertEquals("0.0", appendable01.toString());

        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues((short) 0, 0.0f).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0.0}", appendable02.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((short) 1, 1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((short) 5, 5.0f).appendString(appendable2);
        Assert.assertEquals("5.0", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        ShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "0.0, 1.0".equals(appendable3.toString())
                        || "1.0, 0.0".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        ShortFloatMap map2 = this.newWithKeysValues((short) 1, 1.0f, (short) 32, 32.0f);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[1.0/32.0]".equals(appendable4.toString())
                        || "[32.0/1.0]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        ShortFloatMap map3 = this.newWithKeysValues((short) 1, 1.0f, (short) 32, 32.0f);
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
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        ShortFloatMap actual1 = map.select((short key, float value) -> key == (short) 1 || Float.compare(value, 3.0f) == 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 3, 3.0f), actual1);
        ShortFloatMap actual2 = map.select((short key, float value) -> key == (short) 0 || Float.compare(value, 2.0f) == 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 2, 2.0f), actual2);
    }

    @Test
    public void reject()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        ShortFloatMap actual1 = map.reject((short key, float value) -> key == (short) 1 || Float.compare(value, 3.0f) == 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 2, 2.0f), actual1);
        ShortFloatMap actual2 = map.reject((short key, float value)-> key == (short) 0 || Float.compare(value, 2.0f) == 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 3, 3.0f), actual2);
    }

    @Test
    public void select_value()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        FloatIterable actual1 = map.select(FloatPredicates.greaterThan(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(2.0f, 3.0f), actual1);
        FloatIterable actual2 = map.select(FloatPredicates.lessThan(2.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f, 1.0f), actual2);
    }

    @Test
    public void reject_value()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        FloatIterable actual1 = map.reject(FloatPredicates.lessThan(2.0f));
        Assert.assertEquals(FloatBags.immutable.with(2.0f, 3.0f), actual1);
        FloatIterable actual2 = map.reject(FloatPredicates.greaterThan(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f, 1.0f), actual2);
    }

    @Test
    public void collect()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);

        FloatToObjectFunction<Float> function = (parameter) -> parameter + 1;
        Assert.assertEquals(Bags.immutable.with(1.0f, 2.0f, 3.0f, 4.0f), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with(2.0f), this.newWithKeysValues((short) 1, 1.0f).collect(function));
    }

    @Test
    public void count()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(2, map.count(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(2, map.count(FloatPredicates.lessThan(2.0f)));
    }

    @Test
    public void detectIfNone_value()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        float resultNotFound = map.detectIfNone(FloatPredicates.greaterThan(5.0f), 5.0f);
        Assert.assertEquals(5.0f, resultNotFound, 0.0);

        Assert.assertEquals(5.0f, this.getEmptyMap().detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(5.0f, this.newWithKeysValues((short) 1, 1.0f).detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(1.0f, this.newWithKeysValues((short) 1, 1.0f).detectIfNone(FloatPredicates.equal(1.0f), 5.0f), 0.0);
        Assert.assertEquals(0.0f, map.detectIfNone(FloatPredicates.equal(0.0f), 5.0f), 0.0);
        Assert.assertEquals(1.0f, map.detectIfNone(FloatPredicates.equal(1.0f), 5.0f), 0.0);
        Assert.assertEquals(2.0f, map.detectIfNone(FloatPredicates.equal(2.0f), 5.0f), 0.0);
    }

    @Test
    public void anySatisfy()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1.0f).anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1.0f).anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertTrue(map.anySatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertFalse(map.anySatisfy(FloatPredicates.greaterThan(5.0f)));
    }

    @Test
    public void allSatisfy()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1.0f).allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1.0f).allSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.allSatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertTrue(map.allSatisfy(FloatPredicates.lessThan(5.0f)));
        ShortFloatMap map1 = this.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertFalse(map1.allSatisfy(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void noneSatisfy()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertTrue(this.newWithKeysValues((short) 1, 1.0f).noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(this.newWithKeysValues((short) 1, 1.0f).noneSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(0.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(1.0f)));
        Assert.assertFalse(map.noneSatisfy(FloatPredicates.equal(2.0f)));
        Assert.assertTrue(map.noneSatisfy(FloatPredicates.lessThan(0.0f)));
    }

    @Test
    public void max()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(3.0f, map.max(), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((short) 3, 3.0f).max(), 0.0);
    }

    @Test
    public void min()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 0, 0.0f);
        Assert.assertEquals(0.0f, map.min(), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((short) 3, 3.0f).min(), 0.0);
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
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().minIfEmpty(0.0f), 0.0);
        ShortFloatMap map = this.newWithKeysValues((short) 1, 1.0f, (short) 0, 0.0f, (short) 9, 9.0f, (short) 7, 7.0f);
        Assert.assertEquals(0.0, map.minIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((short) 3, 3.0f).maxIfEmpty(5.0f), 0.0);
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5.0, this.getEmptyMap().maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(0.0, this.getEmptyMap().maxIfEmpty(0.0f), 0.0);
        ShortFloatMap map = this.newWithKeysValues((short) 1, 1.0f, (short) 0, 0.0f, (short) 9, 9.0f, (short) 7, 7.0f);
        Assert.assertEquals(9.0, map.maxIfEmpty(5.0f), 0.0);
        Assert.assertEquals(3.0f, this.newWithKeysValues((short) 3, 3.0f).minIfEmpty(5.0f), 0.0);
    }

    @Test
    public void sum()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(6.0f, map.sum(), 0.0);
        ShortFloatMap map2 = this.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Assert.assertEquals(9.0f, map2.sum(), 0.0);
        ShortFloatMap map3 = this.newWithKeysValues((short) 2, 2.0f);
        Assert.assertEquals(2.0f, map3.sum(), 0.0);
    }

    @Test
    public void average()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(1.5, map.average(), 0.0);
        ShortFloatMap map1 = this.newWithKeysValues((short) 1, 1.0f);
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
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(1.5, map.median(), 0.0);
        ShortFloatMap map2 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        ShortFloatMap map3 = this.newWithKeysValues((short) 1, 1.0f);
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
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.newWithKeysValues((short) 0, 0.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues((short) 1, 1.0f).toList());
        Assert.assertEquals(FloatArrayList.newListWith(2.0f), this.newWithKeysValues((short) 2, 2.0f).toList());
        Assert.assertTrue(this.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f).toList().equals(FloatArrayList.newListWith(2.0f, 3.0f))
                || this.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f).toList().equals(FloatArrayList.newListWith(3.0f, 2.0f)));
    }

    @Test
    public void toSortedList()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f), map.toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), this.newWithKeysValues((short) 1, 1.0f).toSortedList());
    }

    @Test
    public void toSet()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(FloatHashSet.newSetWith(0.0f, 1.0f, 2.0f, 3.0f), map.toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), this.newWithKeysValues((short) 1, 1.0f).toSet());
    }

    @Test
    public void toBag()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 2.0f, 3.0f), map.toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.newWithKeysValues((short) 1, 1.0f).toBag());
    }

    @Test
    public void floatIterator()
    {
        MutableFloatSet expected = FloatHashSet.newSetWith(0.0f, 31.0f, 32.0f);
        MutableFloatSet actual = FloatHashSet.newSetWith();

        FloatIterator iterator = this.map.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().floatIterator().next());
    }

    @Test
    public void asLazy()
    {
        LazyFloatIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll(0.0f, 31.0f, 32.0f));
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<ShortFloatPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((short key, float value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new float[]{0.0f, 31.0f, 32.0f}, this.map.toSortedArray()));
    }

    @Test
    public void toArray()
    {
        ShortFloatMap map = this.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f);
        float[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new float[]{1.0f, 2.0f}, array)
                || Arrays.equals(new float[]{2.0f, 1.0f}, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new float[]{1.0f}, this.newWithKeysValues((short) 1, 1.0f).toArray()));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableShortFloatMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk()
    {
        FloatIterable iterable = this.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        Assert.assertEquals(
                Lists.mutable.with(
                        FloatBags.mutable.with(1.0f),
                        FloatBags.mutable.with(2.0f),
                        FloatBags.mutable.with(3.0f)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertTrue(
                Lists.mutable.with(
                        FloatBags.mutable.with(1.0f, 2.0f),
                        FloatBags.mutable.with(3.0f)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        FloatBags.mutable.with(2.0f, 3.0f),
                        FloatBags.mutable.with(1.0f)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        FloatBags.mutable.with(1.0f, 3.0f),
                        FloatBags.mutable.with(2.0f)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(
                Lists.mutable.with(
                        FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(FloatBags.mutable.with(1.0f)).toSet(),
                this.newWithKeysValues((short) 1, 1.0f).chunk(1).toSet());

        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues((short) 1, 1.0f).chunk(-1));
    }
}
