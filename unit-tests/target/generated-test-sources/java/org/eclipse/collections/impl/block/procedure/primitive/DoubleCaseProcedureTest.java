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

import org.eclipse.collections.api.list.primitive.DoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseProcedureTest.stg.
 */
public class DoubleCaseProcedureTest
{
    @Test
    public void noopCaseAndThenDefault()
    {
        MutableDoubleList result = DoubleLists.mutable.empty();
        DoubleList source = DoubleLists.mutable.with(1.0, 2.0);
        DoubleCaseProcedure procedure = new DoubleCaseProcedure();
        source.each(procedure);
        Verify.assertEmpty(result);
        procedure.setDefault(result::add);
        source.each(procedure);
        Assert.assertEquals(result, source);
        Verify.assertContains("DoubleCaseProcedure", procedure.toString());
    }

    @Test
    public void oneCaseWithDefault()
    {
        MutableDoubleList ifOneList = DoubleLists.mutable.empty();
        MutableDoubleList defaultList = DoubleLists.mutable.empty();
        MutableDoubleList list = DoubleLists.mutable.with(1.0, 2.0);
        DoubleCaseProcedure procedure =
                new DoubleCaseProcedure(defaultList::add)
                        .addCase(value -> Double.compare(value, 1) == 0, ifOneList::add);
        list.each(procedure);
        Assert.assertEquals(DoubleLists.mutable.with(1.0), ifOneList);
        Assert.assertEquals(DoubleLists.mutable.with(2.0), defaultList);
    }

    @Test
    public void twoCasesNoDefault()
    {
        MutableDoubleList ifOneList = DoubleLists.mutable.empty();
        MutableDoubleList ifTwoList = DoubleLists.mutable.empty();
        MutableDoubleList list = DoubleLists.mutable.with(1.0, 2.0, 3.0);
        DoubleCaseProcedure procedure =
                new DoubleCaseProcedure()
                        .addCase(value -> Double.compare(value, 1) == 0, ifOneList::add)
                        .addCase(value -> Double.compare(value, 2) == 0, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(DoubleLists.mutable.with(1.0), ifOneList);
        Assert.assertEquals(DoubleLists.mutable.with(2.0), ifTwoList);
        Verify.assertContains("DoubleCaseProcedure", procedure.toString());
    }

    @Test
    public void twoCasesWithDefault()
    {
        MutableDoubleList ifOneList = DoubleLists.mutable.empty();
        MutableDoubleList ifTwoList = DoubleLists.mutable.empty();
        MutableDoubleList defaultList = DoubleLists.mutable.empty();
        MutableDoubleList list = DoubleLists.mutable.with(1.0, 2.0, 3.0, 4.0);
        DoubleCaseProcedure procedure =
                new DoubleCaseProcedure(defaultList::add)
                        .addCase(value -> Double.compare(value, 1) == 0, ifOneList::add)
                        .addCase(value -> Double.compare(value, 2) == 0, ifTwoList::add);
        list.each(procedure);
        Assert.assertEquals(DoubleLists.mutable.with(1.0), ifOneList);
        Assert.assertEquals(DoubleLists.mutable.with(2.0), ifTwoList);
        Assert.assertEquals(DoubleLists.mutable.with(3.0, 4.0), defaultList);
    }
}
