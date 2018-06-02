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

import org.eclipse.collections.api.factory.map.primitive.MutableDoubleBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.MutableDoubleBooleanMap;
import org.eclipse.collections.api.map.primitive.DoubleBooleanMap;

/**
 * MutableDoubleBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link MutableDoubleBooleanMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableDoubleBooleanMapFactoryImpl implements MutableDoubleBooleanMapFactory
{
    INSTANCE;

    @Override
    public MutableDoubleBooleanMap empty()
    {
        return new DoubleBooleanHashMap(0);
    }

    @Override
    public MutableDoubleBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public MutableDoubleBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public MutableDoubleBooleanMap ofAll(DoubleBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableDoubleBooleanMap withAll(DoubleBooleanMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new DoubleBooleanHashMap(map);
    }
}
