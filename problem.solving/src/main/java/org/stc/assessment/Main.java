package org.stc.assessment;

public class Main {
    public static void main(String[] args) {
        if (args != null && args.length > 0) {
            for (String str : args) {
                System.out.println("Input String: " + str);
                StringParenthesesReverser stringReverser = new StringParenthesesReverser();
                String reversedString = stringReverser.reverseString(str);
                System.out.println("Reversed String: " + reversedString);
            }
        } else {
            System.out.println("Please enter string arguments");
        }
    }
}