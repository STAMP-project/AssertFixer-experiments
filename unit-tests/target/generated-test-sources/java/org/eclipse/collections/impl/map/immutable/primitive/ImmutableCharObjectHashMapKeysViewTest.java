/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyCharIterableTestCase;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;

/**
 * JUnit test for {@link ImmutableCharObjectHashMap#keysView}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeysViewTest.stg.
 */
public class ImmutableCharObjectHashMapKeysViewTest extends AbstractLazyCharIterableTestCase
{
    @Override
    protected LazyCharIterable classUnderTest()
    {
        return CharObjectHashMap.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3).toImmutable().keysView();
    }

    @Override
    protected LazyCharIterable getEmptyIterable()
    {
        return CharObjectHashMap.newMap().toImmutable().keysView();
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2)
    {
        return CharObjectHashMap.newWithKeysValues(element1, 1, element2, 2).toImmutable().keysView();
    }
}
