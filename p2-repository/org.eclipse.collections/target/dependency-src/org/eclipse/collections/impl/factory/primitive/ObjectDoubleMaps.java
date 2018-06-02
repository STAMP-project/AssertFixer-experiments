/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.factory.map.primitive.ImmutableObjectDoubleMapFactory;
import org.eclipse.collections.api.factory.map.primitive.MutableObjectDoubleMapFactory;
import org.eclipse.collections.impl.map.immutable.primitive.ImmutableObjectDoubleMapFactoryImpl;
import org.eclipse.collections.impl.map.mutable.primitive.MutableObjectDoubleMapFactoryImpl;

/**
 * DoubleObjectMaps is a static utility for creating {@link ImmutableObjectDoubleMapFactory}.
 * This file was automatically generated from template file objectPrimitiveMaps.stg.
 *
 * @since 4.0.
 */
@SuppressWarnings("ConstantNamingConvention")
public final class ObjectDoubleMaps
{
    public static final ImmutableObjectDoubleMapFactory immutable = ImmutableObjectDoubleMapFactoryImpl.INSTANCE;
    public static final MutableObjectDoubleMapFactory mutable = MutableObjectDoubleMapFactoryImpl.INSTANCE;

    private ObjectDoubleMaps()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
