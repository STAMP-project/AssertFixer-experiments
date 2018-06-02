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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterableTestCase;

/**
 * JUnit test for {@link LongShortHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class LongShortHashMapKeysViewTest extends AbstractLazyLongIterableTestCase
{
    @Override
    protected LazyLongIterable classUnderTest()
    {
        return LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3).keysView();
    }

    @Override
    protected LazyLongIterable getEmptyIterable()
    {
        return new LongShortHashMap().keysView();
    }

    @Override
    protected LazyLongIterable newWith(long element1, long element2)
    {
        return LongShortHashMap.newWithKeysValues(element1, (short) 1, element2, (short) 2).keysView();
    }
}
