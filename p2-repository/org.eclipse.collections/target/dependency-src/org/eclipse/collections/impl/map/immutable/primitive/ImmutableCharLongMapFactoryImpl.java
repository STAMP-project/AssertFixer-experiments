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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharLongMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.api.map.primitive.CharLongMap;

/**
 * ImmutableCharLongMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableCharLongMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableCharLongMapFactoryImpl implements ImmutableCharLongMapFactory
{
    INSTANCE;

    @Override
    public ImmutableCharLongMap empty()
    {
        return ImmutableCharLongEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableCharLongMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharLongMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharLongMap of(char key, long value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableCharLongMap with(char key, long value)
    {
        return new ImmutableCharLongSingletonMap(key, value);
    }

    @Override
    public ImmutableCharLongMap ofAll(CharLongMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableCharLongMap withAll(CharLongMap map)
    {
        if (map instanceof ImmutableCharLongMap)
        {
            return (ImmutableCharLongMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            char key = map.keysView().charIterator().next();
            return new ImmutableCharLongSingletonMap(key, map.get(key));
        }
        return new ImmutableCharLongHashMap(map);
    }
}
