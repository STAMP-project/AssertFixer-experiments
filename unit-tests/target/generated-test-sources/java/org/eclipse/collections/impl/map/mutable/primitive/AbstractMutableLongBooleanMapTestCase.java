/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.LongToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.map.primitive.MutableLongBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractMutableLongBooleanMapTestCase extends AbstractLongBooleanMapTestCase
{
    protected final MutableLongBooleanMap map = this.classUnderTest();

    protected static LongArrayList generateCollisions()
    {
        LongArrayList collisions = new LongArrayList();
        LongBooleanHashMap hashMap = new LongBooleanHashMap();
        for (long each = 2L; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableLongBooleanMap classUnderTest();

    @Override
    protected abstract MutableLongBooleanMap newWithKeysValues(long key1, boolean value1);

    @Override
    protected abstract MutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2);

    @Override
    protected abstract MutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3);

    @Override
    protected abstract MutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3, long key4, boolean value4);

    @Override
    protected abstract MutableLongBooleanMap getEmptyMap();

    @Test
    public void clear()
    {
        this.map.clear();
        Assert.assertEquals(new LongBooleanHashMap(), this.map);

        this.map.put(1L, false);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false), this.map);
        this.map.clear();
        Assert.assertEquals(new LongBooleanHashMap(), this.map);

        this.map.put(33L, false);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, false), this.map);
        this.map.clear();
        Assert.assertEquals(new LongBooleanHashMap(), this.map);
    }

    @Test
    public void removeKey()
    {
        this.map.removeKey(5L);
        this.map.removeKey(50L);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false, 32L, true), this.map);
        this.map.removeKey(0L);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(31L, false, 32L, true), this.map);
        this.map.removeKey(31L);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(32L, true), this.map);
        this.map.removeKey(32L);
        Assert.assertEquals(new LongBooleanHashMap(), this.map);
        this.map.removeKey(0L);
        this.map.removeKey(31L);
        this.map.removeKey(32L);
        Assert.assertEquals(new LongBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1), false);

        Assert.assertTrue(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0));
        Assert.assertFalse(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0)));

        Assert.assertFalse(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1));
        Assert.assertFalse(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1)));

        MutableLongBooleanMap map1 = this.newWithKeysValues(1L, true);
        map1.removeKey(1L);
        Assert.assertEquals(new LongBooleanHashMap(), map1);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertTrue(this.map.removeKeyIfAbsent(5L, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent(50L, false));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 31L, false, 32L, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent(0L, false));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(31L, false, 32L, true), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent(31L, true));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(32L, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent(32L, false));
        Assert.assertEquals(new LongBooleanHashMap(), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent(0L, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent(31L, false));
        Assert.assertFalse(this.map.removeKeyIfAbsent(32L, false));
        Assert.assertEquals(new LongBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1), false);

        Assert.assertTrue(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertTrue(this.map.removeKeyIfAbsent(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0), false));
        Assert.assertFalse(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(0)));

        Assert.assertFalse(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertFalse(this.map.removeKeyIfAbsent(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1), true));
        Assert.assertFalse(this.map.get(AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1)));

        Assert.assertTrue(this.classUnderTest().withKeyValue(1L, true).removeKeyIfAbsent(0L, false));

        MutableLongBooleanMap map1 = this.classUnderTest().withKeyValue(1L, true);
        Assert.assertTrue(map1.removeKeyIfAbsent(1L, false));
        Assert.assertTrue(map1.removeKeyIfAbsent(0L, false));
        Assert.assertFalse(map1.removeKeyIfAbsent(1L, false));

        MutableLongBooleanMap map2 = this.newWithKeysValues(1L, true);
        Assert.assertTrue(map2.removeKeyIfAbsent(1L, false));
    }

    @Test
    public void put()
    {
        this.map.put(0L, false);
        this.map.put(31L, true);
        this.map.put(32L, false);
        MutableLongBooleanMap expected = this.newWithKeysValues(0L, false, 31L, true, 32L, false);
        Assert.assertEquals(expected, this.map);

        this.map.put(1L, true);
        expected.put(1L, true);
        Assert.assertEquals(expected, this.map);

        this.map.put(33L, false);
        expected.put(33L, false);
        Assert.assertEquals(expected, this.map);

        this.map.put(30L, true);
        expected.put(30L, true);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        long collision1 = AbstractMutableLongBooleanMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongBooleanMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongBooleanMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongBooleanMapTestCase.generateCollisions().get(3);

        MutableLongBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);

        MutableLongBooleanMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, true);
        hashMap1.put(collision3, false);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(collision2, true, collision3, false, collision4, true), hashMap1);

        MutableLongBooleanMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, false);
        hashMap2.put(collision3, true);
        Assert.assertTrue(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(collision1, true, collision2, false, collision4, false), hashMap2);
    }

    @Override
    @Test
    public void get()
    {
        super.get();

        this.map.put(0L, false);
        Assert.assertFalse(this.map.get(0L));

        this.map.put(1L, true);
        Assert.assertTrue(this.map.get(1L));

        this.map.put(5L, true);
        Assert.assertTrue(this.map.get(5L));

        this.map.put(35L, false);
        Assert.assertFalse(this.map.get(35L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();

        this.map.removeKey(0L);
        Assert.assertFalse(this.map.getIfAbsent(0L, false));
        Assert.assertTrue(this.map.getIfAbsent(0L, true));

        Assert.assertFalse(this.map.getIfAbsent(1L, false));
        Assert.assertTrue(this.map.getIfAbsent(1L, true));

        Assert.assertFalse(this.map.getIfAbsent(33L, false));
        Assert.assertTrue(this.map.getIfAbsent(33L, true));

        this.map.put(0L, false);
        Assert.assertFalse(this.map.getIfAbsent(0L, true));

        this.map.put(1L, true);
        Assert.assertTrue(this.map.getIfAbsent(1L, false));

        this.map.put(5L, false);
        Assert.assertFalse(this.map.getIfAbsent(5L, true));

        this.map.put(35L, true);
        Assert.assertTrue(this.map.getIfAbsent(35L, false));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();

        this.map.removeKey(0L);
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(0L));

        this.map.put(0L, false);
        Assert.assertFalse(this.map.getOrThrow(0L));

        this.map.put(1L, true);
        Assert.assertTrue(this.map.getOrThrow(1L));

        this.map.put(5L, false);
        Assert.assertFalse(this.map.getOrThrow(5L));

        this.map.put(35L, true);
        Assert.assertTrue(this.map.getOrThrow(35L));
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableLongBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut(0L, true));
        Assert.assertTrue(map1.getIfAbsentPut(0L, false));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true), map1);
        Assert.assertFalse(map1.getIfAbsentPut(1L, false));
        Assert.assertFalse(map1.getIfAbsentPut(1L, true));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false), map1);

        MutableLongBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut(1L, true));
        Assert.assertTrue(map2.getIfAbsentPut(1L, false));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, true), map2);
        Assert.assertFalse(map2.getIfAbsentPut(0L, false));
        Assert.assertFalse(map2.getIfAbsentPut(0L, true));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false, 1L, true), map2);

        MutableLongBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut(32L, true));
        Assert.assertTrue(map3.getIfAbsentPut(32L, false));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(32L, true), map3);

        MutableLongBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPut(33L, false));
        Assert.assertFalse(map4.getIfAbsentPut(33L, true));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, false), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        BooleanFunction0 factory = () -> true;
        BooleanFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableLongBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut(0L, factory));
        Assert.assertTrue(map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut(1L, factory));
        Assert.assertTrue(map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, true), map1);

        MutableLongBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut(1L, factory));
        Assert.assertTrue(map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, true), map2);
        Assert.assertTrue(map2.getIfAbsentPut(0L, factory));
        Assert.assertTrue(map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, true), map2);

        MutableLongBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut(32L, factory));
        Assert.assertTrue(map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(32L, true), map3);

        MutableLongBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPut(33L, factory));
        Assert.assertTrue(map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, true), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == 0L;
        BooleanFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableLongBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWith(0L, functionLengthEven, "12345678"));
        Assert.assertTrue(map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith(1L, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false), map1);

        MutableLongBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith(1L, functionLengthEven, "12345678"));
        Assert.assertTrue(map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, true), map2);
        Assert.assertFalse(map2.getIfAbsentPutWith(0L, functionLengthEven, "123456789"));
        Assert.assertFalse(map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false, 1L, true), map2);

        MutableLongBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWith(32L, functionLengthEven, "12345678"));
        Assert.assertTrue(map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(32L, true), map3);

        MutableLongBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPutWith(33L, functionLengthEven, "12345678"));
        Assert.assertTrue(map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, true), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToBooleanFunction keyIsEven = (long parameter) -> (parameter & 1) == 0L;
        LongToBooleanFunction functionThrows = (long longParameter) -> { throw new AssertionError(); };

        MutableLongBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey(0L, keyIsEven));
        Assert.assertTrue(map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey(1L, keyIsEven));
        Assert.assertFalse(map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false), map1);

        MutableLongBooleanMap map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey(1L, keyIsEven));
        Assert.assertFalse(map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey(0L, keyIsEven));
        Assert.assertTrue(map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false), map2);

        MutableLongBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey(32L, keyIsEven));
        Assert.assertTrue(map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(32L, true), map3);

        MutableLongBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPutWithKey(33L, keyIsEven));
        Assert.assertFalse(map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, false), map4);
    }

    @Test
    public void updateValue()
    {
        BooleanToBooleanFunction flip = (boolean value) -> !value;

        MutableLongBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue(0L, false, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true), map1);
        Assert.assertFalse(map1.updateValue(0L, false, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false), map1);
        Assert.assertFalse(map1.updateValue(1L, true, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false, 1L, false), map1);
        Assert.assertTrue(map1.updateValue(1L, true, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false, 1L, true), map1);

        MutableLongBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue(1L, false, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, true), map2);
        Assert.assertFalse(map2.updateValue(1L, false, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false), map2);
        Assert.assertFalse(map2.updateValue(0L, true, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false, 1L, false), map2);
        Assert.assertTrue(map2.updateValue(0L, true, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, true, 1L, false), map2);

        MutableLongBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.updateValue(33L, false, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, true), map3);
        Assert.assertFalse(map3.updateValue(33L, false, flip));
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(33L, false), map3);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();

        this.map.removeKey(0L);
        Assert.assertFalse(this.map.containsKey(0L));
        Assert.assertFalse(this.map.get(0L));
        this.map.removeKey(0L);
        Assert.assertFalse(this.map.containsKey(0L));
        Assert.assertFalse(this.map.get(0L));

        this.map.removeKey(1L);
        Assert.assertFalse(this.map.containsKey(1L));
        Assert.assertFalse(this.map.get(1L));

        this.map.removeKey(31L);
        Assert.assertFalse(this.map.containsKey(31L));
        Assert.assertFalse(this.map.get(31L));

        this.map.removeKey(32L);
        Assert.assertFalse(this.map.containsKey(32L));
        Assert.assertFalse(this.map.get(32L));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();

        this.map.clear();
        this.map.put(35L, true);
        Assert.assertTrue(this.map.containsValue(true));

        this.map.removeKey(35L);
        Assert.assertFalse(this.map.containsValue(false));
        Assert.assertFalse(this.map.containsValue(true));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();

        this.map.clear();
        this.map.put(35L, true);
        Assert.assertTrue(this.map.contains(true));

        this.map.removeKey(35L);
        Assert.assertFalse(this.map.contains(false));
        Assert.assertFalse(this.map.contains(true));
    }

    @Override
    @Test
    public void containsAll()
    {
        super.containsAll();
        this.map.clear();

        this.map.put(5L, true);
        Assert.assertTrue(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertFalse(this.map.containsAll(false, false));

        this.map.put(0L, false);
        Assert.assertTrue(this.map.containsAll(false));
        Assert.assertTrue(this.map.containsAll(true, false));

        this.map.removeKey(5L);
        Assert.assertFalse(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertTrue(this.map.containsAll(false, false));

        this.map.removeKey(0L);
        Assert.assertFalse(this.map.containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        super.containsAllIterable();
        this.map.clear();

        this.map.put(5L, true);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, false)));

        this.map.put(0L, false);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true, false)));

        this.map.removeKey(5L);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false, false)));

        this.map.removeKey(0L);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void size()
    {
        super.size();

        MutableLongBooleanMap hashMap1 = this.newWithKeysValues(1L, true, 0L, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1L);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0L);
        Verify.assertSize(0, hashMap1);

        MutableLongBooleanMap hashMap = this.newWithKeysValues(6L, false, 5L, true);
        hashMap.removeKey(5L);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withoutKey()
    {
        MutableLongBooleanMap map = this.newWithKeysValues(0L, false, 1L, true, 31L, false, 32L, true);
        MutableLongBooleanMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(0L, false, 1L, true, 31L, false), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableLongBooleanMap map = this.newWithKeysValues(0L, true, 1L, false, 31L, true, 32L, false);
        MutableLongBooleanMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false, 31L, true), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableLongBooleanMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, false), hashMap);
        Assert.assertEquals(LongBooleanHashMap.newWithKeysValues(1L, false), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedLongBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedLongBooleanMap(this.map), this.map.asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableLongBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongBooleanMap(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void booleanIterator_with_remove()
    {
        MutableLongBooleanMap map = this.classUnderTest();
        MutableBooleanIterator iterator = map.booleanIterator();
        while (iterator.hasNext())
        {
            iterator.next();
            iterator.remove();
        }
        Assert.assertFalse(iterator.hasNext());
        Verify.assertEmpty(map);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableBooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableBooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }
}
