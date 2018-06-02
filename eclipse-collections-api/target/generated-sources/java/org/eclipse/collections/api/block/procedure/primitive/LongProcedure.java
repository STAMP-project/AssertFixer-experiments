/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.block.procedure.primitive;

import java.io.Serializable;

/**
 * A one argument procedure that takes a primitive long as the argument.
 * This file was automatically generated from template file primitiveProcedure.stg.
 *
 * @since 3.0.
 */
@FunctionalInterface
public interface LongProcedure
        extends java.util.function.LongConsumer, Serializable
{
    void value(long each);

    @Override
    default void accept(long each)
    {
        this.value(each);
    }
}
