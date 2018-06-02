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

import org.eclipse.collections.api.factory.map.primitive.MutableCharDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.eclipse.collections.api.map.primitive.CharDoubleMap;

/**
 * MutableCharDoubleMapFactoryImpl is a factory implementation which creates instances of type {@link MutableCharDoubleMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableCharDoubleMapFactoryImpl implements MutableCharDoubleMapFactory
{
    INSTANCE;

    @Override
    public MutableCharDoubleMap empty()
    {
        return new CharDoubleHashMap(0);
    }

    @Override
    public MutableCharDoubleMap of()
    {
        return this.empty();
    }

    @Override
    public MutableCharDoubleMap with()
    {
        return this.empty();
    }

    @Override
    public MutableCharDoubleMap ofAll(CharDoubleMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableCharDoubleMap withAll(CharDoubleMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new CharDoubleHashMap(map);
    }
}
