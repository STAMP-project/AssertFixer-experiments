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

package io.dhilar.phzip.console;

import static java.lang.System.out;

import java.io.IOException;
import java.util.List;

import io.dhilar.phzip.core.CountryCodes;
import io.dhilar.phzip.core.JsonProvinces;
import io.dhilar.phzip.core.JsonStates;
import io.dhilar.phzip.core.PhZipException;
import io.dhilar.phzip.core.Provinces;
import io.dhilar.phzip.core.SortDirection;
import io.dhilar.phzip.core.States;
import io.dhilar.phzip.core.model.Province;
import io.dhilar.phzip.core.model.State;
import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * The {@code PhZipApp} is a console application for launching
 * the PhZip core API.
 */
public class PhZipApp {

  /**
   * Main launcher.
   * @param args console argument
   */
  public static void main(final String... args) {

    PhZipApp app = new PhZipApp();

    Options options = new Options();
    OptionParser parser = options.getParser();

    OptionSet userOptions = null;

    try {
      userOptions = parser.parse(args);
    } catch (Exception ex) {
      throw new PhZipException(ex.getMessage());
    }

    if (userOptions.has(options.getHelp())) {

      app.printHelp(options);

    } else if (userOptions.has(options.getSupportedCountries())) {

      out.println("Supported countries:");
      for (CountryCodes c : CountryCodes.values()) {
        out.println("Code: '" + c + "', Name: '" + c.getName() + "'");
      }

    } else if (userOptions.has(options.getListProvinces())) {

      CountryCodes selectedCountry =
          userOptions.valueOf(options.getListProvinces());
      Provinces provinces = new JsonProvinces(selectedCountry);
      List<Province> allProvinces =
          provinces.getAllProvinces(SortDirection.ASC, true);
      allProvinces.forEach(p -> out.println(p.getName()));

    } else if (userOptions.has(options.getListStates())) {

      CountryCodes selectedCountry =
          userOptions.valueOf(options.getListStates());
      States states = new JsonStates(selectedCountry);
      List<State> allStates = states.getAllStates(SortDirection.ASC);
      allStates.forEach(p -> out.println(p.getName()));

    } else {

      out.println("No argument/s.");
      app.printHelp(options);

    }
  }

  /**
   * Method for printing help.
   * @param options the available options
   */
  private void printHelp(final Options options) {

    OptionParser optionParser = options.getParser();
    optionParser.formatHelpWith(options.getOrderFormatter());

    try {
      optionParser.printHelpOn(System.out);
    } catch (IOException ex) {
      throw new PhZipException("Error printing help", ex);
    }
  }
}
