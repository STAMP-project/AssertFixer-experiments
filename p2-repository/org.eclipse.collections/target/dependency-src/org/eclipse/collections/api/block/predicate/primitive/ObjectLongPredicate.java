/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.block.predicate.primitive;

import java.io.Serializable;

/**
 * A two argument Predicate that takes type T and
 * a primitive long as the arguments.
 * This file was automatically generated from template file objectPrimitivePredicate.stg.
 *
 * @since 3.0.
 */
@FunctionalInterface
public interface ObjectLongPredicate<T>
        extends Serializable
{
    boolean accept(T object, long value);
}
