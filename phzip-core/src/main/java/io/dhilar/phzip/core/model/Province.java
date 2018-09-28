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

import java.io.Serializable;
import java.util.List;

/**
 * Encapsulates Province attribute of a {@code Country}.
 */
public class Province implements SecondLevelDivision, Serializable {

  private static final long serialVersionUID = -6814154739973214965L;

  /**
   * The province Id.
   */
  private Integer id;
  /**
   * The province name.
   */
  private String name;
  /**
   * The province abbreviation.
   */
  private String abbreviation;
  /**
   * The province alternate names.
   */
  private List<String> alt;
  /**
   * The province's cities.
   */
  private List<City> cities;

  /**
   * Zero-arg constructor for Province.
   */
  public Province() {
    super();
  }

  /**
   * Constructor for Province that accepts province Id.
   *
   * @param provinceId the Province Id.
   */
  public Province(final Integer provinceId) {
    super();
    this.id = provinceId;
  }

  /**
   * Gets {@code Province} Id.
   *
   * @return id the Id of the {@code Province}
   */
  @Override
  public final Integer getId() {
    return id;
  }

  /**
   * Sets {@code Province} Id.
   *
   * @param provinceId the Id of the {@code Province}
   */
  @Override
  public final void setId(final Integer provinceId) {
    this.id = provinceId;
  }

  /**
   * Gets {@code Province} name.
   *
   * @return name the name of the {@code Province}
   */
  @Override
  public final String getName() {
    return name;
  }

  /**
   * Sets {@code Province} name.
   *
   * @param provinceName the name of the {@code Province}
   */
  @Override
  public final void setName(final String provinceName) {
    this.name = provinceName;
  }

  /**
   * Gets {@code Province} abbreviation.
   *
   * @return abbreviation the abbreviation of the {@code Province}
   */
  @Override
  public final String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets {@code Province} name.
   *
   * @param provinceAbbreviation the abbreviation of the {@code Province}
   */
  @Override
  public final void setAbbreviation(final String provinceAbbreviation) {
    this.abbreviation = provinceAbbreviation;
  }

  /**
   * Gets {@code Province} alternate names.
   *
   * @return alternate names the alternate names of the {@code Province}
   */
  @Override
  public final List<String> getAlt() {
    return alt;
  }

  /**
   * Sets {@code Province} alternate names.
   *
   * @param provinceAlt the alternate names of the {@code Province}
   */
  @Override
  public final void setAlt(final List<String> provinceAlt) {
    this.alt = provinceAlt;
  }

  /**
   * Gets {@code Province} cities.
   *
   * @return cities the cities of the {@code Province}
   */
  @Override
  public final List<City> getCities() {
    return cities;
  }

  /**
   * Sets {@code Province} cities.
   *
   * @param citiesOfProvince the cities of the {@code Province}
   */
  @Override
  public final void setCities(final List<City> citiesOfProvince) {
    this.cities = citiesOfProvince;
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = 1;
    int theId = 0;
    if (id != null) {
      theId = id.hashCode();
    }
    result = prime * result + theId;
    return result;
  }

  @Override
  public final boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Province other = (Province) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }
}
