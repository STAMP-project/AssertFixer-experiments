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

import org.eclipse.collections.api.factory.map.primitive.MutableFloatFloatMapFactory;
import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.eclipse.collections.api.map.primitive.FloatFloatMap;

/**
 * MutableFloatFloatMapFactoryImpl is a factory implementation which creates instances of type {@link MutableFloatFloatMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableFloatFloatMapFactoryImpl implements MutableFloatFloatMapFactory
{
    INSTANCE;

    @Override
    public MutableFloatFloatMap empty()
    {
        return new FloatFloatHashMap(0);
    }

    @Override
    public MutableFloatFloatMap of()
    {
        return this.empty();
    }

    @Override
    public MutableFloatFloatMap with()
    {
        return this.empty();
    }

    @Override
    public MutableFloatFloatMap ofAll(FloatFloatMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableFloatFloatMap withAll(FloatFloatMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new FloatFloatHashMap(map);
    }
}
