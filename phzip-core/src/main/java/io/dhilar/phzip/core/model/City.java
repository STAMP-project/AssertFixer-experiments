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
 * Encapsulates City attribute of a {@code Country}.
 */
public class City implements Serializable {

  private static final long serialVersionUID = 2499066646884905030L;

  /**
   * The city Id.
   */
  private Integer id;
  /**
   * The city name.
   */
  private String name;
  /**
   * The city abbreviation.
   */
  private String abbreviation;
  /**
   * The city alternate names.
   */
  private List<String> alt;
  /**
   * The city zip code.
   */
  private String zipcode;
  /**
   * The city phone area code.
   */
  private List<String> phones;
  /**
   * The city's locations.
   */
  private List<Location> location;

  /**
   * Zero-arg constructor for {@code City}.
   */
  public City() {
    super();
  }

  /**
   * Constructor that accepts {@code City} Id.
   *
   * @param cityId the Id of the city.
   */
  public City(final Integer cityId) {
    super();
    this.id = cityId;
  }

  /**
   * Gets {@code City} Id.
   *
   * @return id the Id of the {@code City}
   */
  public final Integer getId() {
    return id;
  }

  /**
   * Sets {@code City} Id.
   *
   * @param cityId the Id of the {@code City}
   */
  public final void setId(final Integer cityId) {
    this.id = cityId;
  }

  /**
   * Gets {@code City} name.
   *
   * @return name the name of the {@code City}
   */
  public final String getName() {
    return name;
  }

  /**
   * Sets {@code City} name.
   *
   * @param cityName the name of the {@code City}
   */
  public final void setName(final String cityName) {
    this.name = cityName;
  }

  /**
   * Gets {@code City} abbreviation.
   *
   * @return abbreviation the abbreviation of the {@code City}
   */
  public final String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets {@code City} abbreviation.
   *
   * @param cityAbbreviation the abbreviation of the {@code City}
   */
  public final void setAbbreviation(final String cityAbbreviation) {
    this.abbreviation = cityAbbreviation;
  }

  /**
   * Gets {@code City} alternate names.
   *
   * @return alt the alternate names of the {@code City}
   */
  public final List<String> getAlt() {
    return alt;
  }

  /**
   * Sets {@code City} alternate names.
   *
   * @param altNames the alternate names of the {@code City}
   */
  public final void setAlt(final List<String> altNames) {
    this.alt = altNames;
  }

  /**
   * Gets {@code City} zip code.
   *
   * @return zipcode the zip code of the {@code City}
   */
  public final String getZipcode() {
    return zipcode;
  }

  /**
   * Sets {@code City} zip code.
   *
   * @param cityZipCode the zip code of the {@code City}
   */
  public final void setZipcode(final String cityZipCode) {
    this.zipcode = cityZipCode;
  }

  /**
   * Gets {@code City} phone area code.
   *
   * @return phone the phone area code of the {@code City}
   */
  public final List<String> getPhones() {
    return phones;
  }

  /**
   * Sets {@code City} phone area code.
   *
   * @param phoneAreaCodes the phone area code of the {@code City}
   */
  public final void setPhones(final List<String> phoneAreaCodes) {
    this.phones = phoneAreaCodes;
  }

  /**
   * Gets {@code City} locations.
   *
   * @return location the location of the {@code City}
   */
  public final List<Location> getLocation() {
    return location;
  }

  /**
   * Sets {@code City} locations.
   *
   * @param cityLocations the locations of the {@code City}
   */
  public final void setLocation(final List<Location> cityLocations) {
    this.location = cityLocations;
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
    City other = (City) obj;
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
