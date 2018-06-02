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

import org.eclipse.collections.api.factory.map.primitive.MutableObjectLongMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;

/**
 * MutableObjectLongMapFactoryImpl is a factory implementation which creates instances of type {@link MutableObjectLongMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableObjectLongMapFactoryImpl implements MutableObjectLongMapFactory
{
    INSTANCE;

    @Override
    public <K> MutableObjectLongMap<K> empty()
    {
        return new ObjectLongHashMap(0);
    }

    @Override
    public <K> MutableObjectLongMap<K> of()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectLongMap<K> with()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectLongMap<K> ofAll(ObjectLongMap<? extends K> map)
    {
        return this.withAll(map);
    }

    @Override
    public <K> MutableObjectLongMap<K> withAll(ObjectLongMap<? extends K> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ObjectLongHashMap<>(map);
    }
}
