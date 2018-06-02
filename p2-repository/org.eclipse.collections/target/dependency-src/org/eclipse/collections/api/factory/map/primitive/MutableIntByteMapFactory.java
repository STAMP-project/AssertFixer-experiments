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

import org.eclipse.collections.api.map.primitive.MutableIntByteMap;
import org.eclipse.collections.api.map.primitive.IntByteMap;

/**
 * A factory which creates instances of type {@link MutableIntByteMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableIntByteMapFactory
{
    MutableIntByteMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntByteMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntByteMap with();

    /**
     * Same as {@link #withAll(IntByteMap)}.
     */
    MutableIntByteMap ofAll(IntByteMap map);

    MutableIntByteMap withAll(IntByteMap map);
}
