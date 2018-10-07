package fr.olemerdy.yal.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class ComparatorsTest {

    @Test
    public void comparator_on_length() {
        // Given some words
        String[] words = {"one", "two", "three", "four", "five"};
        // And a comparator on length
        Comparator<String> comparator = Comparators.onLength();

        // When we sort the words with the comparator
        Arrays.sort(words, comparator);

        // Then the words are sorted
        assertThat(words).containsExactly("one", "two", "four", "five", "three");
    }

    @Test
    public void comparator_on_ASCII_order() {
        // Given some words
        String[] words = {"one", "two", "three", "four", "five"};
        // And a comparator on ASCII Order
        Comparator<String> comparator = Comparators.onASCIIOrder();

        // When we sort the words with the comparator
        Arrays.sort(words, comparator);

        // Then the words are sorted
        assertThat(words).containsExactly("five", "four", "one", "three", "two");
    }

    @Test
    public void comparator_on_length_then_on_ASCII_order_should_sort() {
        // Given some words
        String[] words = {"The", "quick", "brown", "fox", "jumped", "over", "the", "lazy", "brown", "dog’s", "back"};
        // And a composite comparator
        Comparator<String> comparator = Comparators.onLength().thenComparing(Comparators.onASCIIOrder());

        // When we sort the words with the comparator
        Arrays.sort(words, comparator);

        // Then the words are sorted
        assertThat(words).containsExactly("The", "fox", "the", "back", "lazy", "over", "brown", "brown", "dog’s", "quick", "jumped");
    }

    @Test(expected = NullPointerException.class)
    public void comparator_on_null_locale_should_fail() {
        Comparators.onLocale(null);
    }

    @Test
    public void comparator_on_France_locale_should_sort_accentuated_words() {
        // Given some words
        String[] words = {"Pèle", "pelé", "pèle", "Pelé"};
        // And a comparator on France locale
        Comparator<Object> comparator = Comparators.onLocale(Locale.FRANCE);

        // When we sort the words with the comparator
        Arrays.sort(words, comparator);

        // Then the words ares sorted accordingly to French rules
        assertThat(words).containsExactly("pèle", "Pèle", "pelé", "Pelé");
    }

}