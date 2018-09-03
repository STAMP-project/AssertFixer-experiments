package ru.job4j.jobparser;

/**
 * Class to validate String in order to find proper topics
 * @input String which can contain "Java"
 *
 */
public class StringSearcher {
    private String input;

    private boolean isJava() {
        return input.contains("java") || input.contains("Java");
    }

    private boolean isNotJavaScript() {
        return !(input.contains("javaScript ") || input.contains("Java Script")
                || input.contains("java script")
                || input.contains("Java script")
                || input.contains("java Script")
                || input.contains("Javascript")
                || input.contains("JavaScript"));
    }

    /**
     * This method for validating String
     * @param input is input string
     * @return true if string input contains "Java"
     * false if String contains "Java Script" (with all types of spaces and cappital letters)
     * or not contains "Java" at all
     */
    public boolean validate(String input) {
        this.input = input;
        return isJava() && isNotJavaScript();
    }
}
