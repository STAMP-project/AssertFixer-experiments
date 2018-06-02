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

import org.eclipse.collections.api.factory.map.primitive.MutableFloatDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.api.map.primitive.FloatDoubleMap;

/**
 * MutableFloatDoubleMapFactoryImpl is a factory implementation which creates instances of type {@link MutableFloatDoubleMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableFloatDoubleMapFactoryImpl implements MutableFloatDoubleMapFactory
{
    INSTANCE;

    @Override
    public MutableFloatDoubleMap empty()
    {
        return new FloatDoubleHashMap(0);
    }

    @Override
    public MutableFloatDoubleMap of()
    {
        return this.empty();
    }

    @Override
    public MutableFloatDoubleMap with()
    {
        return this.empty();
    }

    @Override
    public MutableFloatDoubleMap ofAll(FloatDoubleMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableFloatDoubleMap withAll(FloatDoubleMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new FloatDoubleHashMap(map);
    }
}
