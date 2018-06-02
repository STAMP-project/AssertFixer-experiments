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

import java.lang.reflect.Field;
import java.util.Iterator;

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectIntHashMapTestCase extends AbstractMutableObjectIntMapTestCase
{
    private final MutableObjectIntMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectIntMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectIntMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);

        MutableObjectIntMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        this.newMapWithInitialCapacity(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(1.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        IntToIntFunction function = (int parameter) -> parameter;

        hashMap.updateValue(2.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        hashMap.getIfAbsentPut(2.0f, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        IntFunction0 function = () -> 5;

        hashMap.getIfAbsentPut(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        IntFunction<Integer> function = (Integer object) -> (int) object.intValue();

        hashMap.getIfAbsentPutWith(2.0f, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0f, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0f, function, Integer.valueOf(5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        IntFunction<Float> function = (Float floatParameter) -> (int) floatParameter.floatValue();

        hashMap.getIfAbsentPutWithKey(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2.0f, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectIntMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, i);
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableObjectIntMap<String> map0 = this.newWithKeysValues("0", 0, "1", 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(this.newWithKeysValues("0", 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent("0", 100));

        MutableObjectIntMap<String> map1 = this.newWithKeysValues("0", 0, "1", 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(this.newWithKeysValues("1", 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent("1", 100));

        Assert.assertEquals(100, this.map.removeKeyIfAbsent("5", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("50", 100));
        Assert.assertEquals(this.newWithKeysValues("0", 0, "1", 1, "2", 2), this.map);
        Assert.assertEquals(0, this.map.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(this.newWithKeysValues("1", 1, "2", 2), this.map);
        Assert.assertEquals(1, this.map.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(this.newWithKeysValues("2", 2), this.map);
        Assert.assertEquals(2, this.map.removeKeyIfAbsent("2", 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("0", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("1", 100));
        Assert.assertEquals(100, this.map.removeKeyIfAbsent("2", 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0), 1);
        this.map.put(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, this.map.removeKeyIfAbsent(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, this.map.removeKeyIfAbsent(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0, this.map.get(AbstractMutableObjectIntMapTestCase.generateCollisions().get(1)));

        this.map.put(null, 3);

        Assert.assertEquals(3, this.map.get(null));
        Assert.assertEquals(3, this.map.removeKeyIfAbsent(null, 100));
        Assert.assertEquals(0, this.map.get(null));
    }

    @Test
    public void putWithRehash() throws Exception
    {
        MutableObjectIntMap<Integer> hashMap = this.getEmptyMap();
        for (int each = 2; each < 10; each++)
        {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }

        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int each = 2; each < 10; each++)
        {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put(10, 10);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll()
    {
        MutableObjectIntMap<Integer> hashMap = this.getEmptyMap();
        MutableObjectIntMap<Integer> copyMap = this.getEmptyMap();

        for (int each = 1; each < 11; each++)
        {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }

        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);

        for (int each = 1; each < 11; each++)
        {
            Assert.assertTrue(hashMap.containsKey(each));
        }

        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto()
    {
        MutableObjectIntMap<Integer> hashMap = this.newWithKeysValues(1, 2, 2, 3, 3, 4, 4, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void put_every_slot()
    {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void remove_iterator_every_slot()
    {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableObjectIntMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        IntFunction<String> functionLength = (String string) -> string.length();

        MutableObjectIntMap<String> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(9, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"));
            Assert.assertEquals(9, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        IntFunction<Integer> function = Integer::intValue;

        MutableObjectIntMap<Integer> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(each));
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot()
    {
        IntFunction0 factory = () -> 100;

        MutableObjectIntMap<String> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(100, hashMap.getIfAbsentPut(String.valueOf(each), factory));
            Assert.assertEquals(100, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableObjectIntMap<String> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertEquals(0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction));
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ObjectIntMaps.class);
    }
}
