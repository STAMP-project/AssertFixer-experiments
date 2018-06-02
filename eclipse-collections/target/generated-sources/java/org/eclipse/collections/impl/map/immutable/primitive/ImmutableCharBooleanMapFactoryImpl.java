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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.api.map.primitive.CharBooleanMap;

/**
 * ImmutableCharBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableCharBooleanMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableCharBooleanMapFactoryImpl implements ImmutableCharBooleanMapFactory
{
    INSTANCE;

    @Override
    public ImmutableCharBooleanMap empty()
    {
        return ImmutableCharBooleanEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableCharBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharBooleanMap of(char key, boolean value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableCharBooleanMap with(char key, boolean value)
    {
        return new ImmutableCharBooleanSingletonMap(key, value);
    }

    @Override
    public ImmutableCharBooleanMap ofAll(CharBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableCharBooleanMap withAll(CharBooleanMap map)
    {
        if (map instanceof ImmutableCharBooleanMap)
        {
            return (ImmutableCharBooleanMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            char key = map.keysView().charIterator().next();
            return new ImmutableCharBooleanSingletonMap(key, map.get(key));
        }
        return new ImmutableCharBooleanHashMap(map);
    }
}
