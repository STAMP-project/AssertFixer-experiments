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

import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;

/**
 * A factory which creates instances of type {@link ImmutableObjectFloatMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableObjectFloatMapFactory
{
    /**
     * @since 6.0
     */
    <K> ImmutableObjectFloatMap<K> empty();

    /**
     * Same as {@link #empty()}.
     */
    <K> ImmutableObjectFloatMap<K> of();

    /**
     * Same as {@link #empty()}.
     */
    <K> ImmutableObjectFloatMap<K> with();

    /**
     * Same as {@link #with(Object, float)}.
     */
    <K> ImmutableObjectFloatMap<K> of(K key, float value);

    <K> ImmutableObjectFloatMap<K> with(K key, float value);

    /**
     * Same as {@link #withAll(ObjectFloatMap)}.
     */
    <K> ImmutableObjectFloatMap<K> ofAll(ObjectFloatMap<? extends K> map);

    <K> ImmutableObjectFloatMap<K> withAll(ObjectFloatMap<? extends K> map);
}
