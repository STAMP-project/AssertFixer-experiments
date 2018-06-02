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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyFloatIterate}.
 * This file was automatically generated from template file lazyPrimitiveIterateTest.stg.
 */
public class LazyFloatIterateTest
{
    private final FloatIterable iterable = FloatLists.mutable.with(1.0f, 2.0f, 3.0f);

    @Test
    public void adapt()
    {
        Assert.assertEquals(this.iterable, LazyFloatIterate.adapt(this.iterable).toList());
    }

    @Test
    public void collectIf()
    {
        Assert.assertEquals(this.iterable.collect(each -> each), LazyFloatIterate.collectIf(this.iterable, each -> true, each -> each).toList());
    }
}
