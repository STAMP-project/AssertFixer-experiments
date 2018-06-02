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

import org.eclipse.collections.api.factory.map.primitive.MutableObjectBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectBooleanMap;
import org.eclipse.collections.api.map.primitive.ObjectBooleanMap;

/**
 * MutableObjectBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link MutableObjectBooleanMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableObjectBooleanMapFactoryImpl implements MutableObjectBooleanMapFactory
{
    INSTANCE;

    @Override
    public <K> MutableObjectBooleanMap<K> empty()
    {
        return new ObjectBooleanHashMap(0);
    }

    @Override
    public <K> MutableObjectBooleanMap<K> of()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectBooleanMap<K> with()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectBooleanMap<K> ofAll(ObjectBooleanMap<? extends K> map)
    {
        return this.withAll(map);
    }

    @Override
    public <K> MutableObjectBooleanMap<K> withAll(ObjectBooleanMap<? extends K> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ObjectBooleanHashMap<>(map);
    }
}
