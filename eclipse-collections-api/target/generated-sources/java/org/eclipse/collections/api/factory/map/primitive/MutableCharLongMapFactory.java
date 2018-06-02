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

import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.api.map.primitive.CharLongMap;

/**
 * A factory which creates instances of type {@link MutableCharLongMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableCharLongMapFactory
{
    MutableCharLongMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableCharLongMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableCharLongMap with();

    /**
     * Same as {@link #withAll(CharLongMap)}.
     */
    MutableCharLongMap ofAll(CharLongMap map);

    MutableCharLongMap withAll(CharLongMap map);
}
