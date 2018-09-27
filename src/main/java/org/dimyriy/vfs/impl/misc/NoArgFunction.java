package org.dimyriy.vfs.impl.misc;

/**
 * @author Dmitrii Bogdanov
 * Created at 23.09.18
 */
@FunctionalInterface
public interface NoArgFunction<T> {
  T apply();
}
