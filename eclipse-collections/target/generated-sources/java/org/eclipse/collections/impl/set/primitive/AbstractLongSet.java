/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.primitive;

import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.primitive.AbstractLongIterable;

/**
 * This file was automatically generated from template file abstractPrimitiveSet.stg.
 *
 * @since 6.0.
 */
public abstract class AbstractLongSet extends AbstractLongIterable implements LongSet
{
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof LongSet))
        {
            return false;
        }

        LongSet other = (LongSet) obj;
        return this.size() == other.size() && this.containsAll(other.toArray());
    }

    @SuppressWarnings("AbstractMethodOverridesAbstractMethod")
    @Override
    public abstract int hashCode();
}
