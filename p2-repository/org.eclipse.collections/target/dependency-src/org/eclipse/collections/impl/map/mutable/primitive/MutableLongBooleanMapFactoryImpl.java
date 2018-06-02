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

import org.eclipse.collections.api.factory.map.primitive.MutableLongBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.MutableLongBooleanMap;
import org.eclipse.collections.api.map.primitive.LongBooleanMap;

/**
 * MutableLongBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link MutableLongBooleanMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongBooleanMapFactoryImpl implements MutableLongBooleanMapFactory
{
    INSTANCE;

    @Override
    public MutableLongBooleanMap empty()
    {
        return new LongBooleanHashMap(0);
    }

    @Override
    public MutableLongBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public MutableLongBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public MutableLongBooleanMap ofAll(LongBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableLongBooleanMap withAll(LongBooleanMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new LongBooleanHashMap(map);
    }
}
