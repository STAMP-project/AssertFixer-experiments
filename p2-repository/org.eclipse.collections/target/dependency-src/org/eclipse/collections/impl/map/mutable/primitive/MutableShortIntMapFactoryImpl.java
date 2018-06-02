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

import org.eclipse.collections.api.factory.map.primitive.MutableShortIntMapFactory;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.api.map.primitive.ShortIntMap;

/**
 * MutableShortIntMapFactoryImpl is a factory implementation which creates instances of type {@link MutableShortIntMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortIntMapFactoryImpl implements MutableShortIntMapFactory
{
    INSTANCE;

    @Override
    public MutableShortIntMap empty()
    {
        return new ShortIntHashMap(0);
    }

    @Override
    public MutableShortIntMap of()
    {
        return this.empty();
    }

    @Override
    public MutableShortIntMap with()
    {
        return this.empty();
    }

    @Override
    public MutableShortIntMap ofAll(ShortIntMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableShortIntMap withAll(ShortIntMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ShortIntHashMap(map);
    }
}
