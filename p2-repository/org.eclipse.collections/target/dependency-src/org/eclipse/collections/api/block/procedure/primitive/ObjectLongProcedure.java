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
 * A two argument procedure that takes a type T and primitive long as the arguments.
 * This file was automatically generated from template file objectPrimitiveProcedure.stg.
 *
 * @since 3.0.
 */
@FunctionalInterface
public interface ObjectLongProcedure<T>
        extends java.util.function.ObjLongConsumer<T>, Serializable
{
    void value(T each, long parameter);

    @Override
    default void accept(T each, long parameter)
    {
        this.value(each, parameter);
    }
}
