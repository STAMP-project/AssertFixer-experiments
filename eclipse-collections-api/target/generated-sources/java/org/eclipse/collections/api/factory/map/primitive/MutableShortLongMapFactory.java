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

import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.map.primitive.ShortLongMap;

/**
 * A factory which creates instances of type {@link MutableShortLongMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableShortLongMapFactory
{
    MutableShortLongMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableShortLongMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableShortLongMap with();

    /**
     * Same as {@link #withAll(ShortLongMap)}.
     */
    MutableShortLongMap ofAll(ShortLongMap map);

    MutableShortLongMap withAll(ShortLongMap map);
}
