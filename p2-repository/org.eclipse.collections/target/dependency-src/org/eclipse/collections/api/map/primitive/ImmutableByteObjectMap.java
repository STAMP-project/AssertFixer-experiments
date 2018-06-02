/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.ByteObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableByteObjectMap<V> extends ByteObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableByteObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableByteObjectMap<V> select(ByteObjectPredicate<? super V> predicate);

    @Override
    ImmutableByteObjectMap<V> reject(ByteObjectPredicate<? super V> predicate);

    ImmutableByteObjectMap<V> newWithKeyValue(byte key, V value);

    ImmutableByteObjectMap<V> newWithoutKey(byte key);

    ImmutableByteObjectMap<V> newWithoutAllKeys(ByteIterable keys);

    @Override
    ImmutableObjectByteMap<V> flipUniqueValues();
}
