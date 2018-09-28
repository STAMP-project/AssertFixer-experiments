/*
 * Copyright (c) 2018 Dann Ryan Hilario
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.dhilario.phzip.search;

import java.io.IOException;
import java.util.List;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.model.City;

/**
 * Implementation of searcher with {@code City} level scope.
 */
public class CityScopeSearcher extends AbstractSearcher<City> {

  /**
   * Constructor that accepts the {@code Provinces} API.
   * @param provinces the {@code Provinces} API
   * @throws IOException if there's an error in JSON
   *         deserialization of Provinces.
   */
  public CityScopeSearcher(final Provinces provinces) throws IOException {
    super(provinces);
  }

  @Override
  public final List<City> search(final String queryTerms) {
    return null;
  }

}
