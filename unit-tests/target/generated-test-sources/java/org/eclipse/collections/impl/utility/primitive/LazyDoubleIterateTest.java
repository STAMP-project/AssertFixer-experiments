/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.utility.primitive;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyDoubleIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyDoubleIterateTest
{
    private final DoubleIterable iterable = DoubleLists.mutable.with(1.0, 2.0, 3.0);

    @Test
    public void adapt()
    {
        Assert.assertEquals(this.iterable, LazyDoubleIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf()
    {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyDoubleIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }
}
