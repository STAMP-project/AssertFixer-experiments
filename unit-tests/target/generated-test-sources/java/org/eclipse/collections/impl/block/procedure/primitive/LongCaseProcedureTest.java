/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.procedure.primitive;

import org.eclipse.collections.api.list.primitive.LongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class LongCaseProcedureTest
{
    @Test
    public void noopCaseAndThenDefault()
    {
        MutableLongList result = LongLists.mutable.empty();
        LongList source = LongLists.mutable.with(1L, 2L);
        LongCaseProcedure procedure = new LongCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("LongCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault()
    {
        MutableLongList ifOneList = LongLists.mutable.empty();
        MutableLongList defaultList = LongLists.mutable.empty();
        MutableLongList list = LongLists.mutable.with(1L, 2L);
        LongCaseProcedure procedure =
                new LongCaseProcedure(defaultList::add)
                        .addCase(value -> value == 1, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(LongLists.mutable.with(1L), ifOneList);
        Assert.assertEquals(LongLists.mutable.with(2L), defaultList);
    }

    @Test
    public void twoCasesNoDefault()
    {
        MutableLongList ifOneList = LongLists.mutable.empty();
        MutableLongList ifTwoList = LongLists.mutable.empty();
        MutableLongList list = LongLists.mutable.with(1L, 2L, 3L);
        LongCaseProcedure procedure =
                new LongCaseProcedure()
                        .addCase(value -> value == 1, ifOneList::add)
                        .addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(LongLists.mutable.with(1L), ifOneList);
        Assert.assertEquals(LongLists.mutable.with(2L), ifTwoList);
        Verify.assertContains("LongCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault()
    {
        MutableLongList ifOneList = LongLists.mutable.empty();
        MutableLongList ifTwoList = LongLists.mutable.empty();
        MutableLongList defaultList = LongLists.mutable.empty();
        MutableLongList list = LongLists.mutable.with(1L, 2L, 3L, 4L);
        LongCaseProcedure procedure =
                new LongCaseProcedure(defaultList::add)
                        .addCase(value -> value == 1, ifOneList::add)
                        .addCase(value -> value == 2, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(LongLists.mutable.with(1L), ifOneList);
        Assert.assertEquals(LongLists.mutable.with(2L), ifTwoList);
        Assert.assertEquals(LongLists.mutable.with(3L, 4L), defaultList);
    }
}
