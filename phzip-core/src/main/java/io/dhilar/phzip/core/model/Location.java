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
 * Encapsulates Location attribute of a {@code City}.
 */
public class Location implements Serializable {

  private static final long serialVersionUID = 5397541910574695894L;

  /**
   * The location Id.
   */
  private Integer id;
  /**
   * The location name.
   */
  private String name;
  /**
   * The location zip code.
   */
  private String zipcode;
  /**
   * The location phone zip code.
   */
  private List<String> phones;
  /**
   * The location's alternate names.
   */
  private List<String> alt;

  /**
   * Zero-arg constructor for Location.
   */
  public Location() {
    super();
  }

  /**
   * Gets {@code Location} Id.
   *
   * @return id the Id of the {@code Location}
   */
  public final Integer getId() {
    return id;
  }

  /**
   * Sets {@code Location} Id.
   *
   * @param locId the Id of the {@code Location}
   */
  public final void setId(final Integer locId) {
    this.id = locId;
  }

  /**
   * Gets {@code Location} name.
   *
   * @return name the name of the {@code Location}
   */
  public final String getName() {
    return name;
  }

  /**
   * Sets {@code Location} name.
   *
   * @param locName the name of the {@code Location}
   */
  public final void setName(final String locName) {
    this.name = locName;
  }

  /**
   * Gets {@code Location} zip code.
   *
   * @return zipcode the zip code of the {@code Location}
   */
  public final String getZipcode() {
    return zipcode;
  }

  /**
   * Sets {@code Location} zip code.
   *
   * @param locZipCode the name of the {@code Location}
   */
  public final void setZipcode(final String locZipCode) {
    this.zipcode = locZipCode;
  }

  /**
   * Gets {@code Location} phone area code.
   *
   * @return phone the phone area code of the {@code Location}
   */
  public final List<String> getPhones() {
    return phones;
  }

  /**
   * Sets {@code Location} phone area code.
   *
   * @param locPhone the phone area code of the {@code Location}
   */
  public final void setPhones(final List<String> locPhone) {
    this.phones = locPhone;
  }

  /**
   * Gets {@code Location} alternate names.
   *
   * @return alt the alternate names of the {@code Location}
   */
  public final List<String> getAlt() {
    return alt;
  }

  /**
   * Sets {@code Location} alternate names.
   *
   * @param locAlt the alternate names of the {@code Location}
   */
  public final void setAlt(final List<String> locAlt) {
    this.alt = locAlt;
  }
}
