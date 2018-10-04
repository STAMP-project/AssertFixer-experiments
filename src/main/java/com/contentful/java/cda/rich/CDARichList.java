package com.contentful.java.cda.rich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Parent class for all list classes
 */
public class CDARichList extends CDARichBlock {
  final List<String> symbols = new ArrayList<>();

  /**
   * Create a list of the given symbols per nesting level
   *
   * @param symbols a list of symbols to be added for differenciation. Can be [1,A,a,I,i] for
   *                prefixing each node with an arabic number (1., 2., …), a capitalized letter
   *                (A., B., …), a lowercase letter (a., b., …) or roman numerals in capital
   *                (I, II, …) or non capitalized form (i, ii, …). Alternatively unordered symbols
   *                can be used: `*` for bullets, `-` for dashes and `⭐` for stars etc.
   */
  public CDARichList(String... symbols) {
    this.symbols.addAll(Arrays.asList(symbols));
  }
}
