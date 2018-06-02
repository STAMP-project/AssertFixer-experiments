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

import org.eclipse.collections.api.factory.list.primitive.ImmutableLongListFactory;
import org.eclipse.collections.api.factory.list.primitive.MutableLongListFactory;
import org.eclipse.collections.impl.list.immutable.primitive.ImmutableLongListFactoryImpl;
import org.eclipse.collections.impl.list.mutable.primitive.MutableLongListFactoryImpl;

/**
 * LongLists is a static utility for creating {@link ImmutableLongListFactory}.
 * This file was automatically generated from template file primitiveLists.stg.
 *
 * @since 3.2.
 */
@SuppressWarnings("ConstantNamingConvention")
public final class LongLists
{
    public static final ImmutableLongListFactory immutable = ImmutableLongListFactoryImpl.INSTANCE;
    public static final MutableLongListFactory mutable = MutableLongListFactoryImpl.INSTANCE;

    private LongLists()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
