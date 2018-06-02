/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharCharHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableCharCharHashMapTest extends AbstractImmutableCharCharMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableCharCharMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharCharMap map1 = this.classUnderTest();
        ImmutableCharCharMap expected = this.newWithKeysValues((char) 0, (char) 0, (char) 31, (char) 31, (char) 32, (char) 32, (char) 33, (char) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, (char) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, (char) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharCharMap map1 = this.classUnderTest();
        ImmutableCharCharMap expected = this.newWithKeysValues((char) 0, (char) 0, (char) 31, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharCharMap map1 = this.classUnderTest();
        ImmutableCharCharMap expected = this.newWithKeysValues((char) 31, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableCharCharHashMap iterable = new ImmutableCharCharHashMap(CharCharHashMap.newWithKeysValues((char) 1, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3));
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }
}
