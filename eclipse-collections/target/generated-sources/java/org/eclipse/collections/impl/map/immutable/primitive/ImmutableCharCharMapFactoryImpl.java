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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharCharMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.api.map.primitive.CharCharMap;

/**
 * ImmutableCharCharMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableCharCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableCharCharMapFactoryImpl implements ImmutableCharCharMapFactory
{
    INSTANCE;

    @Override
    public ImmutableCharCharMap empty()
    {
        return ImmutableCharCharEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableCharCharMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharCharMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharCharMap of(char key, char value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableCharCharMap with(char key, char value)
    {
        return new ImmutableCharCharSingletonMap(key, value);
    }

    @Override
    public ImmutableCharCharMap ofAll(CharCharMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableCharCharMap withAll(CharCharMap map)
    {
        if (map instanceof ImmutableCharCharMap)
        {
            return (ImmutableCharCharMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            char key = map.keysView().charIterator().next();
            return new ImmutableCharCharSingletonMap(key, map.get(key));
        }
        return new ImmutableCharCharHashMap(map);
    }
}
