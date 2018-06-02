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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.predicate.primitive.CharObjectPredicate;

/**
 * This file was automatically generated from template file immutablePrimitiveObjectMap.stg.
 *
 * @since 3.0.
 */
public interface ImmutableCharObjectMap<V> extends CharObjectMap<V>, ImmutablePrimitiveObjectMap<V>
{
    @Override
    ImmutableCharObjectMap<V> tap(Procedure<? super V> procedure);

    @Override
    ImmutableCharObjectMap<V> select(CharObjectPredicate<? super V> predicate);

    @Override
    ImmutableCharObjectMap<V> reject(CharObjectPredicate<? super V> predicate);

    ImmutableCharObjectMap<V> newWithKeyValue(char key, V value);

    ImmutableCharObjectMap<V> newWithoutKey(char key);

    ImmutableCharObjectMap<V> newWithoutAllKeys(CharIterable keys);

    @Override
    ImmutableObjectCharMap<V> flipUniqueValues();
}
