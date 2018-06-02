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

import org.eclipse.collections.api.factory.map.primitive.MutableShortByteMapFactory;
import org.eclipse.collections.api.map.primitive.MutableShortByteMap;
import org.eclipse.collections.api.map.primitive.ShortByteMap;

/**
 * MutableShortByteMapFactoryImpl is a factory implementation which creates instances of type {@link MutableShortByteMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortByteMapFactoryImpl implements MutableShortByteMapFactory
{
    INSTANCE;

    @Override
    public MutableShortByteMap empty()
    {
        return new ShortByteHashMap(0);
    }

    @Override
    public MutableShortByteMap of()
    {
        return this.empty();
    }

    @Override
    public MutableShortByteMap with()
    {
        return this.empty();
    }

    @Override
    public MutableShortByteMap ofAll(ShortByteMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableShortByteMap withAll(ShortByteMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ShortByteHashMap(map);
    }
}
