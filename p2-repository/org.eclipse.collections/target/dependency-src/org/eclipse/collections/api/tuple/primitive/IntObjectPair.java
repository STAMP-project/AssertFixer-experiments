/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.tuple.primitive;

import java.io.Serializable;

import org.eclipse.collections.api.tuple.Pair;

/**
 * An instance of this interface can be created by calling PrimitiveTuples.pair(int, Object).
 *
 * @see Pair
 * This file was automatically generated from template file primitiveObjectPair.stg
 */
public interface IntObjectPair<T> extends Serializable, Comparable<IntObjectPair<T>>
{
    int getOne();

    T getTwo();
}
