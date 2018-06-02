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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.list.primitive.MutableFloatList;

/**
 * A factory which creates instances of type {@link MutableFloatList}.
 * This file was automatically generated from template file mutablePrimitiveListFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableFloatListFactory
{
    MutableFloatList empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableFloatList of();

    /**
     * Same as {@link #empty()}.
     */
    MutableFloatList with();

    /**
     * Same as {@link #with(float[])}.
     */
    MutableFloatList of(float... items);

    MutableFloatList with(float... items);

    /**
     * Same as {@link #withAll(FloatIterable)}.
     */
    MutableFloatList ofAll(FloatIterable items);

    MutableFloatList withAll(FloatIterable items);
}
