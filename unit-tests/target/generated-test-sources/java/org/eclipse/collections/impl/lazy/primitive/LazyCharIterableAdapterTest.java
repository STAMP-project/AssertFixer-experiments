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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.primitive.LazyCharIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LazyCharIterableAdapter}.
 * This file was automatically generated from template file lazyPrimitiveIterableAdapterTest.stg.
 */
public class LazyCharIterableAdapterTest extends AbstractLazyCharIterableTestCase
{
    @Override
    protected LazyCharIterable classUnderTest()
    {
        return new LazyCharIterableAdapter(CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected LazyCharIterable getEmptyIterable()
    {
        return new LazyCharIterableAdapter(new CharArrayList());
    }

    @Override
    protected LazyCharIterable newWith(char element1, char element2)
    {
        return new LazyCharIterableAdapter(CharArrayList.newListWith(element1, element2));
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("\u0001, \u0002, \u0003", this.classUnderTest().makeString());
        Assert.assertEquals("\u0001/\u0002/\u0003", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toArray()
    {
        super.toArray();
        Assert.assertArrayEquals(new char[]{(char) 1, (char) 2, (char) 3}, this.classUnderTest().toArray());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toList());
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LazyCharIterate.class);
    }
}
