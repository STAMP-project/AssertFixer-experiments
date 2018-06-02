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
 * A CharFloatProcedure is a two argument lambda or closure which has no return argument and takes a primitive char as the first and
 * a primitive float as the second argument.
 * This file was automatically generated from template file primitivePrimitiveProcedure.stg.
 *
 * @since 3.0.
 */
@FunctionalInterface
public interface CharFloatProcedure
        extends Serializable
{
    void value(char argument1, float argument2);
}
