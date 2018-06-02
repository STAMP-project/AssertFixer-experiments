/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.factory.set.primitive;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.set.primitive.MutableShortSet;

/**
 * A factory which creates instances of type {@link MutableShortSet}.
 * This file was automatically generated from template file mutablePrimitiveSetFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableShortSetFactory
{
    MutableShortSet empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableShortSet of();

    /**
     * Same as {@link #empty()}.
     */
    MutableShortSet with();

    /**
     * Same as {@link #with(short[])}.
     */
    MutableShortSet of(short... items);

    MutableShortSet with(short... items);

    /**
     * Same as {@link #withAll(ShortIterable)}.
     */
    MutableShortSet ofAll(ShortIterable items);

    MutableShortSet withAll(ShortIterable items);
}
