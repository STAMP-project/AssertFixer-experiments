/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.factory.list.primitive;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.list.primitive.MutableShortList;

/**
 * A factory which creates instances of type {@link MutableShortList}.
 * This file was automatically generated from template file mutablePrimitiveListFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableShortListFactory
{
    MutableShortList empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableShortList of();

    /**
     * Same as {@link #empty()}.
     */
    MutableShortList with();

    /**
     * Same as {@link #with(short[])}.
     */
    MutableShortList of(short... items);

    MutableShortList with(short... items);

    /**
     * Same as {@link #withAll(ShortIterable)}.
     */
    MutableShortList ofAll(ShortIterable items);

    MutableShortList withAll(ShortIterable items);
}
