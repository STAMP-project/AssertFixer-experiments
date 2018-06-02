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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import java.util.stream.IntStream;

/**
 * A factory which creates instances of type {@link MutableIntList}.
 * This file was automatically generated from template file mutablePrimitiveListFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableIntListFactory
{
    MutableIntList empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntList of();

    /**
     * Same as {@link #empty()}.
     */
    MutableIntList with();

    /**
     * Same as {@link #with(int[])}.
     */
    MutableIntList of(int... items);

    MutableIntList with(int... items);

    /**
     * Same as {@link #withAll(IntIterable)}.
     */
    MutableIntList ofAll(IntIterable items);

    MutableIntList withAll(IntIterable items);

    /**
     * @since 9.0
     */
    MutableIntList ofAll(IntStream items);

    /**
     * @since 9.0
     */
    MutableIntList withAll(IntStream items);
}
