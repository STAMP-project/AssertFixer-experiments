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

import org.eclipse.collections.api.tuple.primitive.BooleanIntPair;

/**
 * This file was automatically generated from template file primitivePrimitivePairImpl.stg
 */
public class BooleanIntPairImpl implements BooleanIntPair
{
    private static final long serialVersionUID = 1L;

    private final boolean one;
    private final int two;

    BooleanIntPairImpl(boolean newOne, int newTwo)
    {
        this.one = newOne;
        this.two = newTwo;
    }

    @Override
    public boolean getOne()
    {
        return this.one;
    }

    @Override
    public int getTwo()
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
        if (!(o instanceof BooleanIntPair))
        {
            return false;
        }

        BooleanIntPair that = (BooleanIntPair) o;

        return (this.one == that.getOne())
                && (this.two == that.getTwo());
    }

    @Override
    public int hashCode()
    {
        return 29 * (this.one ? 1231 : 1237) + this.two;
    }

    @Override
    public String toString()
    {
        return this.one + ":" + this.two;
    }

    @Override
    public int compareTo(BooleanIntPair that)
    {
        int i = this.one == that.getOne() ? 0 : this.one ? 1 : -1;
        if (i != 0)
        {
            return i;
        }
        return this.two < that.getTwo() ? -1 : this.two > that.getTwo() ? 1 : 0;
    }
}
