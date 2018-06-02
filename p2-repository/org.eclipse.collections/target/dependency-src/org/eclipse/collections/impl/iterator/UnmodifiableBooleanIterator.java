/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.iterator;

import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;

/**
 * UnmodifiableBooleanIterator is a wrapper around BooleanIterator which is unmodifiable and doesn't support remove.
 * This file was automatically generated from template file unmodifiablePrimitiveIterator.stg.
 */
public class UnmodifiableBooleanIterator implements MutableBooleanIterator
{
    private final BooleanIterator booleanIterator;

    public UnmodifiableBooleanIterator(BooleanIterator booleanIterator)
    {
        this.booleanIterator = booleanIterator;
    }

    @Override
    public boolean hasNext()
    {
        return this.booleanIterator.hasNext();
    }

    @Override
    public boolean next()
    {
        return this.booleanIterator.next();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException("Cannot call remove() on " + this.getClass().getSimpleName());
    }
}
