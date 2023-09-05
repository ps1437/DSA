package com.syscho.dsa;

import java.util.Stack;

//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "[()]{}{[()()]()}";

        System.out.println(balanceStack(str));
        System.out.println(balanceStackCharsArray(str));
    }

    private static boolean balanceStackCharsArray(String s) {

        int i = -1;
        char[] stack = new char[s.length()];
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack[++i] = ch;
            else {
                if (i >= 0 && (
                        (stack[i] == '(' && ch == ')')
                                || (stack[i] == '{' && ch == '}')
                                || (stack[i] == '[' && ch == ']')
                )
                ) {
                    i--;
                } else
                    return false;
            }

        }

        return i == -1;
    }

    private static boolean balanceStack(String str) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {

            if (str.charAt(i) == '(') {
                stack.push(')');
            } else if (str.charAt(i) == '[') {
                stack.push(']');
            } else if (str.charAt(i) == '{') {
                stack.push('}');
            } else if (stack.empty() || stack.pop() != str.charAt(i)) {
                return false;
            }
            i++;
        }


        return stack.isEmpty();
    }

}
