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

package io.dhilar.phzip.core;

/**
 * Enumerator for mapping the country to its Id and JSON filename.
 */
public enum CountryCodes {

  /**
   * The Philippines.
   */
  PH("Philippines", 1001, "ph.json"),
  /**
   * The United States of America.
   */
  US("United States", 1002, "us.json");

  /**
   * The name of the country.
   */
  private String name;
  /**
   * The Id of the country.
   */
  private Integer id;
  /**
   * The JSON filename of the the country.
   */
  private String dataFilename;

  /**
   * Constructor that accepts country, country Id, and JSON filename.
   *
   * @param countryName is the name of country.
   * @param countryId is the id of the country.
   * @param filename is the filename of the JSON of the country.
   */
  CountryCodes(final String countryName, final Integer countryId, final String filename) {
    this.name = countryName;
    this.id = countryId;
    this.dataFilename = filename;
  }

  /**
   * Gets country name.
   *
   * @return The name of the country.
   */
  public String getName() {
    return name;
  }

  /**
   * @return The Id of the country.
   */
  public Integer getId() {
    return id;
  }

  /**
   * @return The filename of the JSON file of the country.
   */
  public String getDataFilename() {
    return dataFilename;
  }

  @Override
  public String toString() {
    return name().toLowerCase();
  }
}
