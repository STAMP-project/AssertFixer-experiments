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

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.impl.block.factory.HashingStrategies;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapKeysViewTestCase;

/**
 * JUnit test for {@link ObjectCharHashMapWithHashingStrategy#keysView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeysViewTest.stg.
 */
public class ObjectCharHashMapWithHashingStrategyKeysViewTest extends AbstractObjectCharMapKeysViewTestCase
{
    @Override
    public <T> ObjectCharHashMapWithHashingStrategy<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3)
    {
        return ObjectCharHashMapWithHashingStrategy.newWithKeysValues(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements)
    {
        ObjectCharHashMapWithHashingStrategy<T> map = new ObjectCharHashMapWithHashingStrategy<>(HashingStrategies.nullSafeHashingStrategy(HashingStrategies.<T>defaultStrategy()));
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], (char) i);
        }
        return map.keysView();
    }
}
