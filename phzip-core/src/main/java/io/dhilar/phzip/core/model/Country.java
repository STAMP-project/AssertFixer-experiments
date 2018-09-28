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
 * Encapsulates Country attribute.
 */
public class Country implements Serializable {

  private static final long serialVersionUID = 1030148326653256707L;

  /**
   * The country Id.
   */
  private Integer id;
  /**
   * The country name.
   */
  private String name;
  /**
   * The country abbreviation.
   */
  private String abbreviation;
  /**
   * The country alternate names.
   */
  private List<String> alt;
  /**
   * The country provinces.
   */
  private List<Province> provinces;
  /**
   * The country states.
   */
  private List<State> states;

  /**
   * Zero-arg constructor for Country.
   */
  public Country() {
    super();
  }

  /**
   * Gets {@code Country} Id.
   *
   * @return id the Id of the {@code Country}
   */
  public final Integer getId() {
    return id;
  }

  /**
   * Sets {@code Country} Id.
   *
   * @param countryId the Id of the {@code Country}
   */
  public final void setId(final Integer countryId) {
    this.id = countryId;
  }

  /**
   * Gets {@code Country} name.
   *
   * @return name the name of the {@code Country}
   */
  public final String getName() {
    return name;
  }

  /**
   * Sets {@code Country} name.
   *
   * @param countryName the name of the {@code Country}
   */
  public final void setName(final String countryName) {
    this.name = countryName;
  }

  /**
   * Gets {@code Country} abbreviation.
   *
   * @return abbreviation the abbreviation of the {@code Country}
   */
  public final String getAbbreviation() {
    return abbreviation;
  }

  /**
   * Sets {@code Country} abbreviation.
   *
   * @param countryAbbreviation the abbreviation of the {@code Country}
   */
  public final void setAbbreviation(final String countryAbbreviation) {
    this.abbreviation = countryAbbreviation;
  }

  /**
   * Gets {@code Country} alternate names.
   *
   * @return alternate names the alternate names of the {@code Country}
   */
  public final List<String> getAlt() {
    return alt;
  }

  /**
   * Sets {@code Country} alternate names.
   *
   * @param countryAlt the alternate names of the {@code Country}
   */
  public final void setAlt(final List<String> countryAlt) {
    this.alt = countryAlt;
  }

  /**
   * Gets {@code Country} provinces.
   *
   * @return provinces the provinces of the {@code Country}
   */
  public final List<Province> getProvinces() {
    return provinces;
  }

  /**
   * Sets {@code Country} provinces.
   *
   * @param countryProvinces the provinces of the {@code Country}
   */
  public final void setProvinces(final List<Province> countryProvinces) {
    this.provinces = countryProvinces;
  }

  /**
   * Gets {@code Country} states.
   *
   * @return states the states of the {@code Country}
   */
  public final List<State> getStates() {
    return states;
  }

  /**
   * Sets {@code Country} states.
   *
   * @param countryStates the states of the {@code Country}
   */
  public final void setStates(final List<State> countryStates) {
    this.states = countryStates;
  }


}
