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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleBooleanMap;
import org.eclipse.collections.api.map.primitive.DoubleBooleanMap;

/**
 * ImmutableDoubleBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableDoubleBooleanMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableDoubleBooleanMapFactoryImpl implements ImmutableDoubleBooleanMapFactory
{
    INSTANCE;

    @Override
    public ImmutableDoubleBooleanMap empty()
    {
        return ImmutableDoubleBooleanEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableDoubleBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleBooleanMap of(double key, boolean value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableDoubleBooleanMap with(double key, boolean value)
    {
        return new ImmutableDoubleBooleanSingletonMap(key, value);
    }

    @Override
    public ImmutableDoubleBooleanMap ofAll(DoubleBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableDoubleBooleanMap withAll(DoubleBooleanMap map)
    {
        if (map instanceof ImmutableDoubleBooleanMap)
        {
            return (ImmutableDoubleBooleanMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            double key = map.keysView().doubleIterator().next();
            return new ImmutableDoubleBooleanSingletonMap(key, map.get(key));
        }
        return new ImmutableDoubleBooleanHashMap(map);
    }
}
