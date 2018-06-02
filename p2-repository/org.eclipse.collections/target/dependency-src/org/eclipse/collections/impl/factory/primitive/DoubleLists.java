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

import org.eclipse.collections.api.factory.list.primitive.ImmutableDoubleListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableDoubleListFactory;
import org.eclipse.collections.impl.list.immutable.primitive.ImmutableDoubleListFactoryImpl;
import org.eclipse.collections.impl.list.mutable.primitive.MutableDoubleListFactoryImpl;

/**
 * DoubleLists is a static utility for creating {@link ImmutableDoubleListFactory}.
 * This file was automatically generated from template file primitiveLists.stg.
 *
 * @since 3.2.
 */
@SuppressWarnings("ConstantNamingConvention")
public final class DoubleLists
{
    public static final ImmutableDoubleListFactory immutable = ImmutableDoubleListFactoryImpl.INSTANCE;
    public static final MutableDoubleListFactory mutable = MutableDoubleListFactoryImpl.INSTANCE;

    private DoubleLists()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
