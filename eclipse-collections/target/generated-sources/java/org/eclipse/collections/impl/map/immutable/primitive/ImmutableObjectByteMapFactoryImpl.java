/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectByteMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.ObjectByteMap;

/**
 * ImmutableObjectByteMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableObjectByteMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableObjectByteMapFactoryImpl implements ImmutableObjectByteMapFactory
{
    INSTANCE;

    @Override
    public <K> ImmutableObjectByteMap<K> empty()
    {
        return (ImmutableObjectByteMap<K>) ImmutableObjectByteEmptyMap.INSTANCE;
    }

    @Override
    public <K> ImmutableObjectByteMap<K> of()
    {
        return this.empty();
    }

    @Override
    public <K> ImmutableObjectByteMap<K> with()
    {
        return this.empty();
    }

    @Override
    public <K> ImmutableObjectByteMap<K> of(K key, byte value)
    {
        return this.with(key, value);
    }

    @Override
    public <K> ImmutableObjectByteMap<K> with(K key, byte value)
    {
        return new ImmutableObjectByteSingletonMap<>(key, value);
    }

    @Override
    public <K> ImmutableObjectByteMap<K> ofAll(ObjectByteMap<? extends K> map)
    {
        return this.withAll(map);
    }

    @Override
    public <K> ImmutableObjectByteMap<K> withAll(ObjectByteMap<? extends K> map)
    {
        if (map instanceof ImmutableObjectByteMap)
        {
            return (ImmutableObjectByteMap<K>) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            //TODO use keysView() when available.
            final Object[] array = new Object[1];
            map.forEachKey((K each) -> array[0] = each);
            return new ImmutableObjectByteSingletonMap<>((K) array[0], map.get(array[0]));
        }
        return new ImmutableObjectByteHashMap<>(map);
    }
}
