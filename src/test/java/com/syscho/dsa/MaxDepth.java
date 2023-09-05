package com.syscho.dsa;

import java.util.Stack;

//https://www.geeksforgeeks.org/find-maximum-depth-nested-parenthesis-string/
public class MaxDepth {
    public static void main(String[] args) {
        String str = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";

        maxDepth(str);
        maxDepth2(str);
    }

    private static void maxDepth2(String s) {
        int res = 0, cur = 0;

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == '(') {
                res = Math.max(res, ++cur);
            } else if (ch == ')') {
                cur--;
            }

        }

        System.out.println(res);
    }

    private static void maxDepth(String str) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        int i = 0;
        while (i < str.length()) {

            if (str.charAt(i) == '(') {
                stack.push('(');
            } else if (str.charAt(i) == ')') {
                if (count < stack.size())
                    count = stack.size();

                stack.pop();
            }

            i++;
        }

        System.out.println(count);
    }
}
