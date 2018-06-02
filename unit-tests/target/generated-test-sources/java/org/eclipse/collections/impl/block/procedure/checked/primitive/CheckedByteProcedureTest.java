/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.procedure.checked.primitive;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import org.eclipse.collections.impl.test.Verify;

/**
 * Provides a set of common tests of checked procedures for byte values.
 * This file was automatically generated from template file checkedPrimitiveProcedureTest.stg.
 *
 * @since 5.0.
 */
public final class CheckedByteProcedureTest
{
    @Test
    public void regular()
    {
        final boolean[] result = new boolean[1];
        new CheckedByteProcedure()
        {
            @Override
            public void safeValue(byte item) throws Exception
            {
                result[0] = true;
            }
        }.value((byte) 0);
        Assert.assertTrue(result[0]);
    }

    @Test
    public void runtimeException()
    {
        Verify.assertThrows(RuntimeException.class, () -> {
            new CheckedByteProcedure()
            {
                @Override
                public void safeValue(byte item) throws Exception
                {
                    throw new RuntimeException();
                }
            }.value((byte) 0);
        });
    }

    @Test
    public void checkedException()
    {
        Verify.assertThrows(RuntimeException.class, () -> {
            new CheckedByteProcedure()
            {
                @Override
                public void safeValue(byte item) throws Exception
                {
                    throw new IOException();
                }
            }.value((byte) 0);
        });
    }
}
