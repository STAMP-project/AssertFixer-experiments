/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable.primitive;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableCharSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableCharHashSetTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;

/**
 * JUnit test for {@link ImmutableCharHashSet}.
 * This file was automatically generated from template file immutablePrimitiveHashSetTest.stg.
 */
public class ImmutableCharHashSetTest extends AbstractImmutableCharHashSetTestCase
{
    @Override
    protected ImmutableCharSet classUnderTest()
    {
        return CharHashSet.newSetWith((char) 1, (char) 2, (char) 3).toImmutable();
    }

    @Override
    protected ImmutableCharSet newWith(char... elements)
    {
        return CharHashSet.newSetWith(elements).toImmutable();
    }

    @Override
    protected MutableCharSet newMutableCollectionWith(char... elements)
    {
        return CharHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Character> newObjectCollectionWith(Character... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }
}
