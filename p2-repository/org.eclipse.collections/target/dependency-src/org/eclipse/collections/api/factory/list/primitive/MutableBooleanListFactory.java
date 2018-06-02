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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;

/**
 * A factory which creates instances of type {@link MutableBooleanList}.
 * This file was automatically generated from template file mutablePrimitiveListFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableBooleanListFactory
{
    MutableBooleanList empty();

    /**
     * Same as {@link #empty()}.
     */
    MutableBooleanList of();

    /**
     * Same as {@link #empty()}.
     */
    MutableBooleanList with();

    /**
     * Same as {@link #with(boolean[])}.
     */
    MutableBooleanList of(boolean... items);

    MutableBooleanList with(boolean... items);

    /**
     * Same as {@link #withAll(BooleanIterable)}.
     */
    MutableBooleanList ofAll(BooleanIterable items);

    MutableBooleanList withAll(BooleanIterable items);
}
