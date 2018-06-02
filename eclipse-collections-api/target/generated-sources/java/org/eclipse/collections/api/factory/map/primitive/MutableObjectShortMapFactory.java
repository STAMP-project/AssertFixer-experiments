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

import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.ObjectShortMap;

/**
 * A factory which creates instances of type {@link MutableObjectShortMap}.
 * This file was automatically generated from template file mutableObjectPrimitiveMapFactory.stg.
 *
 * @since 6.0.
 */
public interface MutableObjectShortMapFactory
{
    <K> MutableObjectShortMap<K> empty();

    /**
     * Same as {@link #empty()}.
     */
    <K> MutableObjectShortMap<K> of();

    /**
     * Same as {@link #empty()}.
     */
    <K> MutableObjectShortMap<K> with();

    /**
     * Same as {@link #withAll(ObjectShortMap)}.
     */
    <K> MutableObjectShortMap<K> ofAll(ObjectShortMap<? extends K>  map);

    <K> MutableObjectShortMap<K> withAll(ObjectShortMap<? extends K>  map);
}
