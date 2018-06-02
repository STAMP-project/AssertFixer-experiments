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

import org.eclipse.collections.api.factory.map.primitive.MutableObjectCharMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.ObjectCharMap;

/**
 * MutableObjectCharMapFactoryImpl is a factory implementation which creates instances of type {@link MutableObjectCharMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableObjectCharMapFactoryImpl implements MutableObjectCharMapFactory
{
    INSTANCE;

    @Override
    public <K> MutableObjectCharMap<K> empty()
    {
        return new ObjectCharHashMap(0);
    }

    @Override
    public <K> MutableObjectCharMap<K> of()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectCharMap<K> with()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectCharMap<K> ofAll(ObjectCharMap<? extends K> map)
    {
        return this.withAll(map);
    }

    @Override
    public <K> MutableObjectCharMap<K> withAll(ObjectCharMap<? extends K> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ObjectCharHashMap<>(map);
    }
}
