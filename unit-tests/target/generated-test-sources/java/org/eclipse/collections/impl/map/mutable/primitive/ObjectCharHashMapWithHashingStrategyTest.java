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

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.ObjectCharMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.factory.primitive.ObjectCharMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectCharHashMapWithHashingStrategy}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyTest.stg.
 */
public class ObjectCharHashMapWithHashingStrategyTest extends ObjectCharHashMapTestCase
{
    private static final HashingStrategy<String> STRING_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<String>()
    {
        public int computeHashCode(String object)
        {
            return object.hashCode();
        }

        public boolean equals(String object1, String object2)
        {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Integer> INTEGER_HASHING_STRATEGY = HashingStrategies.nullSafeHashingStrategy(new HashingStrategy<Integer>()
    {
        public int computeHashCode(Integer object)
        {
            return object.hashCode();
        }

        public boolean equals(Integer object1, Integer object2)
        {
            return object1.equals(object2);
        }
    });

    private static final HashingStrategy<Person> FIRST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);
    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);
    private static final HashingStrategy<Person> CONSTANT_HASHCODE_STRATEGY = new HashingStrategy<Person>() {
       @Override
       public int computeHashCode(Person object)
       {
           return 0;
       }

       @Override
       public boolean equals(Person person1, Person person2)
       {
           return person1.getLastName().equals(person2.getLastName());
       }
    };

    private static final Person JOHNSMITH = new Person("John", "Smith");
    private static final Person JANESMITH = new Person("Jane", "Smith");
    private static final Person JOHNDOE = new Person("John", "Doe");
    private static final Person JANEDOE = new Person("Jane", "Doe");

    private final ObjectCharHashMapWithHashingStrategy<String> map = this.classUnderTest();

