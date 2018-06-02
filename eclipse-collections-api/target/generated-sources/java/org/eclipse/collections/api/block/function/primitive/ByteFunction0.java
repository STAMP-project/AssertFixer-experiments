/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.block.function.primitive;

import java.io.Serializable;

/**
 * ByteFunction0 is a zero argument lambda.  It can be stored in a variable or passed as a parameter and executed
 * by calling the value method. It may be used to reduce the overhead
 * of autoboxing Byte objects in places where primitive bytes could be used.
 * This file was automatically generated from template file primitiveFunction0.stg.
 *
 * @since 3.0.
 */
@FunctionalInterface
public interface ByteFunction0
        extends Serializable
{
    byte value();
}
