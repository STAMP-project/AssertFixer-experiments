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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyDoubleIterableTestCase;

/**
 * JUnit test for {@link DoubleLongHashMap#keysView}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeysViewTest.stg.
 */
public class DoubleLongHashMapKeysViewTest extends AbstractLazyDoubleIterableTestCase
{
    @Override
    protected LazyDoubleIterable classUnderTest()
    {
        return DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L).keysView();
    }

    @Override
    protected LazyDoubleIterable getEmptyIterable()
    {
        return new DoubleLongHashMap().keysView();
    }

    @Override
    protected LazyDoubleIterable newWith(double element1, double element2)
    {
        return DoubleLongHashMap.newWithKeysValues(element1, 1L, element2, 2L).keysView();
    }
}
