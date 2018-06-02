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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyCharIterableTestCase;

/**
 * JUnit test for {@link CharCharHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class CharCharHashMapKeysViewTest extends AbstractLazyCharIterableTestCase
{
    @Override
    protected LazyCharIterable classUnderTest()
    {
        return CharCharHashMap.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3).keysView();
    }

    @Override
    protected LazyCharIterable getEmptyIterable()
    {
        return new CharCharHashMap().keysView();
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2)
    {
        return CharCharHashMap.newWithKeysValues(element1, (char) 1, element2, (char) 2).keysView();
    }
}
