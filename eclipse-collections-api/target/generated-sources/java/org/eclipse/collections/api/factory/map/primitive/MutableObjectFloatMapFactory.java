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

import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;

/**
 * A factory which creates instances of type {@link MutableObjectFloatMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableObjectFloatMapFactory
{
    <K> MutableObjectFloatMap<K> empty();

    /**
     * Same as {@link #empty()}.
     */
    <K> MutableObjectFloatMap<K> of();

    /**
     * Same as {@link #empty()}.
     */
    <K> MutableObjectFloatMap<K> with();

    /**
     * Same as {@link #withAll(ObjectFloatMap)}.
     */
    <K> MutableObjectFloatMap<K> ofAll(ObjectFloatMap<? extends K>  map);

    <K> MutableObjectFloatMap<K> withAll(ObjectFloatMap<? extends K>  map);
}
