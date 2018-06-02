/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.factory.map.primitive;

import org.eclipse.collections.api.map.primitive.MutableIntLongMap;
import org.eclipse.collections.api.map.primitive.IntLongMap;

/**
 * A factory which creates instances of type {@link MutableIntLongMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableIntLongMapFactory
{
    MutableIntLongMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntLongMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntLongMap with();

    /**
     * Same as {@link #withAll(IntLongMap)}.
     */
    MutableIntLongMap ofAll(IntLongMap map);

    MutableIntLongMap withAll(IntLongMap map);
}
