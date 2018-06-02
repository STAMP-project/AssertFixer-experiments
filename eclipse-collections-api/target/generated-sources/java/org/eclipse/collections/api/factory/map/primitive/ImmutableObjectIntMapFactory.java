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

import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;

/**
 * A factory which creates instances of type {@link ImmutableObjectIntMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveMapFactory.stg.
 *
 * @since 4.0.
 */
public interface ImmutableObjectIntMapFactory
{
    /**
     * @since 6.0
     */
    <K> ImmutableObjectIntMap<K> empty();

    /**
     * Same as {@link #empty()}.
     */
    <K> ImmutableObjectIntMap<K> of();

    /**
     * Same as {@link #empty()}.
     */
    <K> ImmutableObjectIntMap<K> with();

    /**
     * Same as {@link #with(Object, int)}.
     */
    <K> ImmutableObjectIntMap<K> of(K key, int value);

    <K> ImmutableObjectIntMap<K> with(K key, int value);

    /**
     * Same as {@link #withAll(ObjectIntMap)}.
     */
    <K> ImmutableObjectIntMap<K> ofAll(ObjectIntMap<? extends K> map);

    <K> ImmutableObjectIntMap<K> withAll(ObjectIntMap<? extends K> map);
}