    @Override
    protected ObjectCharHashMapWithHashingStrategy<String> classUnderTest()
    {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, "0", (char) 0, "1", (char) 1, "2", (char) 2);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1)
    {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2)
    {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3)
    {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4)
    {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectCharHashMapWithHashingStrategy<T> getEmptyMap()
    {
        return new ObjectCharHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()));
    }

    @Override
    protected MutableObjectCharMap newMapWithInitialCapacity(int size)
    {
        return new ObjectCharHashMapWithHashingStrategy(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.defaultStrategy()), size);
    }

    @Override
    protected Class getTargetClass()
    {
        return ObjectCharHashMapWithHashingStrategy.class;
    }

    @Override
    @Test
    public void select()
    {
        super.select();

        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(
                        LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
                Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(JOHNDOE, (char) 2), map.select((argument1, argument2) -> "Doe".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();

        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(
                LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(JOHNDOE, (char) 2), map.reject((argument1, argument2) -> "Smith".equals(argument1.getLastName())));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();

        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(
                LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        CharToObjectFunction f = argument1 -> (int) argument1 * 2;
        Assert.assertEquals(FastList.newListWith(4, 8), map.collect(f));
    }

    @Test
    public void contains_with_hashing_strategy()
    {
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(
                LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        Assert.assertTrue(map.containsKey(JOHNDOE));
        Assert.assertTrue(map.containsValue((char) 2));
        Assert.assertTrue(map.containsKey(JOHNSMITH));
        Assert.assertTrue(map.containsValue((char) 4));
        Assert.assertTrue(map.containsKey(JANEDOE));
        Assert.assertTrue(map.containsKey(JANESMITH));

        Assert.assertFalse(map.containsValue((char) 1));
        Assert.assertFalse(map.containsValue((char) 3));
    }

    @Test
    public void remove_with_hashing_strategy()
    {
        ObjectCharHashMapWithHashingStrategy<Person> map = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(
                LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);

        map.remove(JANEDOE);
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (char) 4), map);
        map.remove(JOHNSMITH);

        Verify.assertEmpty(map);

        MutableList<String> collidingKeys = generateCollisions();
        ObjectCharHashMapWithHashingStrategy<String> map2 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(
                STRING_HASHING_STRATEGY, collidingKeys.get(0), (char) 0, collidingKeys.get(1), (char) 1, collidingKeys.get(2), (char) 2, collidingKeys.get(3), (char) 3);
        map2.remove(collidingKeys.get(3));
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(0), (char) 0, collidingKeys.get(1), (char) 1, collidingKeys.get(2), (char) 2), map2);
        map2.remove(collidingKeys.get(0));
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, collidingKeys.get(1), (char) 1, collidingKeys.get(2), (char) 2), map2);
        Verify.assertSize(2, map2);

        ObjectCharHashMapWithHashingStrategy<Integer> map3 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1,  (char) 1, null, (char) 2, 3, (char) 3);
        map3.remove(null);
        Assert.assertEquals(ObjectCharHashMapWithHashingStrategy.newWithKeysValues(INTEGER_HASHING_STRATEGY, 1, (char) 1, 3, (char) 3), map3);
    }

    @Test
    public void equals_with_hashing_strategy()
    {
        ObjectCharHashMapWithHashingStrategy<Person> map1 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 1, JOHNSMITH, (char) 1, JANESMITH, (char) 1);
        ObjectCharHashMapWithHashingStrategy<Person> map2 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(FIRST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 1, JOHNSMITH, (char) 1, JANESMITH, (char) 1);
        ObjectCharHashMapWithHashingStrategy<Person> mapWithConstantHashCodeStrategy = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(CONSTANT_HASHCODE_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 1, JOHNSMITH, (char) 1, JANESMITH, (char) 1);

        Assert.assertEquals(map1, map2);
        Assert.assertEquals(map2, map1);
        Assert.assertEquals(mapWithConstantHashCodeStrategy, map2);
        Assert.assertEquals(map2, mapWithConstantHashCodeStrategy);
        Assert.assertNotEquals(map1.hashCode(), map2.hashCode());
        Assert.assertNotEquals(map1.hashCode(), mapWithConstantHashCodeStrategy.hashCode());
        Assert.assertNotEquals(map2.hashCode(), mapWithConstantHashCodeStrategy.hashCode());

        ObjectCharHashMapWithHashingStrategy<Person> map3 = ObjectCharHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);

        ObjectCharHashMapWithHashingStrategy<Person> map4 = ObjectCharHashMapWithHashingStrategy.newMap(map3);
        ObjectCharMap hashMap = ObjectCharMaps.mutable.withAll(map3);

        Verify.assertEqualsAndHashCode(map3, map4);
        Assert.assertTrue(map3.equals(hashMap) && hashMap.equals(map3) && map3.hashCode() != hashMap.hashCode());

        ObjectCharHashMap<Person> objectMap = ObjectCharHashMap.newWithKeysValues(JOHNDOE, (char) 1, JANEDOE, (char) 2, JOHNSMITH, (char) 3, JANESMITH, (char) 4);
        ObjectCharHashMapWithHashingStrategy<Person> map5 = ObjectCharHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY, objectMap);
        Assert.assertNotEquals(map5, objectMap);
    }

    @Test
    public void put_get_with_hashing_strategy()
    {
        ObjectCharHashMapWithHashingStrategy<String> map = this.classUnderTest();
        map.put(null, (char) 5);

        //Testing getting values from no chains
        Assert.assertEquals((char) 1, map.get("1"));
        Assert.assertEquals((char) 2, map.get("2"));
        Assert.assertEquals((char) 5, map.get(null));

        ObjectCharHashMapWithHashingStrategy<Person> map2 = ObjectCharHashMapWithHashingStrategy.newMap(LAST_NAME_HASHING_STRATEGY);
        map2.put(JOHNSMITH, (char) 1);
        Assert.assertEquals((char) 1, map2.get(JOHNSMITH));
        map2.put(JANESMITH, (char) 2);
        Assert.assertEquals((char) 2, map2.get(JOHNSMITH));
    }
}
