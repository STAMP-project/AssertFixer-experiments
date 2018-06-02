/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.factory.primitive;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.block.function.primitive.ByteByteToObjectFunction;
import org.eclipse.collections.api.factory.set.primitive.ImmutableByteSetFactory;
import org.eclipse.collections.api.factory.set.primitive.MutableByteSetFactory;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.immutable.primitive.ImmutableByteSetFactoryImpl;
import org.eclipse.collections.impl.set.mutable.primitive.MutableByteSetFactoryImpl;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;

/**
 * ByteSets is a static utility for creating {@link ImmutableByteSetFactory}.
 * This file was automatically generated from template file primitiveSets.stg.
 *
 * @since 3.2.
 */
@SuppressWarnings("ConstantNamingConvention")
public final class ByteSets
{
    public static final ImmutableByteSetFactory immutable = ImmutableByteSetFactoryImpl.INSTANCE;
    public static final MutableByteSetFactory mutable = MutableByteSetFactoryImpl.INSTANCE;

    private ByteSets()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    /**
     * @since 9.0
     */
    public static <A, B> LazyIterable<ByteBytePair> cartesianProduct(ByteSet set1, ByteSet set2)
    {
        return ByteSets.cartesianProduct(set1, set2, PrimitiveTuples::pair);
    }

    /**
     * @since 9.0
     */
    public static <A, B, C> LazyIterable<C> cartesianProduct(ByteSet set1, ByteSet set2, ByteByteToObjectFunction<C> function)
    {
        return set1.asLazy()
                .flatCollect(first ->
                    set2.asLazy()
                        .collect(second -> function.value(first, second)));
    }
}
