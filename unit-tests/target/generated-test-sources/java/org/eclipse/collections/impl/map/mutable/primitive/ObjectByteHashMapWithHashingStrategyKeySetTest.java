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

import java.util.Set;

import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.map.primitive.MutableObjectByteMap;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ObjectByteHashMapWithHashingStrategy#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategyKeySetTest.stg.
 */
public class ObjectByteHashMapWithHashingStrategyKeySetTest extends ObjectByteHashMapKeySetTestCase
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

    private static final HashingStrategy<Person> FIRST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_FIRST);
    private static final HashingStrategy<Person> LAST_NAME_HASHING_STRATEGY = HashingStrategies.fromFunction(Person.TO_LAST);

    private static final Person JOHNSMITH = new Person("John", "Smith");
    private static final Person JANESMITH = new Person("Jane", "Smith");
    private static final Person JOHNDOE = new Person("John", "Doe");
    private static final Person JANEDOE = new Person("Jane", "Doe");

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1)
    {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1);
    }

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2)
    {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2);
    }

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3)
    {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3);
    }

    @Override
    public MutableObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3, String key4, byte value4)
    {
        return ObjectByteHashMapWithHashingStrategy.newWithKeysValues(STRING_HASHING_STRATEGY, key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectByteMap<String> newEmptyMap()
    {
        return ObjectByteHashMapWithHashingStrategy.newMap(STRING_HASHING_STRATEGY);
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();

        Set<Person> people = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4).keySet();

        Verify.assertSize(2, people);

        Verify.assertContains(JANEDOE, people);
        Verify.assertContains(JOHNDOE, people);
        Verify.assertContains(JANESMITH, people);
        Verify.assertContains(JOHNSMITH, people);
    }

    @Override
    @Test
    public void removeFromKeySet()
    {
        super.removeFromKeySet();

        MutableObjectByteMap<Person> map = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4);
        Set<Person> people = map.keySet();
        people.remove(JOHNDOE);
        Assert.assertEquals(map, ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNSMITH, (byte) 4));
    }

    @Override
    @Test
    public void keySetEqualsAndHashCode()
    {
        super.keySetEqualsAndHashCode();

        Set<Person> people1 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JOHNSMITH, (byte) 3).keySet();
        Set<Person> people2 = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JANEDOE, (byte) 2, JANESMITH, (byte) 4).keySet();

        Assert.assertTrue(people1.hashCode() == people2.hashCode());
    }

    @Override
    @Test
    public void keySetToArray()
    {
        super.keySetToArray();

        Set<Person> people = ObjectByteHashMapWithHashingStrategy.newWithKeysValues(LAST_NAME_HASHING_STRATEGY, JOHNDOE, (byte) 1, JANEDOE, (byte) 2, JOHNSMITH, (byte) 3, JANESMITH, (byte) 4).keySet();
        Object[] keys1 = {JOHNDOE, JOHNSMITH};
        Assert.assertArrayEquals(people.toArray(), keys1);
        Person[] keys2 = new Person[2];
        Assert.assertArrayEquals(people.toArray(keys2), keys1);
    }
}
