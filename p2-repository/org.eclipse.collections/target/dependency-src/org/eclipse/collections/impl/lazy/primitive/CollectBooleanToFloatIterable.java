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
import org.eclipse.collections.api.block.function.primitive.BooleanToFloatFunction;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.iterator.FloatIterator;

/**
 * This file was automatically generated from template file collectPrimitiveToPrimitiveIterable.stg.
 */
public class CollectBooleanToFloatIterable
        extends AbstractLazyFloatIterable
{
    private final BooleanIterable iterable;
    private final BooleanToFloatFunction function;

    public CollectBooleanToFloatIterable(BooleanIterable iterable, BooleanToFloatFunction function)
    {
        this.iterable = iterable;
        this.function = function;
    }

    @Override
    public void each(final FloatProcedure procedure)
    {
        this.iterable.forEach((boolean each) -> procedure.value(this.function.valueOf(each)));
    }

    @Override
    public FloatIterator floatIterator()
    {
        return new FloatIterator()
        {
            private final BooleanIterator iterator = CollectBooleanToFloatIterable.this.iterable.booleanIterator();

            @Override
            public boolean hasNext()
            {
                return this.iterator.hasNext();
            }

            @Override
            public float next()
            {
                return CollectBooleanToFloatIterable.this.function.valueOf(this.iterator.next());
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
