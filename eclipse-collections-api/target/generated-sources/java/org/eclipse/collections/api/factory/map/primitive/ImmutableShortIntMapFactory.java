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

import org.eclipse.collections.api.map.primitive.ShortIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortIntMap;

/**
 * A factory which creates instances of type {@link ImmutableShortIntMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableShortIntMapFactory
{
    /**
     * @since 6.0
     */
    ImmutableShortIntMap empty();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableShortIntMap of();

    /**
     * Same as {@link #empty()}.
     */
    ImmutableShortIntMap with();

    /**
     * Same as {@link #with(short, int)}.
     */
    ImmutableShortIntMap of(short key, int value);

    ImmutableShortIntMap with(short key, int value);

    /**
     * Same as {@link #withAll(ShortIntMap)}.
     */
    ImmutableShortIntMap ofAll(ShortIntMap map);

    ImmutableShortIntMap withAll(ShortIntMap map);
}
