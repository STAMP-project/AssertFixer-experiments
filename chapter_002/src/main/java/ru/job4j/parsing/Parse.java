package ru.job4j.parsing;

import java.util.Arrays;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
/**Parse.
 *
 *@author Svetlana Egorova (s.sosenkova@gmail.com)
 *
 *@version $Id$
 *
 *@since 0.1
 */
class Parse {
    private Stack<Character> stack = new Stack<>();
    private List<Character> openingBrackets = Arrays.asList('(', '{', '[');
    private List<Character> closingBrackets = Arrays.asList(')', '}', ']');


    private boolean isOpeningBracket(char bracket) {
        return openingBrackets.indexOf(bracket) != -1;
    }

    private boolean isClosingBracket(char bracket) {
        return closingBrackets.indexOf(bracket) != -1;
    }

    private boolean isPair(char opening, char closing) {
        boolean k = false;
        for (int i = 0; i < openingBrackets.size(); i++) {
            if (opening == openingBrackets.get(i) && closing == closingBrackets.get(i)) {
                k = true;
                break;
            }
        }
        return k;
    }

    boolean validate(String input) {
        for (char c : input.toCharArray()) {
            if (isClosingBracket(c) && stack.isEmpty()) {
                return false;
            }
            if (isOpeningBracket(c)) {
                stack.push(c);
            }
            if (isClosingBracket(c)) {
                if (isPair(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    Stack<Character> change(String input) {
        Stack<Character> result = new Stack<>();
        Parse brackets = new Parse();
        if (brackets.validate(input)) {
            for (char c : input.toCharArray()) {
                for (int i = 0; i < openingBrackets.size(); i++) {
                if (c == openingBrackets.get(i)) {
                    result.add(c);
                    result.add(closingBrackets.get(i));
                }
                }
            }
        }
        return result;
    }
}