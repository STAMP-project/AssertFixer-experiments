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
 * JUnit test for {@link FloatByteHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class FloatByteHashMapKeysViewTest extends AbstractLazyFloatIterableTestCase
{
    @Override
    protected LazyFloatIterable classUnderTest()
    {
        return FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3).keysView();
    }

    @Override
    protected LazyFloatIterable getEmptyIterable()
    {
        return new FloatByteHashMap().keysView();
    }

    @Override
    protected LazyFloatIterable newWith(float element1, float element2)
    {
        return FloatByteHashMap.newWithKeysValues(element1, (byte) 1, element2, (byte) 2).keysView();
    }
}
