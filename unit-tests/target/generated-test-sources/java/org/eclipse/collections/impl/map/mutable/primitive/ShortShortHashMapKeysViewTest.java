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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyShortIterableTestCase;

/**
 * JUnit test for {@link ShortShortHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class ShortShortHashMapKeysViewTest extends AbstractLazyShortIterableTestCase
{
    @Override
    protected LazyShortIterable classUnderTest()
    {
        return ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3).keysView();
    }

    @Override
    protected LazyShortIterable getEmptyIterable()
    {
        return new ShortShortHashMap().keysView();
    }

    @Override
    protected LazyShortIterable newWith(short element1, short element2)
    {
        return ShortShortHashMap.newWithKeysValues(element1, (short) 1, element2, (short) 2).keysView();
    }
}
