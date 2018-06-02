/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.tuple.primitive;

import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.impl.block.factory.Comparators;

/**
 * This file was automatically generated from template file primitiveObjectPairImpl.stg
 */
public class DoubleObjectPairImpl<T> implements DoubleObjectPair<T>
{
    private static final long serialVersionUID = 1L;

    private final double one;
    private final T two;

    DoubleObjectPairImpl(double newOne, T newTwo)
    {
        this.one = newOne;
        this.two = newTwo;
    }

    @Override
    public double getOne()
    {
        return this.one;
    }

    @Override
    public T getTwo()
    {
        return this.two;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof DoubleObjectPair))
        {
            return false;
        }

        DoubleObjectPair<?> that = (DoubleObjectPair<?>) o;

        return Double.compare(this.one, that.getOne()) == 0
                && Comparators.nullSafeEquals(this.two, that.getTwo());
    }

    @Override
    public int hashCode()
    {
        return 29 * (int) (Double.doubleToLongBits(this.one) ^ Double.doubleToLongBits(this.one) >>> 32) + (this.two == null ? 0 : this.two.hashCode());
    }

    @Override
    public String toString()
    {
        return this.one + ":" + this.two;
    }

    @Override
    public int compareTo(DoubleObjectPair<T> that)
    {
        int i = Double.compare(this.one, that.getOne());
        if (i != 0)
        {
            return i;
        }
        return ((Comparable<T>) this.two).compareTo(that.getTwo());
    }
}
