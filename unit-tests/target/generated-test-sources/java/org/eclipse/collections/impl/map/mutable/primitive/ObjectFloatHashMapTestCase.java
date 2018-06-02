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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.factory.primitive.ObjectFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectFloatHashMapTestCase extends AbstractMutableObjectFloatMapTestCase
{
    private final MutableObjectFloatMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectFloatMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectFloatMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);

        MutableObjectFloatMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
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

        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f);

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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        FloatToFloatFunction function = (float parameter) -> parameter;

        hashMap.updateValue(2.0f, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, 0.0f, function); // putting in a slot marked REMOVED
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
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (float) i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, 9.0f); // putting in a slot marked REMOVED
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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        hashMap.getIfAbsentPut(2.0f, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, 5.0f); //putting in a slot marked REMOVED
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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        FloatFunction0 function = () -> 5.0f;

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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        FloatFunction<Integer> function = (Integer object) -> (float) object.intValue();

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
        MutableObjectFloatMap<Float> hashMap = this.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        FloatFunction<Float> function = (Float floatParameter) -> (float) floatParameter.floatValue();

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
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (float) i);
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableObjectFloatMap<String> map0 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("0", 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent("0", 100.0f), 0.0f);

        MutableObjectFloatMap<String> map1 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("1", 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent("1", 100.0f), 0.0f);

        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("5", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("50", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f), this.map);
        Assert.assertEquals(0.0f, this.map.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("1", 1.0f, "2", 2.0f), this.map);
        Assert.assertEquals(1.0f, this.map.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(this.newWithKeysValues("2", 2.0f), this.map);
        Assert.assertEquals(2.0f, this.map.removeKeyIfAbsent("2", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("0", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("1", 100.0f), 0.0f);
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent("2", 100.0f), 0.0f);
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0), 1.0f);
        this.map.put(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0)), 0.0f);
        Assert.assertEquals(1.0f, this.map.removeKeyIfAbsent(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(0)), 0.0f);

        Assert.assertEquals(2.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1)), 0.0f);
        Assert.assertEquals(2.0f, this.map.removeKeyIfAbsent(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.get(AbstractMutableObjectFloatMapTestCase.generateCollisions().get(1)), 0.0f);

        this.map.put(null, 3.0f);

        Assert.assertEquals(3.0f, this.map.get(null), 0.0f);
        Assert.assertEquals(3.0f, this.map.removeKeyIfAbsent(null, 100.0f), 0.0f);
        Assert.assertEquals(0.0f, this.map.get(null), 0.0f);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        for (float each = 2; each < 10; each++)
        {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }

        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (float each = 2; each < 10; each++)
        {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put(10.0f, 10.0f);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll()
    {
        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();
        MutableObjectFloatMap<Float> copyMap = this.getEmptyMap();

        for (float each = 1; each < 11; each++)
        {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }

        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);

        for (float each = 1; each < 11; each++)
        {
            Assert.assertTrue(hashMap.containsKey(each));
        }

        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto()
    {
        MutableObjectFloatMap<Integer> hashMap = this.newWithKeysValues(1, 2.0f, 2, 3.0f, 3, 4.0f, 4, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void put_every_slot()
    {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void remove_iterator_every_slot()
    {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        FloatFunction<String> functionLength = (String string) -> string.length();

        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            Assert.assertEquals(9.0f, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"), 0.0f);
            Assert.assertEquals(9.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        FloatFunction<Float> function = Float::floatValue;

        MutableObjectFloatMap<Float> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(each), 0.0f);
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function), 0.0f);
            Assert.assertEquals(each, hashMap.get(each), 0.0f);
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot()
    {
        FloatFunction0 factory = () -> 100.0f;

        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            Assert.assertEquals(100.0f, hashMap.getIfAbsentPut(String.valueOf(each), factory), 0.0f);
            Assert.assertEquals(100.0f, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1;

        MutableObjectFloatMap<String> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertEquals(0.0f, hashMap.get(String.valueOf(each)), 0.0f);
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction), 0.0f);
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)), 0.0f);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ObjectFloatMaps.class);
    }
}
