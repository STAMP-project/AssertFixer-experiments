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

import static java.util.Arrays.asList;
import java.util.LinkedHashSet;
import java.util.Map;
import io.dhilar.phzip.core.CountryCodes;
import joptsimple.BuiltinHelpFormatter;
import joptsimple.OptionDescriptor;
import joptsimple.OptionParser;
import joptsimple.OptionSpec;

/**
 * Class that encapsulates available options for the command-line.
 */
public class Options {

  /**
   * The {@code OptionParser}.
   */
  private final OptionParser parser = new OptionParser();

  /**
   * Displays help information.
   */
  private final OptionSpec<Void> help;
  /**
   * Displays supported countries.
   */
  private final OptionSpec<Void> supportedCountries;
  /**
   * List provinces.
   */
  private final OptionSpec<CountryCodes> listProvinces;
  /**
   * List states.
   */
  private final OptionSpec<CountryCodes> listStates;

  /**
   * Initialize options.
   */
  Options() {

    help = parser.acceptsAll(asList("h", "help"),
        "Display this help information.");

    supportedCountries =
        parser.acceptsAll(asList("c", "supported-countries"),
            "List supported countries.");

    listProvinces =
        parser.acceptsAll(asList("p", "list-provinces"),
            "List provinces of the specified country")
            .withRequiredArg().ofType(CountryCodes.class)
            .withValuesConvertedBy(new CountryCodesConverter())
            .defaultsTo(CountryCodes.PH);

    listStates =
        parser.acceptsAll(asList("s", "list-states"),
            "List states of the specified country")
            .withRequiredArg().ofType(CountryCodes.class)
            .withValuesConvertedBy(new CountryCodesConverter())
            .defaultsTo(CountryCodes.US);
  }

  /**
   * Gets {@code OptionParser}.
   * @return parser the {@code OptionParser} object
   */
  final OptionParser getParser() {
    return parser;
  }

  /**
   * Gets help {@code OptionSpec}.
   * @return help the help {@code OptionSpec}
   */
  public final OptionSpec<Void> getHelp() {
    return help;
  }

  /**
   * Gets supportedCountries {@code OptionSpec}.
   * @return supportedCountries the supported countries {@code OptionSpec}
   */
  public final OptionSpec<Void> getSupportedCountries() {
    return supportedCountries;
  }

  /**
   * Gets list of provinces {@code OptionSpec}.
   * @return listProvinces the list of province {@code OptionSpec}
   */
  public final OptionSpec<CountryCodes> getListProvinces() {
    return listProvinces;
  }

  /**
   * Gets list of states {@code OptionSpec}.
   * @return listStates the list of states {@code OptionSpec}
   */
  public final OptionSpec<CountryCodes> getListStates() {
    return listStates;
  }

  /**
   * Gets order formatter.
   * @return an order formatter
   */
  public final BuiltinHelpFormatter getOrderFormatter() {
    return new OrderFormatter();
  }

  /**
   * Formats how to display the help options.
   */
  private static final class OrderFormatter extends BuiltinHelpFormatter {

    /**
     * Overall width of the console display.
     */
    private static final int OVERALL_WIDTH = 90;
    /**
     * Column separator width of the console display.
     */
    private static final int COLUMN_SEPARATOR_WIDTH = 4;

    /**
     * Sets overall width and column separator width for the console display.
     */
    private OrderFormatter() {
      super(OVERALL_WIDTH, COLUMN_SEPARATOR_WIDTH);
    }

    /**
     * Formats display console.
     */
    @Override
    public String format(
        final Map<String, ? extends OptionDescriptor> options) {
      addRows(new LinkedHashSet<>(options.values()));
      return formattedHelpOutput();
    }
  }
}
