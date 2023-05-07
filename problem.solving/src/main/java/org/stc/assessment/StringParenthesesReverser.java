package org.stc.assessment;

import java.util.Stack;

/**
 * The type String parentheses reverser.
 *
 * @author Mahmoud Amin
 */
public class StringParenthesesReverser {
    /**
     * Reverse string string.
     *
     * @param str the str
     * @return the string
     */
    public String reverseString(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char[] strArr = str.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            char ch = strArr[i];
            if (ch == '(') {
                strBuilder.append(ch);
                i++;
                i = parenthesesReverser(strArr, strBuilder, i);
            } else {
                strBuilder.append(ch);
            }
        }
        return strBuilder.toString();
    }

    private int parenthesesReverser(char[] strArr, StringBuilder strBuilder, int index) {
        Stack<Character> characterStack = new Stack<>();
        int i;
        for (i = index; i < strArr.length; i++) {
            char ch = strArr[i];
            if (ch != ')') {
                characterStack.push(ch);
            } else {
                buildString(strBuilder, characterStack);
                strBuilder.append(ch);
                break;
            }
        }
        return i;
    }

    private void buildString(StringBuilder strBuilder, Stack<Character> characterStack) {
        while (!characterStack.isEmpty()) {
            strBuilder.append(characterStack.pop());
        }
    }
}
