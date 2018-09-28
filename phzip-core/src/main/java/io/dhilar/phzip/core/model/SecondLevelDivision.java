/*
 * Copyright (c) 2018 Dann Ryan Hilario
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */

package io.dhilar.phzip.core.model;

import java.util.List;

public interface SecondLevelDivision {

  /**
   * Gets {@code Province} or {@code State} Id.
   *
   * @return id the Id of the {@code Province} or {@code State}
   */
  public Integer getId();

  /**
   * Sets {@code Province} or {@code State} Id.
   *
   * @param id the Id of the {@code Province} or {@code State}
   */
  public void setId(final Integer id);

  /**
   * Gets {@code Province} or {@code State} name.
   *
   * @return name the name of the {@code Province} or {@code State}
   */
  public String getName();

  /**
   * Sets {@code Province} or {@code State} name.
   *
   * @param name the name of the {@code Province} or {@code State}
   */
  public void setName(final String name);

  /**
   * Gets {@code Province} or {@code State} abbreviation.
   *
   * @return abbreviation the abbreviation of the {@code Province} or {@code State}
   */
  public String getAbbreviation();

  /**
   * Sets {@code Province} or {@code State} name.
   *
   * @param abbreviation the abbreviation of the {@code Province} or {@code State}
   */
  public void setAbbreviation(final String abbreviation);

  /**
   * Gets {@code Province} or {@code State} alternate names.
   *
   * @return alternate names the alternate names of the {@code Province} or {@code State}
   */
  public List<String> getAlt();

  /**
   * Sets {@code Province} or {@code State} alternate names.
   *
   * @param alt the alternate names of the {@code Province} or {@code State}
   */
  public void setAlt(final List<String> alt);

  /**
   * Gets {@code Province} or {@code State}'s cities.
   *
   * @return cities the cities of the {@code Province} or {@code State}
   */
  List<City> getCities();
  
  /**
   * Sets {@code Province} or {@code State}'s cities.
   *
   * @param cities the cities of the {@code Province} or {@code State}
   */
  public void setCities(final List<City> cities);
}
