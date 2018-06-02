/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.factory.set.primitive.ImmutableDoubleSetFactory;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import java.util.stream.DoubleStream;

/**
 * ImmutableDoubleSetFactoryImpl is a factory implementation which creates instances of type {@link ImmutableDoubleSet}.
 * This file was automatically generated from template file immutablePrimitiveSetFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableDoubleSetFactoryImpl implements ImmutableDoubleSetFactory
{
    INSTANCE;

    @Override
    public ImmutableDoubleSet empty()
    {
        return ImmutableDoubleEmptySet.INSTANCE;
    }

    @Override
    public ImmutableDoubleSet of()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleSet with()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleSet of(double one)
    {
        return this.with(one);
    }

    @Override
    public ImmutableDoubleSet with(double one)
    {
        return new ImmutableDoubleSingletonSet(one);
    }

    @Override
    public ImmutableDoubleSet of(double... items)
    {
        return this.with(items);
    }

    @Override
    public ImmutableDoubleSet with(double... items)
    {
        if (items == null || items.length == 0)
        {
            return this.with();
        }
        if (items.length == 1)
        {
            return this.with(items[0]);
        }
        return DoubleHashSet.newSetWith(items).toImmutable();
    }

    @Override
    public ImmutableDoubleSet ofAll(DoubleIterable items)
    {
        return this.withAll(items);
    }

    @Override
    public ImmutableDoubleSet withAll(DoubleIterable items)
    {
        if (items instanceof ImmutableDoubleSet)
        {
            return (ImmutableDoubleSet) items;
        }
        return this.with(items.toArray());
    }

    /**
     * @since 9.0
     */
    @Override
    public ImmutableDoubleSet ofAll(DoubleStream items)
    {
        return this.withAll(items);
    }

    /**
     * @since 9.0
     */
    @Override
    public ImmutableDoubleSet withAll(DoubleStream items)
    {
        return this.with(items.toArray());
    }
}
