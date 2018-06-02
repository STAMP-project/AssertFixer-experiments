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
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.api.map.primitive.MutableShortBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortBooleanMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveBooleanMapTestCase.stg.
 */
public abstract class AbstractMutableShortBooleanMapTestCase extends AbstractShortBooleanMapTestCase
{
    protected final MutableShortBooleanMap map = this.classUnderTest();

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableShortBooleanMap classUnderTest();

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1);

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2);

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3);

    @Override
    protected abstract MutableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4);

    @Override
    protected abstract MutableShortBooleanMap getEmptyMap();

    @Test
    public void clear()
    {
        this.map.clear();
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);

        this.map.put((short) 1, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), this.map);
        this.map.clear();
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);

        this.map.put((short) 33, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), this.map);
        this.map.clear();
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
    }

    @Test
    public void removeKey()
    {
        this.map.removeKey((short) 5);
        this.map.removeKey((short) 50);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true), this.map);
        this.map.removeKey((short) 0);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 31, false, (short) 32, true), this.map);
        this.map.removeKey((short) 31);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), this.map);
        this.map.removeKey((short) 32);
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        this.map.removeKey((short) 0);
        this.map.removeKey((short) 31);
        this.map.removeKey((short) 32);
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1), false);

        Assert.assertTrue(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));

        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));

        MutableShortBooleanMap map1 = this.newWithKeysValues((short) 1, true);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortBooleanHashMap(), map1);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 5, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 50, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 0, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 31, false, (short) 32, true), this.map);
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 31, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 32, false));
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        Assert.assertTrue(this.map.removeKeyIfAbsent((short) 0, true));
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 31, false));
        Assert.assertFalse(this.map.removeKeyIfAbsent((short) 32, false));
        Assert.assertEquals(new ShortBooleanHashMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0), true);
        this.map.put(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1), false);

        Assert.assertTrue(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));
        Assert.assertTrue(this.map.removeKeyIfAbsent(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0), false));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(0)));

        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));
        Assert.assertFalse(this.map.removeKeyIfAbsent(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1), true));
        Assert.assertFalse(this.map.get(AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1)));

        Assert.assertTrue(this.classUnderTest().withKeyValue((short) 1, true).removeKeyIfAbsent((short) 0, false));

        MutableShortBooleanMap map1 = this.classUnderTest().withKeyValue((short) 1, true);
        Assert.assertTrue(map1.removeKeyIfAbsent((short) 1, false));
        Assert.assertTrue(map1.removeKeyIfAbsent((short) 0, false));
        Assert.assertFalse(map1.removeKeyIfAbsent((short) 1, false));

        MutableShortBooleanMap map2 = this.newWithKeysValues((short) 1, true);
        Assert.assertTrue(map2.removeKeyIfAbsent((short) 1, false));
    }

    @Test
    public void put()
    {
        this.map.put((short) 0, false);
        this.map.put((short) 31, true);
        this.map.put((short) 32, false);
        MutableShortBooleanMap expected = this.newWithKeysValues((short) 0, false, (short) 31, true, (short) 32, false);
        Assert.assertEquals(expected, this.map);

        this.map.put((short) 1, true);
        expected.put((short) 1, true);
        Assert.assertEquals(expected, this.map);

        this.map.put((short) 33, false);
        expected.put((short) 33, false);
        Assert.assertEquals(expected, this.map);

        this.map.put((short) 30, true);
        expected.put((short) 30, true);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortBooleanMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortBooleanMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortBooleanMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortBooleanMapTestCase.generateCollisions().get(3);

        MutableShortBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
        hashMap.put(collision2, false);
        hashMap.put(collision3, true);
        Assert.assertFalse(hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues(collision1, true, collision3, true, collision4, false), hashMap);

        MutableShortBooleanMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, false);
        hashMap1.put(collision2, true);
        hashMap1.put(collision3, false);
        Assert.assertFalse(hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, true);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues(collision2, true, collision3, false, collision4, true), hashMap1);

        MutableShortBooleanMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, true);
        hashMap2.put(collision2, false);
        hashMap2.put(collision3, true);
        Assert.assertTrue(hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, false);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues(collision1, true, collision2, false, collision4, false), hashMap2);
    }

    @Override
    @Test
    public void get()
    {
        super.get();

        this.map.put((short) 0, false);
        Assert.assertFalse(this.map.get((short) 0));

        this.map.put((short) 1, true);
        Assert.assertTrue(this.map.get((short) 1));

        this.map.put((short) 5, true);
        Assert.assertTrue(this.map.get((short) 5));

        this.map.put((short) 35, false);
        Assert.assertFalse(this.map.get((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();

        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.getIfAbsent((short) 0, false));
        Assert.assertTrue(this.map.getIfAbsent((short) 0, true));

        Assert.assertFalse(this.map.getIfAbsent((short) 1, false));
        Assert.assertTrue(this.map.getIfAbsent((short) 1, true));

        Assert.assertFalse(this.map.getIfAbsent((short) 33, false));
        Assert.assertTrue(this.map.getIfAbsent((short) 33, true));

        this.map.put((short) 0, false);
        Assert.assertFalse(this.map.getIfAbsent((short) 0, true));

        this.map.put((short) 1, true);
        Assert.assertTrue(this.map.getIfAbsent((short) 1, false));

        this.map.put((short) 5, false);
        Assert.assertFalse(this.map.getIfAbsent((short) 5, true));

        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.getIfAbsent((short) 35, false));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();

        this.map.removeKey((short) 0);
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 0));

        this.map.put((short) 0, false);
        Assert.assertFalse(this.map.getOrThrow((short) 0));

        this.map.put((short) 1, true);
        Assert.assertTrue(this.map.getOrThrow((short) 1));

        this.map.put((short) 5, false);
        Assert.assertFalse(this.map.getOrThrow((short) 5));

        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.getOrThrow((short) 35));
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, true));
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPut((short) 1, false));
        Assert.assertFalse(map1.getIfAbsentPut((short) 1, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map1);

        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, true));
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPut((short) 0, false));
        Assert.assertFalse(map2.getIfAbsentPut((short) 0, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true), map2);

        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, true));
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, false));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);

        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPut((short) 33, false));
        Assert.assertFalse(map4.getIfAbsentPut((short) 33, true));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        BooleanFunction0 factory = () -> true;
        BooleanFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, factory));
        Assert.assertTrue(map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertTrue(map1.getIfAbsentPut((short) 1, factory));
        Assert.assertTrue(map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, true), map1);

        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, factory));
        Assert.assertTrue(map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertTrue(map2.getIfAbsentPut((short) 0, factory));
        Assert.assertTrue(map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, true), map2);

        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, factory));
        Assert.assertTrue(map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);

        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPut((short) 33, factory));
        Assert.assertTrue(map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (short) 0;
        BooleanFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWith((short) 0, functionLengthEven, "12345678"));
        Assert.assertTrue(map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWith((short) 1, functionLengthEven, "123456789"));
        Assert.assertFalse(map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map1);

        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.getIfAbsentPutWith((short) 1, functionLengthEven, "12345678"));
        Assert.assertTrue(map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertFalse(map2.getIfAbsentPutWith((short) 0, functionLengthEven, "123456789"));
        Assert.assertFalse(map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true), map2);

        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWith((short) 32, functionLengthEven, "12345678"));
        Assert.assertTrue(map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);

        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertTrue(map4.getIfAbsentPutWith((short) 33, functionLengthEven, "12345678"));
        Assert.assertTrue(map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, true), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToBooleanFunction keyIsEven = (short parameter) -> (parameter & 1) == (short) 0;
        ShortToBooleanFunction functionThrows = (short shortParameter) -> { throw new AssertionError(); };

        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.getIfAbsentPutWithKey((short) 0, keyIsEven));
        Assert.assertTrue(map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.getIfAbsentPutWithKey((short) 1, keyIsEven));
        Assert.assertFalse(map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map1);

        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertFalse(map2.getIfAbsentPutWithKey((short) 1, keyIsEven));
        Assert.assertFalse(map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), map2);
        Assert.assertTrue(map2.getIfAbsentPutWithKey((short) 0, keyIsEven));
        Assert.assertTrue(map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map2);

        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.getIfAbsentPutWithKey((short) 32, keyIsEven));
        Assert.assertTrue(map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 32, true), map3);

        MutableShortBooleanMap map4 = this.getEmptyMap();
        Assert.assertFalse(map4.getIfAbsentPutWithKey((short) 33, keyIsEven));
        Assert.assertFalse(map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), map4);
    }

    @Test
    public void updateValue()
    {
        BooleanToBooleanFunction flip = (boolean value) -> !value;

        MutableShortBooleanMap map1 = this.getEmptyMap();
        Assert.assertTrue(map1.updateValue((short) 0, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true), map1);
        Assert.assertFalse(map1.updateValue((short) 0, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false), map1);
        Assert.assertFalse(map1.updateValue((short) 1, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, false), map1);
        Assert.assertTrue(map1.updateValue((short) 1, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true), map1);

        MutableShortBooleanMap map2 = this.getEmptyMap();
        Assert.assertTrue(map2.updateValue((short) 1, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, true), map2);
        Assert.assertFalse(map2.updateValue((short) 1, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), map2);
        Assert.assertFalse(map2.updateValue((short) 0, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, false), map2);
        Assert.assertTrue(map2.updateValue((short) 0, true, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false), map2);

        MutableShortBooleanMap map3 = this.getEmptyMap();
        Assert.assertTrue(map3.updateValue((short) 33, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, true), map3);
        Assert.assertFalse(map3.updateValue((short) 33, false, flip));
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 33, false), map3);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();

        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.get((short) 0));
        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.get((short) 0));

        this.map.removeKey((short) 1);
        Assert.assertFalse(this.map.containsKey((short) 1));
        Assert.assertFalse(this.map.get((short) 1));

        this.map.removeKey((short) 31);
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertFalse(this.map.get((short) 31));

        this.map.removeKey((short) 32);
        Assert.assertFalse(this.map.containsKey((short) 32));
        Assert.assertFalse(this.map.get((short) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();

        this.map.clear();
        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.containsValue(true));

        this.map.removeKey((short) 35);
        Assert.assertFalse(this.map.containsValue(false));
        Assert.assertFalse(this.map.containsValue(true));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();

        this.map.clear();
        this.map.put((short) 35, true);
        Assert.assertTrue(this.map.contains(true));

        this.map.removeKey((short) 35);
        Assert.assertFalse(this.map.contains(false));
        Assert.assertFalse(this.map.contains(true));
    }

    @Override
    @Test
    public void containsAll()
    {
        super.containsAll();
        this.map.clear();

        this.map.put((short) 5, true);
        Assert.assertTrue(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertFalse(this.map.containsAll(false, false));

        this.map.put((short) 0, false);
        Assert.assertTrue(this.map.containsAll(false));
        Assert.assertTrue(this.map.containsAll(true, false));

        this.map.removeKey((short) 5);
        Assert.assertFalse(this.map.containsAll(true));
        Assert.assertFalse(this.map.containsAll(true, false));
        Assert.assertTrue(this.map.containsAll(false, false));

        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        super.containsAllIterable();
        this.map.clear();

        this.map.put((short) 5, true);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, false)));

        this.map.put((short) 0, false);
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(true, false)));

        this.map.removeKey((short) 5);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.map.containsAll(BooleanArrayList.newListWith(false, false)));

        this.map.removeKey((short) 0);
        Assert.assertFalse(this.map.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void size()
    {
        super.size();

        MutableShortBooleanMap hashMap1 = this.newWithKeysValues((short) 1, true, (short) 0, false);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey((short) 1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey((short) 0);
        Verify.assertSize(0, hashMap1);

        MutableShortBooleanMap hashMap = this.newWithKeysValues((short) 6, false, (short) 5, true);
        hashMap.removeKey((short) 5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withoutKey()
    {
        MutableShortBooleanMap map = this.newWithKeysValues((short) 0, false, (short) 1, true, (short) 31, false, (short) 32, true);
        MutableShortBooleanMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 0, false, (short) 1, true, (short) 31, false), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableShortBooleanMap map = this.newWithKeysValues((short) 0, true, (short) 1, false, (short) 31, true, (short) 32, false);
        MutableShortBooleanMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 31, true), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableShortBooleanMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, false), hashMap);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortBooleanMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedShortBooleanMap(this.map), this.map.asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortBooleanMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortBooleanMap(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void booleanIterator_with_remove()
    {
        MutableShortBooleanMap map = this.classUnderTest();
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
