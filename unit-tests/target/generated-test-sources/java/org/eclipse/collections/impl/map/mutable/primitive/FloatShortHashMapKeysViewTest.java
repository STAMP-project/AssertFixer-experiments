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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyFloatIterableTestCase;

/**
 * JUnit test for {@link FloatShortHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class FloatShortHashMapKeysViewTest extends AbstractLazyFloatIterableTestCase
{
    @Override
    protected LazyFloatIterable classUnderTest()
    {
        return FloatShortHashMap.newWithKeysValues(1.0f, (short) 1, 2.0f, (short) 2, 3.0f, (short) 3).keysView();
    }

    @Override
    protected LazyFloatIterable getEmptyIterable()
    {
        return new FloatShortHashMap().keysView();
    }

    @Override
    protected LazyFloatIterable newWith(float element1, float element2)
    {
        return FloatShortHashMap.newWithKeysValues(element1, (short) 1, element2, (short) 2).keysView();
    }
}
