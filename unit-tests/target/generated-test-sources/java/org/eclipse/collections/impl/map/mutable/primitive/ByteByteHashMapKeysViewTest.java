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
 * JUnit test for {@link ByteByteHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class ByteByteHashMapKeysViewTest extends AbstractLazyByteIterableTestCase
{
    @Override
    protected LazyByteIterable classUnderTest()
    {
        return ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3).keysView();
    }

    @Override
    protected LazyByteIterable getEmptyIterable()
    {
        return new ByteByteHashMap().keysView();
    }

    @Override
    protected LazyByteIterable newWith(byte element1, byte element2)
    {
        return ByteByteHashMap.newWithKeysValues(element1, (byte) 1, element2, (byte) 2).keysView();
    }
}
