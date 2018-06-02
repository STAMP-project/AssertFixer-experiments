/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.map.primitive;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.primitive.FloatBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;

/**
 * This file was automatically generated from template file primitiveValuesMap.stg.
 *
 * @since 6.0.
 */
public interface FloatValuesMap extends FloatIterable
{
    boolean containsValue(float value);

    void forEachValue(FloatProcedure procedure);

    MutableFloatCollection values();

    @Override
    FloatBag select(FloatPredicate predicate);

    @Override
    FloatBag reject(FloatPredicate predicate);

    /**
     * @since 9.0.
     */
    default FloatValuesMap tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    @Override
    <V> Bag<V> collect(FloatToObjectFunction<? extends V> function);
}
