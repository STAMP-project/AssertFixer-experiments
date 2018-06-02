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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortBooleanPredicate;
import org.eclipse.collections.api.tuple.primitive.ShortBooleanPair;

/**
 * This file was automatically generated from template file mutablePrimitivePrimitiveMap.stg.
 *
 * @since 3.0.
 */
public interface MutableShortBooleanMap extends ShortBooleanMap, MutableBooleanValuesMap
{
    void put(short key, boolean value);

   /**
     * This method allows MutableShortBooleanMap the ability to add an element in the form of ShortBooleanPair.
     *
     * @see #put(short, boolean)
     * @since 9.1.0
     */
    default void putPair(ShortBooleanPair keyValuePair)
    {
        this.put(keyValuePair.getOne(), keyValuePair.getTwo());
    }

    void putAll(ShortBooleanMap map);

    void removeKey(short key);

    void remove(short key);

    boolean removeKeyIfAbsent(short key, boolean value);

    boolean getIfAbsentPut(short key, boolean value);

    boolean getIfAbsentPut(short key, BooleanFunction0 function);

    boolean getIfAbsentPutWithKey(short key, ShortToBooleanFunction function);

    <P> boolean getIfAbsentPutWith(short key, BooleanFunction<? super P> function, P parameter);

    boolean updateValue(short key, boolean initialValueIfAbsent, BooleanToBooleanFunction function);

    @Override
    MutableShortBooleanMap select(ShortBooleanPredicate predicate);

    @Override
    MutableShortBooleanMap reject(ShortBooleanPredicate predicate);

    MutableShortBooleanMap withKeyValue(short key, boolean value);

    MutableShortBooleanMap withoutKey(short key);

    MutableShortBooleanMap withoutAllKeys(ShortIterable keys);

    MutableShortBooleanMap asUnmodifiable();

    MutableShortBooleanMap asSynchronized();
}
