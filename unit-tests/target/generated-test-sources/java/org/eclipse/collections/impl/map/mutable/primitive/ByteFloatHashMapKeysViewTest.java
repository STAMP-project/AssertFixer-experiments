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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyByteIterableTestCase;

/**
 * JUnit test for {@link ByteFloatHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class ByteFloatHashMapKeysViewTest extends AbstractLazyByteIterableTestCase
{
    @Override
    protected LazyByteIterable classUnderTest()
    {
        return ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f).keysView();
    }

    @Override
    protected LazyByteIterable getEmptyIterable()
    {
        return new ByteFloatHashMap().keysView();
    }

    @Override
    protected LazyByteIterable newWith(byte element1, byte element2)
    {
        return ByteFloatHashMap.newWithKeysValues(element1, 1.0f, element2, 2.0f).keysView();
    }
}
