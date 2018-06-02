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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.block.function.primitive.BooleanToIntFunction;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.iterator.IntIterator;

/**
 * This file was automatically generated from template file collectPrimitiveToPrimitiveIterable.stg.
 */
public class CollectBooleanToIntIterable
        extends AbstractLazyIntIterable
{
    private final BooleanIterable iterable;
    private final BooleanToIntFunction function;

    public CollectBooleanToIntIterable(BooleanIterable iterable, BooleanToIntFunction function)
    {
        this.iterable = iterable;
        this.function = function;
    }

    @Override
    public void each(final IntProcedure procedure)
    {
        this.iterable.forEach((boolean each) -> procedure.value(this.function.valueOf(each)));
    }

    @Override
    public IntIterator intIterator()
    {
        return new IntIterator()
        {
            private final BooleanIterator iterator = CollectBooleanToIntIterable.this.iterable.booleanIterator();

            @Override
            public boolean hasNext()
            {
                return this.iterator.hasNext();
            }

            @Override
            public int next()
            {
                return CollectBooleanToIntIterable.this.function.valueOf(this.iterator.next());
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
