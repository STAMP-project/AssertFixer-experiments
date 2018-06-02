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

import org.eclipse.collections.api.factory.map.primitive.MutableShortLongMapFactory;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.map.primitive.ShortLongMap;

/**
 * MutableShortLongMapFactoryImpl is a factory implementation which creates instances of type {@link MutableShortLongMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortLongMapFactoryImpl implements MutableShortLongMapFactory
{
    INSTANCE;

    @Override
    public MutableShortLongMap empty()
    {
        return new ShortLongHashMap(0);
    }

    @Override
    public MutableShortLongMap of()
    {
        return this.empty();
    }

    @Override
    public MutableShortLongMap with()
    {
        return this.empty();
    }

    @Override
    public MutableShortLongMap ofAll(ShortLongMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableShortLongMap withAll(ShortLongMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ShortLongHashMap(map);
    }
}
