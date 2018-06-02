/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.utility.internal.primitive;

import java.util.Collection;

import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectBooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;

/**
 * The BooleanIteratorIterate class provides implementations of the various iteration patterns for use with the {@link BooleanIterator}.
 * This file was automatically generated from template file primitiveIteratorIterate.stg.
 *
 * @since 5.0
 */
public final class BooleanIteratorIterate
{
    private BooleanIteratorIterate()
    {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }

    public static void forEach(BooleanIterator iterator, BooleanProcedure procedure)
    {
        while (iterator.hasNext())
        {
            procedure.value(iterator.next());
        }
    }

    public static <R extends MutableBooleanCollection> R select(
            BooleanIterator iterator,
            BooleanPredicate predicate,
            R targetCollection)
    {
        while (iterator.hasNext())
        {
            boolean item = iterator.next();
            if (predicate.accept(item))
            {
                targetCollection.add(item);
            }
        }
        return targetCollection;
    }

    public static <R extends MutableBooleanCollection> R reject(
            BooleanIterator iterator,
            BooleanPredicate predicate,
            R targetCollection)
    {
        while (iterator.hasNext())
        {
            boolean item = iterator.next();
            if (!predicate.accept(item))
            {
                targetCollection.add(item);
            }
        }
        return targetCollection;
    }

    public static <V, R extends Collection<V>> R collect(
            BooleanIterator iterator,
            BooleanToObjectFunction<? extends V> function,
            R targetCollection)
    {
        while (iterator.hasNext())
        {
            boolean item = iterator.next();
            targetCollection.add(function.valueOf(item));
        }
        return targetCollection;
    }

    public static boolean detectIfNone(BooleanIterator iterator, BooleanPredicate predicate, boolean ifNone)
    {
        while (iterator.hasNext())
        {
            boolean item = iterator.next();
            if (predicate.accept(item))
            {
                return item;
            }
        }
        return ifNone;
    }

    public static int count(BooleanIterator iterator, BooleanPredicate predicate)
    {
        int count = 0;
        while (iterator.hasNext())
        {
            if (predicate.accept(iterator.next()))
            {
                count++;
            }
        }
        return count;
    }

    public static boolean anySatisfy(BooleanIterator iterator, BooleanPredicate predicate)
    {
        while (iterator.hasNext())
        {
            if (predicate.accept(iterator.next()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean allSatisfy(BooleanIterator iterator, BooleanPredicate predicate)
    {
        while (iterator.hasNext())
        {
            if (!predicate.accept(iterator.next()))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean noneSatisfy(BooleanIterator iterator, BooleanPredicate predicate)
    {
        while (iterator.hasNext())
        {
            if (predicate.accept(iterator.next()))
            {
                return false;
            }
        }
        return true;
    }

    public static <T> T injectInto(BooleanIterator iterator, T injectedValue, ObjectBooleanToObjectFunction<? super T, ? extends T> function)
    {
        T result = injectedValue;
        while (iterator.hasNext())
        {
            result = function.valueOf(result, iterator.next());
        }
        return result;
    }
}
