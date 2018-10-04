package com.weaverplatform.sdk;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.regex.Pattern;

/**
 * @author bastbijl, Sysunite 2017
 * found on https://piotrga.wordpress.com/2009/03/27/hamcrest-regex-matcher/
 */
public class RegexMatcher extends BaseMatcher {
  private final String regex;

  public RegexMatcher(String regex){
    this.regex = regex;
  }

  public boolean matches(Object o) {
    Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
    return pattern.matcher((String)o).find();
  }

  public void describeTo(Description description){
    description.appendText("matches regex=");
  }

  public static RegexMatcher matches(String regex){
    return new RegexMatcher(regex);
  }
}