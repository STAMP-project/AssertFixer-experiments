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

import org.eclipse.collections.api.map.primitive.MutableIntBooleanMap;
import org.eclipse.collections.api.map.primitive.IntBooleanMap;

/**
 * A factory which creates instances of type {@link MutableIntBooleanMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableIntBooleanMapFactory
{
    MutableIntBooleanMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntBooleanMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntBooleanMap with();

    /**
     * Same as {@link #withAll(IntBooleanMap)}.
     */
    MutableIntBooleanMap ofAll(IntBooleanMap map);

    MutableIntBooleanMap withAll(IntBooleanMap map);
}
