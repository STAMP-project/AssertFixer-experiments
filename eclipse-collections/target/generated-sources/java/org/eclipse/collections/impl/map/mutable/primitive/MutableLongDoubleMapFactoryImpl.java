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

import org.eclipse.collections.api.factory.map.primitive.MutableLongDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.api.map.primitive.LongDoubleMap;

/**
 * MutableLongDoubleMapFactoryImpl is a factory implementation which creates instances of type {@link MutableLongDoubleMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongDoubleMapFactoryImpl implements MutableLongDoubleMapFactory
{
    INSTANCE;

    @Override
    public MutableLongDoubleMap empty()
    {
        return new LongDoubleHashMap(0);
    }

    @Override
    public MutableLongDoubleMap of()
    {
        return this.empty();
    }

    @Override
    public MutableLongDoubleMap with()
    {
        return this.empty();
    }

    @Override
    public MutableLongDoubleMap ofAll(LongDoubleMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableLongDoubleMap withAll(LongDoubleMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new LongDoubleHashMap(map);
    }
}
