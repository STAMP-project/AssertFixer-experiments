/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.ordered.primitive;

import java.util.Collection;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectCharIntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharIntProcedure;
import org.eclipse.collections.api.ordered.OrderedIterable;

/**
 * This file was automatically generated from template file orderedPrimitiveIterable.stg.
 *
 * @since 6.0.
 */
public interface OrderedCharIterable extends CharIterable
{
    char getFirst();

    int indexOf(char value);

    @Override
    OrderedCharIterable select(CharPredicate predicate);

    @Override
    OrderedCharIterable reject(CharPredicate predicate);

    @Override
    <V> OrderedIterable<V> collect(CharToObjectFunction<? extends V> function);

    /**
     * Returns a new OrderedIterable using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    default <V> OrderedIterable<V> collectWithIndex(CharIntToObjectFunction<? extends V> function)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++));
    }

    /**
     * Adds elements to the target Collection using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    default <V, R extends Collection<V>> R collectWithIndex(CharIntToObjectFunction<? extends V> function, R target)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++), target);
    }

    <T> T injectIntoWithIndex(T injectedValue, ObjectCharIntToObjectFunction<? super T, ? extends T> function);

    void forEachWithIndex(CharIntProcedure procedure);
}
