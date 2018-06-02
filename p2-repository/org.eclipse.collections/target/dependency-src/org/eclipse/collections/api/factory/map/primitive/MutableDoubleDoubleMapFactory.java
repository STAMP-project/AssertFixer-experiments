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

import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.eclipse.collections.api.map.primitive.DoubleDoubleMap;

/**
 * A factory which creates instances of type {@link MutableDoubleDoubleMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableDoubleDoubleMapFactory
{
    MutableDoubleDoubleMap empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableDoubleDoubleMap of();

    /**
     * Same as {@link #empty()}.
     */
    MutableDoubleDoubleMap with();

    /**
     * Same as {@link #withAll(DoubleDoubleMap)}.
     */
    MutableDoubleDoubleMap ofAll(DoubleDoubleMap map);

    MutableDoubleDoubleMap withAll(DoubleDoubleMap map);
}
