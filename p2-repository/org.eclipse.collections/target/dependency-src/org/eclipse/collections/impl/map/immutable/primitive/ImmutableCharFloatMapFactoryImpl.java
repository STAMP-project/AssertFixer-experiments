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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharFloatMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableCharFloatMap;
import org.eclipse.collections.api.map.primitive.CharFloatMap;

/**
 * ImmutableCharFloatMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableCharFloatMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableCharFloatMapFactoryImpl implements ImmutableCharFloatMapFactory
{
    INSTANCE;

    @Override
    public ImmutableCharFloatMap empty()
    {
        return ImmutableCharFloatEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableCharFloatMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharFloatMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharFloatMap of(char key, float value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableCharFloatMap with(char key, float value)
    {
        return new ImmutableCharFloatSingletonMap(key, value);
    }

    @Override
    public ImmutableCharFloatMap ofAll(CharFloatMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableCharFloatMap withAll(CharFloatMap map)
    {
        if (map instanceof ImmutableCharFloatMap)
        {
            return (ImmutableCharFloatMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            char key = map.keysView().charIterator().next();
            return new ImmutableCharFloatSingletonMap(key, map.get(key));
        }
        return new ImmutableCharFloatHashMap(map);
    }
}
