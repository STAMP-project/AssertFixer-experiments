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

import org.eclipse.collections.api.factory.bag.primitive.ImmutableDoubleBagFactory;
import org.eclipse.collections.api.factory.bag.primitive.MutableDoubleBagFactory;
import org.eclipse.collections.impl.bag.immutable.primitive.ImmutableDoubleBagFactoryImpl;
import org.eclipse.collections.impl.bag.mutable.primitive.MutableDoubleBagFactoryImpl;

/**
 * DoubleBags is a static utility for creating {@link ImmutableDoubleBagFactory}.
 * This file was automatically generated from template file primitiveBags.stg.
 *
 * @since 4.0.
 */
@SuppressWarnings("ConstantNamingConvention")
public final class DoubleBags
{
    public static final ImmutableDoubleBagFactory immutable = ImmutableDoubleBagFactoryImpl.INSTANCE;
    public static final MutableDoubleBagFactory mutable = MutableDoubleBagFactoryImpl.INSTANCE;

    private DoubleBags()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
