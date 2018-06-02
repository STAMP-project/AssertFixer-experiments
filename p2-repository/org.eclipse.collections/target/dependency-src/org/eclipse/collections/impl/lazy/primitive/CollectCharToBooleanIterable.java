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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharToBooleanFunction;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.BooleanIterator;

/**
 * This file was automatically generated from template file collectPrimitiveToPrimitiveIterable.stg.
 */
public class CollectCharToBooleanIterable
        extends AbstractLazyBooleanIterable
{
    private final CharIterable iterable;
    private final CharToBooleanFunction function;

    public CollectCharToBooleanIterable(CharIterable iterable, CharToBooleanFunction function)
    {
        this.iterable = iterable;
        this.function = function;
    }

    @Override
    public void each(final BooleanProcedure procedure)
    {
        this.iterable.forEach((char each) -> procedure.value(this.function.valueOf(each)));
    }

    @Override
    public BooleanIterator booleanIterator()
    {
        return new BooleanIterator()
        {
            private final CharIterator iterator = CollectCharToBooleanIterable.this.iterable.charIterator();

            @Override
            public boolean hasNext()
            {
                return this.iterator.hasNext();
            }

            @Override
            public boolean next()
            {
                return CollectCharToBooleanIterable.this.function.valueOf(this.iterator.next());
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
