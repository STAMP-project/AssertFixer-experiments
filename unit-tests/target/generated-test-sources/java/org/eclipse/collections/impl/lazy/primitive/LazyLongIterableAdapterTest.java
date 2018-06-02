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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyLongIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyLongIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyLongIterableAdapterTest extends AbstractLazyLongIterableTestCase
{
    @Override
    protected LazyLongIterable classUnderTest()
    {
        return new LazyLongIterableAdapter(LongArrayList.newListWith(1L, 2L, 3L));
    }

    @Override
    protected LazyLongIterable getEmptyIterable()
    {
        return new LazyLongIterableAdapter(new LongArrayList());
    }

    @Override
    protected LazyLongIterable newWith(long element1, long element2)
    {
        return new LazyLongIterableAdapter(LongArrayList.newListWith(element1, element2));
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1, 2, 3]", this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1, 2, 3", this.classUnderTest().makeString());
        Assert.assertEquals("1/2/3", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1, 2, 3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1/2/3", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toArray()
    {
        super.toArray();
        Assert.assertArrayEquals(new long[]{1L, 2L, 3L}, this.classUnderTest().toArray());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LazyLongIterate.class);
    }
}
