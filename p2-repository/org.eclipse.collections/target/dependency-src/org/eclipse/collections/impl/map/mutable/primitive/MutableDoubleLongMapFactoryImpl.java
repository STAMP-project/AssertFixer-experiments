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

import org.eclipse.collections.api.factory.map.primitive.MutableDoubleLongMapFactory;
import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.eclipse.collections.api.map.primitive.DoubleLongMap;

/**
 * MutableDoubleLongMapFactoryImpl is a factory implementation which creates instances of type {@link MutableDoubleLongMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableDoubleLongMapFactoryImpl implements MutableDoubleLongMapFactory
{
    INSTANCE;

    @Override
    public MutableDoubleLongMap empty()
    {
        return new DoubleLongHashMap(0);
    }

    @Override
    public MutableDoubleLongMap of()
    {
        return this.empty();
    }

    @Override
    public MutableDoubleLongMap with()
    {
        return this.empty();
    }

    @Override
    public MutableDoubleLongMap ofAll(DoubleLongMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableDoubleLongMap withAll(DoubleLongMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new DoubleLongHashMap(map);
    }
}
