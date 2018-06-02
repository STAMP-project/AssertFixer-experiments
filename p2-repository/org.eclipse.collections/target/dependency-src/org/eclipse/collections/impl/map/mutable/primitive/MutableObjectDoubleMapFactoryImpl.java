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

import org.eclipse.collections.api.factory.map.primitive.MutableObjectDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;

/**
 * MutableObjectDoubleMapFactoryImpl is a factory implementation which creates instances of type {@link MutableObjectDoubleMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableObjectDoubleMapFactoryImpl implements MutableObjectDoubleMapFactory
{
    INSTANCE;

    @Override
    public <K> MutableObjectDoubleMap<K> empty()
    {
        return new ObjectDoubleHashMap(0);
    }

    @Override
    public <K> MutableObjectDoubleMap<K> of()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectDoubleMap<K> with()
    {
        return this.empty();
    }

    @Override
    public <K> MutableObjectDoubleMap<K> ofAll(ObjectDoubleMap<? extends K> map)
    {
        return this.withAll(map);
    }

    @Override
    public <K> MutableObjectDoubleMap<K> withAll(ObjectDoubleMap<? extends K> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ObjectDoubleHashMap<>(map);
    }
}
