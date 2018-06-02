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

import org.eclipse.collections.api.factory.map.primitive.MutableObjectShortMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.ObjectShortMap;

/**
 * MutableObjectShortMapFactoryImpl is a factory implementation which creates instances of type {@link MutableObjectShortMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableObjectShortMapFactoryImpl implements MutableObjectShortMapFactory
{
    INSTANCE;

    @Override
    public <K> MutableObjectShortMap<K> empty()
    {
        return new ObjectShortHashMap(0);
    }

    @Override
    public <K> MutableObjectShortMap<K> of()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectShortMap<K> with()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectShortMap<K> ofAll(ObjectShortMap<? extends K> map)
    {
        return this.withAll(map);
    }

    @Override
    public <K> MutableObjectShortMap<K> withAll(ObjectShortMap<? extends K> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ObjectShortHashMap<>(map);
    }
}
