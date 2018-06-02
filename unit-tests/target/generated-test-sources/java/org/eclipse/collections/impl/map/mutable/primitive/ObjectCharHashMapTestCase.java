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

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

public abstract class ObjectCharHashMapTestCase extends AbstractMutableObjectCharMapTestCase
{
    private final MutableObjectCharMap<String> map = this.classUnderTest();

    private Class targetClass = this.getTargetClass();

    protected abstract MutableObjectCharMap newMapWithInitialCapacity(int size);

    protected abstract Class getTargetClass();

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = targetClass.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = targetClass.getDeclaredField("values");
        values.setAccessible(true);

        MutableObjectCharMap<String> hashMap = this.newMapWithInitialCapacity(3);
        Assert.assertEquals(8L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);

        MutableObjectCharMap<String> hashMap2 = this.newMapWithInitialCapacity(15);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
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

        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(this.getEmptyMap(), hashMap);
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = targetClass.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = targetClass.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3);

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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        CharToCharFunction function = (char parameter) -> parameter;

        hashMap.updateValue(2.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, (char) 0, function); // putting in a slot marked REMOVED
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
        MutableObjectCharMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (char) i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, (char) 9); // putting in a slot marked REMOVED
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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        hashMap.getIfAbsentPut(2.0f, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, (char) 5); //putting in a slot marked REMOVED
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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        CharFunction0 function = () -> (char) 5;

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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        CharFunction<Integer> function = (Integer object) -> (char) object.intValue();

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
        MutableObjectCharMap<Float> hashMap = this.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        CharFunction<Float> function = (Float floatParameter) -> (char) floatParameter.floatValue();

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
        MutableObjectCharMap<Float> hashMap = this.getEmptyMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (char) i);
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, (char) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableObjectCharMap<String> map0 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("0", (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent("0", (char) 100));

        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("1", (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent("1", (char) 100));

        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("5", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("50", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2), this.map);
        Assert.assertEquals((char) 0, this.map.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("1", (char) 1, "2", (char) 2), this.map);
        Assert.assertEquals((char) 1, this.map.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals(this.newWithKeysValues("2", (char) 2), this.map);
        Assert.assertEquals((char) 2, this.map.removeKeyIfAbsent("2", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("0", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("1", (char) 100));
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent("2", (char) 100));
        Assert.assertEquals(this.getEmptyMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 1);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, this.map.removeKeyIfAbsent(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals((char) 0, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals((char) 2, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, this.map.removeKeyIfAbsent(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals((char) 0, this.map.get(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1)));

        this.map.put(null, (char) 3);

        Assert.assertEquals((char) 3, this.map.get(null));
        Assert.assertEquals((char) 3, this.map.removeKeyIfAbsent(null, (char) 100));
        Assert.assertEquals((char) 0, this.map.get(null));
    }

    @Test
    public void putWithRehash() throws Exception
    {
        MutableObjectCharMap<Character> hashMap = this.getEmptyMap();
        for (char each = 2; each < 10; each++)
        {
            Assert.assertFalse(hashMap.containsKey(each));
            hashMap.put(each, each);
        }

        Field keys = targetClass.getDeclaredField("keys");
        Field values = targetClass.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (char each = 2; each < 10; each++)
        {
            Assert.assertTrue(hashMap.containsKey(each));
            Assert.assertTrue(hashMap.containsValue(each));
        }
        hashMap.put((char) 10, (char) 10);
        Assert.assertEquals(32L, ((Object[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void testPutAll()
    {
        MutableObjectCharMap<Character> hashMap = this.getEmptyMap();
        MutableObjectCharMap<Character> copyMap = this.getEmptyMap();

        for (char each = 1; each < 11; each++)
        {
            Assert.assertFalse(hashMap.containsKey(each));
            copyMap.put(each, each);
        }

        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(10, hashMap);

        for (char each = 1; each < 11; each++)
        {
            Assert.assertTrue(hashMap.containsKey(each));
        }

        Assert.assertEquals(hashMap, copyMap);
    }

    @Test
    public void injectInto()
    {
        MutableObjectCharMap<Integer> hashMap = this.newWithKeysValues(1, (char) 2, 2, (char) 3, 3, (char) 4, 4, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void put_every_slot()
    {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
            hashMap.remove(String.valueOf(each));
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void remove_iterator_every_slot()
    {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            hashMap.put(String.valueOf(each), each);
            Iterator<String> iterator = hashMap.keySet().iterator();
            Assert.assertTrue(iterator.hasNext());
            Assert.assertEquals(String.valueOf(each), iterator.next());
            iterator.remove();
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            hashMap.getIfAbsentPut(String.valueOf(each), each);
            Assert.assertEquals(each, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();

        MutableObjectCharMap<String> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals((char) 9, hashMap.getIfAbsentPutWith(String.valueOf(each), functionLength, "123456789"));
            Assert.assertEquals((char) 9, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        CharFunction<Character> function = Character::charValue;

        MutableObjectCharMap<Character> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(each));
            Assert.assertEquals(each, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot()
    {
        CharFunction0 factory = () -> (char) 100;

        MutableObjectCharMap<String> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals((char) 100, hashMap.getIfAbsentPut(String.valueOf(each), factory));
            Assert.assertEquals((char) 100, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + 1);

        MutableObjectCharMap<String> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertEquals((char) 0, hashMap.get(String.valueOf(each)));
            Assert.assertEquals(each + 1, hashMap.updateValue(String.valueOf(each), each, incrementFunction));
            Assert.assertEquals(each + 1, hashMap.get(String.valueOf(each)));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ObjectCharMaps.class);
    }
}
