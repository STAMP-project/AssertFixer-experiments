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

import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.eclipse.collections.api.map.primitive.ByteFloatMap;

/**
 * A factory which creates instances of type {@link MutableByteFloatMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableByteFloatMapFactory
{
    MutableByteFloatMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableByteFloatMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableByteFloatMap with();

    /**
     * Same as {@link #withAll(ByteFloatMap)}.
     */
    MutableByteFloatMap ofAll(ByteFloatMap map);

    MutableByteFloatMap withAll(ByteFloatMap map);
}
