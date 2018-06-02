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

import java.util.Iterator;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.lazy.AbstractLazyIterable;

/**
 * This file was automatically generated from template file collectPrimitiveToObjectIterable.stg.
 */
public class CollectCharToObjectIterable<V>
        extends AbstractLazyIterable<V>
{
    private final CharIterable iterable;
    private final CharToObjectFunction<? extends V> function;

    public CollectCharToObjectIterable(CharIterable iterable, CharToObjectFunction<? extends V> function)
    {
        this.iterable = iterable;
        this.function = function;
    }

    @Override
    public void each(final Procedure<? super V> procedure)
    {
        this.iterable.forEach((char each) -> procedure.value(this.function.valueOf(each)));
    }

    @Override
    public void forEachWithIndex(final ObjectIntProcedure<? super V> objectIntProcedure)
    {
        this.iterable.forEach(new CharProcedure()
        {
            private int index;

            @Override
            public void value(char each)
            {
                objectIntProcedure.value(CollectCharToObjectIterable.this.function.valueOf(each), this.index++);
            }
        });
    }

    @Override
    public <P> void forEachWith(final Procedure2<? super V, ? super P> procedure, final P parameter)
    {
        this.iterable.forEach((char each) -> procedure.value(this.function.valueOf(each), parameter));
    }

    @Override
    public Iterator<V> iterator()
    {
        return new Iterator<V>()
        {
            private final CharIterator iterator = CollectCharToObjectIterable.this.iterable.charIterator();

            @Override
            public boolean hasNext()
            {
                return this.iterator.hasNext();
            }

            @Override
            public V next()
            {
                return CollectCharToObjectIterable.this.function.valueOf(this.iterator.next());
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException("Cannot call remove() on " + this.getClass().getSimpleName());
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
