/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.primitive;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.block.function.primitive.DoubleToCharFunction;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.iterator.CharIterator;

/**
 * This file was automatically generated from template file collectPrimitiveToPrimitiveIterable.stg.
 */
public class CollectDoubleToCharIterable
        extends AbstractLazyCharIterable
{
    private final DoubleIterable iterable;
    private final DoubleToCharFunction function;

    public CollectDoubleToCharIterable(DoubleIterable iterable, DoubleToCharFunction function)
    {
        this.iterable = iterable;
        this.function = function;
    }

    @Override
    public void each(final CharProcedure procedure)
    {
        this.iterable.forEach((double each) -> procedure.value(this.function.valueOf(each)));
    }

    @Override
    public CharIterator charIterator()
    {
        return new CharIterator()
        {
            private final DoubleIterator iterator = CollectDoubleToCharIterable.this.iterable.doubleIterator();

            @Override
            public boolean hasNext()
            {
                return this.iterator.hasNext();
            }

            @Override
            public char next()
            {
                return CollectDoubleToCharIterable.this.function.valueOf(this.iterator.next());
            }
        };
    }

    @Override
    public int size()
    {
        return this.iterable.size();
    }

    @Override
    public boolean isEmpty()
    {
        return this.iterable.isEmpty();
    }

    @Override
    public boolean notEmpty()
    {
        return this.iterable.notEmpty();
    }
}
