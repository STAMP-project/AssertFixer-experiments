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

import org.eclipse.collections.api.factory.map.primitive.MutableShortBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.MutableShortBooleanMap;
import org.eclipse.collections.api.map.primitive.ShortBooleanMap;

/**
 * MutableShortBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link MutableShortBooleanMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortBooleanMapFactoryImpl implements MutableShortBooleanMapFactory
{
    INSTANCE;

    @Override
    public MutableShortBooleanMap empty()
    {
        return new ShortBooleanHashMap(0);
    }

    @Override
    public MutableShortBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public MutableShortBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public MutableShortBooleanMap ofAll(ShortBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableShortBooleanMap withAll(ShortBooleanMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ShortBooleanHashMap(map);
    }
}
