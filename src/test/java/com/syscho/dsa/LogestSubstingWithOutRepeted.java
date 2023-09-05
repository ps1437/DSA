package com;

import java.util.HashSet;
import java.util.Set;

//Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LogestSubstingWithOutRepeted {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring4("edvderf"));

    }

    public static int lengthOfLongestSubstring4(String s) {
        Set<Character> set = new HashSet();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            while (!set.add(s.charAt(i))) {
                set.remove(s.charAt(left++));
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {

        int ans = 1;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                int sz = set.size();
                ans = Math.max(ans, sz);
            }
        }

        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        //dvdf
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                char e = s.charAt(j++); // d v --j 1,2 3 -d -f
                set.add(e);
                max = Math.max(max, set.size());
            } else { //dv -> d ->0 removed -> i =1
                char o = s.charAt(i++);
                set.remove(o);
            }
        }

        return max;
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        int maxLength = -1;
        String result = "";

        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);

            if (result.contains(current)) {
                result = result.substring(result.indexOf(current) + 1);
            }
            result = result + c;
            maxLength = Math.max(result.length(), maxLength);
        }
        return maxLength;
    }
}
