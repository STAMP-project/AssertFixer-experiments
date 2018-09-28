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
 * Encapsulates State attribute of a {@code Country}.
 */
public class State implements SecondLevelDivision, Serializable {

  private static final long serialVersionUID = -835118376467025755L;

  /**
   * The state Id.
   */
  private Integer id;
  /**
   * The state name.
   */
  private String name;
  /**
   * The state abbreviation.
   */
  private String abbreviation;
  /**
   * The state alternate names.
   */
  private List<String> alt;
  /**
   * The state's cities.
   */
  private List<City> cities;

  /**
   * Zero-arg constructor for State.
   */
  public State() {
    super();
  }

  /**
   * Constructor for State that accepts state Id.
   *
   * @param stateId the State Id.
   */
  public State(final Integer stateId) {
    super();
    this.id = stateId;
  }

  /**
   * Gets {@code State} Id.
   *
   * @return id the Id of the {@code State}
   */
  @Override
  public final Integer getId() {
    return id;
  }

  /**
   * Sets {@code State} Id.
   *
   * @param stateId the Id of the {@code State}
   */
  @Override
  public final void setId(final Integer stateId) {
    this.id = stateId;
  }

  /**
   * Gets {@code State} name.
   *
   * @return name the name of the {@code State}
   */
  @Override
  public final String getName() {
    return name;
  }

  /**
   * Sets {@code State} name.
   *
   * @param stateName the name of the {@code State}
   */
  @Override
  public final void setName(final String stateName) {
    this.name = stateName;
  }

  /**
   * Gets {@code State} abbreviation.
   *
   * @return abbreviation the abbreviation of the {@code State}
   */
  @Override
  public final String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets {@code State} abbreviation.
   *
   * @param stateAbbreviation the abbreviation for the {@code State}
   */
  @Override
  public final void setAbbreviation(final String stateAbbreviation) {
    this.abbreviation = stateAbbreviation;
  }

  /**
   * Gets {@code State} alternate names.
   *
   * @return alt the alternate names of the {@code State}
   */
  @Override
  public final List<String> getAlt() {
    return alt;
  }

  /**
   * Sets {@code State} alternate names.
   *
   * @param stateAlt the alternate names of the {@code State}
   */
  @Override
  public final void setAlt(final List<String> stateAlt) {
    this.alt = stateAlt;
  }

  /**
   * Gets {@code State} cities.
   *
   * @return cities the cities of the {@code State}
   */
  @Override
  public final List<City> getCities() {
    return cities;
  }

  /**
   * Sets {@code State} cities.
   *
   * @param citiesOfState the cities of the {@code State}
   */
  @Override
  public final void setCities(final List<City> citiesOfState) {
    this.cities = citiesOfState;
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
    State other = (State) obj;
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
